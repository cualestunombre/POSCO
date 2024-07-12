/*
    * let & const
*/

// 1. const 블록 범위 : 상수
try{
    if(true){
        const NUM = 5;
        
    }
    console.log(NUM);
}catch(e){
    console.error("error: "+e);
}

// 2. 대입(Assignment) 에러
try{
    const NUM = 20;
    NUM = 15;
}catch(e){
    console.error("error: "+e);
}

