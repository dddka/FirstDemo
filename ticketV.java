/**
 * Created by IntelliJ IDEA.<p>
 *
 * @Auther: shanbaojia
 * @Date: 2019/2/28 15:28
 * @Description:
 */
public class ticketV {
    public static void main(String[] args) throws InterruptedException {
        String  str = "lock";
        Ticket ticket = new Ticket(100,str);
        new Thread(ticket,"窗口A").start();
        new Thread(ticket,"窗口B").start();
        new Thread(ticket,"窗口C").start();
        new Thread(ticket,"窗口D").start();
    }
}
class Ticket implements Runnable{

    private int num;
    private int init = 1;
    private String lock;

    public Ticket(int num,String lock){
        this.num = num;
        this.lock = lock;
    }

    @Override
    public void run() {
        while (true){    //这一行和下面不能交换，不然都是一个窗口把票卖完了
            synchronized (lock) {
                if (init > num) {
                    System.out.println("火车票已经卖完了");
                    return;
                }
                try {
                    //模拟出票过程，否则因为执行太快，大部分被一个线程执行完了
                    Thread.sleep(200);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + "售出火车票：" + init++);
            }
        }
    }
}

