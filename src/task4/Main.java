package task4;

public class Main {
    public static void main(String[] args) {
        //створюємо екземпляр класу Book, в якому будуть синхронізуватися методи ;
        Book  book = new Book() ;
        //створюємо екземпляр класу Бібліотекар, який видає книжки;
        Librarian librarian = new Librarian(book , 10);
        //створюємо екземпляр класу Відвідувач, який бере книжки;
        Visitor visitor = new Visitor(book , 10);
        //запускаємо потоки
        librarian .start();
        visitor.start();
    }
}

class Book {
    String s = (char)27 + "[32m";
    String s1 = (char)27 + "[39m";
    String s2 = (char)27 + "[34m";
    int number;

    boolean is;

    synchronized void noBook(int number) {
        // Якщо книжки немає, відвідувач чекає
        if (!is) {
            try {
                wait();
            } catch (Exception e) {
                System.out.println(e.getMessage() );
            }
        }
        System.out.println(s+ "Книжку під номером  " + this.number + " забрав відвідувач"+ s1 );
        is = false;
        notify();
    }

    synchronized void isBook(int number ) {
        // Якщо книжка є, відвідувач її забирає і бібліотекар чекає на повернення;
        if (is) {
            try {
                wait();
            } catch (Exception e) {
                System.out.println(e.getMessage() );
            }
        }
        this.number  = number ;
        System.out.println(s2+ "Книжка під номером " + this.number + " з'явилася в бібліотеці"+ s1);
        is = true;
        notify();
    }
}

class Librarian extends Thread {
    Book  book ;
    int count;

    Librarian(Book  book , int count) {
        this.book  = book ;
        this.count = count;
    }

    public void run() {
        for (int i = 0; i < count; i++) {
            i++;
            book .isBook(i)  ;
        }
    }
}

class Visitor extends Thread {
    Book  book;
    int count;

    Visitor(Book  book, int count) {
        this.book = book;
        this.count = count;
    }

    public void run() {
        for (int i = 0; i < count; i++) {
            i++;
            book.noBook(i) ;
        }
    }
}


