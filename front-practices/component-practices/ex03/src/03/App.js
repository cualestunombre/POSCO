import React,{useState} from 'react';

export default function App() {
    
    const [value,setValue] = useState(0);
    return (
        <>
            <h2>ex03 - SyntheticEvent</h2>
            <p>
                Native DOM Event 객체를 Wrapper 하고 있다.<br/>
                Native 이벤트 객체와 사용하는 방식이 같다.
            </p>
            <form
                onSubmit={(e)=>{
                    e.preventDefault();
                    
                }}
                name='addForm'
                method='post'
                action='/do/not/go'>
                <input
                    onChange={(e)=>{setValue(e.target.value)}}
                    value={value}
                    type='text'
                    name='message'
                    placeholder='메세지를 입력 하세요' />
                <br/>
                <br/>
                <input
                    type='submit'
                    value='등록' />
            </form>
        </>
    );
}