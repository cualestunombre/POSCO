import React, { useState} from 'react';
import * as styles from './assets/css/styles.css';
import Task from './Task';
import axios from 'axios';

export default function TaskList({ tasks, setter, no }) {
    const [inputValue, setInputValue] = useState("");
    const [isComposing, setIsComposing] = useState(false);

    return (
        <div className={styles.Task_List}>
            <ul>
                {tasks?.map(e => <Task no={no} setter={setter} key={e.no} task={e} />)}
            </ul>
            <input
                className={styles.Input_Add_Task}
                type="text"
                placeholder="태스크 추가"
                value={inputValue}
                onCompositionStart={() => setIsComposing(true)}
                onCompositionEnd={() => setIsComposing(false)}
                onKeyDown={async e => {
                    if (!isComposing && e.key === 'Enter') {
                        const res = await axios.post("/api/task", {
                            name: inputValue,
                            done: "N",
                            cardNo: no
                        });

                        setInputValue("");

                        setter(prev => {
                            return prev.map(v => {
                                if (v.no == no) {
                                    return { ...v, tasks: [...v.tasks, res.data.data] };
                                }
                                return v;
                            });
                        });
                    }
                }}
                onChange={e => setInputValue(e.target.value)}
            />
        </div>
    );
}
