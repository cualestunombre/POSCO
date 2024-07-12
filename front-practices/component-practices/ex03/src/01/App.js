import React,{useState} from 'react';

function App() {
    const [counter,setCounter] = useState(0);
    const handleOnClick = ()=>{
        setCounter(counter+1);
    };
    return (
        <div id={'App'}>
            <h1 style={{fontSize:"100px",height:"500px",width:"600px",margin:"auto",textAlign:"center"}}>
                {counter}
            </h1>
            <button onClick={()=>{setCounter(counter+1);}}>
                UP
            </button>
            <button onClick={()=>{setCounter(counter-1);}}>
                DOWN
            </button>
    
        </div>
    );
}

export default App;