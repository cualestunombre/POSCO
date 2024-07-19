import React, {useState, useEffect,useCallback} from 'react';
import Main from "./component/Main";
import Gallery from "./component/Gallery";
import Guestbook from "./component/Guestbook";
import Error404 from "./component/Error404";

export default function App() {
    const [route, setRoute] = useState('');

    const handlerHashChange = useCallback(() => {
        setRoute(window.location.hash.substring(1));
    }, []); 


    useEffect(()=>{
        // dom을 사용할 수 밖에 없다
        window.addEventListener("hashchange",handlerHashChange);
        
        return ()=>{
            window.removeEventListener("hashchange",handlerHashChange);
        }
    },[]);

    return (() => {
        switch(route) {
            case '' :
            case '/' :
                return <Main />;
            case '/guestbook' :
                return <Guestbook />;
            case '/gallery':
                return <Gallery />;
            default :
                return <Error404 />;                    
        }
    })();
}