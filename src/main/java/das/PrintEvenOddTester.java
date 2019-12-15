package das;

public class PrintEvenOddTester {
    public static void main(String[] args) {
        Printer print = new Printer();
        Thread t1 = new Thread(new EvenOddTask(print, 50, false));
        Thread t2 = new Thread(new EvenOddTask(print, 50, true));

        t1.start();
        t2.start();
    }
}

class EvenOddTask implements Runnable{

    private int max;
    private Printer print;
    private boolean isEvenNumber;

    public EvenOddTask(Printer print, int max, boolean isEvenNumber){
        this.max = max;
        this.print = print;
        this.isEvenNumber = isEvenNumber;
    }

    @Override
    public void run() {

        int number = isEvenNumber == true ? 2 : 1;
        while(number <= max){
            if(isEvenNumber)
                print.printEven(number);
            else
                print.printOdd(number);

            number = number + 2;
        }
    }
}

class Printer{

    boolean isOdd = false;

    public synchronized void printEven(int number){
        while(isOdd == false){
            try{
                wait();
            }catch(InterruptedException ie){
                ie.printStackTrace();
            }
        }
        System.out.println("Even: "+number);
        isOdd = false;
        notifyAll();
    }

    public synchronized void printOdd(int number){
        while(isOdd == true){
            try{
                wait();
            }catch(InterruptedException ie){
                ie.printStackTrace();
            }
        }
        System.out.println("Odd: "+number);
        isOdd = true;
        notifyAll();
    }
}
