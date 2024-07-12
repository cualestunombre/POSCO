// import 하기
/*
    1. mjs를 사용한다
    2. package.json 또는 browser script 태그에 type="module"이라 명시해준다(네임스페이스 오염 방지)
    3. 바벨과 웹팩을 사용한다
*/

// mod1 unnamed export 모듈에서 import할 때는 반드시 이름을 지정한다.
import myFunction from './mod01.mjs'
import Function from './mod02.mjs'
import {add,subtract} from './mod03.mjs'

import * as m from './mod03.mjs'
import math,{add,subtract} from './mod04.mjs'

// 1,2는 반드시 이름 지정이 필요하다

myFunction(1,2);
console.log(Function.subtract(1,2));
console.log(add(123,123));

console.log(m);
console.log(m4);

