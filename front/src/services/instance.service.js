import axios from 'axios';
import Cookies from "universal-cookie";

//export const baseURL_server = process.env["REACT_APP_API_URL "];
export const baseURL_server = " http://localhost:8080/api"

export const cookies = new Cookies();
export let instance : axios;
export const updateInstance = () => {
    if (cookies.get('token') && cookies.get('roles')) {
        instance = axios.create({
            baseURL: baseURL_server,
            headers: {
                Authorization: 'Bearer ' + cookies.get('token'),
                'Content-Type': 'application/json',
                // 'Access-Control-Allow-Origin': "http://localhost:8080"
            },

        });
        console.log('instance now WITH headers');
    }
    else {
        instance = axios.create({
            baseURL: baseURL_server,
            headers: {
                // 'Access-Control-Allow-Origin': "http://localhost:8080",
                // 'Content-Type': 'application/json',
            },
        })
        console.log('instance now WITHOUT headers');
    }
}

updateInstance()


