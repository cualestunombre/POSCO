import React from 'react';
import * as styles from './assets/css/styles.css';
import axios from 'axios';
export default function TaskItem({ task, setter, no }) {
    const handleCheckboxChange = async() => {
        const data = await axios.post("/api/checkbox",{
            no:task.no
        });
        
        setter(prev => {

            return prev.map(card => {
                if (card.no === no) {
        
                    const updatedTasks = card.tasks.map(t => {
                        if (t.no === task.no) {
                            return { ...t, done: t.done === 'Y' ? 'N' : 'Y' };
                        }
                        return t;
                    });
                    return { ...card, tasks: updatedTasks };
                }
                return card;
            });
        });

  

    };

    return (
        <ul className={styles._Task}>
            <input 
                type="checkbox" 
                checked={task.done === 'Y' ? true : false} 
                onChange={handleCheckboxChange} 
            />
            {task.name}
            <a href="#" 
            className={styles.Task_Remove}
            onClick={async()=>{
                await axios.delete(`/api/task?no=${task.no}`);
                setter(prev=>{
                    return prev.map(v=>{
                        
                        if(v.no == no){
                            return {
                                ...v, tasks:v.tasks.filter(x=>x.no != task.no)
                            }
                        }
                        return v;
                    });
                });
            }}
            ></a>
        </ul>
    );
}
