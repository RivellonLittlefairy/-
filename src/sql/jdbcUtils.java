package sql;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

public class jdbcUtils {
    static String url=null;
    static String driver=null;
    static String psw=null;
    static String userName=null;
    static{
        try{
            File file=new File("C:\\Users\\MSF\\Desktop\\projects\\src\\sql\\db.properties");
            InputStream in=new BufferedInputStream(new FileInputStream(file));
            Properties properties=new Properties();
            properties.load(in);
            driver=properties.getProperty("driver");
            userName=properties.getProperty("username");
            url=properties.getProperty("url");
            psw=properties.getProperty("password");
            Class.forName(driver);
        }catch(Exception e){
            System.out.println("get property failed");
        }
    }
    public static Connection getcon() throws SQLException {
        Connection connection= DriverManager.getConnection(url,userName,psw);
        return connection;
    }
    public static boolean close(Connection con, Statement sta, ResultSet res) throws SQLException {
        if(res!=null) res.close();
        if(sta!=null) sta.close();
        if(con!=null) con.close();
        return true;
    }
}
