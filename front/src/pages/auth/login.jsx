// @ts-ignore
import styles from './auth.module.css'
import Logo from "../../components/ui/logo/Logo";
// @ts-ignore
import React, {useState} from "react";
import Button from "../../components/ui/button/button";
import AuthService from "../../services/auth.service";
import {useNavigate} from "react-router-dom";

const Login = () => {

    const [errors, setErrors] = useState({'email' : null, 'password' : null})
    const navigate = useNavigate();
    const onSubmit = async (e) => {
        e.preventDefault();
        let email = e.target.querySelector("#email").value
        let password = e.target.querySelector("#password").value
        if (!email) {
            setErrors(prevState => ({...prevState, "email": true}))
            return
        }
        if (!password) {
            setErrors(prevState => ({...prevState, "password": "Введите пароль"}))
            return
        }
        else if (password.length < 6) {
            setErrors(prevState => ({...prevState, "password": "Неверный пароль"}))
            return
        }

        if (password && email) {

            await AuthService.authLogin({email: email, password: password})
                .then( () => {
                    navigate('/layout')
                })
                .catch((e) => {
                    console.log(e)
                    setErrors(prevState => ({...prevState, password: e.message}))
                })

        }

    }

    return <>
        <div className={styles.body}>
            <Logo className={styles.logo}/>
            <form className={styles.form} onSubmit={onSubmit}>
                <div>Вход</div>
                <div className={styles.formItem}>

                    <input required={true} placeholder={'Почта'} type="email" id="email"  onChange={() => {
                        if (errors.email) setErrors(prevState => ({...prevState, email: null}))}
                    } className={styles.input}/>
                    {errors.email && <span className={styles.errorMsg}>{errors.email}</span>}
                </div>
                <div className={styles.formItem}>
                    <input  placeholder={'Пароль'} type='password' id="password" onChange={() => {
                        if (errors.password)
                            setErrors(prevState => ({...prevState, password: null}))
                    }}/>
                    {errors.password && <span className={styles.errorMsg}>{errors.password}</span>}
                </div>

                <Button className={styles.authButton} type="submit">Продолжить</Button>
            </form>
        </div>
    </>
}

export default Login;