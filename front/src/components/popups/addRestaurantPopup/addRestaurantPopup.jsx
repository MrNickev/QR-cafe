import React, {FC, useEffect, useState,} from 'react';
import ReactDOM from 'react-dom';
import styles from "./addRestaurant.module.css";
import Button from '../../ui/button/button';
import {useForm} from "react-hook-form";
import {RestaurantAdd} from "../../../constants/types";
import RestaurantService from "../../../services/restaurant.service";
import useComponentVisible from "../../../hooks/useComponentVisible";

const AddRestaurantPopup = ({setOpenAddRestaurantPopup, addRestaurant}) => {

    const [errors, setErrors] = useState({})

    const {ref, isComponentVisible} = useComponentVisible(true)

    useEffect(() => {
        setOpenAddRestaurantPopup(isComponentVisible)
    }, [isComponentVisible]);

    const onSubmit = (e) => {
        let name = e.target.querySelector("#name").value
        let address = e.target.querySelector("#address").value
        if (!name || name.length === 0) {
            setErrors(prevState => ({...prevState, name : "Имя не может быть пустым"}))
            return
        }
        if (!address || address.length === 0) {
            setErrors(prevState => ({...prevState, address : "Адрес не может быть пустым"}))
            return
        }
        RestaurantService.addRestaurant({name : name, address : address})
            .then((response) => {
                console.log(response.data)
                if (response.data) {
                    addRestaurant(response.data)
                    setOpenAddRestaurantPopup(false);
                }
            })
            .catch((e) => {
                console.error(e);
                setErrors(prevState => ({...prevState, serverError : e.message}))
            })
    }

    return (
        <div className={styles.frame} >
            <form className={styles.addRestaurantForm} ref={ref} onSubmit={onSubmit}>
                <div className={styles.formTitle}>Добавить ресторан</div>
                <div className={styles.formItem}>
                    <label htmlFor="name">Название</label>
                    {errors.name && <span className={styles.errorMsg}>Введите название Вашего ресторана</span>}
                    <input type="text" id="name" className={styles.input} onChange={() => setErrors(prevState => ({...prevState, name : null}))}/>
                </div>
                <div className={styles.formItem}>
                    <label htmlFor="address">Адрес:</label>
                    {errors.address && <span className={styles.errorMsg}>Введите адрес</span>}
                    <input type="text" id="address" className={styles.input} onChange={() => setErrors(prevState => ({...prevState, address : null}))}/>
                </div>
                {errors.serverError && <span className={styles.errorMsg}>{errors.serverError}</span>}
                <Button className={styles.addButton} type="submit">Добавить</Button>
            </form>
        </div>
    );
};

export default AddRestaurantPopup;