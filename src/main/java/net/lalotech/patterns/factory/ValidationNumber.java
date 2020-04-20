package net.lalotech.patterns.factory;

public class ValidationNumber {

    private ValidationNumber() {

    }

    public static Boolean isNull(final Object obj) {
        return obj == null;
    }

    public static void notNull(final Object obj) {
        if (isNull(obj)) {
            throw new CustomNumberException("My Custom number exception.");
        }
    }

    public static Boolean isNumber(final Object obj) {
        return obj instanceof Number;
    }

    public static Boolean isInteger(final Object obj) {
        return obj instanceof Integer;
    }

    public static Integer plus(final Integer base, final Integer amount) {
        notNull(base);
        notNull(amount);
        return base + amount;
    }

    public static Integer minus(final Integer base, final Integer amount) {
        notNull(base);
        notNull(amount);
        return base - amount;
    }
}
