// Array 함수 - map
const a = [1,2,3];
const newA = a.map(e=>e*2);
console.log(newA);


// Array 함수 - filter
const b = [5,10,15];
const newB = b.filter(e=>e%2 != 0);
console.log(newB);

// Array 함수 - forEach


// Array 함수 - reduce
const ret = 
    [10,15,20]
    .reduce((acc,e)=>
        {console.log(acc,e); return acc+e;},0
    );
console.log(ret);