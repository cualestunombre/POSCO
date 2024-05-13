package singleTon;

public class Singleton {
    private static volatile Singleton instance;

    private Singleton() {
    	
        // Private 생성자로 외부에서 직접 생성하지 못하도록 합니다.
    	
    }

    public static Singleton getInstance() {
        if (instance == null) {
            synchronized (Singleton.class) {
                if (instance == null) {
                    instance = new Singleton();
                }
            }
        }
        return instance;
    }
}
