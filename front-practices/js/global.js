function a(){
    console.log(this);
}

a(); // global 객체 출력

// global
x = 16;

console.log(global.x);

const b = ()=>{
    console.log(this);
}

b();

console.log(this);