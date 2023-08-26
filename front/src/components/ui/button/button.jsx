import React, { FC } from 'react';
import cn from 'classnames';
import styles from './button.module.css';
interface ButtonProps extends React.DetailedHTMLProps<React.ButtonHTMLAttributes<HTMLButtonElement>, HTMLButtonElement>, React.AriaAttributes  {}

const Button: FC<ButtonProps> = (props) => {
    const {children, className, ...rest} = props;

    return (
        <button className={cn(className, styles.button)} {...rest}>{children}</button>
    )
};

export default Button;