package org.logging;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {

        BestCourier bestCourier = new BestCourier();

//        Rider ranking list extension
//        bestCourier.selectCourier("11:00", 3, false);

        //with distance exception
//        bestCourier.selectCourier("16:50", 3.5, false);

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


//        Rider ranking with 2 couriers
        bestCourier.selectCourier("10:00", 2.5, false);

        //With refrigeration and late: Geoff
//        bestCourier.selectCourier("15:20", 4, true);

// longer distance and later delivery: Robert
//        bestCourier.selectCourier("16:20", 4.5, false);


    }
}