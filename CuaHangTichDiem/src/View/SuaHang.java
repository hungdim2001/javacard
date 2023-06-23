/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Model.Product;
import controller.HangHoaController;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

/**
 *
 * @author pc
 */
public class SuaHang {
    public static SuaHang getInstance(int idProduct) throws SQLException {
        instance = new SuaHang(idProduct);
    return instance;
}    
  public static void dispose() {
       if (instance != null) {
            instance.fr.dispose();
            instance = null;
        } 
    }
  
    public SuaHang(int idProduct) throws SQLException {
       this.product = HangHoaController.find(idProduct);
//        this.mainPns.put("selectTypeAccount", ContainerCreateAccount.selectTypeAccount());
        show();
}
    private static SuaHang instance;
    private Product product;
private JLabel lbTenHang;
private JTextField tfTenHang;
private JLabel lbDonGiaNhap;
private JLabel lbDonGiaBan;
private JTextField tfDonGiaNhap;
private JTextField tfDonGiaBan;
private JLabel tfMaHang;
private JLabel lbMaHang;
private JLabel lbDonViTinh;
private JTextField tfDonViTinh;
private JLabel lbMaKhuyenMai;
private JTextField tfMaKhuyenMai;
private JLabel lbDiem;
private JTextField tfDiem;
private JLabel lbGiamGia;
private JTextField tfGiamGia;
private JLabel lbDonViGiamGia;
private JTextField tfDonViGiamGia;
JFrame fr=new JFrame("SỬA SẢN PHẨM");
JLabel lb=new JLabel("Sửa SẢN PHẨM");
JButton bt=new JButton("Sửa");
public void show()
{
    lbTenHang =new JLabel("Tên sản phẩm"); 
    tfTenHang =new JTextField(product.getTenHang(),15);
    lbMaKhuyenMai =new JLabel("Mã khuyến mại"); 
    tfMaKhuyenMai =new JTextField(product.getMaKhuyenMai(),15);
    lbDiem =new JLabel("Điểm"); 
    tfDiem =new JTextField(String.valueOf(product.getDiem()),15);
    lbGiamGia =new JLabel("Giảm giá"); 
    tfGiamGia =new JTextField(String.valueOf(product.getGiamGia()),15);
    lbDonViGiamGia =new JLabel("Đơn vị giảm"); 
    tfDonViGiamGia =new JTextField(product.getDonViGiamGia(),15);
    lbDonGiaNhap =new JLabel("Đơn giá nhập"); 
    lbDonGiaBan =new JLabel("Đơn giá bán"); 
    tfDonGiaNhap =new JTextField(String.valueOf(product.getDonGiaNhap()),15);
    tfDonGiaBan =new JTextField(String.valueOf(product.getDonGiaBan()),15);
    tfMaHang =new JLabel(String.valueOf(product.getMaHang()));
    lbMaHang =new JLabel("Mã sản phẩm");
    lbDonViTinh =new JLabel("Đơn vị tính"); 
    tfDonViTinh =new JTextField(String.valueOf(product.getDonViTinh()),15);

    fr.setLayout(null);
    fr.setSize(350,520);
     lbMaHang.setBounds(10,70,100,30);
     tfMaHang.setBounds(130,70,170,30);
    lb.setBounds(100,10,200,50);
    lbTenHang.setBounds(10,110,100,30);
    lbDonGiaNhap.setBounds(10,190,100,30);
    lbDonGiaBan.setBounds(10,230,100,30);
    tfTenHang.setBounds(130,110,170,30);
    tfDonGiaNhap.setBounds(130,190,170,30);
    tfDonGiaBan.setBounds(130,230,170,30);
    lbDonViTinh.setBounds(10,150,100,30);
    tfDonViTinh.setBounds(130,150,170,30);
    lbMaKhuyenMai.setBounds(10,270,100,30);
    tfMaKhuyenMai.setBounds(130,270,170,30);
    lbDiem.setBounds(10,310,70,30);
    tfDiem.setBounds(130,310,170,30);
    lbGiamGia.setBounds(10,350,100,30);
    tfGiamGia.setBounds(130,350,170,30);
    lbDonViGiamGia.setBounds(10,390,100,30);
    tfDonViGiamGia.setBounds(150,390,170,30);
    bt.setBounds(200,440,70,30);
    fr.add(lb);
    fr.add(lbMaHang);
    fr.add(tfMaHang);
    fr.add(lbTenHang);
    fr.add(lbDonGiaNhap);
    fr.add(lbDonGiaBan);
    fr.add(lbDonViTinh);
    fr.add(tfTenHang);
    fr.add(tfDonGiaNhap);
    fr.add(tfDonGiaBan);
    fr.add(tfDonViTinh);
    fr.add(bt);
    fr.add(lbMaKhuyenMai);
    fr.add(tfMaKhuyenMai);
    fr.add(lbDiem);
    fr.add(tfDiem);
    fr.add(lbGiamGia);
    fr.add(tfGiamGia);
    fr.add(lbDonViGiamGia);
    fr.add(tfDonViGiamGia);
    bt.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               product.setDiem( Integer.parseInt(tfDiem.getText()));              
                product.setMaKhuyenMai(tfMaKhuyenMai.getText());
                product.setDonGiaNhap( Integer.parseInt(tfDonGiaNhap.getText()));
                product.setDonGiaBan( Integer.parseInt(tfDonGiaBan.getText()));
                product.setTenHang(tfTenHang.getText());
                product.setDonViGiamGia(tfDonViGiamGia.getText());
                product.setDonViTinh(tfDonViTinh.getText()); 
                product.setGiamGia( Integer.parseInt(tfGiamGia.getText()));
               
                boolean inserted = HangHoaController.suaHang(product);
                if(inserted ){
                    JOptionPane.showMessageDialog(fr,"Sửa sản phẩm thành công");
                    DanhMucHangHoa.dispose();
                    DanhMucHangHoa.getInstance();
                    SuaHang.dispose();

                    fr.dispose();
                }else{
                    JOptionPane.showMessageDialog(fr,"Sửa sản phẩm thất bại");
                    DanhMucHangHoa.getInstance();
                    SuaHang.dispose();
                }
            }
        });
    fr.setLocationRelativeTo(null);
    fr.setResizable(false);
    fr.setVisible(true);
}

}


