package net.lalotech.patterns.singleton;

public class DBConnection {

    private static DBConnection INSTANCE = new DBConnection();

    private DBConnection() {
    }

    public static DBConnection getInstance() {
        return INSTANCE;
    }
}
