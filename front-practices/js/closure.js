const closure = () => {
    let value = {a:"a",b:"b"};

    return function(){
        console.log(value);
    }
};

const ret = closure();
ret();  
/*
 외부에 대한 보호를 제공
*/

function createProtectedAction(password) {
    // 외부 함수의 변수
    let storedPassword = password;
  
    // 클로저를 반환
    return function(inputPassword, action) {
      if (inputPassword === storedPassword) {
        action(); // 비밀번호가 일치하면 액션 실행
      } else {
        console.log("Incorrect password!");
      }
    };
  }
  
  const protectedAction = createProtectedAction("secret");
  
  // 올바른 비밀번호로 액션 실행
  protectedAction("secret", () => {
    console.log("Action executed!");
  });
  
  // 잘못된 비밀번호로 액션 실행
  protectedAction("wrongPassword", () => {
    console.log("You should not see this message.");
  });




  