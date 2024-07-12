import './assets/scss/App.scss';
import logo from './assets/images/logo.svg';
import React from "react";

function App() {
    // const App = document.createElement('div');
    // App.textContent = "Hello Webpack";
    // App.className = "Header";
    // App.innerHTML = `<img src='${logo}'>`;

   /*
   React.createElement("div",null,React.createElement("p",null,"안녕"));
    과
    JSX
    <div>
        <p>안녕</p>
    </div>
    는 같은 표현이다.
    그러나, babel이 JSX -> JS로 바꾸는 역할을 한다

    모든 JSX 태그들이 React.createElement가 된다는 것을 이해하면 된다 
   */


    // React DOM의 element
    const App = React.createElement("div",null,'helloworld');
    return App;

    
}

export {App};