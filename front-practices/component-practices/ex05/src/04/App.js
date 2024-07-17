import React, {useState, useEffect} from 'react';
import './assets/scss/App.scss'
import Clock from './Clock';

export default function App() {
    const [time, setTime] = useState(new Date());
    const [tick, setTick] = useState(0);
    
    useEffect(()=>{
        const cron = setInterval(()=>{
            setTime(new Date());

            // 이 코드는 안된다
            // setTick(tick + 1); 
            setTick(prevTick => prevTick + 1); 
           
        },1000);

        return ()=>{
            clearInterval(cron);
        }
    },[]);

  


    return(
        <>
            <Clock
                title={`ex05: Clock Component II: ${tick}`}
                hours={time.getHours()}
                minutes={time.getMinutes()}
                seconds={time.getSeconds()} />
        </>
    );    
}