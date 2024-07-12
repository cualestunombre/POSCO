console.log(Array.prototype.length); // 0

let arr1 = new Array();
console.log(arr1.length); // 0

arr1.push(1, 2, 3);
console.log(arr1.length); // 3

let arr2 = [];
console.log(arr2.length); // 0

arr2[2] = 'a';
console.log(arr2.length); // 3
console.log(arr2.pop());
console.log(arr2.length);


Array.prototype.forEach.call([1,2,3],(e)=>console.log(e));


s = ["red","black"].join(",");
console.log(s);


s = [1,2,3,4];
s.shift();
console.log(s);


s = [1,2,3,4];
v = s.slice(1,3);
console.log(v);

s = [1,2,3,4,5];
v = s.splice(0,2,20,30);
console.log(s);


// 1번 인덱스 5로 변경
s = [1,2,3,4,5];
s.splice(1,1,5);
console.log(s);

// 1번 인덱스 100 삽입
s = [1,2,3,4,5];
s.splice(1,0,100);
console.log(s);
console.log(Object.getOwnPropertyNames(s));
console.log(Reflect.ownKeys(s)); 


Array.prototype.insert = function(index,value){
    if (value instanceof Array){
        value.forEach((e)=>{
            this.splice(index++,0,e);
    });
    }else{
        this.push(value);
    }

};

x = [1,2,3,4];
x.insert(1,[100,200]);
console.log(x);




const 
a
= 
1 
+
100

const 
b 
=
1+
2
