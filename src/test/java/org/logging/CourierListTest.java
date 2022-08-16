package org.logging;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalTime;

class CourierListTest {

    @Test
    @DisplayName("Getting Bobby's profile detail")
    public void shouldReturnBobbyDetail() {
        CourierList courierList = new CourierList();
        Assertions.assertAll(() -> Assertions.assertEquals("Bobby", courierList.getCourierList().get(0).getName()),
                () -> Assertions.assertEquals(LocalTime.parse("09:00"), courierList.getCourierList().get(0).getStartTime()),
                () -> Assertions.assertEquals(LocalTime.parse("13:00"), courierList.getCourierList().get(0).getEndTime()),
                () -> Assertions.assertEquals(true, courierList.getCourierList().get(0).getIsBoxRefrigerated()),
                () -> Assertions.assertEquals(5, courierList.getCourierList().get(0).getMaxDistance()),
                () -> Assertions.assertEquals(BigDecimal.valueOf(1.75), courierList.getCourierList().get(0).getRatePerMile()));

    }

}