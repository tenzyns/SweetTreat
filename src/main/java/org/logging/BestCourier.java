package org.logging;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalTime;
import java.util.ArrayList;
@Getter
@Setter
public class BestCourier {
    private Courier cheapest;

    public void selectCourier(String time, double distance, boolean refrigeration) throws IllegalArgumentException {
        CourierList courierList = new CourierList();
        LocalTime orderTime = LocalTime.parse(time);
        ArrayList<Courier> screenedCouriers = new ArrayList<>();
        for (Courier i : courierList.getCourierList()) {
            if(refrigeration && orderTime.isAfter(i.getStartTime()) && orderTime.isBefore(i.getEndTime()) &&
                    i.getIsBoxRefrigerated() && i.getMaxDistance() >= distance) {
                screenedCouriers.add(i);
                System.out.println(i.getIsBoxRefrigerated());
                System.out.println(i.getName());
            } else if(!refrigeration && orderTime.isAfter(i.getStartTime()) && orderTime.isBefore(i.getEndTime())
                     && i.getMaxDistance() >= distance) {
                screenedCouriers.add(i);
            }
            //System.out.println(screenedCouriers.get(0).getName());
        }
        if(screenedCouriers.size() == 0) {
            throw new Exception("Distance or time out of reach!");
        } else {
            cheapest = screenedCouriers.get(0); //To handle exception if length is 0
            int size = screenedCouriers.size();
            System.out.println("screened courier array size: " + size);
            System.out.println("screened courier1 " + screenedCouriers.get(0).getName());
            //System.out.println("screened courier2 " + screenedCouriers.get(1).getName());
            for (int j = 1; j < size; j++) {
                    if (screenedCouriers.get(j).getRatePerMile().compareTo(cheapest.getRatePerMile()) < 0) {
                        cheapest = screenedCouriers.get(j);
                    }
                }
        }
        System.out.println("The cheapest courier for your delivery is " + cheapest.getName());
        System.out.println("Your delivery cost would be: £" + BigDecimal.valueOf(distance).multiply(cheapest.getRatePerMile()));

    }
}
