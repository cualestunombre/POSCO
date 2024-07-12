import React from 'react';

function TitelBar02() {

    const onClickHandler = ()=>{
        console.log("clicked");
    }

    return (
        <div onClick={()=>{onClickHandler()}}>
            <h4>
                Function Handler in Function Component(click here!)
            </h4>
        </div>
    )
}

export default TitelBar02;