package net.lalotech.patterns.builder;

public class TestBuilder {

    public static void main(String arg[]) {
        Taco.Builder builder = new Taco.Builder();
        Meat beefMeat = new BeefMeat("beef", "type", "color");
        builder.dressing("dressing").meat(beefMeat).sauce(Taco.TacoSauce.SAUCE_GREEN);
        Taco taco = builder.build();

        System.out.println(taco.getDressing());
        System.out.println("beef: "+taco.getMeat());
        System.out.println(taco.getSauce());
    }
}
