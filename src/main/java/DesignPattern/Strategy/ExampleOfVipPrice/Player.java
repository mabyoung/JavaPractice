package DesignPattern.Strategy.ExampleOfVipPrice;

public class Player {
    private Double totalAmount = 0.0;
    private Double amount = 0.0;
    private CalPrice calPrice = new Orgnic();

    public void buy(Double amount) {
        totalAmount += amount;
        System.out.println("本次消费" + amount + "元");
        CalPriceFactory calPriceFactory = CalPriceFactory.getInstacne();
        calPriceFactory.createCalPrice(this);
    }

    public Double calLastAmount(Double amount) {
        return calPrice.calPrice(amount);
    }

    public Double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(Double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public CalPrice getCalPrice() {
        return calPrice;
    }

    public void setCalPrice(CalPrice calPrice) {
        this.calPrice = calPrice;
    }
}
