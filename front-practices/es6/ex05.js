/*
    * arrow function
*/


const power = (x)=>{
    return x*x;
};  


const nums = [1,2,3,4,5];
nums.forEach(e=>{
    // 즉시 실행 함수
    const result = (function(e){
        return e*e;
    }(e));
    process.stdout.write(`${e}:${result}\n`);
});

const dooly = {
    name : "둘리",
    friends:['또치','도우너','마이콜'],
    printFriends:function(){
        console.log(this.friends);
        this.friends.forEach(function(){
            // global이 되버린다
            console.log(this.friends);
        });

        this.friends.forEach((friend)=>{
            console.log(`friend:${friend}는 ${this.name}의 친구`);
        });
    },
 
}

dooly.printFriends();
