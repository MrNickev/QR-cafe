import {cookies, instance, updateInstance} from './instance.service';
import { Auth } from '../constants/types';
import type {RegisterUser} from "../constants/types";

const authLogin = async (data: Auth) => {
    console.log(cookies.get('token'))
        cookies.remove('token')
        cookies.remove('roles')
    console.log(cookies.get('token'))

        let response = await instance.post(`auth`, {
            username: data.email,
            password: data.password,
        });
        if (response.data.token && response.data.roles && response.data.username) {
            cookies.set('token', response.data.token)
            cookies.set('roles', response.data.roles)
            cookies.set('username', response.data.username)
            console.log('saving info to cookies: ', cookies.get('token'), cookies.get('username'), cookies.get('roles'))
        }
        else {
            console.error("Response data not valid")
            console.warn(response.data)
            throw new Error("Response data not valid")
        }
    updateInstance()
};

const updateToken = async () => {

}

const registerDm = async (data: RegisterUser) => {
        cookies.remove('token')
        cookies.remove('roles')
        updateInstance()
        let response = await instance.post(`/registration/decisionMaker`, data);
        if (response.data.token && response.data.roles && response.data.username) {
            cookies.set('token', response.data.token)
            cookies.set('roles', response.data.roles)
            cookies.set('username', response.data.username)
            console.log('saving info to cookies: ', cookies.get('token'), cookies.get('username'), cookies.get('roles'))
            updateInstance()
        }
        else {
            console.warn(response.data)
            throw new Error('Response data not valid')
        }
}

const AuthService = {
    authLogin,
    updateToken,
    registerDm
};

export default AuthService;
