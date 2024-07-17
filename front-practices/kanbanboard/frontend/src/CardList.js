import React, {memo} from 'react';
import * as styles from './assets/css/styles.css';
import Card from './Card';
export default memo(function({title,cards,setter}){
    return (
        <div className={styles.Card_List}>
            <h1>{title}</h1>
            {
                cards.map(e=>
                    <Card setter={setter} key={e.no} detail={e}/>
                )
            }
        </div>
    );  
});