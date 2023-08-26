import Header from "../../../components/ui/header/header";
import Button from "../../../components/ui/button/button";
import Search from "../../../components/ui/search/search";
import {useEffect, useState} from "react";
import styles from './restaurants.module.css'
import RestaurantCard from "../../../components/ui/restaurant-card/restaurant-card";
import DecisionMakerService from "../../../services/decision-maker-service";
import AddRestaurantPopup from "../../../components/popups/addRestaurantPopup/addRestaurantPopup";

const Restaurants = () => {
    const [restaurants, setRestaurants] = useState([])
    const [isOpenAddWaiterPopup, setOpenAddWaiterPopup] = useState(false)
    useEffect(() => {
        DecisionMakerService.getRestaurants()
            .then((response) => {
                console.log(response.data);
                setRestaurants(response.data)
            })
            .catch((e) => {
                console.error(e)
            })

    }, []);

    useEffect(() => {
        console.log("isOpenAddWaiterPopup changed")
    }, [isOpenAddWaiterPopup]);

    const handleSearchQueryChange = (value: string) => {

    };

    return(
        <>
            <Header headerTitle={"Мои рестораны"} to={"/layout"}/>
            <div className={styles.wrapper}>
                <Search onSearchQueryChange={handleSearchQueryChange} />
                <Button className={styles.addNewWaiter} onClick={()=> setOpenAddWaiterPopup(true)}>Добавить ресторан</Button>
            </div>
            <div className={styles.sortWrapper}>
                Сортировка:
                <span>{'А-я ↗↘'}</span>
            </div>
            <section className={styles.restaurantsList}>
                {restaurants && restaurants.length > 0 && restaurants.map(restaurant => <RestaurantCard key={restaurant.id} restaurantData={restaurant}/>)}
            </section>

            {isOpenAddWaiterPopup && <AddRestaurantPopup setOpenAddRestaurantPopup={setOpenAddWaiterPopup} addRestaurant={(rest) => setRestaurants(prevState => ([...prevState, rest]))}/>}
        </>
    )
}

export default Restaurants;