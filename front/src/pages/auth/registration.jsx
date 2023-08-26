// @ts-ignore
import styles from './auth.module.css'
import Logo from "../../components/ui/logo/Logo";
import React, {useState} from "react";
import Button from "../../components/ui/button/button";
import AuthService from "../../services/auth.service";
import {useNavigate} from "react-router-dom";

const Registration = () => {

    const [errors, setErrors] = useState({'email' : null, 'password' : null, 'repeatPassword' : null})

    const navigate = useNavigate();


    const onSubmit = async (e) => {
        e.preventDefault();
        let email = e.target.querySelector("#email").value
        let password = e.target.querySelector("#password").value
        let repeatPassword = e.target.querySelector("#repeat-password").value
        let firstName = e.target.querySelector("#firstName").value
        let lastName = e.target.querySelector("#lastName").value
        let middleName = e.target.querySelector("#middleName").value
        let inn = e.target.querySelector("#inn").value
        let username = e.target.querySelector("#username").value


        if (!email) {
            setErrors(prevState => ({...prevState, "email": true}))
            return
        }

        if(!username || username.length < 4) {
            setErrors(prevState => ({...prevState, "username": "Логин не может быть меньше 4 символов"}))
        }

        if (!password) {
            setErrors(prevState => ({...prevState, "password": "Введите пароль"}))
            return
        }
        else if (password.length < 6) {
            setErrors(prevState => ({...prevState, "password": "Неверный пароль"}))
            return
        }

        if (password !== repeatPassword) {
            setErrors(prevState => ({...prevState, repeatPassword: "Пароли не совпадают"}))
            return
        }

        if (!inn) {
            setErrors(prevState => ({...prevState, inn: "Неверный ИНН"}))
        }

        if (firstName && middleName && lastName && email && password && password === repeatPassword) {
            console.log('registration request sending...')
            await AuthService.registerDm(
                {
                    email: email,
                    password: password,
                    firstName: firstName,
                    middleName : middleName,
                    lastName : lastName,
                    inn : inn,
                    username : username
                })
                .then((response) => {
                        navigate('/layout')
                    }
                )
                .catch((e) => {
                    console.log(e)
                    setErrors(prevState => ({...prevState, repeatPassword: e.message}))
                })
        }
    }

    return <>
        <div className={styles.body}>
            <Logo className={styles.logo}/>
            <form className={styles.form} onSubmit={onSubmit}>
                <div>Вход</div>
                <div className={styles.formItem}>
                    <input  placeholder={'Фамилия'} type='text' id="lastName" required={true} />
                </div>
                <div className={styles.formItem}>
                    <input  placeholder={'Имя'} type='text' required={true} id="firstName"/>
                </div>
                <div className={styles.formItem}>
                    <input  placeholder={'Отчество'} required={true} type='text' id="middleName" />
                </div>
                <div className={styles.formItem}>
                    <input required={true} placeholder={'Почта'} type="email" id="email"  onChange={() => {
                        if (errors.email) setErrors(prevState => ({...prevState, email: null}))}
                    } className={styles.input}/>
                    {errors.email && <span className={styles.errorMsg}>{errors.email}</span>}
                </div>
                <div className={styles.formItem}>
                    <input required={true} placeholder={'Логин'} type="text" id="username"  onChange={() => {
                        if (errors.username) setErrors(prevState => ({...prevState, username: null}))}
                    } className={styles.input}/>
                    {errors.username && <span className={styles.errorMsg}>{errors.username}</span>}
                </div>
                <div className={styles.formItem}>
                    <input required={true} placeholder={'ИНН'} type="text" id="inn"  onChange={() => {
                        if (errors.inn) setErrors(prevState => ({...prevState, inn: null}))}
                    } className={styles.input}/>
                    {errors.inn && <span className={styles.errorMsg}>{errors.inn}</span>}
                </div>
                <div className={styles.formItem}>
                    <input  placeholder={'Пароль'} type='password' id="password" onChange={() => {
                        if (errors.password)
                            setErrors(prevState => ({...prevState, password: null}))
                    }}/>
                    {errors.password && <span className={styles.errorMsg}>{errors.password}</span>}
                </div>
                <div className={styles.formItem}>
                    <input  placeholder={'Повторите пароль'} type='password' id="repeat-password" onChange={() => {
                        if (errors.password)
                            setErrors(prevState => ({...prevState, password: null}))
                    }}/>
                    {errors.repeatPassword && <span className={styles.errorMsg}>{errors.repeatPassword}</span>}
                </div>

                <Button className={styles.authButton} type="submit">Зарегистрироваться</Button>
            </form>
        </div>
    </>
}

export default Registration;