package task6;
// Одним зі способів боротьби з вже існуючим DeadLock є натиснути на червоний квадрат.
//Взаємоблокування неможливо повністю вирішити.Але ми можемо уникнути їх.
//Ми повинні:
// - уникати блокування кількох потоків,
// - Уникати непотрібних блокувань : блокування слід використовувати для важливих потоків.
//Для уникнення ситуацій DeadLock частково можна, де можливо, не використовувати конструкції wait, notify, join.
//у нашому випадку ми змінили код, а саме: не використали метод join в SecondClass. Код коректно завершив роботу.

public class Main {
    public static void main(String[] args) {
        FirstClass thread1 = new FirstClass() ;
        SecondClass thread2 = new SecondClass() ;
        thread1.setThread2(thread2 );
        thread2.setThread1(thread1 );
        thread1.start() ;
        thread2.start() ;
    }
}
class FirstClass extends Thread {
    Thread thread2;

    public FirstClass() {
        System.out.println("First");
    }

    @Override
    public void run() {
        System.out.println("First start");
        try {
            sleep(2000);
        } catch (Exception e) {
            System.out.println(e.getMessage() );
        }
        try {
            thread2 .join();

        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("First finished");
    }
    public void setThread2(Thread thread) {
        this.thread2 = thread ;
    }
}
class SecondClass extends Thread {
    Thread thread1;

    public SecondClass() {
        System.out.println("Second");
    }

    @Override
    public void run() {
        System.out.println("Second start");
        try {
            sleep(2000);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("Second finished");
    }
    public void setThread1(Thread thread) {
        this.thread1 = thread ;
    }

}
