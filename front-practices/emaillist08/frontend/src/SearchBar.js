import React from "react";
import {Searchbar} from "./assets/css/styles.css"
export default function(){
    return (
        <>
            <div className={Searchbar}>
                <input type='text' placeholder='찾기'/>
            </div>
        </>
    );
}