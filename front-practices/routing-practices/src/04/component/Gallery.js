import React from 'react';
import {Link} from 'react-router-dom';

export default function Gallery() {
    return (
        <div>
            <h1>Gallery</h1>
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