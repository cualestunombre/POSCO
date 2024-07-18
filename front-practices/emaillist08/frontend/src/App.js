import React,{useState,useEffect} from 'react';
import RegisterForm from './RegisterForm';
import Emaillist from './Emaillist';
import axios from 'axios';
function App(props) {

    const [list,setList] = useState([
    ]);

    useEffect(()=>{
        axios.get("http://localhost:9090/emails")
        .then(e=>{
            
            setList([...e.data]);
        })
  
    },[]);


    return (
        <div id="App">
            <RegisterForm list={list} setList={setList}/>
            <Emaillist list={list} setList={setList}/>
        </div>
    );
}

export default App;