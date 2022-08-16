package org.logging;

import java.math.BigDecimal;
import java.time.LocalTime;
import java.util.ArrayList;

public class BestCourier {

    public void selectCourier(String time, double distance, boolean refrigeration) {
        CourierList courierList = new CourierList();
        LocalTime orderTime = LocalTime.parse(time);
        ArrayList<Courier> screenedCouriers = new ArrayList<>();
        for (Courier i : courierList.getCourierList()) {
            if(refrigeration && orderTime.isAfter(i.getStartTime()) && orderTime.isBefore(i.getEndTime()) &&
                    i.getIsBoxRefrigerated() && i.getMaxDistance() >= distance) {
                screenedCouriers.add(i);
            } else if(orderTime.isAfter(i.getStartTime()) && orderTime.isBefore(i.getEndTime())
                     && i.getMaxDistance() >= distance) {
                screenedCouriers.add(i);
            }
        }
        Courier cheapest = screenedCouriers.get(0); //To handle exception if length is 0
        int size = screenedCouriers.size();
        for (int j = 1; j < size; j++) {
            if(screenedCouriers.get(j).getRatePerMile().compareTo(cheapest.getRatePerMile()) < 0 ) {
                cheapest = screenedCouriers.get(j);
            }
        }
        System.out.println("The cheapest courier for your delivery is " + cheapest.getName());
        System.out.println("Your delivery cost is: £" + BigDecimal.valueOf(distance).multiply(cheapest.getRatePerMile()));


    }
}
