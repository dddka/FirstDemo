import java.util.HashMap;
import java.util.UUID;

/**
 * Created by IntelliJ IDEA.<p>
 *
 * @Auther: shanbaojia
 * @Date: 2019/2/28 15:50
 * @Description:
 */
public class whatHashMap {

//使用线程操作hashmap 会导致CPU使用率增长到100% 
    //应当注意。

    public  static void main (String[] args) throws InterruptedException {
        final int i=0;
        final HashMap<String, String> map = new HashMap<String, String>(2);
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10000; i++) {
                    new Thread(new Runnable() {
                        @Override
                        public void run() {
                            map.put(UUID.randomUUID().toString(),"");

                            System.out.println(0);
                        }
                    }, "moon" + i).start();
                }
            }
        }, "ftf");
     t.start();
     t.join();
    }
}
