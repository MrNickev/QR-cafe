export interface Auth {
    email : string,
    password : string
}

export interface Register {
    firstName : string,
    middleName : string,
    lastName : string,
    email : string,
    password : string
}

export interface AuthData {
    token : string,
    role : string
}