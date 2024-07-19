import React, { memo } from 'react';
import * as styles from './assets/css/styles.css';
import axios from 'axios';

export default memo(function TaskItem({
    task,
    no,
    handleCheckboxChange,
    onTaskDelete,
}) {
    return (
        <ul className={styles._Task}>
            <input
                type="checkbox"
                checked={task.done === 'Y'}
                onChange={() => handleCheckboxChange(no, task)}
            />
            {task.name}
            <a
                href="#"
                className={styles.Task_Remove}
                onClick={() => onTaskDelete(no, task)}
            ></a>
        </ul>
    );
});
