import React from 'react';
import {Outlet, useNavigate} from "react-router-dom";

import styles from './layout.module.css'
import Logo from "../ui/logo/Logo";
import {cookies} from "../../services/instance.service";

const Layout = () => {
    const navigate = useNavigate();
    return (
        <>
            <div className={styles.header}>
                <div onClick={()=>navigate('/layout')}><Logo className={styles.logo}/></div>
                <div className={styles.profile}>
                    <div>{cookies.get('username')}</div>
                    <div />
                </div>
            </div>
            <Outlet />
        </>
    );
};

export default Layout;