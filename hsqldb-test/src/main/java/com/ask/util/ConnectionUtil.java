package com.ask.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class ConnectionUtil
{
    public static Connection getConnection() throws SQLException
    {
        Connection connection = null;
        connection = DriverManager.getConnection("jdbc:hsqldb:file:db/testdb", "SA", "");
        return connection;

    }
    
    public static void shutdown() throws SQLException {

        Connection con=getConnection();
        Statement st = con.createStatement();

        // db writes out to files and performs clean shuts down
        // otherwise there will be an unclean shutdown
        // when program ends
        st.execute("SHUTDOWN");
        con.close();    // if there are no other open connection
    }
}
