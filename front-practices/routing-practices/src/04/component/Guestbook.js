import React from 'react';
import {Link} from 'react-router-dom';

export default function Guestbook() {
    return (
        <div>
            <h1>Guestbook</h1>
            <ul>
                    <li>
                        <Link to={'/'}>[Main]</Link>
                    </li>
                    <li>     
                        <Link to={'/guestbook'}>[Guestbook]</Link> 
                    </li>
                    <li>    
                        <Link to={'/gallery'}>[Gallery]</Link> 
                    </li>
                </ul>
        </div>
    );
}