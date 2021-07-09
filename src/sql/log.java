package sql;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

public class log {
    public static void main(String[] args) throws Exception {
        System.out.println(loging("msf","fs4txdya"));
    }
    public static int loging(String name,String psw){
        Connection connection=null;
        PreparedStatement psm=null;
        ResultSet resultSet=null;
        int res=0;
        try {
            connection = jdbcUtils.getcon();
            String sql="" +
                    "SELECT id FROM user_information " +
                    "WHERE userName=? AND psw=PASSWORD(?);";
            //SELECT id FROM user_information
            //WHERE userName='msf' OR 1=1 AND psw=PASSWORD('fs4txdya') OR 1=1;
            psm = connection.prepareStatement(sql);
            psm.setString(1,name);
            psm.setString(2,psw);
            System.out.println(sql);
            resultSet=psm.executeQuery();
            if(resultSet.wasNull()){
                System.out.println("账户密码错误");
                return 0;
            }
            while(resultSet.next())
            res=resultSet.getInt("id");
        }catch(Exception e){
            System.out.println(e.getMessage());
        }finally {
            try {
                jdbcUtils.close(connection,psm,resultSet);
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return res;
    }
}
