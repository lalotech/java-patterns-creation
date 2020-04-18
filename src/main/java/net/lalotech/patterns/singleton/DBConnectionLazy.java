package net.lalotech.patterns.singleton;

public class DBConnectionLazy {
    private static DBConnectionLazy INSTANCE = null;

    private DBConnectionLazy() {

    }

    public static DBConnectionLazy getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new DBConnectionLazy();
        }
        return INSTANCE;
    }
}
