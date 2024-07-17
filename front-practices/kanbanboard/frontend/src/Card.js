import React, { useState } from 'react';
import * as styles from './assets/css/styles.css';
import TaskList from './TaskList';

export default function({ detail,setter }) {
    const [isOpen, setIsOpen] = useState(false);

    const handleToggle = () => {
        setIsOpen(!isOpen);
    };

    return (
        <div className={styles._Card}>
            <div 
                className={`${styles.Card_Title} ${isOpen ? styles.Card_Title_Open : ''}`}
                onClick={handleToggle} 
            >
                {detail.title}
            </div>
            {   isOpen && 
                <div className="Card_Details">
                    <TaskList no={detail.no} setter={setter} tasks={detail.tasks} />
                </div>
            }  
        </div>
    );
}
