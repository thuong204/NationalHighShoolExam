package view;

import java.awt.BorderLayout;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Dao.NguoiDungDao;
import Helper.DataValidator;
import Helper.MessageDialogHelper;
import model.NguoiDung;

import java.awt.FlowLayout;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import javax.swing.JPasswordField;
import javax.swing.JSeparator;
import javax.swing.JTextPane;
import javax.swing.JTextArea;

public class LoginView extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldTenDangNhap;
	private JPasswordField jTextFieldmatKhau;

	public LoginView() {
		this.setTitle("LOGIN");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 537, 410);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 128, 64));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
			
		this.setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel labelTendangNhap = new JLabel("Tên đăng nhập");
		labelTendangNhap.setForeground(new Color(0, 255, 255));
		labelTendangNhap.setIcon(new ImageIcon("C:\\Users\\DELL\\Downloads\\Administrator-icon.png"));
		labelTendangNhap.setFont(new Font("Tahoma", Font.BOLD, 16));
		labelTendangNhap.setBounds(207, 88, 193, 35);
		contentPane.add(labelTendangNhap);
		
		textFieldTenDangNhap = new JTextField();
		textFieldTenDangNhap.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textFieldTenDangNhap.setBounds(207, 134, 213, 33);
		contentPane.add(textFieldTenDangNhap);
		textFieldTenDangNhap.setColumns(10);
		
		JLabel lblMatKhau = new JLabel("Mật khẩu");
		lblMatKhau.setForeground(new Color(0, 255, 255));
		lblMatKhau.setIcon(new ImageIcon("C:\\Users\\DELL\\Downloads\\Lock-Lock-icon.png"));
		lblMatKhau.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblMatKhau.setBounds(207, 168, 129, 33);
		contentPane.add(lblMatKhau);
		
		JButton btnNewButtonDangNhap = new JButton("Đăng nhập");
		btnNewButtonDangNhap.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				StringBuilder sb = new StringBuilder();
				DataValidator.validateEmpty(textFieldTenDangNhap, sb, "Tên đăng nhập không được để trống");
				DataValidator.validateEmpty(jTextFieldmatKhau, sb,"Mật khẩu không được để trống");
			
			if(sb.length()>0) {
				MessageDialogHelper.showErrorDialog(null, sb.toString(),"Lỗi");
				return;
			}
			NguoiDungDao dao = new  NguoiDungDao();
			try{
				NguoiDung nd  = dao.checkLogin(textFieldTenDangNhap.getText(), new String(jTextFieldmatKhau.getPassword()));
			
				if(nd==null) {
						MessageDialogHelper.showErrorDialog(null,"Tên đăng nhập hoặc mật khẩu sai","Lỗi");
				}
				else { 
					 MessageDialogHelper.showMessageDialog(null, "Đăng nhập thành công","Thành công");
					 LoginView.this.dispose();
					 HomeView homeView = new HomeView();
					 homeView.setVisible(true);
					 
					}
			}
			catch(Exception ex) {
				ex.printStackTrace();
				MessageDialogHelper.showErrorDialog(null,ex.getMessage(), "Lỗi");
			}
		}
     }
);
		btnNewButtonDangNhap.setIcon(new ImageIcon("C:\\Users\\DELL\\Downloads\\corrrect.png"));
        btnNewButtonDangNhap.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButtonDangNhap.setToolTipText("");
		btnNewButtonDangNhap.setBounds(86, 289, 159, 33);
		contentPane.add(btnNewButtonDangNhap);
			
		JButton btnThoat = new JButton("Thoát");
		btnThoat.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
				
			}
		});
		btnThoat.setIcon(new ImageIcon("C:\\Users\\DELL\\Downloads\\exit.png"));
		btnThoat.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnThoat.setBounds(275, 289, 113, 33);
		contentPane.add(btnThoat);
		
		JLabel jLabelImage1 = new JLabel("");
		jLabelImage1.setIcon(new ImageIcon("C:\\Users\\DELL\\Downloads\\Chromatix-Aerial-Laptop.128.png"));
		jLabelImage1.setBounds(48, 88, 128, 128);
		contentPane.add(jLabelImage1);
		
		jTextFieldmatKhau = new JPasswordField();
		jTextFieldmatKhau.setFont(new Font("Tahoma", Font.BOLD, 14));
		jTextFieldmatKhau.setBounds(207, 205, 213, 33);
		contentPane.add(jTextFieldmatKhau);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(10, 270, 480, 2);
		contentPane.add(separator);
		
		JLabel jLabelIamge2 = new JLabel("");
		jLabelIamge2.setIcon(new ImageIcon("C:\\Users\\DELL\\Downloads\\graduate-icon (1).png"));
		jLabelIamge2.setBounds(27, 11, 48, 48);
		contentPane.add(jLabelIamge2);
		
		JLabel lblNewLabel_KYTHI = new JLabel("QUẢN LÍ  THI TỐT NGHIỆP THPT");
		lblNewLabel_KYTHI.setForeground(new Color(255, 255, 0));
		lblNewLabel_KYTHI.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_KYTHI.setBounds(119, 11, 356, 48);
		contentPane.add(lblNewLabel_KYTHI);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}
}
