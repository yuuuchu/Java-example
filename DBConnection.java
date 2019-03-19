/**
 * This class is the database connection class. It contains the login information to the local database
 * This is an assignment for class OOSD CMPP-264-Java
 *
 * @author: Eugenia Chiu
 * @version: 7.1
 * @since 2019-03-18
 *
 * */

package sample;

import java.sql.*;

public class DBConnection {
    /*Databse will throw ClassNotFound and also the SqlException
    * */
    public Connection getConnection() throws ClassNotFoundException, SQLException
    {
        //Class is a predefined method in the java class library. This allows this class to connect to the
        //SQL driver. JDBC - Java Database Connectivity
        Class.forName("com.mysql.jdbc.Driver");

        //SQL login info for local machine
        return DriverManager.getConnection(
                "jdbc:mysql://'put path file in here'",
                "put username here",
                "put password to database here"
        );
    }
}
