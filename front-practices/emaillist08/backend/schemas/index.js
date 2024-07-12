const mongoose = require("mongoose");


// 몽고DB 연결

const connect = ()=>{
    mongoose.connect('mongodb://localhost:27017',
    {
        dbName : 'emaillist',
        maxPoolSize:10
    });

    console.log("몽고 DB 연결 성공");


}


mongoose.connection.on("error",(error)=>{
    logger.error("몽고디비 연결 에러. 연결을 재시도 합니다",error);
    
   
});
mongoose.connection.on("disconnected",()=>{
    logger.error("몽고 디비 연결이 끊어 졌습니다.");
});

module.exports = connect;