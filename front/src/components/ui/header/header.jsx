import { FC } from 'react';
import { Link } from 'react-router-dom';
import { HiOutlineArrowNarrowLeft } from 'react-icons/hi';
import styles from './header.module.css'

const Header: FC<{headerTitle: string, to: string}> = ({ headerTitle , to}) => {
    return (
        <div className={styles.header}>
            <div>
                <Link className={styles.back} to={to}><HiOutlineArrowNarrowLeft /></Link>
                <div>{headerTitle}</div>
            </div>
        </div>
    );
};

export default Header;
