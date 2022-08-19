package org.logging;

import lombok.Getter;
import lombok.Setter;

import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.logging.*;

@Getter
@Setter
public class BestCourier {
    private Courier cheapest;
    private BigDecimal courierCost;
    private static final Logger LOGGER = Logger.getLogger(BestCourier.class.getName());

    static {
        FileHandler fileHandler = null;
        try {
            fileHandler = new FileHandler(BestCourier.class.getSimpleName() + ".log");
            fileHandler.setFormatter(new SimpleFormatter());
            Filter filterAll = s -> true;
            fileHandler.setFilter(filterAll);
        } catch (IOException e) {
            e.printStackTrace();
        }
        LOGGER.addHandler(fileHandler);
    }
    public Courier selectCourier(String time, double distance, boolean refrigeration) {
        CourierList courierList = new CourierList();
        LocalTime orderTime = LocalTime.parse(time);
        ArrayList<Courier> screenedCouriers = new ArrayList<>();
        ArrayList<String> failMsg = new ArrayList<>();

        for (Courier i : courierList.getCourierList()) {
            if(refrigeration && orderTime.isAfter(i.getStartTime()) && orderTime.isBefore(i.getEndTime()) &&
                    i.getIsBoxRefrigerated() && i.getMaxDistance() >= distance) {
                screenedCouriers.add(i);
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
            try {
                throw new IllegalArgumentException("Courier not available for your requirement due to the following reasons: \n" + failMsg);
            } catch (Exception e) {
                LOGGER.log(Level.WARNING, "Unable to select a suitable courier for this order, made at " + orderTime + ", for a distance of " + distance + " miles.");
                e.printStackTrace();
            }
        } else {
            cheapest = screenedCouriers.get(0);
            int size = screenedCouriers.size();
            for (int j = 1; j < size; j++) {
                if (screenedCouriers.get(j).getRatePerMile().compareTo(cheapest.getRatePerMile()) < 0) {
                    cheapest = screenedCouriers.get(j);
                }
            }
            setCourierCost(BigDecimal.valueOf(distance).multiply(cheapest.getRatePerMile()).setScale(2, RoundingMode.HALF_EVEN));
            LOGGER.log(Level.INFO, "Most suitable courier selected for this order is "+ cheapest.getName() + " for the request time " + orderTime + " and will cost £" + courierCost);

        }
        return cheapest;
    }
}
