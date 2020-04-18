package net.lalotech.patterns.builder;

public class Taco {

    private String sauce;
    private String dressing;
    private Meat meat;

    private Taco(Builder builder) {
        this.sauce = builder.sauce;
        this.dressing = builder.dressing;
        this.meat = builder.meat;
    }

    public static class Builder {

        private String sauce;
        private String dressing;
        private Meat meat;

        public Builder() {
        }

        public Builder dressing(final String dressing) {
            this.dressing = dressing;
            return this;
        }

        public Builder meat(final Meat meat) {
            this.meat = meat;
            return this;
        }

        public Builder sauce(final TacoSauce sauce) {
            this.sauce = sauce.getSauce();
            return this;
        }

        public Taco build() {
            return new Taco(this);
        }
    }

    public enum TacoSauce {
        SAUCE_GREEN("Green"),
        SAUCE_GREEN_RED("Green/Red"),
        SAUCE_RED("Red");
        private String sauce;

        private TacoSauce(final String sauce) {
            this.sauce = sauce;
        }

        public String getSauce() {
            return this.sauce;
        }
    }

    public String getSauce() {
        return sauce;
    }

    public String getDressing() {
        return dressing;
    }

    public Meat getMeat() {
        return meat;
    }
}
