const promiseProvider = (value)=>{
    return new Promise((resolve,reject)=>{
        if (value < 10){
            console.log(value);
            resolve(++value);
        }else{
            reject("error");
        }
    });
};

promiseProvider(1)
    .then(v=>promiseProvider(v))
    .then(v=>promiseProvider(v))
    .then(v=>promiseProvider(v))
    .then(v=>promiseProvider(v))
    .then(v=>promiseProvider(v))
    .then(v=>promiseProvider(v))
    .then(v=>promiseProvider(v))
    .then(v=>promiseProvider(v))
    .then(v=>promiseProvider(v))
    .then(v=>promiseProvider(v))
    .then(v=>promiseProvider(v))
    .then(v=>promiseProvider(v))
    .then(v=>promiseProvider(v))
    .then(v=>promiseProvider(v))
    .catch(v=>console.log(v));

Promise.resolve(
    {value:"value"}
).then(v=>console.log(v));

Promise.reject({error:"error"})
    .catch(e=>console.log(e));


Promise.all(
    [promiseProvider(1),promiseProvider(2),promiseProvider(3)]
).then(r=>console.log(r));

// 예외 발생
Promise.all(
    [promiseProvider(1),promiseProvider(10),promiseProvider(3)]
).then(r=>console.log(r));


Promise.allSettled(
    [promiseProvider(1),promiseProvider(2),promiseProvider(3)]
).then(r=>console.log(r));

// 예외 발생x
Promise.allSettled(
    [promiseProvider(1),promiseProvider(10),promiseProvider(3)]
).then(r=>console.log(r));

// Promise.any();
// Promise.all();