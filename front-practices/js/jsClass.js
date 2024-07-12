/*
class Rect
*/

class Rect{
    static name = 'Rect';
    static getName(){
        console.log(`this.name:${this.name}`);
        console.log(`Rect.name:${Rect.name}`);
    }

    constructor(width,height){
        this.width = width;
        this.height = height;
    }

    draw(){
        console.log(`width:${this.width},height:${this.height}`)
    }

}

/*
class ColorRect
*/

class ColorRect extends Rect{
    constructor(width,height,color){
        super(width,height);
        this.color = color
    }

    draw(){
        super.draw();
        console.log(`color:${this.color}`);
    }

    func = ()=>{
        console.log(this);
        this.draw();
    }
    number = 5;
}

const rect1 = new Rect(10,20);
rect1.draw();
Rect.getName();
const colorRect1 = new ColorRect(100,200,'black');
colorRect1.draw();

console.log(colorRect1 instanceof ColorRect);
console.log(colorRect1 instanceof Rect);
console.log(colorRect1.__proto__);


