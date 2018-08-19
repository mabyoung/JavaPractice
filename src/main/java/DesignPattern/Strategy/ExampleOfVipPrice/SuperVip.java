package DesignPattern.Strategy.ExampleOfVipPrice;

@PriceRegion(min = 20000,max = 30000)
public class SuperVip implements CalPrice{
    @Override
    public Double calPrice(Double originPrce) {
        return 0.8*originPrce;
    }
}
