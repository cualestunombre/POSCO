const express = require("express");
const app = express();
const port = 8040;
const connect = require("./schemas/index");
const emaillist = require("./schemas/emaillist");
const cors = require("cors");

const path = require('path');
const publicPath = path.join(__dirname, 'assets');


connect();

app.use(cors());
app.use(express.static(publicPath));
app.use(express.urlencoded({extended:true}));
app.use(express.json());

app.get("/",(req,res)=>{
    res.sendFile(__dirname+"/assets/index.html");
});

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

app.delete("/emails", async (req, res) => {
    const { email } = req.query;  // Query parameter로 email 사용



    const result = await emaillist.deleteOne({ email: email });

    if (result.deletedCount === 0) {
        return res.status(404).send({ error: "Email not found" });
    }

    res.send({ result: "success" });
  
});


app.listen(port);


