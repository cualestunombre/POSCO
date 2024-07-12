function Class(name) {
    this.name = name;
}



// 프로토타입 체인을 명시적으로 설정할 필요는 없지만,
// 명확히 하고자 하는 경우 다음 두 줄을 사용할 수 있습니다.
// Class.prototype = Object.create(Object.prototype);
// Class.prototype.constructor = Class;

// 프로토타입 메서드 정의
Class.prototype.hi = function() {
    console.log(`Hi I am ${this.name}`);
};

// 객체 생성 및 메서드 호출
let instance = new Class('Alice');
instance.hi(); // "Hi I am Alice"


function ChildClass(name, age) {
    Class.call(this, name); // 부모 클래스의 생성자 호출
    this.age = age;
}

// ChildClass의 프로토타입을 Class의 인스턴스로 설정
ChildClass.prototype = Object.create(Class.prototype);
ChildClass.prototype.constructor = ChildClass;

// ChildClass만의 메서드 추가
ChildClass.prototype.hello = function() {
    Class.prototype.hi.call(this); // 부모 클래스의 메서드 호출
    console.log(`Hello I'm ${this.age} years old`);
};

let child = new ChildClass('Bob', 10); // 매개변수 전달
child.hello(); // "Hi I am Bob" 출력 후 "Hello I'm 10 years old" 출력

const test = {
    func:function(){
        console.log(this.age);
    },
    age:5
};

const newFunc = test.func;
newFunc.call(test);

console.log(ChildClass.prototype.__proto__.__proto__);
Array.prototype.forEach.call([1,2,3],(e)=>{console.log(e)});

a = new Number(5);
console.log(instance.__proto__ === Class.prototype);


