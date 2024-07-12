
const b = ()=>{
    console.log(this);
}
b();

// {}출력
function c(){
    var x = 15;
    console.log(this);

    function d(){
        var x = 11;
        console.log(x);
    }
    console.log(x)

    function e(){
        d();
    }
    d();

    return d;
}
c();
// global객체 출력
console.log(this);

c()();
let i = 12;
10 
i
10 + i;
i
= 
100

console.log(i);
/*
    js 개행은 공백으로 해석되거나, 자동으로 ;를 붙이는 역할을 한다
    표현식을 실행하고자 할 때는 ;를 붙이거나 개행이 있으면 해당 코드를 실행한다.
    이처럼 표현식을 실행하는 것을 표현식 구문이라고 한다.
    구문 뒤에 다가는 ;를 붙이지 않는다
*/


const a
= 
100;

console.log(a);

variable = "많이무";



console.log(variable,global.variable);


{
    function dd(){
        console.log("dd");
    }

}

dd();

