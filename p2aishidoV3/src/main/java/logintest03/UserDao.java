package logintest03;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
 
public class UserDao {
 
    private static Connection getConnection() {
        try {
   //        
        	  Class.forName("com.mysql.cj.jdbc.Driver");
            return DriverManager.getConnection("jdbc:mysql://localhost/userdbA1","root", "root");
    //        return DriverManager.getConnection("jdbc:mysql://localhost/userdbA1","root", "xxxx");
            
        
        } catch (Exception e) {
            throw new IllegalArgumentException(e);
        }
    }
 
    private static void allClose(PreparedStatement statement, Connection connection) {
        if (statement != null) {
            try {
                statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
 
    }
 
    static Connection connection = null;
    static PreparedStatement statement = null;
 
    public UserDto findUser(String id) {
        UserDto user = new UserDto();
 
        try {
            connection = getConnection();
 
            statement = connection.prepareStatement("SELECT * FROM userinfA1 WHERE userid = ?");
            statement.setString(1, id);
            ResultSet resultSet = statement.executeQuery();
 
            if (!resultSet.next()) { return null; }
 
            user.setUserid(resultSet.getString("userid"));
            user.setPassword(resultSet.getString("password"));
            user.setSio(resultSet.getString("sio"));
            user.setKanri(resultSet.getInt("kanri"));
            
 
        } catch (SQLException e) {
            e.printStackTrace();
            
        } finally {
            allClose(statement, connection);
        }
        return user;
 
    }
    public ArrayList<UserDto> getUserList() {
        ArrayList<UserDto> list = new ArrayList<UserDto>();
 
        try {
            connection = getConnection();
 
            statement = connection.prepareStatement("SELECT * FROM userinfA1");
            ResultSet resultSet = statement.executeQuery();
 
            while (resultSet.next()) {
                UserDto ud = new UserDto();
                ud.setNo(resultSet.getInt(1));
                ud.setUserid(resultSet.getString(2));
                ud.setPassword(resultSet.getString(3));
                list.add(ud);
            }
 
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            allClose(statement, connection);
        }
        return list;
 
    }
 
    public int regUser(String id, String password) {
        int result = 0;
 
        try {
            connection = getConnection();
 
            statement = connection.prepareStatement("INSERT INTO userinfA1 (userid, password) VALUES (?, ?)");
            statement.setString(1, id);
            statement.setString(2, password);
            result = statement.executeUpdate();
 
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            allClose(statement, connection);
        }
        return result;
 
    }
 
    public int delUser(String id, String password) {
        int result = 0;
 
        try {
            connection = getConnection();
 
            statement = connection.prepareStatement("DELETE FROM userinfA1 WHERE userid = ? AND password = ?");
            statement.setString(1, id);
            statement.setString(2, password);
            result = statement.executeUpdate();
 
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            allClose(statement, connection);
        }
        return result;
 
    }
 
}