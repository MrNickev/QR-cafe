import axios from 'axios';

export const baseURL_server = process.env["REACT_APP_API_URL "];

const instance = axios.create({
    baseURL: baseURL_server,
    headers: {},
});

export default instance;