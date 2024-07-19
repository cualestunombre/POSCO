import React, { useState, memo } from 'react';
import * as styles from './assets/css/styles.css';
import Task from './Task';
import axios from 'axios';

export default memo(function TaskList({
    tasks,
    insertTask,
    no,
    handleCheckboxChange,
    onTaskDelete,
}) {
    const [inputValue, setInputValue] = useState('');
    const [isComposing, setIsComposing] = useState(false);

    return (
        <div className={styles.Task_List}>
            <ul>
                {tasks?.map((e) => (
                    <Task
                        key={e.no}
                        no={no}
                        handleCheckboxChange={handleCheckboxChange}
                        onTaskDelete={onTaskDelete}
                        task={e}
                    />
                ))}
            </ul>
            <input
                className={styles.Input_Add_Task}
                type="text"
                placeholder="태스크 추가"
                value={inputValue}
                onCompositionStart={() => setIsComposing(true)}
                onCompositionEnd={() => setIsComposing(false)}
                onKeyDown={async (e) => {
                    if (!isComposing && e.key === 'Enter') {
                        const res = await axios.post('/api/task', {
                            name: inputValue,
                            done: 'N',
                            cardNo: no,
                        });

                        setInputValue('');

                        insertTask(no, res.data.data);
                    }
                }}
                onChange={(e) => setInputValue(e.target.value)}
            />
        </div>
    );
});
