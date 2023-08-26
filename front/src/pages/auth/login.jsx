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
        let username = e.target.querySelector("#username").value
        let password = e.target.querySelector("#password").value
        if (!username || username.length < 4) {
            setErrors(prevState => ({...prevState, username: "Неверный логин"}))
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

        if (password && username) {

            await AuthService.authLogin({
                email: username,
                password: password
            })
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

                    <input required={true} placeholder={'Логин'} type="text" id="username"  onChange={() => {
                        if (errors.username) setErrors(prevState => ({...prevState, username: null}))}
                    } className={styles.input}/>
                    {errors.username && <span className={styles.errorMsg}>{errors.username}</span>}
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