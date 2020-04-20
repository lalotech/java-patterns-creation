package net.lalotech.patterns.factory;

public class TestFactory {

    public static void main(final String arg[]) {

        //some validations
        System.out.println(ValidationNumber.isNull(null));
        System.out.println(ValidationNumber.isNull(new Integer(5)));

        System.out.println(ValidationNumber.isInteger(new Long(1)));
        System.out.println(ValidationNumber.isInteger(new Integer(5)));

        System.out.println(ValidationNumber.plus(new Integer(5), new Integer(-15)));
        System.out.println(ValidationNumber.minus(null, null));

    }
}
