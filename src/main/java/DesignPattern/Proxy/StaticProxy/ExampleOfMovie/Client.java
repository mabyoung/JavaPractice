package DesignPattern.Proxy.StaticProxy.ExampleOfMovie;

public class Client {
    public static void main(String[] args) {
        Cinema cinema = new Cinema(new RealMovie());
        cinema.play();
    }
}
