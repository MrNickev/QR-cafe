import React from 'react';
import {NavLink} from "react-router-dom";
import styles from './navbar.module.css';
import stylesDm from './navbar-decision-maker.module.css'
import {cookies} from "../../services/instance.service";

const Navbar = () => {
    const checkRole = (role : string) => {
        let roles = cookies.get('roles')
        console.log(roles)
        for (let curRole of roles) {
            if (role === curRole.authority)
                return true;
        }

    }
    return (
        <div className={styles.nav}>
            {checkRole("MANAGER")  && <>
                <NavLink to="tables" className={styles.navItem}>Модель зала</NavLink>
                <NavLink to="waiters" className={styles.navItem}>Официанты</NavLink>
                <NavLink to="menu" className={styles.navItem}>Меню</NavLink>
                <NavLink to="feedbacks" className={styles.navItem}>Отзывы</NavLink>
            </>}

            {checkRole("DECISION_MAKER") && <>
                <NavLink to="restaurants" className={stylesDm.navItem}>Мои рестораны</NavLink>
                <NavLink to="stats" className={stylesDm.navItem}>Общая статистика</NavLink>
                <NavLink to="payment" className={stylesDm.navItem}>Оплата</NavLink>
            </>}

        </div>
    );
};

export default Navbar;