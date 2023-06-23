/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import DB.DBConnection;
import Model.Product;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author pc
 */
public class HangHoaController {
       
     public static Product find(int id) throws SQLException
    {
         Connection conn = DBConnection.getConnection();
         
        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery("select * from product where maHang = '"+id+"'");
        
        if (rs.next()){
            
                Product x = new Product(rs.getInt("maHang"), rs.getString("tenHang"), rs.getString("donViTinh"), rs.getInt("soLuong"),
                rs.getInt("donGiaNhap"), rs.getInt("donGiaBan"), rs.getString("maKhuyenMai"), rs.getInt("diem"), rs.getInt("giamGia"),
                rs.getString("donviGiamGia")
                );
               conn.close();                                                 
                return x;
        }
        conn.close();
        return null;
    }
      public static boolean themHang(String tenHang,String donViTinh,String donGiaNhap,String donGiaBan)
    {
         Connection conn = DBConnection.getConnection();
         
        if (tenHang.equals("")||donGiaNhap.equals("")|donGiaBan.equals("")||donViTinh.equals(""))
        {return false;}  
        try {
            Statement st = conn.createStatement();
            int x=Integer.parseInt(donGiaNhap);
            int y=Integer.parseInt(donGiaBan);
           
            
            
         //   int rs = st.executeUpdate("insert into hang values('" + maNV + "','" + hoTen +"','"+ngaySinh+"','"+gioiTinh+"',"+luong+","+0+",'"+diaChi+"','"+chucVu+"','"+soDienThoai+"')");
              int rs = st.executeUpdate("INSERT INTO `product` (`maHang`, `tenHang`, `donViTinh`, `donGiaNhap`, `donGiaBan`, `soLuong`, `maKhuyenMai`, `diem`, `giamGia`)"
                      + "VALUES (NULL, '" + tenHang +"', '" + donViTinh + "', '" + donGiaNhap + "', '" + donGiaBan + "', '0', null, 0, 0);");
            return true;
        } catch (SQLException throwables) {
            System.out.print("loi");
        }
        return false;
    }
      public static boolean suaHang(Product product)
    {
         Connection conn = DBConnection.getConnection();
         try {
         Statement st = conn.createStatement();
            String sql = "update product set ";
            sql += "donGiaNhap=" + product.getDonGiaNhap();
            sql += ",donGiaBan=" + product.getDonGiaBan();

            sql += ",soLuong=" + product.getSoLuong();

            sql += ",diem=" + product.getDiem();
            sql += ",giamGia=" + product.getGiamGia();

            if (!product.getTenHang().equals("")) {
                sql += ",tenHang ='" + product.getTenHang() +"'";
            }
             if (!product.getMaKhuyenMai().equals("")) {
                sql += ",maKhuyenMai ='" + product.getMaKhuyenMai() +"'";
            }
            if (!product.getDonViTinh().equals("")) {
                sql += ",donViTinh ='" + product.getDonViTinh() +"'";
            }
            if (!product.getDonViGiamGia().equals("")) {
                sql += ",donViGiamGia ='" + product.getDonViGiamGia()  +"'";
            }
            
            
            sql += " where mahang='" + product.getMaHang() +"'";
              int rs = st.executeUpdate(sql);
            return true;
        } catch (SQLException throwables) {
            System.out.print("loi");
        }
        return false;
    }
       public static void xoaHang(int maHang)
    {
         Connection conn = DBConnection.getConnection();
         
     
        try {
            Statement st = conn.createStatement();
            
           
            
            
         //   int rs = st.executeUpdate("insert into hang values('" + maNV + "','" + hoTen +"','"+ngaySinh+"','"+gioiTinh+"',"+luong+","+0+",'"+diaChi+"','"+chucVu+"','"+soDienThoai+"')");
              int rs = st.executeUpdate("delete from product where maHang='"+maHang+"'");
           
        } catch (SQLException throwables) {
            System.out.print("loi");
        }
        
    }
      public static DefaultTableModel getTableHangHoa(String x){
        Connection conn = DBConnection.getConnection();
        Vector data = new Vector();
    Vector column =new Vector();
    column.add("Mã Hàng");
     column.add("Tên Hàng");
     column.add("Số lượng");
      column.add("Đơn Vị Tính");
       column.add("Đơn Giá Nhập");
        column.add("Đơn Giá Bán");
         column.add("Mã khuyến mại");
         column.add("Điểm");
         column.add("Giảm giá"); 
       try{
            
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("select * from product where maHang like '"+x+"%'");
            while(rs.next()){ Vector record=new Vector();
                record.add(rs.getString("maHang"));
                record.add(rs.getString("tenHang"));
                 record.add(rs.getString("soLuong"));
                record.add(rs.getString("donViTinh"));
                record.add(rs.getString("donGiaNhap"));
                record.add(rs.getString("donGiaBan"));
                record.add(rs.getString("maKhuyenMai"));

                record.add(rs.getString("diem"));

                record.add(rs.getString("giamGia")+ " " + rs.getString("donviGiamGia"));

                                                                
                data.add(record);
            }
            conn.close();
        }catch (SQLException e){
           e.printStackTrace();
        }
        DefaultTableModel tableModel  = new DefaultTableModel(data, column);
        return tableModel;
    }
      
      public static DefaultTableModel getTableHangHoaOptimize(String x){
        Connection conn = DBConnection.getConnection();
        Vector data = new Vector();
    Vector column =new Vector();
    column.add("ID");
     column.add("Tên Hàng");
     column.add("Giá bán");
        column.add("Điểm sử dụng");
       try{
            
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("select * from product where maHang like '"+x+"%' or tenHang like '"+x+"%'");
            while(rs.next()){ Vector record=new Vector();
                record.add(rs.getString("maHang"));
                record.add(rs.getString("tenHang"));
                 record.add(rs.getString("donGiaBan"));
                 record.add(rs.getString("diem"));
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
