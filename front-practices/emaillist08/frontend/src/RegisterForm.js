import React, { useState } from "react";
import {RegisterForm,InputFirstName, InputLastName,InputEmail} from './assets/css/styles.css'
import axios from 'axios';
export default function ({list,setList}) {
    const [firstName, setFirstName] = useState("");
    const [lastName, setLastName] = useState("");
    const [email, setEmail] = useState("");

    const handleSubmit = (e) => {
        e.preventDefault();
        axios.post("http://localhost:8040/emails",
        {
            firstName, lastName, email
        }).then(e=>{
            setList([...list,{
                firstName, lastName,
                email
            }])
            setFirstName("");
            setLastName("");
            setEmail("");
            

        });

    };

    return (
        <>
            <form className={RegisterForm} onSubmit={handleSubmit}>
                <input
                    value={firstName}
                    type='text'
                    name='firstName'
                    onChange={(e) => setFirstName(e.target.value)}
                    placeholder='성'
                    className={InputFirstName}
                />
                <input
                    value={lastName}
                    type='text'
                    name='lastName'
                    onChange={(e) => setLastName(e.target.value)}
                    placeholder='이름'
                    className={InputLastName}
                />
                <input
                    value={email}
                    type='text'
                    name='email'
                    onChange={(e) => setEmail(e.target.value)}
                    placeholder='이메일'
                    className={InputEmail}
                />
                <input type='submit' value='등록' />
            </form>
        </>
    );
}
