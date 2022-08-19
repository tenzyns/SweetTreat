package org.logging;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CourierList {

    private static final List<Courier> couriersList = loadCouriers();

    public List<Courier> getCourierList() {
        return couriersList;
    }

    public static List<Courier> loadCouriers() {

        Courier bobby = new Courier("Bobby", "09:00", "13:00", true, 5, 1.75);
        Courier martin = new Courier("Martin", "09:00", "17:00", false, 3, 1.50);
        Courier geoff = new Courier("Geoff", "10:00", "16:00", true, 4, 2.0);
        Courier robert = new Courier("Robert", "10:30", "16:30", false, 4.5, 1.65);

        Courier[] couriers = {bobby, martin, geoff, robert};

        return new ArrayList<>(Arrays.asList(couriers));
    }
}
