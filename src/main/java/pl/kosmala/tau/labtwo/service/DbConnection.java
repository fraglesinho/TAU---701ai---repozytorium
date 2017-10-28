package pl.kosmala.tau.labtwo.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

class DbConnection  {
    public DbConnection(String dbms,
                        String serverName,
                        int portNumber,
                        String dbName,
                        String userName,
                        String password) throws SQLException {
        getConnection(dbms,serverName,portNumber,dbName,userName,password);
    }
    private Connection getConnection(String dbms,
                                    String serverName,
                                    int portNumber,
                                    String dbName,
                                    String userName,
                                    String password) throws SQLException {

        Connection conn = null;
        Properties connectionProps = new Properties();
        connectionProps.put("user", userName);
        connectionProps.put("password", password);

        if (dbms.equals("mysql")) {
            conn = DriverManager.getConnection(
                    "jdbc:" + dbms + "://" +
                            serverName +
                            ":" + portNumber + "/",
                    connectionProps);
        } else if (dbms.equals("derby")) {
            conn = DriverManager.getConnection(
                    "jdbc:" + dbms + ":" +
                            dbName +
                            ";create=true",
                    connectionProps);
        }
        System.out.println("Connected to database");
        return conn;
    }
}
