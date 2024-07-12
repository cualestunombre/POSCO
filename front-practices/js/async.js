const b = () => new Promise((resolve,reject)=>{
    try{
        console.log("비동기 작업 시작!!");
        setTimeout(()=>{
            resolve("비동기 작업 완료");
        },2000);
        
    }catch(err){
        reject(new Error(err));
    }
    

});

const a = async()=>{
    const c = await b();
    console.log(c);

}


a();

