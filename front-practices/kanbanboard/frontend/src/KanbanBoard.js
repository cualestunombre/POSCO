import React,{useState} from 'react';
import * as styles from './assets/css/styles.css';
import CardList from './CardList';
import cards from './assets/json/data.js'
function KanbanBoard() {
    const [toDos,setToDos] = useState(cards
    .filter(e=>e.status === 'ToDo'));

    const [done, setDone] = useState(cards
    .filter(e=>e.status === 'Done'));

    const [doing, setDoing] = useState(cards
    .filter(e=>e.status === 'Doing'));



    return (
        <div className={styles.Kanban_Board}>  
            <CardList setter={setToDos} cards = {toDos} title={"To Do"}/>
            <CardList setter={setDoing} cards = {doing} title={"Doing"}/>
            <CardList setter={setDone} cards = {done} title={"Done"}/>
        </div>
    );
}

export default KanbanBoard;