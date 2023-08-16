import instance from './instance.service';
import { Auth } from '../constants/types';

const authLogin = async (data: Auth) => {
    return await instance.post(`Auth/login`, {
        username: data.email,
        password: data.password,
    });
};

const updateToken = async () => {

}

const AuthService = {
    authLogin,
    updateToken
};

export default AuthService;
