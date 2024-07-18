import React, { useState, useEffect } from "react";
import { Emaillist } from "./assets/css/styles.css";
import axios from "axios";
import SearchBar from "./SearchBar";

export default function ({ list,setList }) {
    const [keyword, setKeyword] = useState("");

    return (
        <>
            <SearchBar keyword={keyword} setKeyword={setKeyword} />
            <ul className={Emaillist}>
                {
                    list
                        .filter(e => {
                            if (!e || e === "") return false;
                            const fullName = (e.firstName + e.lastName).toLowerCase();
                            return fullName.includes(keyword.toLowerCase());
                        })
                        .map((e, i) => (
                            <li key={e.email}>
                                {e.firstName + " " + e.lastName}<br />
                                {e.email}
                                <button style={{display:"block",position:"relative", marginLeft:"auto", marginRight:"auto"}}
                                onClick = {async()=>{
                                    const result = await axios.delete(`/emails?email=${e.email}`);
                                    setList(prev=>prev.filter(v=>v.email!=e.email));
                                }}
                                >삭제</button>
                            </li>
                        ))
                }
            </ul>
        </>
    );
}
