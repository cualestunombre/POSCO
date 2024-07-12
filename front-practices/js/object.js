/*
JS 원시값
undefined: 값이 할당되지 않은 변수의 기본 값입니다.
null: 값이 없음을 나타내는 특별한 값입니다.
boolean: true 또는 false 중 하나의 논리적 값입니다.
number: 숫자입니다. 정수와 부동 소수점 숫자를 포함합니다.
string: 문자열입니다. 작은 따옴표 ', 큰 따옴표 ", 또는 백틱 으로 둘러싸인 텍스트입니다.
symbol: ES6에서 추가된 원시 값으로, 유일하고 변경 불가능한 데이터 타입입니다.
*/


const a = new String("abc");
const func = ()=>{

}


console.log(typeof null);
console.log(typeof 5);
console.log(typeof func);
console.log(a == "abc");
console.log(null == null);
console.log(null === null);
console.log(undefined);
console.log({} instanceof Object);
console.log([] instanceof Array);



/*
자바스크립트 객체1 - object 타입

1. 자바스크립트 객체는 function 타입과 object 타입 딱! 두가지가 있다.
2. 보통, function 타입 객체는 함수라고 부른다.
3. 따라서 자바스크립트에서 객체라고 부르는 것은 object타입의 객체를 가르킨다.
*/

/*
생성방법
생성자 함수를 사용하는 방법
1. Number, Boolean, String, Object, Array 내장 객체(생성자 함수)
2. 사용자 정의 생성자 함수
*/

let o1 = new Object();


b = 5; 
c = new Function();

console.log(typeof(c));
