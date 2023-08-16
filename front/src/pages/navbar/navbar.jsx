import React from 'react';
import {NavLink} from "react-router-dom";
import styles from './navbar.module.css';

const Navbar = () => {
    return (
        <div className={styles.nav}>
            <NavLink to="tables" className={styles.navItem}>Модель зала</NavLink>
            <NavLink to="waiters" className={styles.navItem}>Официанты</NavLink>
            <NavLink to="menu" className={styles.navItem}>Меню</NavLink>
            <NavLink to="feedbacks" className={styles.navItem}>Отзывы</NavLink>
        </div>
    );
};

export default Navbar;