package org.logging;

public class Main {
    public static void main(String[] args) {

        BestCourier bestCourier = new BestCourier();
//        bestCourier.selectCourier("11:00", 4.5, true);
//        bestCourier.selectCourier("12:50", 5, true);

//        all eligible except for price
        bestCourier.selectCourier("11:00", 3, false);

        //with distance exception
//        bestCourier.selectCourier("16:50", 3.5, false);

        //with time exception
//        bestCourier.selectCourier("17:50", 3, false);
        //No error
     //   bestCourier.selectCourier("16:20", 4, false);

//        bestCourier.selectCourier("16:40", 4.5, false);
       // bestCourier.selectCourier("17:20", 3, false);

    }
}