import React, { memo } from 'react';
import * as styles from './assets/css/styles.css';
import Card from './Card';

export default memo(function({
    title,
    cards,
    handleToggle,
    insertTask,
    handleCheckboxChange,
    onTaskDelete,
}) {
    return (
        <div className={styles.Card_List}>
            <h1>{title}</h1>
            {cards.map((e) => (
                <Card
                    key={e.no}
                    handleToggle={handleToggle}
                    insertTask={insertTask}
                    handleCheckboxChange={handleCheckboxChange}
                    onTaskDelete={onTaskDelete}
                    detail={e}
                />
            ))}
        </div>
    );
});
