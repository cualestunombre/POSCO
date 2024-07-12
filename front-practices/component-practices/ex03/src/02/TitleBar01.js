import React, {Component} from 'react';

export default class TitelBar01 extends Component {
    constructor(props) {
        super(props);
    }

    onclickHandler = ()=>{
        console.log("clicked");  
        console.log(this);  
    };

    
    render() {
        return (
            <div onClick={()=>{this.onclickHandler()}}>
                <h4>
                    Function Handler in Class Component(click here!)
                </h4>
            </div>
        );
    }
}