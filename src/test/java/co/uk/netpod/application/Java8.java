package co.uk.netpod.application;

import java.util.function.Predicate;

public class Java8 {
    public static void main(String[] args) {
        Predicate<Integer> lesserthan = i -> (i < 18);
        System.out.println("args = [" + lesserthan.test(10) + "]");

        Predicate<Integer> numberLessZero = (i) -> i < 0;
        System.out.println("args = [" + lesserthan.test(10) + "]");
    
    }
}
