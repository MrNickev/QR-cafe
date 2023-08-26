export interface Auth {
    email : string,
    password : string
}

export interface RegisterUser {
    firstName : string,
    middleName : string,
    lastName : string,
    email : string,
    password : string
}

export interface RegisterDecisionMaker extends RegisterUser{
    inn : string
}

export interface RegisterWaiter extends RegisterUser {
    restaurantId : string
}

export interface AuthData {
    token : string,
    role : string
}

export interface RestaurantAdd {
    name : string,
    address : string
}