/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import controller.HangHoaController;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author pc
 */
public class ThemHang {
    public static ThemHang getInstance() {
        instance = new ThemHang();
    return instance;
}    
  public static void dispose() {
       if (instance != null) {
            instance.fr.dispose();
            instance = null;
        } 
    }
  
    public ThemHang() {
       
//        this.mainPns.put("selectTypeAccount", ContainerCreateAccount.selectTypeAccount());
        show();
}
    private static ThemHang instance;
   JLabel lbTenHang=new JLabel("Tên sản phẩm"); 
   JTextField tfTenHang=new JTextField(15);
    JLabel lbDonGiaNhap=new JLabel("Đơn giá nhập"); 
    JLabel lbDonGiaBan=new JLabel("Đơn giá bán"); 
   JTextField tfDonGiaNhap=new JTextField(15);
   JTextField tfDonGiaBan=new JTextField(15);
    JLabel lbDonViTinh=new JLabel("Đơn vị tính"); 
   JTextField tfDonViTinh=new JTextField(15);
JFrame fr=new JFrame("THÊM SẢN PHẨM");
JLabel lb=new JLabel("THÊM SẢN PHẨM");
JButton bt=new JButton("Thêm");
public void show()
{
    fr.setLayout(null);
    fr.setSize(350,400);
    lb.setBounds(100,10,200,50);
    lbTenHang.setBounds(10,110,100,30);
    lbDonGiaNhap.setBounds(10,190,100,30);
    lbDonGiaBan.setBounds(10,230,100,30);
    lbDonViTinh.setBounds(10,150,70,30);
    tfTenHang.setBounds(130,110,170,30);
    tfDonGiaNhap.setBounds(130,190,170,30);
    tfDonGiaBan.setBounds(130,230,170,30);
    tfDonViTinh.setBounds(130,150,170,30);
    bt.setBounds(200,280,70,30);
    fr.add(lb);
    fr.add(lbTenHang);
    fr.add(lbDonGiaNhap);
    fr.add(lbDonGiaBan);
    fr.add(lbDonViTinh);
    fr.add(tfTenHang);
    fr.add(tfDonGiaNhap);
    fr.add(tfDonGiaBan);
    fr.add(tfDonViTinh);
    fr.add(bt);
    bt.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String tenHang = tfTenHang.getText();
                String donGiaNhap = tfDonGiaNhap.getText();
                String donGiaBan=tfDonGiaBan.getText();
                String donViTinh=tfDonViTinh.getText();
               
                boolean inserted = HangHoaController.themHang(tenHang,donViTinh,donGiaNhap,donGiaBan);
                if(inserted ){
                    JOptionPane.showMessageDialog(fr,"Thêm sản phẩm thành công");
                    DanhMucHangHoa.dispose();
                    DanhMucHangHoa.getInstance();
                    ThemHang.dispose();

         fr.dispose();
                }else{
                    JOptionPane.showMessageDialog(fr,"Thêm sản phẩm thất bại");
                    DanhMucHangHoa.getInstance();
                    ThemHang.dispose();
                }
            }
        });
    fr.setLocationRelativeTo(null);
    fr.setResizable(false);
    fr.setVisible(true);
}

}


