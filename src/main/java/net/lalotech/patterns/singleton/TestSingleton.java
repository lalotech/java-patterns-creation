package net.lalotech.patterns.singleton;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class TestSingleton {

    public static void main(String arg[]) {
        DBConnection instance = DBConnection.getInstance();
        DBConnection instance2 = DBConnection.getInstance();

        System.out.println("[Static version]");
        System.out.println(instance);
        System.out.println(instance2);
        if (instance == instance2) {
            System.out.println("They are the same object.\n");
        }

        DBConnectionLazy instanceLazy = DBConnectionLazy.getInstance();
        DBConnectionLazy instanceLazy2 = DBConnectionLazy.getInstance();

        System.out.println("[Lazy version]");
        System.out.println(instanceLazy);
        System.out.println(instanceLazy2);
        if (instanceLazy == instanceLazy2) {
            System.out.println("They are the same object.\n");
        }

        DBConnectionThreadSafe instanceDb = DBConnectionThreadSafe.getInstance();
        long timeBefore = System.currentTimeMillis();
        Connection cnn = instanceDb.getConnection();
        long timeAfter = System.currentTimeMillis();

        System.out.println("time: " + (timeAfter - timeBefore));

        Statement stm = null;
        try {
            stm = cnn.createStatement();
            int count = stm.executeUpdate("CREATE TABLE Singleton (ID INT, NAME VARCHAR(50))");
            stm.close();
            System.out.println("[database created]");
        } catch (SQLException sq) {
            sq.printStackTrace();
        }
        timeBefore = System.currentTimeMillis();
        cnn = instanceDb.getConnection();
        timeAfter = System.currentTimeMillis();

        System.out.println("time: " + (timeAfter - timeBefore));

    }
}
