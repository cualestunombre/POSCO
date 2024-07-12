import React,{useState,useEffect} from 'react';
import RegisterForm from './RegisterForm';
import SearchBar from './SearchBar';
import Emaillist from './Emaillist';
import axios from 'axios';
function App(props) {

    const [list,setList] = useState([
    ]);

    useEffect(()=>{
        axios.get("http://localhost:8040/emails")
        .then(e=>{
            
            setList([...e.data]);
        })
  
    },[]);


    return (
        <div id="App">
            <RegisterForm list={list} setList={setList}/>
            <SearchBar/>
            <Emaillist list={list}/>
        </div>
    );
}

export default App;