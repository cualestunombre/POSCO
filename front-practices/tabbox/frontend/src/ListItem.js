import React from "react";


export default function ListItem({info:{no,name,contents},onClick,curTab}){
   
    return (
        <>
            {
                curTab==no ?  <li onClick={onClick} className='active'>{name}</li> 
                :  <li onClick={onClick}>{name}</li>
            }

        </>
    );

}