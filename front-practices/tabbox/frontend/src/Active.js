import React, {useState,useEffect} from "react";


export default React.memo(function Active(){
    let number = 1;

    useEffect(()=>{


        return ()=>{
            number++;
            console.log(number);
        }
    },[]);
    return(
        <>
            <div className="activeClass">
                
            </div>
        </>
    );
})