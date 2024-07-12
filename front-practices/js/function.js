/*
    함수정의
*/
// 1. 함수 선언문(표현식이 아니라 구문이다)
function add(x,y){
    return x+y;
}
// 2. 함수 리터럴
const add2 = function(x,y){
    return x+y;
}
// 3. 생성자 함수
// 4. 화살표 함수
const add3 =(x,y)=>{return x+y;}

// 함수 즉시 실행
const a = (function(a,b){
    return a+b;
})(5,4);
console.log(a);

// 가변파라미터
const sum = function(){

    // 쓸 수 없음(배열이 아니라 유사 배열)
    // return arguments.reduce((acc,e)=>{
    //     return acc + e;
    // },0);

    return Array.from(arguments).reduce((acc, e) => {
        return acc + e;
    }, 0);
}

const total = sum(1,2,3,4,5);
console.log(total);


// 아래는 함수 표현식으로 해석된다
(function(a,b){
    console.log(a*b);
    return a+b;
})(2,3);


/*
    자바스크립트는 함수 호출 시, 매개변수에 대한 제약이 없다
*/

function func2(a,b){
    console.log(arguments[2]); 
    return a+b;
}

console.log(func2(1,2,3));

/*
    ES6는 변수 기본 값을 설정할 수 있다
*/

const func3 = (a=0,b=0,c=0)=>{
    return a+b+c;
}

console.log(func3(5,6));

if (0){
    console.log("hi");
}else{
    console.log("hello");
}


function enumTest(a,b){
    for (let e of arguments){
        console.log(e);
    }

    
}
enumTest(1,2);


console.log(enumTest.__proto__ == Function.prototype);
console.dir(Function.prototype);
b = {}
console.log(Object.getOwnPropertyDescriptors(Array.prototype));