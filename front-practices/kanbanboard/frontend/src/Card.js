import axios from 'axios';
import React, { useState } from 'react';
import * as styles from './assets/css/styles.css';
import TaskList from './TaskList';

export default function({ detail,setter }) {
    const [isOpen, setIsOpen] = useState(false);

    const handleToggle = async() => {
        setIsOpen(prev=>!prev);
        const res = await axios.get(`/api/tasks?cardNo=${detail.no}`);
        console.log(res);
        setter(prev=>{
            return prev.map(v=>{
                if (v.no == detail.no) return {...v, tasks:res.data.data};
                return v;
            });
        });
            

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
