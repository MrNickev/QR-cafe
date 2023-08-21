import {cookies, instance, updateInstance} from './instance.service';
import { Auth } from '../constants/types';
import type {AuthData, Register} from "../constants/types";

const authLogin = async (data: Auth) => {
    console.log(cookies.get('token'))
        cookies.remove('token')
        cookies.remove('role')
    console.log(cookies.get('token'))
        updateInstance()
        let response = await instance.post(`auth/login`, {
            username: data.email,
            password: data.password,
        });
        if (response.data.token && response.data.role) {
            cookies.set('token', response.data.token)
            cookies.set('role', response.data.role)
            console.log('saving info to cookies: ', response.data.token, response.data.role)
        }
        else {
            console.error("Response data not valid")
            console.warn(response.data)
        }

};

const updateToken = async () => {

}

const register = async (data: Register) => {
        cookies.remove('token')
        cookies.remove('role')
        updateInstance()
        let response = await instance.post(`auth/register`, data);
        if (response.data.token && response.data.role) {
            cookies.set('token', response.data.token)
            cookies.set('role', response.data.role)
            console.log('saving info to cookies: ', response.data.token, response.data.role)
            updateInstance()
        }
        else {
            console.warn(response.data)
            throw new Error({message: 'Response data not valid'})
        }

}

const AuthService = {
    authLogin,
    updateToken,
    register
};

export default AuthService;
