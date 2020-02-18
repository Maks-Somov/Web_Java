package example7;

import java.util.concurrent.atomic.AtomicInteger;

public class MainConcurrency {
    static int syncSum;
    static volatile int sum;
    static final AtomicInteger ATOMIC_SUM = new AtomicInteger();
    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 10000; i++) {
          new Thread(){
              @Override
              public void run() {
                  sum++;
                  ATOMIC_SUM.incrementAndGet();
                  synchronized (this){
                      syncSum++;
                  }
              }
          }.start();
        }
        Thread.sleep(500);
        System.out.println(sum);
        System.out.println(ATOMIC_SUM.get());
        System.out.println(syncSum);
    }
}
/*  new Thread() {
                @Override
                public void run() {
                    System.out.println(this.getName());
                }
            }.start();*/


/* int finalI = i;
            new Thread(new Runnable() {
              @Override
              public void run() {
                  System.out.println(finalI);
              }
          }).start();*/