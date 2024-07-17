import {useEffect,useState} from "react";

export default function({state}){

    const [ownValue, setOwnValue] = useState(0);


    useEffect(()=>{
    
        console.log("첫 렌더링");

        return ()=>{console.log("언 마운트");}
    },[]);

    return(<>
        <div>
            상위 컴포넌트의 props : {state.count} // 언마운트시 유지
        </div>

        <div onClick={()=>{setOwnValue(prev=>(prev+1))}}>
            상위 컴포넌트의 props : {ownValue} // 언마운트시 유지 X
        </div>
    </>);
}