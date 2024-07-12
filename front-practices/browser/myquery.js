const myQuery = function(param){
    if(typeof(param) === 'function'){
        window.addEventListener("load",param);
    }

    let elements;
    if(typeof(param) === 'string'){
         elements = document.querySelectorAll(param);
    }

    

    return new _myQuery(elements);

}

const _myQuery = function(elements){
    if (elements){
        this.length = elements.length;
        elements.forEach((e, i) => {
            this[i] = e;
        });
    }
   
};

_myQuery.prototype.myQuery = '0.0.1.beta';
_myQuery.prototype.click = function(handler){
    for (let i=0; i<this.length; i++){
        this[i].addEventListener('click',handler);
    }

};
_myQuery.prototype.css = function(name,value){
    for (let i=0; i<this.length; i++){
        console.log(this);
        this[i].style[name] = value;
    }
};


const 마이쿼리 = myQuery;