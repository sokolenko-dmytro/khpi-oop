package ua.khpi.oop.sokolenko14;

import ua.khpi.oop.sokolenko11_12.*;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ThreadPart {
    public static void startThreads() {
        int timer_num = InfoInput.enterTimer();
        System.out.println("");

        Thread1 first = new Thread1();
        Thread t1 = new Thread(first, "Thread ¹1");

        Thread2 second = new Thread2();
        Thread t2 = new Thread(second, "Thread ¹2");

        Thread3 third = new Thread3();
        Thread t3 = new Thread(third, "Thread ¹3");

        t1.start();
        t2.start();
        t3.start();
        Timer timer = new Timer(timer_num, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                System.out.println("");
                t1.interrupt();
                t2.interrupt();
                t3.interrupt();
            }
        });
        timer.setRepeats(false);
        timer.start();
        try {
            t1.join();
            t2.join();
            t3.join();
            timer.stop();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Finishing all threads...");
    }
    
    
    public static void test1() throws InterruptedException {
        int count = 0;
        System.out.println("First Thread: ");
        try {
            for (Prisoner elem : Helper.object) {
                if (!Thread.currentThread().isInterrupted()) {
                    if (RegexProcessing.checkName(elem.getFirstName())) {
                        count++;
                    }
                } else {
                    throw new InterruptedException();
                }
            }
            System.out.println("Number of trips in monday and friday: " + count);
        } catch (InterruptedException e) {
            System.err.println(e.getMessage());
        }
    }

    public static void test2() throws InterruptedException {
        int count = 0;
        System.out.println("Second Thread:");
        try {
            for (Prisoner elem : Helper.object) {
                if (!Thread.currentThread().isInterrupted()) {
                    count++;
                } else {
                    throw new InterruptedException();
                }
            }
            count /= Helper.object.size();
            System.out.println("Average number of total sits: " + count);
        } catch (InterruptedException e) {
            System.err.println(e.getMessage());
        }
    }

    public static void test3() throws InterruptedException {
        System.out.println("Third Thread: ");
        int count = 0;
        try {
            for (Prisoner elem : Helper.object) {
                if (!Thread.currentThread().isInterrupted()) {
                    if (RegexProcessing.checkName(elem.getFirstName())) {
                        count++;
                    }
                } else {
                    throw new InterruptedException();
                }
            }
            System.out.println("First trip is at: " + count);
        } catch (InterruptedException e) {
            System.err.println(e.getMessage());
        }
    }
    
    public static long cParallel() {
        long time_start = System.currentTimeMillis();
        System.out.println("Start...");
        Thread1 first = new Thread1();
        Thread t1 = new Thread(first, "Thread 1");

        Thread2 second = new Thread2();
        Thread t2 = new Thread(second, "Thread 2");

        Thread3 third = new Thread3();
        Thread t3 = new Thread(third, "Thread 3");

        t1.start();
        t2.start();
        t3.start();

        try {
            t1.join();
            t2.join();
            t3.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Finish...");
        return System.currentTimeMillis() - time_start;
    }

    public static long comparisonSequential() {
        long time_start = System.currentTimeMillis();
        System.out.println("Start...");
        try {
            ThreadPart.test1();
            ThreadPart.test2();
            ThreadPart.test3();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Finish...");
        return System.currentTimeMillis() - time_start;
    	}
}

class Thread1 implements Runnable {
    public void run() {
        int count = 0;
        System.out.println("First Thread: ");
        try {
            for (Prisoner elem : Helper.object) {
                if (!Thread.currentThread().isInterrupted()) {
                    if (RegexProcessing.checkName(elem.getFirstName())) {
                        count++;
                    }
                } else {
                    throw new InterruptedException();
                }
            }
            System.out.println("Number of prisoners: " + count);
        } catch (InterruptedException e) {
            System.err.println(e.getMessage());
        }
    }
}

class Thread2 implements Runnable {
    public void run() {
        int count = 0;
        System.out.println("Second Thread: ");
        try {
            for (Prisoner elem : Helper.object) {
                if (!Thread.currentThread().isInterrupted()) {
                    count++;
                } else {
                    throw new InterruptedException();
                }
            }
            count /= Helper.object.size();
            System.out.println("Average number of prisoners: " + count);
        } catch (InterruptedException e) {
            System.err.println(e.getMessage());
        }

    }
}

class Thread3 implements Runnable {
    public void run() {
    	int count = 0;
        System.out.println("Third Thread: ");
        try {
            for (Prisoner elem : Helper.object) {
                if (!Thread.currentThread().isInterrupted()) {
                    if (RegexProcessing.checkName(elem.getFirstName())) {
                        count++;
                    }
                } else {
                    throw new InterruptedException();
                }
            }
            System.out.println("Average number of prisoners: " + count);
        } catch (InterruptedException e) {
            System.err.println(e.getMessage());
        }
    }

}

