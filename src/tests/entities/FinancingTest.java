package entities;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FinancingTest {

    @Test
    public void constructorShouldCreateObjectWhenValidData() {

        Financing f = new Financing(100000.0, 20000.0, 80);

        Assertions.assertEquals(100000.0, f.getTotalAmount());
        Assertions.assertEquals(20000.0, f.getIncome());
        Assertions.assertEquals(80, f.getMonths());
    }

    @Test
    public void constructorShouldThrowIllegalArgumentExceptionWhenInvalidData() {

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            Financing f = new Financing(100000.0, 2000.0, 20);
        });
    }

    @Test
    public void setTotalAmountShouldUpdateDataWhenValidData() {

        Financing f = new Financing(100000.0, 20000.0, 80);

        f.setTotalAmount(90000.0);

        Assertions.assertEquals(90000.0, f.getTotalAmount());
    }

    @Test
    public void setTotalAmountShouldThrowIllegalArgumentExceptionWhenInvalidData() {

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            Financing f = new Financing(100000.0, 2000.0, 80);
            f.setTotalAmount(200000.0);
        });
    }

    @Test
    public void setIncomeShouldUpdateDataWhenValidData() {

        Financing f = new Financing(100000.0, 20000.0, 80);

        f.setIncome(30000.0);

        Assertions.assertEquals(30000.0, f.getIncome());
    }

    @Test
    public void setIncomeShouldThrowIllegalArgumentExceptionWhenInvalidData() {

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            Financing f = new Financing(100000.0, 20000.0, 40);
            f.setIncome(2000.0);
        });
    }

    @Test
    public void setMonthseShouldUpdateDataWhenValidData() {

        Financing f = new Financing(100000.0, 20000.0, 80);

        f.setMonths(90);

        Assertions.assertEquals(90, f.getMonths());
    }

    @Test
    public void setMonthsShouldThrowIllegalArgumentExceptionWhenInvalidData() {

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            Financing f = new Financing(100000.0, 2000.0, 40);
            f.setMonths(10);
        });
    }

    @Test
    public void entryShouldReturnTwentyPercentOfTotalAmount() {

        double expectedValue = 200.0;
        Financing financing = new Financing(1000.0,10000.0, 10);
        double entry = financing.entry();

        Assertions.assertEquals(expectedValue, entry);
    }

    @Test
    public void quotaShouldReturnHowMuchMoneyMustPayByMonth() {

        double expectedValue = 800.0;
        Financing financing = new Financing(10000.0,10000.0, 10);
        double quotaValue = financing.quota();

        Assertions.assertEquals(expectedValue, quotaValue);
    }
}