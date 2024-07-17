const fs = require('fs');
const path = require('path');

const filePath = path.resolve(__dirname, './json/data.json');;

console.log("== Violation ===================================");
let order = JSON.parse(fs.readFileSync(filePath, 'utf-8'));

const updateOrder = Object.assign({}, order, {receive: '강남구 논현동...'});
updateOrder.payment.method = "mobile";

console.log(order, updateOrder);