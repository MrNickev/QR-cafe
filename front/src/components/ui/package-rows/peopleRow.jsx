import styles from "./peopleRow.module.css";
import {FiEdit3} from "react-icons/fi";
import {AiOutlineDelete} from "react-icons/ai";

const PeopleRow = ({info}) => {
    return(
        <tr key={info.id} className={styles.row}>
            <td>{info.user.lastName + " " + info.user.firstName + " " + info.user.middleName}</td>
            <td>{info.user.role ? info.user.role === "GENERAL_MANAGER" ? "Директор" : "Администратор" : info.user.effectivity}</td>
            <td>{info.user.email}</td>
            <td>{info.user.phone}</td>
            <td><FiEdit3 onClick={() => alert('изменить?')} className={styles.edit}/></td>
            <td><AiOutlineDelete onClick={() => alert('удалить?')} className={styles.deleteWaiter} /></td>
        </tr>
    )
}

export default PeopleRow