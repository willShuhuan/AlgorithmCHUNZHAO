package practice;

/**
 * @author DSH
 * @date 2021/3/27
 * @description
 * join保证线程顺序执行
 * 使得线程之间的并行执行变成串行执行
 */
public class ThreadJoin {
    public static void main(String[] args) {

        Thread t1 = new ThreadTest("A");
        Thread t2 = new ThreadTest("B");
        Thread t3 = new ThreadTest("C");
        try {
            t1.start();
            t1.join();
            t2.start();
            t2.join();
            t3.start();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }


    static class ThreadTest extends Thread{
        String name;
        public ThreadTest(String name) {
            this.name = name;
        }

        @Override
        public void run() {
            for (int i = 0; i < 5; i++) {
                System.out.println("线程"+name+i+"正在执行");
            }
        }
    }
}
