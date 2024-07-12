// 구조 분해 할당(배열, 객체)

// ex1 - basic
const user = {
    firstName: '둘',
    lastName: '리',
    age : 10
};

const {firstName,lastName, age} = user;
console.log(firstName);
console.log(lastName);
console.log(age);

const arr = [1,2,3,4];
const [one,two,three] = arr;
console.log(one,two,three);

// ex2 - default
const goods = {
    name: 'TV',
    price: 1000,
    countStock: 10
};

const {name, price,countStock, countSold=10} = goods;
console.log(name,price,countStock,countSold);

// ex3 - 구조 분해 대상이 되는 객체의 속성 이름과 다른 변수 이름을 사용할 때...
const person = {
    n:'마이콜',
    c:'korea'
};

const {n: fullname, c:country} = person;
console.log(fullname, country);

// ex4 - 내부객체(nested object)의 구조분해
const student = {
    name: '둘리',
    age:10,
    score:{
        math:100,
        science:90,
        english:85
    }
}

const {score:{math,science,english},age:student_age} = student;
console.log(math,science,english,student_age);

// ex5 - 함수 파라미터
const avgScore = ({score:{math,science,english,music=0}}) => {
    console.log(math,science,english,music);
};
avgScore(student);


// ex6 - 배열의 구조분해 : basic
const color = [155,200,675];
let [red,green,blue] = color;

// ex7 - 배열의 구조 분해 : default value
[red,green,blue,alpha=0] = color;

// ex8 - 배열의 구조 분해 : skip value
const [,,colorOfBlue] = color;
console.log(colorOfBlue); 

// ex9 - swap
let x = 10;
let y = 20;
console.log(x,y);

let temp = x;
x = y;
y = temp; 
console.log(x,y);

[y,x] = [x,y];
console.log(x,y);

// ex10 - ...array : array spread operator
const colors = ['red', 'orange', 'yellow', 'green','blue','indigo','violet'];
const [first,...rest] = colors;

// 배열이 맞다
console.log(Array.isArray(rest));

// 가변 파라미터 함수에 ...를 사용할 수 있다
const printColor = ([...rest],b) => {
    console.log(b);
    rest.forEach(e=>console.log(e));
};

printColor(['red','orange','yellow'],'z');
// 배열 펼치기
printColor([...colors]);

const printColor2 = (first,second,...rest)=>{
    
    rest.forEach(e=>console.log(e));
}

printColor2('black','white','gold');
printColor2(...colors);