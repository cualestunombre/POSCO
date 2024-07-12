const path = require('path');

module.exports = {
    mode: 'development',
    entry: path.resolve('src/index.js'), // Entry 설정
    output: {
        path: path.resolve('public'),    // Output 경로 설정
        filename: 'assets/js/main.js'    // Output 파일 이름 설정
    }
};
