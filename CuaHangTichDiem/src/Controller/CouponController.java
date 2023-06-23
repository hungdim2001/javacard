/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;
import DB.DBConnection;
import javax.swing.*;
//import View.DBConnection;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import Model.Admin;
import Model.Coupon;
import View.Login;
import View.FormMain;
import java.util.Vector;

import javax.swing.table.DefaultTableModel;

/**
 *
 * @author pc
 */
public class CouponController {
       public static void xoaMa(int maHang)
    {
         Connection conn = DBConnection.getConnection();
         
     
        try {
            Statement st = conn.createStatement();
            
           
            
            
         //   int rs = st.executeUpdate("insert into hang values('" + maNV + "','" + hoTen +"','"+ngaySinh+"','"+gioiTinh+"',"+luong+","+0+",'"+diaChi+"','"+chucVu+"','"+soDienThoai+"')");
              int rs = st.executeUpdate("delete from makhuyenmai where maKhuyenMai='"+maHang+"'");
           
        } catch (SQLException throwables) {
        }
        
    }
       
       public static boolean themMa(String maKhuyenMai,String giaTri,String donVi,String giaTriApDung, String moTa)
    {
         Connection conn = DBConnection.getConnection();
         
        if (maKhuyenMai.equals("")||giaTri.equals("")|donVi.equals("")||giaTriApDung.equals(""))
        {return false;}  
        try {
            Statement st = conn.createStatement();
            
            
            
         //   int rs = st.executeUpdate("insert into hang values('" + maNV + "','" + hoTen +"','"+ngaySinh+"','"+gioiTinh+"',"+luong+","+0+",'"+diaChi+"','"+chucVu+"','"+soDienThoai+"')");
              int rs = st.executeUpdate("INSERT INTO `maKhuyenMai` (`maKhuyenMai`, `giaTri`, `donVi`, `giaTriApDung`, `moTa`)"
                      + "VALUES ('" + maKhuyenMai +"', '" + giaTri + "', '" + donVi + "', '" + giaTriApDung + "', '" + moTa + "');");
            return true;
        } catch (SQLException throwables) {
            System.out.print("loi");
        }
        return false;
    }
     public static Coupon find(String id) throws SQLException
    {
         Connection conn = DBConnection.getConnection();
         
        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery("select * from makhuyenmai where maKhuyenMai = '"+id+"'");
        
        if (rs.next()){
            
                Coupon x = new Coupon(rs.getString("maKhuyenMai"), rs.getInt("giaTri"), rs.getString("donVi"), rs.getInt("giaTriApDung"),
                rs.getString("moTa")
                );
               conn.close();                                                 
                return x;
        }
        conn.close();
        return null;
    }
      public static DefaultTableModel getList(String x){
        Connection conn = DBConnection.getConnection();
        Vector data = new Vector();
    Vector column =new Vector();
    column.add("ID");
     column.add("Giá trị khuyến mại");
     column.add("Đơn vị");
      column.add("Giá trị áp dụng");
       column.add("Mô tả");
        
       try{
            
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("select * from makhuyenmai where maKhuyenMai like '"+x+"%'");
            while(rs.next()){ Vector record=new Vector();
                record.add(rs.getString("maKhuyenMai"));
                record.add(rs.getString("giaTri"));
                 record.add(rs.getString("donVi"));
                record.add(rs.getString("giaTriApDung"));
                record.add(rs.getString("moTa"));
                          
                data.add(record);
            }
            conn.close();
        }catch (SQLException e){
           e.printStackTrace();
        }
        DefaultTableModel tableModel  = new DefaultTableModel(data, column);
        return tableModel;
    }
}
