const fs = require('fs');
const path = require('path');

const filePath = path.resolve(__dirname, './json/data.json');

let order = JSON.parse(fs.readFileSync(filePath, 'utf-8'));
const updateOrderProducts1 = order.products;

updateOrderProducts1.push({
    no: 'c002-003',
    name: '블루양말',
    price: 2000,
    amount: 1
});
console.log(order.products, updateOrderProducts1, order.products === updateOrderProducts1);



console.log("== Sol1 ========================================");
order = JSON.parse(fs.readFileSync(filePath, 'utf-8'))

const updateOrderProducts2 = order.products.concat({
    no: 'c002-003',
    name: '블루양말',
    price: 2000,
    amount: 1
});
console.log(order.products, updateOrderProducts2, order.products === updateOrderProducts2);


console.log("== Sol2 ========================================");
order = JSON.parse(fs.readFileSync(filePath, 'utf-8'))

const updateOrderProducts3 = [...order.products, {
    no: 'c002-003',
    name: '블루양말',
    price: 2000,
    amount: 1
}];
console.log(order.products, updateOrderProducts3, order.products === updateOrderProducts3);