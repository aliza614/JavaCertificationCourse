import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.locks.ReentrantLock;

public class Main {
    public static final String EOF="EOF";

    public static void main(String[] args) {
       List<String> buffer=new ArrayList<>();
        ReentrantLock bufferLock=new ReentrantLock();
       MyProducer producer=new MyProducer(buffer, ThreadColor.ANSI_GREEN, bufferLock);
       MyConsumer consumer1=new MyConsumer(buffer, ThreadColor.ANSI_PURPLE, bufferLock);
       MyConsumer consumer2=new MyConsumer(buffer, ThreadColor.ANSI_CYAN, bufferLock);
        new Thread(producer).start();
        new Thread(consumer1).start();
        new Thread(consumer2).start();
    }
}

class MyProducer implements Runnable{
    private List<String> buffer;
    private String color;
    private ReentrantLock bufferlock;
    public MyProducer(List<String> buffer, String color, ReentrantLock bufferlock) {
        this.buffer = buffer;
        this.color = color;
        this.bufferlock=bufferlock;
    }

    @Override
    public void run() {
        Random random=new Random();
        String [] nums={"1","2","3", "4", "5"};
        for (String num:nums){
            try{
                System.out.println(color+"Adding..."+num);
                //synchronized (buffer){
                bufferlock.lock();
                    try{
                        buffer.add(num);
                    } finally{
                        bufferlock.unlock();
                    }
                //}
                Thread.sleep(random.nextInt(1000));
            }catch(InterruptedException e)
            {
                System.out.println("Producer was interrupted");
            }
        }
        System.out.println(color+"Adding EOP and exiting...");
        //synchronized (buffer){
        bufferlock.lock();
            try{
                buffer.add("EOF");
            }
         finally{
                bufferlock.unlock();
            }
         //}
    }
}
class MyConsumer implements Runnable{
    private List<String> buffer;
    private String color;
    private ReentrantLock bufferLock;
    public MyConsumer(List<String> buffer, String color, ReentrantLock bufferLock) {
        this.buffer = buffer;
        this.color = color;
        this.bufferLock=bufferLock;
    }

    @Override
    public void run() {
        while (true){
            bufferLock.lock();
            //synchronized (buffer){
            try{
                if(buffer.isEmpty()){
                    bufferLock.unlock();
                    continue;
                }
                if(buffer.get(0).equals("EOF"))
                {
                    System.out.println(color+"Exiting");
                    bufferLock.unlock();
                    break;
                }else{

                    System.out.println(color+"Removed"+buffer.remove(0));
                }
            //}
            //problem here because you skip the unlock with continue but it's still being held.
            // so eventually exceed the maximum locks you can have
            //this was a problem here-->bufferLock.unlock();

        }
    }
}