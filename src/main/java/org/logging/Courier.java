package org.logging;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalTime;
import java.util.Comparator;

@Getter
@Setter
public class Courier {

    private String name;
    private LocalTime startTime;
    private LocalTime endTime;
    private Boolean isBoxRefrigerated;
    private double maxDistance;
    private BigDecimal ratePerMile;

    public double getDoubleRatePerMile(){ // for use in sorting list
        return ratePerMile.doubleValue();
    }

    public Courier(String name, String startTime, String endTime, Boolean isBoxRefrigerated, double maxDistance, double ratePerMile) {
        this.name = name;
        this.startTime = LocalTime.parse(startTime);
        this.endTime = LocalTime.parse(endTime);
        this.isBoxRefrigerated = isBoxRefrigerated;
        this.maxDistance = maxDistance;
        this.ratePerMile = BigDecimal.valueOf(ratePerMile);
    }

    @Override
    public String toString() {
        return "[Courier: " + name + ", cost per mile: £" + ratePerMile + " delivers up to " + maxDistance + " miles]";
    }

}
