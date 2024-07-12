import React from 'react';
import Header from './Header';
// import './assets/scss/App.scss';
import styled from 'styled-components';

const Button = styled.button`
display:block;
margin:auto;
margin-bottom:20px;
background-color: rgb(255,255,255,0.2);
color: white;
font-size: 1.2em;
padding: 10px 20px;
border: none;
border-radius: 5px;
cursor: pointer;

/* 버튼에 마우스를 올렸을 때의 스타일 */
&:hover {
  background-color: #2980b9;
}
`;

function App() {
    return (
        <div id={'App'}>
           <Header />
           <Button>Hello World</Button>
           <Button>We Greet You</Button>
           <Button>Hi There</Button>
        </div>
    );
}

export default App;