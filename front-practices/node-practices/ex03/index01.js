/* 모듈로 분리되어 있지 않은 App */
const App = function(){
    const app = {};
    app.textContents = 'hello world';
    return app;
}


console.log(App().textContents);