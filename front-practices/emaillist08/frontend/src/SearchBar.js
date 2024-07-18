import React,{useState} from "react";
import {Searchbar} from "./assets/css/styles.css"
export default function({keyword, setKeyword}){
    
    return (
        <>
            <div className={Searchbar}>
                <input type='text' value={keyword} placeholder='찾기' onChange={(e)=>{setKeyword(e.target.value)}}/>
            </div>
        </>
    );
}