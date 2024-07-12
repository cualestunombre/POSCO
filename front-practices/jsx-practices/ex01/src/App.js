import React, { useState } from 'react';
import style from "./style.css";

function App() {
    const [inputValue, setInputValue] = useState('');

    return (
        <div>
            {
                /*
                    JSX 태그 내부에서 평가되어야 하는 요소는 {}안에 넣어야 한다
                */
            }
            {["안녕", "하세요", "ㅋㅋㅋ"].map(e => <div key={e}>{e}</div>)}
            <h1>Ex01</h1>
            <p>특징1: HTML과의 차이점</p>

            {/*
                1. 속성은 Camel Case
            */}
            <input 
                type='text' 
                maxLength='10' 
                value={inputValue}
                onChange={(e) => setInputValue(e.target.value)}
            />

            {/*
                2. Element 꼭 닫는다.
            */}
            <br/>
            <hr/>
            <img src='' alt='' />

            {/*
                3. JSX Element의 속성 이름은 DOM API와 일치한다.
                <h4 id='title' class='header'>타이틀</h4>
                document.getElementById('title').className = 'header';
            */}
            <h4 id='title' className='header'>타이틀</h4>
            <p>{inputValue}</p>
        </div>
    );
}

export { App };
