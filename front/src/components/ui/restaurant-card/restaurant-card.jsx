import styles from "./restaurant-card.module.css"
import Button from "../button/button";
import {Link, NavLink} from "react-router-dom";
import {useEffect, useState} from "react";

const RestaurantCard  = ({restaurantData}) => {

    const [data, setData] = useState()

    useEffect(() => {
        console.log(restaurantData);
        setData(restaurantData)
    }, []);

    return(
        <>
            {data &&
        <div className={styles.card}>
            <div className={styles.name}>{data.name}</div>
            <ul className={styles.parameters}>
                <li>Выручка за август: <span className={styles.value}>1 954 000 ₽</span></li>
                <li>Количество заказов: <span className={styles.value}>360</span></li>
                <li>Средний чек: <span className={styles.value}>2 650 ₽</span></li>
                <li>Количество сотрудников: {data.waiters && data.managers && <span className={styles.value}>{data.waiters.length + data.managers.length}</span>}</li>
            </ul>

            <div className={styles.director }>
                <div className={styles.value}>Директор</div>
                <div className={styles.directorProfile}>
                    {data.generalManager && <div className={styles.avatar} />}
                    <div className={styles.directorName}>{data.generalManager ? data.generalManager : "Директор не указан"}</div>
                </div>
            </div>
            <div className={styles.address}>
                <div className={styles.value}>Адрес</div>
                <div>{data.address}</div>
            </div>

            <Link to={data.id} className={styles.more}>Подробнее</Link>


        </div>}
        </>
    )
}

export default RestaurantCard;