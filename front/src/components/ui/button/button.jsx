import cn from 'classnames';
import styles from './button.module.css'
const Button = ({className, type, children}) => {
    return <button className={cn(className, styles.button)} type = {type}>{children}</button>
}

export default Button;