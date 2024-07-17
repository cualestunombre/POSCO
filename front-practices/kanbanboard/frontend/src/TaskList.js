import React from 'react';
import * as styles from './assets/css/styles.css';
import Task from './Task';
export default function TaskList({tasks,setter,no}){
    return(
        <div className={styles.Task_List}>
            <ul>
            {
                tasks.map(e=><Task no={no} setter={setter} key={e.no} task={e}/>)
            }
            </ul>
            <input className={styles.Input_Add_Task} type="text" placeholder="태스크 추가"></input>
        </div>
    );
}