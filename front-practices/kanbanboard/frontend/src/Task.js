import React from 'react';
import * as styles from './assets/css/styles.css';

export default function TaskItem({ task, setter, no }) {
    const handleCheckboxChange = () => {
        setter(prev => {

            return prev.map(card => {
                if (card.no === no) {
        
                    const updatedTasks = card.tasks.map(t => {
                        if (t.no === task.no) {
                            return { ...t, done: !t.done };
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
                checked={task.done} 
                onChange={handleCheckboxChange} 
            />
            {task.name}
            <a href="#" className={styles.Task_Remove}></a>
        </ul>
    );
}
