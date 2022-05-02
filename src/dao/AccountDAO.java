/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

/**
 *
 * @author vomin
 */
public class AccountDAO {
    String sql_getUserName = "Select * from TaiKhoan where userName = ?";
    String sql_getPassWord = "Select * from TaiKhoan where passWord = ?";
    
    public String getUserName(String id){
        return null;
    }
}
