const express = require("express");
const path = require("path");

const port = 9090;
const application = express();
application.use(express.static(path.join(__dirname,'public')));

application.listen(port,()=>{
    console.log(`${port}포트에서 서버 시작`);
});

