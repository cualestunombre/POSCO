package networks;

public class ThreadEx01 {
	
	public static void main(String[] args) {
		
		Thread alphabetThread = new Thread(new Runnable() {
			@Override
			public void run() {
				for (char i = 'a' ; i <= 'z'; i++) {
                	System.out.println(i);
                	try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
                }
			}
		});
		
		Thread digitThread = new Thread(new Runnable() {
			@Override
            public void run() {
                for (int i = 0 ; i < 10; i++) {
                	System.out.println(i);
                	try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
                }
            }
		});
		digitThread.start();
		alphabetThread.start();
		
		
	
	}

}
