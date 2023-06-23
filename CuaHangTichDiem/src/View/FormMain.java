/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package View;

import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.swing.*;
import Model.Admin;
import Constants.ConstAdmin;
import controller.AdminController;
import java.awt.event.ActionEvent;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.smartcardio.CardException;




/**
 *
 * @author hieu
 */
public class FormMain {
    private static FormMain instance;
   
    private JPanel pn;
    private String currentComponent;
    private HashMap <String, JPanel> mainPns = new HashMap<>();
    public static FormMain getInstance() {
        if (instance == null) {
            instance = new FormMain();
        }
        return instance;
    }
    
    public static void dispose() {
       if (instance != null) {
            instance.fr.dispose();
            instance = null;
        } 
    }
    
     public FormMain() {
       
//        this.mainPns.put("selectTypeAccount", ContainerCreateAccount.selectTypeAccount());
        initComponents();
    }
    private JFrame fr;
    private Font font;
    
    private JLabel infoAdmin;
    
    private JButton btDangXuat;
    private JButton btNhanVien = new JButton();
    private JButton btPhieuNhap = new JButton();
    private JButton btTaoTaiKhoan = new JButton();    
    private JButton btThe = new JButton();
    private JButton btHangHoa = new JButton();
    private JButton btPhieuBanHang = new JButton();
    
    private JLabel lbDangXuat;
    private JLabel lbNhanVien;
    private JLabel lbPhieuNhap;
    private JLabel lbTaoTaiKhoan;
    private JLabel lbThe;
    private JLabel lbHangHoa;
    private JLabel lbPhieuBanHang;
    
