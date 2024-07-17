import React, {useState, useEffect} from 'react';

export default function Hook({ color }) {

    const [backgroundColor, setBackgroundColor] = useState(null);
    const [text, setText] = useState("");

    if (color != backgroundColor){
        setBackgroundColor(color);
    }

    /* 
        clean-up이 재렌더링시 실행, 컴포넌트 정리후 실행
    */
    useEffect(()=>{
        console.log("매번 실행");
        return ()=>{console.log("정리1");}
    });

    /* 
        clean-up이 컴포넌트 정리후 실행
    */
    useEffect(()=>{
        console.log("한번만 실행");
        return ()=>{console.log("정리2");}
    },[]);

    /* 
        clean-up이 background 변화시 실행, 컴포넌트 정리후 실행
    */
    useEffect(()=>{
        console.log("백그라운드 색 변화시 실행");
        return ()=>{console.log("정리3");}
    },[backgroundColor]);


    return (
        <>
            <h3
                style={ {
                    width: 300,
                    height: 50,
                    backgroundColor: color
                } } />
            <input 
                value = {text}
                onChange = {(e)=>{setText(e.target.value)}}
                type='text' />
        </>
    );
}