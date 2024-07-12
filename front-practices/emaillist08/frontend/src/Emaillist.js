import React,{useState,useEffect} from "react";
import {Emaillist} from "./assets/css/styles.css";
import axios from "axios";
export default function({list}){

  

    return(
        <>
            <ul className={Emaillist}>
                {
                    list.map((e,i)=>
                        {return <li key={e.email}>{e.firstName + e.lastName}<br/>{e.email}</li>}
                    )
                }
            </ul>
        </>

    );
}