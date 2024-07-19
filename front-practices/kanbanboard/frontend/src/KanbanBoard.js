import React, { useState, useEffect, useCallback, useMemo } from 'react';
import * as styles from './assets/css/styles.css'; 
import CardList from './CardList';
import axios from 'axios';

export default function KanbanBoard() {
    const [cards, setCards] = useState([]);

    const handleToggle = useCallback(async (detail) => {
        try {
            const res = await axios.get(`/api/tasks?cardNo=${detail.no}`);
            setCards(prev => {
                return prev.map(v => {
                    if (v.no === detail.no) return { ...v, tasks: res.data.data };
                    return v;
                });
            });
        } catch (error) {
            console.error("Error fetching tasks:", error);
        }
    }, []);

    const insertTask = useCallback((no, task) => {
        setCards(prev => {
            return prev.map(v => {
                if (v.no === no) {
                    return { ...v, tasks: [...v.tasks, task] };
                }
                return v;
            });
        });
    }, []);

    const onTaskDelete = useCallback(async (no, task) => {
        try {
            await axios.delete(`/api/task?no=${task.no}`);
            setCards(prev => {
                return prev.map(v => {
                    if (v.no === no) {
                        return {
                            ...v, tasks: v.tasks.filter(x => x.no !== task.no)
                        };
                    }
                    return v;
                });
            });
        } catch (error) {
            console.error("Error deleting task:", error);
        }
    }, []);

    const handleCheckboxChange = useCallback(async (no, task) => {
        try {
            await axios.post("/api/checkbox", { no: task.no });
            setCards(prev => {
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
        } catch (error) {
            console.error("Error updating task:", error);
        }
    }, []);

    useEffect(() => {
        (async () => {
            try {
                const res = await axios.get("/api/cards");
                setCards(res.data.data);
            } catch (error) {
                console.error("Error fetching cards:", error);
            }
        })();
    }, []);

    const statuses = useMemo(() => [
        { status: 'ToDo', title: 'To Do' },
        { status: 'Doing', title: 'Doing' },
        { status: 'Done', title: 'Done' }
    ], []);

    const filteredCards = useMemo(() => {
        return statuses.map(({ status }) => ({
            status,
            cards: cards.filter(card => card.status === status)
        }));
    }, [cards, statuses]);

    return (
        <div className={styles.Kanban_Board}>
            {filteredCards.map(({ status, cards }) => (
                <CardList
                    key={status}
                    title={statuses.find(s => s.status === status).title}
                    cards={cards}
                    handleToggle={handleToggle}
                    insertTask={insertTask}
                    handleCheckboxChange={handleCheckboxChange}
                    onTaskDelete={onTaskDelete}
                />
            ))}
        </div>
    );
}
