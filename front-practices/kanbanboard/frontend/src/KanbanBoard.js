import React,{useState,useEffect} from 'react';
import * as styles from './assets/css/styles.css';
import CardList from './CardList';
import cards from './assets/json/data.js'
import axios from 'axios';

function KanbanBoard() {
    
    const [cards, setCards] = useState([]);

    useEffect(() => {
        const fetchCards = async () => {
            try {
                const res = await axios.get("/api/cards");
                setCards(res.data.data);
            } catch (error) {
                console.error("Error fetching cards:", error);
            }
        };
        fetchCards();
    }, []);
    

  

    return (
        <div className={styles.Kanban_Board}>
            <CardList 
                title="To Do" 
                cards={cards.filter(e=>e.status==='ToDo')} 
                setter={setCards} 
            />
            <CardList 
                title="Doing" 
                cards={cards.filter(e=>e.status==='Doing')} 
                setter={setCards} 
            />
            <CardList 
                title="Done" 
                cards={cards.filter(e=>e.status==='Done')} 
                setter={setCards} 
            />
        </div>
    );
}

export default KanbanBoard;