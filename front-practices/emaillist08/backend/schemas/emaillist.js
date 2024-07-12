const mongoose = require("mongoose");

const { Schema } = mongoose;

// 레슨 스키마 정의
const emaillistSchema = new Schema({
    firstName:{
        type:String,
        required:true
    },
    lastName:{
        type:String,
        required:true
    },
    email:{
        type:String,
        required:true
    },
    
});




emaillistSchema.index({email:1}, { unique: true });

// Lesson 모델을 생성하여 내보냄
module.exports = mongoose.model('emaillist', emaillistSchema);
