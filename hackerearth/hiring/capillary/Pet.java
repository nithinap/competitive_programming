package hackerearth.hiring.capillary;

import java.awt.*;
import java.util.Arrays;

public class Pet {
    public static void main(String[] args) {
        A a = new B();
        a.toFile();

//        Pet a = new Pet();
//        a.start();
    }

    void start() {
        long[] a1 = {3,4,5};
        long[] a2 = fix(a1);
//        boolean a1 = false;
//        boolean a2 = fix(a1);
        System.out.println(a1[0] + a1[1] + " ");
        System.out.println(a2[0] + a2[1]);
//        System.out.println(a1);
//        System.out.println(a2);

    }



    long[] fix(long[] a3) {
        a3[1] = 7;
        return a3;
    }
    /*
    boolean fix(boolean a1) {
        a1 = true;
        return a1;
    }*/
}

abstract class A {
    abstract void toFile();
}

class B extends A {

    @Override
    void toFile() {
        System.out.println("HERE");
    }
}