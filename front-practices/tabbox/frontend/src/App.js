import React,{useState} from 'react';
import TabView  from './TabView';
import ListItem from './ListItem';
import Active  from './Active';
import * as styles from '../public/styles.css';
function App() {
    console.log(styles); 
    const [curTab,setCurTab] = useState(0);
    const [isActive,setIsActive] = useState(false);
    const [tabs,setTabs] = useState(  [
        {no:0, name:'메뉴1', contents: '메뉴1의 뷰 내용'},
        {no:1, name:'메뉴2', contents: '메뉴2의 뷰 내용'},
        {no:2, name:'메뉴3',contents: '메뉴3의 뷰 내용'},
        {no:3, name:'메뉴4',contents: '메뉴4의 뷰 내용'},
        {no:4, name:'메뉴5', contents: '메뉴5의 뷰 내용'}
    ]);

    


    const handleClick = (no)=>{
        setCurTab(no);
    };

    const handleButtonClick = ()=>{
        setIsActive(!isActive);
    };
    return (
        <div className='App'>
            <div className='tab-box'>
                <ul>
                    {
                        tabs.map(e=>
                            <ListItem curTab={curTab} onClick={()=> handleClick(e.no)} key={e.no} info={e} />)
                    }
                </ul>
                <TabView contents={tabs[curTab].contents}/>
                <button onClick={handleButtonClick}>버튼</button>
                {isActive ? <Active/> : ""}
            </div>
        </div>
    );
}



export {App};