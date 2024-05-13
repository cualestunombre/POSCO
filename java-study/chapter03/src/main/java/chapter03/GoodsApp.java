package chapter03;

public class GoodsApp {
    public static void main(String[] args){
        Goods camera = new Goods();
         
        camera.setName("nickon");
        camera.setPrice(400000);
        camera.setCountSold(10);
        camera.setCountStock(500);
        camera.showInfo();
        
        Goods camera2 = new Goods();
      
        System.out.println(Goods.countOfGoods);
        System.out.println(camera.calcDiscountPrice((float) 0.99));
        
        
    }
    

}
