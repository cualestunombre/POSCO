import React,{useState, useEffect} from 'react';
import clockCss from "./Clock.css"
function Clock(props) {
    const [time, setTime] = useState(getCurrentTime());

    useEffect(() => {
        const interval = setInterval(() => {
            setTime(getCurrentTime());
        }, 1000);

        return () => {
            clearInterval(interval);
        };
    }, []);

  
    function getCurrentTime() {
        const now = new Date();
        const hours = now.getHours().toString().padStart(2, '0');
        const minutes = now.getMinutes().toString().padStart(2, '0');
        const seconds = now.getSeconds().toString().padStart(2, '0');
        const ampm = hours >= 12 ? 'PM' : 'AM';

        return `${hours}:${minutes}:${seconds}${ampm}`;
    }


    return (
        <div className='clock'>
            {time}
        </div>
    );
}

export default Clock;