import React from 'react';
import {Linkm,NavLink} from 'react-router-dom';

export default function Guestbook() {
    return (
        <div>
            <h1>Guestbook</h1>
            <ul>
                    <li>
                        <NavLink to={'/'}>[Main]</NavLink>
                    </li>
                    <li>     
                        <NavLink to={'/guestbook'}>[Guestbook]</NavLink> 
                    </li>
                    <li>    
                        <NavLink to={'/gallery'}>[Gallery]</NavLink> 
                    </li>
                </ul>
        </div>
    );
}