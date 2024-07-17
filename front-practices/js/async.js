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
console.log("먼저 실행합니다");



// callback 지원 비동기 함수
// callback의 표준은 callback(error,result); 이다
exports.asyncFn01 = function (param1,callback){
    // 비동기 코드
    setTimeout(()=>{
        // 비동기 처리가 됐다고 치고
        if(param1 != null){
            // 결과 처리
            callback(null, {result:'success'});
        } else{
            //에러처리
            callback(new Error('fail'), null);
        }
    },3000);
}

exports.asyncFn01('params~',(error,result)=>{
    if (error){
        console.error(error);
    }
    else{
        console.log("success");
    }
});


// promise 지원 비동기 함수
exports.asyncFn02 = function(param){
    return new Promise((resolve,reject)=>{
        if(param != null){
            // 결과 처리
            resolve(param);
        } else{
            //에러처리
            reject(new Error("에러 발생"));
        }
    })
}

exports.asyncFn02("hh")
    .then((result)=>{
        console.log(result);
    })
    .catch((ex)=>{
        console.error(ex);
    });