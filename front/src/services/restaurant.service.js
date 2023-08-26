import type {RestaurantAdd} from "../constants/types";
import {instance} from "./instance.service";

const addRestaurant = async (data : RestaurantAdd) => {
    console.log('sending data: ', data)
    return await instance.post(`restaurants/create`, data);
}

const getRestaurantById = async (id) => {
    return await instance.get(`restaurants/` + id)
}

const RestaurantService = {
    addRestaurant,
    getRestaurantById
}

export default RestaurantService