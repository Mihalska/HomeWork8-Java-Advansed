package task2;

public class Main  {
    public static void main(String[] args)  {
        OtherThread t2 = new OtherThread();
        t2.setName("main");
        System.out.println(t2.getName());
        OtherThread t1 = new OtherThread();
        t1.setName("second");
        System.out.println(t1.getName());
        OtherThread t = new OtherThread();
        t.setName("first");
        System.out.println(t.getName());
        t2.start() ;
        t1.start() ;
        t.start() ;
        System.out.println("---Завершення---");

   }

}
class OtherThread extends Thread {
    //для затримки потоків використовуємо метод sleep та регуляємо відповідно який потік має швидше закінчити роботу
    public void run() {

        try {
            if (getName().equals("main")) {
                 sleep(2500);

            } else if (getName().equals("first")){
                 sleep(10);
            } else
                 sleep(1000);

        } catch (Exception e) {
            e.printStackTrace() ;
        } finally {

            if (getName().equals("first"))
                System.out.println("first");
            else if (getName().equals("second")){
                System.out.println("second");
            }else
                System.out.println("main ");

    }
    }
}
