package DesignPattern.Strategy.ExampleOfVipPrice;

@PriceRegion(min = 30000)
public class GoldVip implements CalPrice{
    @Override
    public Double calPrice(Double originPrce) {
        return 0.7*originPrce;
    }
}
