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

    public void selectCourier(String time, double distance, boolean refrigeration) throws Exception {
        CourierList courierList = new CourierList();
        LocalTime orderTime = LocalTime.parse(time);
        ArrayList<Courier> screenedCouriers = new ArrayList<>();
        ArrayList<String> failMsg = new ArrayList<>();
        for (Courier i : courierList.getCourierList()) {
            if(refrigeration && orderTime.isAfter(i.getStartTime()) && orderTime.isBefore(i.getEndTime()) &&
                    i.getIsBoxRefrigerated() && i.getMaxDistance() >= distance) {
                screenedCouriers.add(i);
                System.out.println(i.getIsBoxRefrigerated());
                System.out.println(i.getName());
            } else if(!refrigeration && orderTime.isAfter(i.getStartTime()) && orderTime.isBefore(i.getEndTime())
                     && i.getMaxDistance() >= distance) {
                screenedCouriers.add(i);
            } else if(i.getMaxDistance() < distance) {
                failMsg.add(i.getName() + " can't deliver beyond " + i.getMaxDistance() + " miles");
            } else if(orderTime.isBefore(i.getStartTime()) || orderTime.isAfter(i.getEndTime())) {
                failMsg.add(i.getName() + " is only available for these hours: " + i.getStartTime() +"-" + i.getEndTime());
            }
        }
        if(screenedCouriers.size() == 0) {//if no courier satisfies the requirement
            throw new Exception("Courier not available for your requirement due to the following reasons: \n" + String.valueOf(failMsg));
        } else {
            cheapest = screenedCouriers.get(0);
            int size = screenedCouriers.size();
            //to delete these s.out below
            System.out.println("screened courier array size: " + size);
            System.out.println("screened courier1 " + screenedCouriers.get(0).getName());
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
