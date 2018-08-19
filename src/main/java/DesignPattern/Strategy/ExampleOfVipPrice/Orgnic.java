package DesignPattern.Strategy.ExampleOfVipPrice;

@PriceRegion(max = 10000)
public class Orgnic implements CalPrice{
    @Override
    public Double calPrice(Double originPrce) {
        return originPrce;
    }
}
