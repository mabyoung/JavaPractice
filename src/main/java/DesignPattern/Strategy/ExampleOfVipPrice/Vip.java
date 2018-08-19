package DesignPattern.Strategy.ExampleOfVipPrice;

@PriceRegion(max = 20000)
public class Vip implements CalPrice{
    @Override
    public Double calPrice(Double originPrce) {
        return 0.9*originPrce;
    }
}
