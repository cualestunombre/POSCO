import React from 'react'; 
// 모듈로 불러 버리면, 선택자를 hash화 한다, 그것을 불러와서 className에 동적으로 넣어줘야 한다
// ID, ClassName을 hash한다
import {Header,namu} from './assets/css/App.css'

function App() {
    console.log(Header);
    console.log(namu);
    return (
        <div id={'App'}>
            <h1 className={Header}>CSS Module I</h1>
        </div>
    );
}

export default App;