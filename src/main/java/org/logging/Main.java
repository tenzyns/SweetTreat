package org.logging;

public class Main {
    public static void main(String[] args) {

        BestCourier bestCourier = new BestCourier();
//        Cheapest with refrigeration :Bobby
//        bestCourier.selectCourier("11:00", 4, true);

//       Cheapest without refrigeration and with the right distance : Martin
//        bestCourier.selectCourier("11:00", 2, false);

        //time and distance exception
        bestCourier.selectCourier("16:40", 4.5, false);

        //with distance exception
//        bestCourier.selectCourier("11:50", 5.5, false);

        //with time exception
//        bestCourier.selectCourier("17:50", 3, false);

        //With refrigeration and late: Geoff
//        bestCourier.selectCourier("15:20", 4, true);

// longer distance and later delivery: Robert
//        bestCourier.selectCourier("16:20", 4.5, false);


    }
}