import {instance} from "./instance.service";

const getRestaurants = async () => {
    return await instance.get(`decisionMaker/restaurants`)


    // console.log(response.data)
    //
    // if (response.data){
    //     return  response.data
    //     }
    // else {
    //     throw new Error("Ошибка получения данных")
    // }
}

const DecisisionMakerService = {
    getRestaurants,
}

export default DecisisionMakerService

