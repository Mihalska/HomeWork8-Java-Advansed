package task3;

public class Main {
    public static void main(String[] args) {
        String s = (char)27 + "[33m";
        String s1 = (char)27 + "[39m";
        String s2 = (char)27 + "[34m";
        Thread myThread = Thread.currentThread();
        myThread.setName("Main");
        Thread priorityRunner = new Thread(new PriorityRunner() ) ;
        Thread priorityThread = new Thread(new PriorityThread());
        priorityRunner.setPriority(1);
        priorityThread.setPriority(10);
        priorityRunner.start() ;
        priorityThread.start() ;
        System.out.println(myThread.getName() + " Is Thread Alive?: " + myThread.isAlive());
        for (int i = 0; i < 50; i++) {
            System.out.println("Потік  "+ s +myThread.getName() + s1 +" з пріоритетністю " + myThread.getPriority() + " виводить значення " + i);
        }
        System.out.println(s2 + "Main завершив роботу"+ s1);
    }
}
class PriorityRunner implements Runnable {
    @Override
    public void run (){
        String s = (char)27 + "[33m";
        String s1 = (char)27 + "[39m";
        String s2 = (char)27 + "[34m";
        Thread myThread1 = Thread.currentThread() ;
        myThread1.setName("PriorityRunner") ;
        System.out.println(myThread1.getName() + " Is Thread Alive?: " + myThread1.isAlive());
        for (int i = 0; i < 50; i++) {
            System.out.println("Потік  "+ s + myThread1.getName() +s1+" з пріоритетністю " + myThread1.getPriority() + " виводить значення " + i);
        }
        System.out.println(s2 + "PriorityRunner завершив роботу"+ s1 );
    }
}
class PriorityThread extends Thread {
    public void run (){
        String s = (char)27 + "[33m";
        String s1 = (char)27 + "[39m";
        String s2 = (char)27 + "[34m";
        Thread myThread2 = Thread.currentThread() ;
        myThread2.setName("PriorityThread") ;
        System.out.println(myThread2.getName() + " Is Thread Alive?: " + myThread2.isAlive());
        for (int j = 0; j < 50; j++) {
            System.out.println("Потік  "+ s +myThread2.getName()+ s1 +" з пріоритетністю " + myThread2.getPriority() + " виводить значення " + j );
        }
        System.out.println(s2 + "PriorityThread завершив роботу"+ s1 );
    }
}
