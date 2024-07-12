const counter = (
    function(){
        // 은닉된 private 변수
        let num = 0;

        return {
            increase(){
                num++;
            },
            decrease(){
                num--;
            },
            get(){
                return num;
            }
        }
    }

());

counter.increase();
console.log(counter.get());

