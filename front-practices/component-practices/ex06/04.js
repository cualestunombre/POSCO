const fs = require('fs');
const path = require('path');
const update  = require('immutability-helper');
const filePath = path.resolve(__dirname, './json/data.json');;


console.log("== Sol =========================================");

const state = {
    name: 'John',
    age: 30,
    address: {
      city: 'New York',
      country: 'USA'
    },
    grade:{
        math:100,
        science:100
    }
  };
  
  const newState = update(state, {
    address: {
      city: { $set: 'Los Angeles' }
    }
  });

console.log(state != newState);
console.log(state.grade == newState.grade);
console.log(state.address != newState.address);


