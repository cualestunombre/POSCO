module.exports = {
    PI : 3.14,
    min : function(){
        const min = Number.MAX_SAFE_INTEGER;
        return Array.from(arguments)
             .reduce((acc,e)=>{
                if (acc >= e) return e;
                return acc;
             },min);
    },
    max : function(){
        const max = Number.MIN_SAFE_INTEGER;
        return Array.from(arguments)
            .reduce((acc,e)=>{
                if (acc < e) return e;
                return acc;
            },max);
    }
};



