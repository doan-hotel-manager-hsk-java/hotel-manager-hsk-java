package dao;

import connection.DatabaseConnection;
import entity.Account;
import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.PreparedStatement;

public class AccountDAO {
     private final String USERNAME = "userName";
    private final String PASSWORD = "password";
    private static final String INSERT_ACCOUNT ="INSERT INTO TAIKHOAN VALUES (?,?)";
    private static final String SELECT_USERNAME = "Select userName from TaiKhoan where userName = ?";
    private static final String SELECT_PASSWORD = "Select password from TaiKhoan where userName = ?";
    private static final String UPDATE_PASSWORD = "update TaiKhoan set password = ? where userName = ?";
    
   public String findUserName(String userName){
       String username = null;
       try (Connection con = DatabaseConnection.opConnection();
               PreparedStatement pts = con.prepareStatement(SELECT_USERNAME)){
           pts.setString(1, userName);
           ResultSet rs = pts.executeQuery();
           
           while(rs.next()){
               username = rs.getString("userName");
           }
           return username;
       } catch (Exception e) {
           
       }
       return null;
   }
   
    public String findPass(String userName){
       String password = null;
       try (Connection con = DatabaseConnection.opConnection();
               PreparedStatement pts = con.prepareStatement(SELECT_PASSWORD)){
           pts.setString(1, userName);
           ResultSet rs = pts.executeQuery();
           
           while(rs.next()){
               password = rs.getString("password");
           }
           return password;
       } catch (Exception e) {
           
       }
       return null;
   }
    
   public boolean updatePass(String passNew, String username){
       try (Connection con = DatabaseConnection.opConnection();
               PreparedStatement ptm = con.prepareStatement(UPDATE_PASSWORD)){
           ptm.setString(1, passNew);
           ptm.setString(2, username);
           
           return  ptm.executeUpdate() > 0;
       } catch (Exception e) {
       }
       return false;
   }
   public boolean insertAccount(Account a){
       try (Connection con = DatabaseConnection.opConnection();
               PreparedStatement ptm = con.prepareStatement(INSERT_ACCOUNT)){
           ptm.setString(1, a.getUserName());
           ptm.setString(2, a.getPassWord());
           
           return  ptm.executeUpdate() > 0;
       } catch (Exception e) {
            System.err.println("insertAccount(): connect db fail");
            e.printStackTrace();
        }
        return false;
   }
}
