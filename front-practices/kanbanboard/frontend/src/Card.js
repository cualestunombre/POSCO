import axios from 'axios';
import React, { useState, memo } from 'react';
import * as styles from './assets/css/styles.css';
import TaskList from './TaskList';

export default memo(function({
    detail,
    handleToggle,
    insertTask,
    handleCheckboxChange,
    onTaskDelete,
}) {
    const [isOpen, setIsOpen] = useState(false);

    return (
        <div className={styles._Card}>
            <div
                className={`${styles.Card_Title} ${isOpen ? styles.Card_Title_Open : ''}`}
                onClick={() => {
                    handleToggle(detail);
                    setIsOpen((prev) => !prev);
                }}
            >
                {detail.title}
            </div>
            {isOpen && (
                <div className="Card_Details">
                    <TaskList
                        no={detail.no}
                        handleCheckboxChange={handleCheckboxChange}
                        insertTask={insertTask}
                        onTaskDelete={onTaskDelete}
                        tasks={detail.tasks}
                    />
                </div>
            )}
        </div>
    );
});
