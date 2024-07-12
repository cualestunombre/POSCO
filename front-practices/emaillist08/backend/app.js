const express = require("express");
const app = express();
const port = 8040;
const connect = require("./schemas/index");
const emaillist = require("./schemas/emaillist");
const cors = require("cors");

connect();

app.use(cors());

app.use(express.urlencoded({extended:true}));
app.use(express.json());


app.get("/emails",async(req,res)=>{
   const data = await emaillist.find(); 
   res.send(data);
});

app.post("/emails",async(req,res)=>{
    await emaillist.create({
        firstName:req.body.firstName,
        lastName:req.body.lastName,
        email:req.body.email
    });
    res.send({result:"success"});

});

app.listen(port);


