let myVar1 = undefined;
let myVar2; // 암시적으로 undefined
let myVar3 = null;


console.log(myVar1+":"+myVar2+":"+myVar3);

// undefined와 null의 동치 비교

// 값비교(기본형)
console.log(myVar1 == myVar3);
// 타입비교 + 값비교(기본형)
console.log(myVar1 === myVar3);

console.log('4' == 4);
console.log(false == 0);
console.log(false === 0);
console.log('abc' == new String("abc"));
console.log('abc' === new String("abc"));

console.log(true + 10);
console.log('abc' + new String("abc"));
console.log(1 + '11');
console.log("11"+1);
console.log(11==='11');
// === 
/*
    1. 타입이 동일성
    2. 타입이 같은 경우
        2.1. primitive : 값의 동일성
        2.2. object : 객체의 동일성
*/


// == 
/*
    1.1 primitive vs primitive
        값의 동일성
        암묵적 형변환 발생
    1.2 primitive vs object
        객체를 원시값으로 반환 시도해서 비교
    1.3 object vs object
        참조 동등성 비교
    
*/

console.log({"kim":"min"} + 5);