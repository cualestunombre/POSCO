import React,{useEffect}from 'react';
import * as styles from '../../assets/scss/component/About.scss';
import { useNavigate } from 'react-router-dom';
export default function About() {
    const navigate = useNavigate();

    useEffect(() => {
        const timeOut = setTimeout(()=>{
            navigate("/error");
        },2000);

        return () => {
            clearTimeout(timeOut);
        };
    }, []);
  
    return (
            <div className={styles.About}>
                <h2>kickscar 입니다.</h2>
            </div>
    );
}