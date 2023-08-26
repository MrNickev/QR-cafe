import styles from './chart-card.module.css'
import {BsFillCaretDownFill} from "react-icons/bs";
import {CartesianGrid, Line, LineChart, ResponsiveContainer, XAxis, YAxis} from "recharts";
import {useEffect, useState} from "react";
import Card from "../card/card";
const ChartCard = () => {
    const [data, setData] = useState()

    useEffect(() => {
        setData([
            {date: "01.08.2023", value: 13456},
            {date: "02.08.2023", value: 10456},
            {date: "03.08.2023", value: 18456},
            {date: "04.08.2023", value: 22456},
            {date: "05.08.2023", value: 13456},
            {date: "06.08.2023", value: 23456},
            {date: "07.08.2023", value: 13456},
            {date: "08.08.2023", value: 30456},
            {date: "09.08.2023", value: 23578},
            {date: "10.08.2023", value: 3458},
            {date: "11.08.2023", value: 15165},
            {date: "12.08.2023", value: 18158},
            {date: "13.08.2023", value: 30456},
            {date: "14.08.2023", value: 30456},
            {date: "15.08.2023", value: 30456},
            {date: "16.08.2023", value: 30456},
            {date: "17.08.2023", value: 30456},
            {date: "18.08.2023", value: 30456},
            {date: "19.08.2023", value: 30456},
            {date: "21.08.2023", value: 30456},
            {date: "22.08.2023", value: 30456},
            {date: "23.08.2023", value: 30456},
            {date: "24.08.2023", value: 30456},
            {date: "25.08.2023", value: 30456},
            {date: "26.08.2023", value: 30456},
            {date: "27.08.2023", value: 30456},
            {date: "28.08.2023", value: 30456},
            {date: "29.08.2023", value: 30456},
            {date: "30.08.2023", value: 30456},
            {date: "31.08.2023", value: 29456}])
    }, []);

    return(
        <Card>
            <div className={styles.heading}>Статистика за <span className={styles.decorated}>август</span><BsFillCaretDownFill/></div>
            <div className={styles.headingItem}>Выручка: 954 000 ₽</div>
            <div className={styles.headingItem}>Количество заказов: 360</div>
            <ResponsiveContainer width="95%" height={300}>
            <LineChart className={styles.chart} data={data}>
                <Line type="monotone" dataKey="value" stroke="#8884d8" />
                <CartesianGrid stroke="#ccc" strokeDasharray="5 5" />
                <XAxis className={styles.axis} dataKey="date"/>
                <YAxis className={styles.axis}/>
            </LineChart>
            </ResponsiveContainer>
            <div className={styles.note + " " + styles.decorated}>Обновление данных может быть с задержкой до 1 дня</div>
        </Card>
    )
}

export default ChartCard