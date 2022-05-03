/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import connection.DatabaseConnection;
import entity.Room;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author vomin
 */
public class RoomDAO {
   //tuan
   private final String SELECT_ALL_ROOM = "SELECT * FROM PHONG";
   private final String SELECT_ROOM_BY_NAME = "SELECT * FROM PHONG WHERE TENPHONG = ?";
   

}
