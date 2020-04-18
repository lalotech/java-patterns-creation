package net.lalotech.patterns.singleton;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnectionThreadSafe {

    private static final String JDBC_DERBY_MEMORY_URL = "jdbc:derby:memory:codejava/webdb;create=true;";
    private static volatile DBConnectionThreadSafe INSTANCE = null;
    private static volatile Connection CONNECTION = null;

    private DBConnectionThreadSafe() {
        try {
            DriverManager.registerDriver(new org.apache.derby.jdbc.EmbeddedDriver());
        } catch (SQLException sq) {
            sq.printStackTrace();
        }
        if (INSTANCE != null) {
            throw new RuntimeException("Use getInstance() method to create.");
        }
        if (CONNECTION != null) {
            throw new RuntimeException("Use getConnection() method to create.");
        }
    }

    public static DBConnectionThreadSafe getInstance() {
        if (INSTANCE == null) {
            synchronized (DBConnectionThreadSafe.class) {
                if (INSTANCE == null) {
                    INSTANCE = new DBConnectionThreadSafe();
                }
            }
        }
        return INSTANCE;
    }

    public Connection getConnection() {
        if (CONNECTION == null) {
            synchronized (DBConnectionThreadSafe.class) {
                if (CONNECTION == null) {
                    try {
                        CONNECTION = DriverManager.getConnection(JDBC_DERBY_MEMORY_URL);
                    } catch (SQLException sq) {
                        sq.printStackTrace();
                    }
                }
            }
        }
        return CONNECTION;
    }
}
