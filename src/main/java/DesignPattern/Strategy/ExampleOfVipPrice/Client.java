package DesignPattern.Strategy.ExampleOfVipPrice;

public class Client {
    public static void main(String[] args) {
        Player player = new Player();
        player.buy(player.calLastAmount(500.0));
        player.buy(player.calLastAmount(10000.0));
        player.buy(player.calLastAmount(500.0));
        player.buy(player.calLastAmount(500.0));
        player.buy(player.calLastAmount(500.0));
    }
}
