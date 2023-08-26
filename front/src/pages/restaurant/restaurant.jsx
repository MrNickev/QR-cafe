import {useParams} from "react-router-dom";
import Header from "../../components/ui/header/header";
import {useEffect, useState} from "react";
import RestaurantService from "../../services/restaurant.service";
import styles from "./restaurant.module.css"
import Button from "../../components/ui/button/button";
import ChartCard from "../../components/ui/chart-card/chart-card";
import Card from "../../components/ui/card/card";
import {AiOutlineDelete} from "react-icons/ai";
import {FiEdit3} from "react-icons/fi";
import PeopleRow from "../../components/ui/package-rows/peopleRow";

const Restaurant = () => {

    const id = useParams().id

    const [data, setData] = useState()

    useEffect(() => {
        RestaurantService.getRestaurantById(id)
            .then((response) => {
                setData(response.data)
            })
    }, []);

    return(
        <>
            {data && <>
                <div className={styles.headerWithButton} >
                    <Header headerTitle={data.name} to={'/layout/restaurants'} />
                    <Button>Закрыть ресторан</Button>
                </div>
                <ChartCard />
                <Card>
                    <div className={styles.heading}>
                        Управляющий состав
                        <Button>Добавить</Button>
                    </div>
                    <table>
                        <tbody>
                            {data.generalManager && <PeopleRow info={data.generalManager}/>}
                            {data.managers && data.managers.length > 0 && data.managers.map(manager => <PeopleRow info={manager} />)}
                        </tbody>
                    </table>
                </Card>
                <Card>
                    <div className={styles.heading}>
                        Официанты
                        <Button>Добавить</Button>
                    </div>
                    <table>
                        <tbody>
                            {data.waiter && data.waiter.length > 0 && data.waiter.map(waiter => <PeopleRow info={waiter} />)}
                        </tbody>
                    </table>
                </Card>
            </>}
        </>
    )
}

export default Restaurant