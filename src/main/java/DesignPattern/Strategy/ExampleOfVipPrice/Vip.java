package DesignPattern.Strategy.ExampleOfVipPrice;

@PriceRegion(min=10000,max = 20000)
public class Vip implements CalPrice{
    @Override
    public Double calPrice(Double originPrce) {
        System.out.println("会员消费一律九折");
        return 0.9*originPrce;
    }
}