    private BufferedImage img;
    private Image dimg;
    ImageIcon icon;
    private void initComponents() {
        btDangXuat=new JButton("Đăng xuất");
        fr=new JFrame("Trang Chủ");
        infoAdmin = new JLabel("ID:" + Integer.toString(Admin.currentAdmin.getId()) + " - " + Admin.currentAdmin.getFullname());
        font=new Font("Serif",Font.PLAIN,13);
        pn = new JPanel();
        fr.setLayout(null);
        pn.setLayout(null);
        btDangXuat.setFont(font);
        infoAdmin.setFont(font);

        
        fr.add(btDangXuat);
        fr.add(infoAdmin);

        btDangXuat.setBounds(870,10,110,30);
        int index = 0;
        if (Admin.currentAdmin.getRole() == ConstAdmin.role.get("giamDoc") || Admin.currentAdmin.getRole() == ConstAdmin.role.get("banHang")) {
            try {
                img = ImageIO.read(new File("src/Hinh/images/thanhtoan.jpg"));
            } catch (IOException e) {
                e.printStackTrace();
            }
             dimg = img.getScaledInstance(226, 140,Image.SCALE_SMOOTH);
            icon = new ImageIcon(dimg);    
            btPhieuBanHang=new JButton(icon);
            lbPhieuBanHang=new JLabel("Thanh Toán", SwingConstants.CENTER);
            pn.add(btPhieuBanHang);
            pn.add(lbPhieuBanHang);
            lbPhieuBanHang.setFont(font);

            btPhieuBanHang.setBounds((index % 3) * 255, (int) (index /3) * 185, 250,150);
            lbPhieuBanHang.setBounds((index % 3) * 255, (int) (index /3) * 185 + 155, 250, 30);
            index++;
        }
        
         if (Admin.currentAdmin.getRole() == ConstAdmin.role.get("giamDoc") || Admin.currentAdmin.getRole() == ConstAdmin.role.get("banHang") || Admin.currentAdmin.getRole() == ConstAdmin.role.get("quanKho")) {
            try {
                img = ImageIO.read(new File("src/Hinh/images/hanghoa.jpg"));
            } catch (IOException e) {
                e.printStackTrace();
            }
             dimg = img.getScaledInstance(226, 140,Image.SCALE_SMOOTH);
            icon = new ImageIcon(dimg);    
            btHangHoa=new JButton(icon);
            lbHangHoa=new JLabel("Hàng Hóa", SwingConstants.CENTER);
            pn.add(btHangHoa);
            pn.add(lbHangHoa);
            btHangHoa.setBounds((index % 3) * 255, (int) (index /3) * 185, 250,150);
            lbHangHoa.setBounds((index % 3) * 255, (int) (index /3) * 185 + 155, 250, 30);
            lbHangHoa.setFont(font);
            index++;
        }
        
        
        try {
            img = ImageIO.read(new File("src/Hinh/images/nhanvien.jpg"));
        } catch (IOException e) {
            e.printStackTrace();
        }
         dimg = img.getScaledInstance(226, 140,Image.SCALE_SMOOTH);
        icon = new ImageIcon(dimg);    
        btNhanVien=new JButton(icon);
        lbNhanVien=new JLabel("Nhân Sự", SwingConstants.CENTER);
        pn.add(btNhanVien);
        pn.add(lbNhanVien);
        btNhanVien.setBounds((index % 3) * 255, (int) (index /3) * 185, 250,150);
        lbNhanVien.setBounds((index % 3) * 255, (int) (index /3) * 185 + 155, 250, 30);
        lbNhanVien.setFont(font);
        index++;
        
       if (Admin.currentAdmin.getRole() == ConstAdmin.role.get("giamDoc") || Admin.currentAdmin.getRole() == ConstAdmin.role.get("quanKho")) {
            try {
                img = ImageIO.read(new File("src/Hinh/images/khuyen-mai-.jpg"));
            } catch (IOException e) {
                e.printStackTrace();
            }
             dimg = img.getScaledInstance(226, 140,Image.SCALE_SMOOTH);
            icon = new ImageIcon(dimg);    
            btPhieuNhap=new JButton(icon);
            lbPhieuNhap=new JLabel("Mã khuyến mại", SwingConstants.CENTER);
            pn.add(btPhieuNhap);
            pn.add(lbPhieuNhap);
            btPhieuNhap.setBounds((index % 3) * 255, (int) (index /3) * 185, 250,150);
            lbPhieuNhap.setBounds((index % 3) * 255, (int) (index /3) * 185 + 155, 250, 30);
            lbPhieuNhap.setFont(font);
            index++;
        }
         
        if (Admin.currentAdmin.getRole() == ConstAdmin.role.get("giamDoc") || Admin.currentAdmin.getRole() == ConstAdmin.role.get("nhanSu")) {
            try {
                img = ImageIO.read(new File("src/Hinh/images/taotaikhoan.png"));
            } catch (IOException e) {
                e.printStackTrace();
            }
            dimg = img.getScaledInstance(226, 140,Image.SCALE_SMOOTH);
            icon = new ImageIcon(dimg);    
            btTaoTaiKhoan=new JButton(icon);
            pn.add(btTaoTaiKhoan);
            lbTaoTaiKhoan=new JLabel("Tạo tài khoản", SwingConstants.CENTER);
            pn.add(lbTaoTaiKhoan);
            lbTaoTaiKhoan.setFont(font);
            btTaoTaiKhoan.setBounds((index % 3) * 255, (int) (index /3) * 185, 250,150);
            lbTaoTaiKhoan.setBounds((index % 3) * 255, (int) (index /3) * 185 + 155, 250, 30);
            index++;
        }
        
        if (Admin.currentAdmin.getRole() == ConstAdmin.role.get("giamDoc") 
            || Admin.currentAdmin.getRole() == ConstAdmin.role.get("nhanSu")
            || Admin.currentAdmin.getRole() == ConstAdmin.role.get("banHang")
            ) {
            try {
                img = ImageIO.read(new File("src/Hinh/images/card.jpg"));
            } catch (IOException e) {
                e.printStackTrace();
            }
            dimg = img.getScaledInstance(226, 140,Image.SCALE_SMOOTH);
            icon = new ImageIcon(dimg);    
            btThe=new JButton(icon);
            pn.add(btThe);
            lbThe=new JLabel("Thẻ", SwingConstants.CENTER);
            pn.add(lbThe);
            lbThe.setFont(font);
            btThe.setBounds((index % 3) * 255, (int) (index /3) * 185, 250,150);
            lbThe.setBounds((index % 3) * 255, (int) (index /3) * 185 + 155, 250, 30);
            index++;
        }
        fr.add(pn);
        pn.setBounds(10, 50, 800, 600);
        infoAdmin.setBounds(10,10,200,25);

        btTaoTaiKhoan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ContainerCreateAccount.getInstance();
            }
        });
        btPhieuNhap.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DanhMucMaKhuyenMai.getInstance();
            }
        });
         btHangHoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DanhMucHangHoa.getInstance();
            }
        });
         
         btPhieuBanHang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                try {
                    CreateInvoice.getInstance();
                } catch (UnsupportedEncodingException ex) {
                    Logger.getLogger(FormMain.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
         
        btThe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                try {
                    ViewCard.getInstance();
                } catch (IOException ex) {
                    Logger.getLogger(FormMain.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        fr.setSize(820,660);
        fr.setLocationRelativeTo(null);
        fr.setResizable(false);
        fr.setVisible(true);

    };
    
      private void showMainPanel(String pnStr) {
//        if (currentComponent != null) {
//            this.mainPns.get(currentComponent).hide();
//        }
//        currentComponent = pnStr;
        fr.remove(this.mainPns.get("selectTypeAccount"));
    }
}
