const b = (callback) => {
    try {
        console.log("비동기 작업 시작!!");
        setTimeout(() => {
            callback(null, "비동기 작업 완료");
        }, 2000);
    } catch (err) {
        callback(err, null);
    }
};

const a = () => {
    b((err, result) => {
        if (err) {
            console.error("에러 발생:", err);
        } else {
            console.log(result);
        }
    });
};

a();

const arr = [1,2];

