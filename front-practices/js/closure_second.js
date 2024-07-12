const increase = function(num){
    return ++num;
};

const decrease = function(num){
    return --num;
};

const aux = {increase,decrease};

function makeCounter(aux){
    let num = 0;

    return function(){
        num = aux(num);
        return num;
    };
}


const increaser = makeCounter(aux.increase);
console.log(increaser()); 
// 1
console.log(increaser());
// 2

const decreaser = makeCounter(aux.decrease);
console.log(decreaser());
// -1
console.log(decreaser());
// -2

console.dir(makeCounter.__proto__);