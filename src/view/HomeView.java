package view;

import java.awt.EventQueue;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JToolBar;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.KeyStroke;
import javax.swing.RowFilter;
import javax.swing.RowSorter;

import java.awt.event.KeyEvent;
import java.sql.Date;
import java.util.ArrayList;
import java.awt.event.InputEvent;
import javax.swing.JSeparator;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.CardLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import javax.swing.text.TableView.TableRow;

import Dao.ThiSinhDao;
import Helper.DataValidator;
import Helper.MessageDialogHelper;
import model.DiemThiSinh;
import model.ThiSinh;
import model.Tinh;

import javax.swing.JTextArea;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.KeyAdapter;

public class HomeView extends JFrame {
	private JTextField textFieldMaTS;
	private JTextField textField_TenTS;
	private JTextField textFieldLop;
	private JTextField textFieldTruong;
	private JTextField textFieldQliMaTs;
	private JTextField textField_Van;
	private JTextField textField_Anh;
	private JTextField textField_Ly;
	private JTextField textField_Hoa;
	private JTextField textField_Sinh;
	private JTextField textField_Toan;
	private JTextField textFieldMaTsTimKiem;
	private JTextField textField_NgaySinh;
	public JPanel panel_QuanLiThiSinh;
	private JPanel panel_QuanLiDiem;
	 
	private ArrayList<DiemThiSinh> listDiemThiSinh;
	private ArrayList<ThiSinh> listThiSinh;
	private ArrayList<Tinh> listTinh;
	DefaultTableModel modelDiemThiSinh;
	DefaultTableModel modelThiSinh;  
	public JTable tableDiem;
	private JTable tableThiSinh;
	private JLabel lblNewLabelNgaySinh;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HomeView frame = new HomeView();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}



	/**
	 * Create the frame.
	 */
	public HomeView() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1063, 608);
		this.setTitle("TRANG CHỦ QUẢN LÍ THI THPT");
		this.setLocationRelativeTo(null);
		
		//Giao Diện menu
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnNewMenuHethong = new JMenu("Hệ thống");
		mnNewMenuHethong.setForeground(new Color(0, 0, 0));
		mnNewMenuHethong.setFont(new Font("Arial", Font.BOLD, 20));
		menuBar.add(mnNewMenuHethong);
		
		JCheckBoxMenuItem mntmNewMenuItemDangXuat = new JCheckBoxMenuItem("Đăng xuất");
		mntmNewMenuItemDangXuat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LoginView loginView = new LoginView();
				HomeView.this.dispose();
				loginView.setVisible(true);
				
			}
		});
		mntmNewMenuItemDangXuat.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_L, InputEvent.CTRL_DOWN_MASK));
		mntmNewMenuItemDangXuat.setIcon(new ImageIcon("C:\\Users\\DELL\\Downloads\\login5.png"));
		mntmNewMenuItemDangXuat.setFont(new Font("Segoe UI", Font.BOLD, 14));
		mnNewMenuHethong.add(mntmNewMenuItemDangXuat);
		
		JSeparator separator = new JSeparator();
		mnNewMenuHethong.add(separator);
		
		//Thoat ứng dụng
		JMenuItem mntmNewMenuItemThoat = new JMenuItem("Thoát");
		mntmNewMenuItemThoat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);;
			}
		});
		mntmNewMenuItemThoat.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F4, InputEvent.ALT_DOWN_MASK));
		mntmNewMenuItemThoat.setIcon(new ImageIcon("C:\\Users\\DELL\\Downloads\\Close-2-icon (1).png"));
		mntmNewMenuItemThoat.setForeground(new Color(0, 0, 0));
		mntmNewMenuItemThoat.setFont(new Font("Segoe UI", Font.BOLD, 14));
		mntmNewMenuItemThoat.setHorizontalAlignment(SwingConstants.LEFT);
		mnNewMenuHethong.add(mntmNewMenuItemThoat);
		
		JMenu mnNewMenuThiSinh = new JMenu("Thí sinh");
		mnNewMenuThiSinh.setForeground(new Color(0, 0, 0));
		mnNewMenuThiSinh.setFont(new Font("Arial", Font.BOLD, 20));
		menuBar.add(mnNewMenuThiSinh);
		
		
		//Chuyển giao diện quản lí thí sinh
		JMenuItem mntmNewMenuItemQLTS =  new JMenuItem("Quản lí Thí Sinh");
		mntmNewMenuItemQLTS.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				HomeView homeView = new HomeView();
				homeView.panel_QuanLiDiem.setVisible(false);
				homeView.panel_QuanLiThiSinh.setVisible(true);
			}
		});
		mntmNewMenuItemQLTS.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_I, InputEvent.ALT_DOWN_MASK));
		mntmNewMenuItemQLTS.setIcon(new ImageIcon("C:\\Users\\DELL\\Downloads\\personal-information-icon.png"));
		mntmNewMenuItemQLTS.setFont(new Font("Segoe UI", Font.BOLD, 14));
		mnNewMenuThiSinh.add(mntmNewMenuItemQLTS);
		
		JSeparator separator_1 = new JSeparator();
		mnNewMenuThiSinh.add(separator_1);
		
		//CHuyển giao diện qua quản lí điểm
		JMenuItem mntmNewMenuItemQLDiem = new JMenuItem("Quản lí điểm");
		mntmNewMenuItemQLDiem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				HomeView homeView = new HomeView();
				homeView.panel_QuanLiThiSinh.setVisible(false);
				homeView.panel_QuanLiDiem.setVisible(true);
			}
		});
		mntmNewMenuItemQLDiem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F, InputEvent.ALT_DOWN_MASK));
		mntmNewMenuItemQLDiem.setIcon(new ImageIcon("C:\\Users\\DELL\\Downloads\\Actions-mail-mark-task-icon.png"));
		mntmNewMenuItemQLDiem.setFont(new Font("Segoe UI", Font.BOLD, 14));
		mnNewMenuThiSinh.add(mntmNewMenuItemQLDiem);
		
		JMenu mnNewMenuTroGiup = new JMenu("Trợ giúp");
		mnNewMenuTroGiup.setForeground(new Color(0, 0, 0));
		mnNewMenuTroGiup.setFont(new Font("Arial", Font.BOLD, 20));
		menuBar.add(mnNewMenuTroGiup);
		
		JMenuItem mntmNewMenuItemGioiThieu = new JMenuItem("Giới thiệu");
		mntmNewMenuItemGioiThieu.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_H, InputEvent.CTRL_DOWN_MASK));
		mntmNewMenuItemGioiThieu.setIcon(new ImageIcon("C:\\Users\\DELL\\Downloads\\Info-icon.png"));
		mntmNewMenuItemGioiThieu.setFont(new Font("Segoe UI", Font.BOLD, 14));
		mnNewMenuTroGiup.add(mntmNewMenuItemGioiThieu);
		getContentPane().setLayout(new CardLayout(0, 0));
		
		JPanel panel = new JPanel();
		getContentPane().add(panel, "name_101782358054800");
		panel.setLayout(new CardLayout(0, 0));
		
		//Giao diện quản lí thí sinh
		panel_QuanLiThiSinh = 
				new JPanel();
		panel_QuanLiThiSinh.setBackground(new Color(128, 255, 255));
		panel_QuanLiThiSinh.setForeground(new Color(128, 128, 128));
		panel.add(panel_QuanLiThiSinh, "name_101933947173200");
		panel_QuanLiThiSinh.setLayout(null);
		
		JLabel lblNewLabelQuanLiThiSinh = new JLabel("Quản Lí Thí Sinh");
		lblNewLabelQuanLiThiSinh.setBackground(new Color(255, 255, 255));
		lblNewLabelQuanLiThiSinh.setForeground(new Color(255, 0, 0));
		lblNewLabelQuanLiThiSinh.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabelQuanLiThiSinh.setBounds(21, 11, 176, 43);
		panel_QuanLiThiSinh.add(lblNewLabelQuanLiThiSinh);
		
		JLabel lblNewLabeMaTSl = new JLabel("Mã thí sinh");
		lblNewLabeMaTSl.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabeMaTSl.setBounds(31, 67, 86, 22);
		panel_QuanLiThiSinh.add(lblNewLabeMaTSl);
		
		textFieldMaTS = new JTextField();
		textFieldMaTS.setEditable(false);
		textFieldMaTS.setBackground(new Color(255, 255, 255));
		textFieldMaTS.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textFieldMaTS.setBounds(136, 66, 136, 26);
		panel_QuanLiThiSinh.add(textFieldMaTS);
		textFieldMaTS.setColumns(10);
		
		textField_TenTS = new JTextField();
		textField_TenTS.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textField_TenTS.setColumns(10);
		textField_TenTS.setBounds(136, 103, 242, 26);
		panel_QuanLiThiSinh.add(textField_TenTS);
		
		JLabel lblNewLabelTenTS = new JLabel("Tên thí sinh");
		lblNewLabelTenTS.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabelTenTS.setBounds(31, 103, 93, 25);
		panel_QuanLiThiSinh.add(lblNewLabelTenTS);
		
		JLabel lblNewLabelTenLop = new JLabel("Lớp");
		lblNewLabelTenLop.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabelTenLop.setBounds(413, 69, 57, 18);
		panel_QuanLiThiSinh.add(lblNewLabelTenLop);
		
		textFieldLop = new JTextField();
		textFieldLop.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textFieldLop.setColumns(10);
		textFieldLop.setBounds(480, 64, 136, 26);
		panel_QuanLiThiSinh.add(textFieldLop);
		
		JLabel lblNewLabelTruong = new JLabel("Trường");
		lblNewLabelTruong.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabelTruong.setBounds(413, 109, 86, 22);
		panel_QuanLiThiSinh.add(lblNewLabelTruong);
		
		textFieldTruong = new JTextField();
		textFieldTruong.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textFieldTruong.setColumns(10);
		textFieldTruong.setBounds(480, 108, 291, 26);
		panel_QuanLiThiSinh.add(textFieldTruong);
		
		JLabel lblNewLabelGioiTinh = new JLabel("Giới tính");
		lblNewLabelGioiTinh.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabelGioiTinh.setBounds(31, 178, 65, 22);
		panel_QuanLiThiSinh.add(lblNewLabelGioiTinh);
		
		JLabel lblNewLabelTinh = new JLabel("Tỉnh");
		lblNewLabelTinh.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabelTinh.setBounds(413, 150, 86, 14);
		panel_QuanLiThiSinh.add(lblNewLabelTinh);
		
		JSeparator separator_4 = new JSeparator();
		separator_4.setForeground(new Color(0, 0, 0));
		separator_4.setBounds(424, 11, 9, 246);
		panel_QuanLiThiSinh.add(separator_4);
		
		ButtonGroup btGroupGioiTinh = new ButtonGroup();
		JRadioButton rdbtnNewRadioButtonNam = new JRadioButton("Nam");
		rdbtnNewRadioButtonNam.setFont(new Font("Tahoma", Font.PLAIN, 16));
		rdbtnNewRadioButtonNam.setBounds(123, 176, 59, 29);
		panel_QuanLiThiSinh.add(rdbtnNewRadioButtonNam);
		
		JRadioButton rdbtnNewRadioButtonNu = new JRadioButton("Nữ");
		rdbtnNewRadioButtonNu.setFont(new Font("Tahoma", Font.PLAIN, 16));
		rdbtnNewRadioButtonNu.setBounds(213, 176, 47, 29);
		panel_QuanLiThiSinh.add(rdbtnNewRadioButtonNu);
		
		btGroupGioiTinh.add(rdbtnNewRadioButtonNam);
		btGroupGioiTinh.add(rdbtnNewRadioButtonNu);
		
		JComboBox comboBoxTinh = new JComboBox();
	    ArrayList<Tinh> listTinh =Tinh.getDSTinh();
	    for(Tinh tinh:listTinh) {
	    	comboBoxTinh.addItem(tinh.getTenTinh());
	    }
		comboBoxTinh.setBounds(480, 149, 136, 22);
		panel_QuanLiThiSinh.add(comboBoxTinh);
		
		JSeparator separator_5 = new JSeparator();
		separator_5.setBounds(31, 52, 763, 2);
		panel_QuanLiThiSinh.add(separator_5);
		
		JSeparator separator_6 = new JSeparator();
		separator_6.setBounds(41, 219, 763, 2);
		panel_QuanLiThiSinh.add(separator_6);
		
		JPanel panel_ChucNang = new JPanel();
		panel_ChucNang.setBackground(new Color(0, 128, 192));
		panel_ChucNang.setBounds(866, 50, 149, 158);
		panel_QuanLiThiSinh.add(panel_ChucNang);
		panel_ChucNang.setLayout(null);
		
		
		//Lưu
		JButton btnNewButtonLuu = new JButton("Lưu");
		btnNewButtonLuu.setBackground(new Color(255, 255, 255));
		btnNewButtonLuu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {	
					StringBuilder sb = new StringBuilder();
					DataValidator.validateEmpty(textFieldMaTS, sb, "Mã thí sinh không được để trống");
					DataValidator.validateEmpty(textField_TenTS, sb, "Tên thí sinh không được để trống");
					if(sb.length()>0) {
						MessageDialogHelper.showErrorDialog(null, sb.toString(), "Lỗi");
						return;
					}
	
					try {
						ThiSinh ts = new ThiSinh();
						ts.setMaThiSinh(textFieldMaTS.getText());
						ts.setTenThiSinh(textField_TenTS.getText());
						ts.setNgaySinh(textField_NgaySinh.getText());
						int gioitinh=1;
						if(rdbtnNewRadioButtonNam.isSelected()) {
							gioitinh=1;
						}
						else
							gioitinh=0;
						ts.setGioiTinh(gioitinh);
						ts.setLop(textFieldLop.getText());
						ts.setTruong(textFieldTruong.getText());
						int queQuan =comboBoxTinh.getSelectedIndex();
						Tinh tinh =Tinh.getTinhByID(queQuan);
						ts.setTinh(comboBoxTinh.getSelectedItem().toString());
						
						ThiSinhDao dao = new ThiSinhDao();
						if(dao.insert(ts)) {
							MessageDialogHelper.showMessageDialog(null, "Thí sinh đã được lưu", "Thông báo");
							listThiSinh.add(ts);
						}
						else {
							MessageDialogHelper.showConfirmDialog(null, "Thí sinh chưa được lưu","Cảnh báo");
						}
						showResultThiSinh();//hiển thị bảng sau khi thêm
				}
				catch(Exception ex) {
					ex.printStackTrace();
					MessageDialogHelper.showErrorDialog(null,"Mã sinh viên đã tồn tại","Lỗi" );
					}				
				}
		});
		
		btnNewButtonLuu.setIcon(new ImageIcon("C:\\Users\\DELL\\Downloads\\Save-as-icon.png"));
		btnNewButtonLuu.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnNewButtonLuu.setBounds(10, 56, 129, 23);
		panel_ChucNang.add(btnNewButtonLuu);
		
		
		//Cập nhật
		JButton btnNewButtonCapNhat = new JButton("Cập nhật");
		btnNewButtonCapNhat.setBackground(new Color(255, 255, 255));
		btnNewButtonCapNhat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				StringBuilder sb = new StringBuilder();
				DataValidator.validateEmpty(textFieldMaTS, sb, "Mã thí sinh không được để trống");
				DataValidator.validateEmpty(textField_TenTS, sb, "Tên thí sinh không được để trống");
				if(sb.length()>0) {
					MessageDialogHelper.showErrorDialog(null, sb.toString(), "Lỗi");
					return;
				}
				if(MessageDialogHelper.showConfirmDialog(null, "Bạn có muốn cập nhật thí sinh hay không?", "Hỏi")==JOptionPane.NO_OPTION){
					return;
				}
					try {
                        int selectedIndex = tableThiSinh.getSelectedRow();
						listThiSinh.remove(selectedIndex);
						showDataThiSinh();//show lại bảng
						
						ThiSinh ts = new ThiSinh();
						ts.setMaThiSinh(textFieldMaTS.getText());
						ts.setTenThiSinh(textField_TenTS.getText());
						ts.setNgaySinh(textField_NgaySinh.getText());
						int gioitinh=1;
						if(rdbtnNewRadioButtonNam.isSelected()) {
							gioitinh=1;
						}
						else
							gioitinh=0;
						ts.setGioiTinh(gioitinh);
						ts.setLop(textFieldLop.getText());
						ts.setTruong(textFieldTruong.getText());
						int queQuan =comboBoxTinh.getSelectedIndex();
						Tinh tinh =Tinh.getTinhByID(queQuan);
						ts.setTinh(comboBoxTinh.getSelectedItem().toString());
						
						ThiSinhDao dao = new ThiSinhDao();
						if (listThiSinh.size() == 0) {
							JOptionPane.showConfirmDialog(null, "Thông tin cập nhật rỗng");
						}else if (selectedIndex == -1){
							JOptionPane.showMessageDialog(rootPane, "Bạn hãy chọn một dòng trong bảng để cập nhật");
						}						
						if(dao.update(ts)) {
							MessageDialogHelper.showMessageDialog(null, "Thí sinh đã được cập nhật", "Thông báo");
							listThiSinh.add(ts);
							showResultThiSinh();//show lại bảng sau khi thêm
						}
						else {
							MessageDialogHelper.showErrorDialog(null, "Thí sinh chưa được cập nhật", "Lỗi");
						}
				}
				catch(Exception ex) {
					ex.printStackTrace();
					MessageDialogHelper.showErrorDialog(null,"Thí sinh chưa đươc cập nhật ","Lỗi" );
					}				
			}	
			}
		);
	
		btnNewButtonCapNhat.setIcon(new ImageIcon("C:\\Users\\DELL\\Downloads\\Document-write-icon (1).png"));
		btnNewButtonCapNhat.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnNewButtonCapNhat.setBounds(10, 90, 129, 23);
		panel_ChucNang.add(btnNewButtonCapNhat);
		
		
		//Xóa
		JButton btnNewButtonXoa = new JButton("Xóa");
		btnNewButtonXoa.setBackground(new Color(255, 255, 255));
		btnNewButtonXoa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				StringBuilder sb = new StringBuilder();
				DataValidator.validateEmpty(textFieldMaTS, sb, "Mã thí sinh không được để trống");
				if(sb.length()>0) {
					MessageDialogHelper.showErrorDialog(null, sb.toString(), "Lỗi");
					return;
				}
				if(MessageDialogHelper.showConfirmDialog(null, "Bạn có muốn xóa thí sinh hay không?", "Hỏi")==JOptionPane.NO_OPTION){
					return;
				}
					try {
						int selectedIndex = tableThiSinh.getSelectedRow();
						listThiSinh.remove(selectedIndex);
						showDataThiSinh();
						
						ThiSinhDao dao = new ThiSinhDao();
						if(dao.delete(textFieldMaTS.getText())) {
							MessageDialogHelper.showMessageDialog(null, "Thí sinh đã được xóa", "Thông báo");
						}
						else {
							MessageDialogHelper.showMessageDialog(null, "Thí sinh không được xóa do không tồn tại","Cảnh báo");
						}
				}
				catch(Exception ex) {
					ex.printStackTrace();
					MessageDialogHelper.showErrorDialog(null,"Thí sinh này đã có điểm nên chưa được xóa","Lỗi" );
					}				
			}	
			}
		);
		btnNewButtonXoa.setIcon(new ImageIcon("C:\\Users\\DELL\\Downloads\\Delete-icon (1).png"));
		btnNewButtonXoa.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnNewButtonXoa.setBounds(10, 124, 96, 23);
		panel_ChucNang.add(btnNewButtonXoa);
		
		
		//Tạo mới
		JButton btnNewButtonTaoMoi = new JButton("Tạo mới");
		btnNewButtonTaoMoi.setIcon(new ImageIcon("C:\\Users\\DELL\\Downloads\\New-file-icon.png"));
		btnNewButtonTaoMoi.setBackground(new Color(255, 255, 255));
		btnNewButtonTaoMoi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textFieldMaTS.setEditable(true);
				textFieldMaTS.setText("");
				textField_TenTS.setText("");
				textField_NgaySinh.setText("");
				textFieldLop.setText("");
				textFieldTruong.setText("");
				rdbtnNewRadioButtonNam.setSelected(true);
				comboBoxTinh.setSelectedIndex(0);	
			}
		});
		btnNewButtonTaoMoi.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnNewButtonTaoMoi.setBounds(10, 22, 129, 23);
		panel_ChucNang.add(btnNewButtonTaoMoi);
		
		//Table thí sinh
		
		tableThiSinh = new JTable();
		tableThiSinh.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int row = tableThiSinh.getSelectedRow();
				TableModel model = tableThiSinh.getModel();
				textFieldMaTS.setText(modelThiSinh.getValueAt(row, 0)+"");
				textFieldMaTS.setEditable(false);
				textField_TenTS.setText(modelThiSinh.getValueAt(row, 1)+"");
				if((modelThiSinh.getValueAt(row, 2)).toString().equals("1")) {
					rdbtnNewRadioButtonNam.setSelected(true);
				}
				else {
					rdbtnNewRadioButtonNu.setSelected(true);
				}
				textField_NgaySinh.setText(modelThiSinh.getValueAt(row, 3)+"");
				textFieldLop.setText(modelThiSinh.getValueAt(row, 4)+"");
				textFieldTruong.setText(modelThiSinh.getValueAt(row, 5)+"");
				comboBoxTinh.setSelectedItem(modelThiSinh.getValueAt(row, 6)+"");
				
			}
		});
		tableThiSinh.setFont(new Font("Tahoma", Font.PLAIN, 14));
		tableThiSinh.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null, null},
			},
			new String[] {
				"M\u00E3 th\u00ED sinh", "T\u00EAn th\u00ED sinh", "Gi\u1EDBi t\u00EDnh", "Ng\u00E0y sinh", "L\u1EDBp", "Tr\u01B0\u1EDDng", "T\u1EC9nh/Th\u00E0nh ph\u1ED1"
			}
		) {
			Class[] columnTypes = new Class[] {
				Object.class, String.class, String.class, Object.class, Object.class, Object.class, Object.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		tableThiSinh.getColumnModel().getColumn(0).setPreferredWidth(94);
		tableThiSinh.getColumnModel().getColumn(1).setPreferredWidth(193);
		tableThiSinh.getColumnModel().getColumn(1).setMinWidth(48);
		tableThiSinh.getColumnModel().getColumn(2).setPreferredWidth(68);
		tableThiSinh.getColumnModel().getColumn(3).setPreferredWidth(96);
		tableThiSinh.getColumnModel().getColumn(4).setPreferredWidth(58);
		tableThiSinh.getColumnModel().getColumn(5).setPreferredWidth(260);
		tableThiSinh.getColumnModel().getColumn(6).setPreferredWidth(135);

		
		JScrollPane scrollPane = new JScrollPane(tableThiSinh);
		scrollPane.setBounds(113, 268, 822, 251);
		panel_QuanLiThiSinh.add(scrollPane);
		
		JLabel lblNewLabelDanhSachThiSinh = new JLabel("Danh Sách Thí Sinh");
		lblNewLabelDanhSachThiSinh.setForeground(new Color(255, 0, 0));
		lblNewLabelDanhSachThiSinh.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabelDanhSachThiSinh.setBounds(21, 219, 251, 43);
		panel_QuanLiThiSinh.add(lblNewLabelDanhSachThiSinh);
		
		lblNewLabelNgaySinh = new JLabel("Ngày Sinh");
		lblNewLabelNgaySinh.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabelNgaySinh.setBounds(31, 141, 79, 22);
		panel_QuanLiThiSinh.add(lblNewLabelNgaySinh);
		
		textField_NgaySinh = new JTextField();
		textField_NgaySinh.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textField_NgaySinh.setColumns(10);
		textField_NgaySinh.setBounds(136, 140, 136, 26);
		panel_QuanLiThiSinh.add(textField_NgaySinh);
		
		
		//Cập nhật lại chương trình
		JButton btnNewButtonRefreshThiSinh = new JButton("Refresh");
		btnNewButtonRefreshThiSinh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			HomeView.this.dispose();
			HomeView homeView = new HomeView();	
			homeView.panel_QuanLiThiSinh.setVisible(true);
			homeView.panel_QuanLiDiem.setVisible(false);
			}
		});
		
		listThiSinh = new ThiSinhDao().getListThiSinh();
		modelThiSinh= (DefaultTableModel) tableThiSinh.getModel();
		showTableThiSinh();
		
		btnNewButtonRefreshThiSinh.setIcon(new ImageIcon("C:\\Users\\DELL\\Downloads\\icons8-synchronize-26.png"));
		btnNewButtonRefreshThiSinh.setForeground(Color.RED);
		btnNewButtonRefreshThiSinh.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnNewButtonRefreshThiSinh.setBounds(241, 223, 142, 34);
		panel_QuanLiThiSinh.add(btnNewButtonRefreshThiSinh);
		
		
		//Giao diện quản lí điểm
		panel_QuanLiDiem = new JPanel();
		panel_QuanLiDiem.setBackground(new Color(255, 255, 128));
		panel.add(panel_QuanLiDiem, "name_101944687875600");
		panel_QuanLiDiem.setLayout(null);
		panel_QuanLiDiem.setVisible(true);
		
		JLabel lbQLDieml = new JLabel("Quản lí Điểm thi");
		lbQLDieml.setForeground(new Color(0, 0, 255));
		lbQLDieml.setFont(new Font("Tahoma", Font.BOLD, 24));
		lbQLDieml.setBounds(10, 11, 254, 34);
		panel_QuanLiDiem.add(lbQLDieml);
		
		JSeparator separator_2 = new JSeparator();
		separator_2.setBounds(20, 56, 986, 2);
		panel_QuanLiDiem.add(separator_2);
		
		JLabel lblNewLabelQliMaTs = new JLabel("Mã thí sinh");
		lblNewLabelQliMaTs.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabelQliMaTs.setBounds(20, 74, 129, 22);
		panel_QuanLiDiem.add(lblNewLabelQliMaTs);
		
		textFieldQliMaTs = new JTextField();
		textFieldQliMaTs.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textFieldQliMaTs.setBounds(146, 69, 118, 27);
		panel_QuanLiDiem.add(textFieldQliMaTs);
		textFieldQliMaTs.setColumns(10);
		
		JLabel lblNewLabelDiemAnh = new JLabel("Anh");
		lblNewLabelDiemAnh.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabelDiemAnh.setBounds(20, 234, 65, 22);
		panel_QuanLiDiem.add(lblNewLabelDiemAnh);
		
		textField_Van = new JTextField();
		textField_Van.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textField_Van.setColumns(10);
		textField_Van.setBounds(146, 172, 71, 27);
		panel_QuanLiDiem.add(textField_Van);
		
		JLabel lblNewLabelQliDiemVan = new JLabel("Văn");
		lblNewLabelQliDiemVan.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabelQliDiemVan.setBounds(20, 177, 78, 22);
		panel_QuanLiDiem.add(lblNewLabelQliDiemVan);
		
		textField_Anh = new JTextField();
		textField_Anh.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textField_Anh.setColumns(10);
		textField_Anh.setBounds(146, 229, 71, 27);
		panel_QuanLiDiem.add(textField_Anh);
		
		JLabel lblNewLabelDiemLy = new JLabel("Lý");
		lblNewLabelDiemLy.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabelDiemLy.setBounds(278, 118, 39, 22);
		panel_QuanLiDiem.add(lblNewLabelDiemLy);
		
		textField_Ly = new JTextField();
		textField_Ly.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textField_Ly.setColumns(10);
		textField_Ly.setBounds(380, 119, 71, 27);
		panel_QuanLiDiem.add(textField_Ly);
		
		JLabel lblNewLabelDiemHoa = new JLabel("Hóa");
		lblNewLabelDiemHoa.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabelDiemHoa.setBounds(278, 177, 48, 22);
		panel_QuanLiDiem.add(lblNewLabelDiemHoa);
		
		textField_Hoa = new JTextField();
		textField_Hoa.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textField_Hoa.setColumns(10);
		textField_Hoa.setBounds(380, 176, 71, 27);
		panel_QuanLiDiem.add(textField_Hoa);
		
		JLabel lblNewLabelDiemSinh = new JLabel("Sinh");
		lblNewLabelDiemSinh.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabelDiemSinh.setBounds(278, 234, 48, 22);
		panel_QuanLiDiem.add(lblNewLabelDiemSinh);
		
		textField_Sinh = new JTextField();
		textField_Sinh.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textField_Sinh.setColumns(10);
		textField_Sinh.setBounds(380, 227, 71, 27);
		panel_QuanLiDiem.add(textField_Sinh);
		
		JLabel lblNewLabelDiemToan = new JLabel("Toán");
		lblNewLabelDiemToan.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabelDiemToan.setBounds(20, 124, 71, 22);
		panel_QuanLiDiem.add(lblNewLabelDiemToan);
		
		textField_Toan = new JTextField();
		textField_Toan.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textField_Toan.setColumns(10);
		textField_Toan.setBounds(146, 118, 71, 27);
		panel_QuanLiDiem.add(textField_Toan);
		
		JPanel panel_Timkiem = new JPanel();
		panel_Timkiem.setBackground(new Color(128, 255, 255));
		panel_Timkiem.setBounds(650, 69, 389, 56);
		panel_QuanLiDiem.add(panel_Timkiem);
		panel_Timkiem.setLayout(null);
		
		
		//Chức năng tìm kiếm
		textFieldMaTsTimKiem = new JTextField();
		textFieldMaTsTimKiem.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				String str = textFieldMaTsTimKiem.getText();
				DefaultTableModel model =(DefaultTableModel) tableDiem.getModel();
				TableRowSorter<DefaultTableModel> rts = new TableRowSorter<DefaultTableModel>(model);
				tableDiem.setRowSorter(rts);
				rts.setRowFilter(RowFilter.regexFilter(str));
				
			}
		});
		textFieldMaTsTimKiem.setColumns(10);
		textFieldMaTsTimKiem.setBounds(126, 11, 118, 27);
		panel_Timkiem.add(textFieldMaTsTimKiem);
		
		JLabel lblNewLabelQliMaTsTimKiem = new JLabel("Mã thí sinh");
		lblNewLabelQliMaTsTimKiem.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabelQliMaTsTimKiem.setBounds(10, 14, 129, 22);
		panel_Timkiem.add(lblNewLabelQliMaTsTimKiem);
		
		JLabel lblNewLabelHihi = new JLabel("New label");
		lblNewLabelHihi.setIcon(new ImageIcon("C:\\Users\\DELL\\Downloads\\Graduate-male-icon.png"));
		lblNewLabelHihi.setBounds(277, 60, 129, 136);
		panel_Timkiem.add(lblNewLabelHihi);
		
		JLabel lblNewLabelTimKiem = new JLabel("Tìm kiếm");
		lblNewLabelTimKiem.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabelTimKiem.setIcon(new ImageIcon("C:\\Users\\DELL\\Downloads\\Search-icon (3).png"));
		lblNewLabelTimKiem.setBounds(266, 14, 102, 24);
		panel_Timkiem.add(lblNewLabelTimKiem);
		
		
		//Đưa thông tin các dòng được chọn từ bảng vào textField
		tableDiem = new JTable();
		tableDiem.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int row = tableDiem.getSelectedRow();
				TableModel model = tableDiem.getModel();
				textFieldQliMaTs.setText(model.getValueAt(row, 0)+"");
				textField_Toan.setText(model.getValueAt(row, 1)+"");
				textField_Van.setText(model.getValueAt(row, 2)+"");
				textField_Anh.setText(model.getValueAt(row, 3)+"");
				textField_Ly.setText(model.getValueAt(row, 4)+"");
				textField_Hoa.setText(model.getValueAt(row, 5)+"");
				textField_Sinh.setText(model.getValueAt(row, 6)+"");
			}
		});
		tableDiem.setFont(new Font("Tahoma", Font.PLAIN, 14));
		tableDiem.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"M\u00E3 th\u00ED sinh", "To\u00E1n", "V\u0103n", "Anh", "L\u00FD", "H\u00F3a", "Sinh"
			}
		) {
			

			boolean[] columnEditables = new boolean[] {
				false, false, false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		JScrollPane scrollPane_1 = new JScrollPane(tableDiem);
		scrollPane_1.setBounds(10, 325, 685, 205);
		panel_QuanLiDiem.add(scrollPane_1);
		
		JSeparator separator_7 = new JSeparator();
		separator_7.setBounds(10, 277, 593, 2);
		panel_QuanLiDiem.add(separator_7);
		
		JLabel lbDSDieml = new JLabel("Danh Sách Điểm thi");
		lbDSDieml.setForeground(Color.BLUE);
		lbDSDieml.setFont(new Font("Tahoma", Font.BOLD, 24));
		lbDSDieml.setBounds(10, 280, 254, 34);
		panel_QuanLiDiem.add(lbDSDieml);
		
		listDiemThiSinh = new ThiSinhDao().getListComponents();
		modelDiemThiSinh = (DefaultTableModel) tableDiem.getModel();
		
		JButton btnNewButtonQlThemmoi = new JButton("Thêm mới");
		btnNewButtonQlThemmoi.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnNewButtonQlThemmoi.setIcon(new ImageIcon("C:\\Users\\DELL\\Downloads\\New-file-icon.png"));
		btnNewButtonQlThemmoi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textFieldQliMaTs.setText("");
				textField_Toan.setText("");
				textField_Ly.setText("");
				textField_Hoa.setText("");
				textField_Sinh.setText("");
				textField_Anh.setText("");
				textField_Van.setText("");
			}
		});
		btnNewButtonQlThemmoi.setBounds(509, 72, 114, 34);
		panel_QuanLiDiem.add(btnNewButtonQlThemmoi);
		
		//Chức năng lưu điểm
		JButton btnNewButtonQlLuu = new JButton("Lưu");
		btnNewButtonQlLuu.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnNewButtonQlLuu.setIcon(new ImageIcon("C:\\Users\\DELL\\Downloads\\Save-as-icon.png"));
		btnNewButtonQlLuu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				StringBuilder sb = new StringBuilder();
				String maThiSinh_1= textFieldQliMaTs.getText();
				String toan_1 = textField_Toan.getText();
				String ly_1 = textField_Ly.getText();
				String hoa_1 = textField_Hoa.getText();
				String sinh_1 = textField_Sinh.getText();
				String van_1 = textField_Van.getText();
				String anh_1 = textField_Anh.getText();
				if(maThiSinh_1.length()==0) {
					JOptionPane.showMessageDialog(null, "Bạn cần nhập Mã thí sinh");
					
				}
				else if(toan_1.length()==0) {
					JOptionPane.showMessageDialog(null, "Bạn cần nhập điểm Toán");
				}
				else if(ly_1.length()==0) {
					JOptionPane.showMessageDialog(null, "Bạn cần nhập điểm Lý");
				}
				else if(hoa_1.length()==0) {
					JOptionPane.showMessageDialog(null, "Bạn cần nhập điểm Hóa");
				}
				else if(van_1.length()==0) {
					JOptionPane.showMessageDialog(null, "Bạn cần nhập điểm Văn");
				}
				else if(anh_1.length()==0) {
					JOptionPane.showMessageDialog(null, "Bạn cần nhập điểm Anh");
				}
				else if(sinh_1.length()==0) {
					JOptionPane.showMessageDialog(null, "Bạn cần nhập điểm Sinh");
				}
				else {

				try {
					DiemThiSinh s = new DiemThiSinh();
					s.setMaTS(textFieldQliMaTs.getText());
					s.setToan(Float.parseFloat(textField_Toan.getText()));
					s.setLy(Float.parseFloat(textField_Ly.getText()));
					s.setHoa(Float.parseFloat(textField_Hoa.getText()));
					s.setVan(Float.parseFloat(textField_Van.getText()));
					s.setAnh(Float.parseFloat(textField_Anh.getText()));
					s.setSinh(Float.parseFloat(textField_Sinh.getText()));
					if(new ThiSinhDao().insertDiem(s)  ) {
						MessageDialogHelper.showMessageDialog(null, "Điểm  thí sinh đã được lưu", "Thông báo");
						listDiemThiSinh.add(s);
					}
					else {
						MessageDialogHelper.showMessageDialog(null, "Điểm thí sinh chưa được lưu", "Cảnh báo");
					}
					showResultDiemThiSinh();
			}
			catch(Exception ex) {
				ex.printStackTrace();
				MessageDialogHelper.showErrorDialog(null,"Mã thí sinh không hợp lệ","Lỗi" );
				}				
			}
			}
	});
		btnNewButtonQlLuu.setBounds(509, 121, 114, 34);
		panel_QuanLiDiem.add(btnNewButtonQlLuu);
		
		
		//Chức năng cập nhật điểm
		JButton btnNewButtonQlCapNhat = new JButton("Cập nhật");
		btnNewButtonQlCapNhat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				StringBuilder sb = new StringBuilder();
				String maThiSinh_1= textFieldQliMaTs.getText();
				String toan_1 = textField_Toan.getText();
				String ly_1 = textField_Ly.getText();
				String hoa_1 = textField_Hoa.getText();
				String sinh_1 = textField_Sinh.getText();
				String van_1 = textField_Van.getText();
				String anh_1 = textField_Anh.getText();
				if(maThiSinh_1.length()==0) {
					JOptionPane.showMessageDialog(null, "Bạn cần nhập Mã thí sinh");
					
				}
				else if(toan_1.length()==0) {
					JOptionPane.showMessageDialog(null, "Bạn cần nhập điểm Toán");
				}
				else if(ly_1.length()==0) {
					JOptionPane.showMessageDialog(null, "Bạn cần nhập điểm Lý");
				}
				else if(hoa_1.length()==0) {
					JOptionPane.showMessageDialog(null, "Bạn cần nhập điểm Hóa");
				}
				else if(van_1.length()==0) {
					JOptionPane.showMessageDialog(null, "Bạn cần nhập điểm Văn");
				}
				else if(anh_1.length()==0) {
					JOptionPane.showMessageDialog(null, "Bạn cần nhập điểm Anh");
				}
				else if(sinh_1.length()==0) {
					JOptionPane.showMessageDialog(null, "Bạn cần nhập điểm Sinh");
				}
				else {
				if(MessageDialogHelper.showConfirmDialog(null, "Bạn có muốn cập nhật thí sinh hay không?", "Hỏi")==JOptionPane.NO_OPTION){
					return;
				}
					try {
						int selectedIndex = tableDiem.getSelectedRow();
						listDiemThiSinh.remove(selectedIndex);
						showDataDiemThiSinh();
						DiemThiSinh s = new DiemThiSinh();
						s.setMaTS(textFieldQliMaTs.getText());
						s.setToan(Float.parseFloat(textField_Toan.getText()));
						s.setLy(Float.parseFloat(textField_Ly.getText()));
						s.setHoa(Float.parseFloat(textField_Hoa.getText()));
						s.setVan(Float.parseFloat(textField_Van.getText()));
						s.setAnh(Float.parseFloat(textField_Anh.getText()));
						s.setSinh(Float.parseFloat(textField_Sinh.getText()));
						if(new ThiSinhDao().updateDiem(s)) {
							MessageDialogHelper.showMessageDialog(null, "Điểm thí sinh đã được cập nhật", "Thông báo");
							listDiemThiSinh.add(s);
							showDataDiemThiSinh();
						}
						else {
							MessageDialogHelper.showMessageDialog(null, "Điểm thí sinh chưa được cập nhật","Cảnh báo");
						}
				}
				catch(Exception ex) {
					ex.printStackTrace();
					MessageDialogHelper.showErrorDialog(null,"Diểm thí sinh chưa được cập nhật","Lỗi" );
					}				
			}	
			}
		}
		);
				
		
		btnNewButtonQlCapNhat.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnNewButtonQlCapNhat.setIcon(new ImageIcon("C:\\Users\\DELL\\Downloads\\Document-write-icon (1).png"));
		btnNewButtonQlCapNhat.setBounds(509, 172, 114, 31);
		panel_QuanLiDiem.add(btnNewButtonQlCapNhat);
		
		
		//Chức năng xóa điểm
		JButton btnButtonQlXoa = new JButton("Xóa");
		btnButtonQlXoa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				StringBuilder sb = new StringBuilder();
				DataValidator.validateEmpty(textFieldQliMaTs, sb, "Mã thí sinh không được để trống");
				if(sb.length()>0) {
					MessageDialogHelper.showErrorDialog(null, sb.toString(), "Lỗi");
					return;
				}
				if(MessageDialogHelper.showConfirmDialog(null, "Bạn có muốn xóa điểm của thí sinh hay không?", "Hỏi")==JOptionPane.NO_OPTION){
					return;
				}
					try {
						int removeIndex = tableDiem.getSelectedRow();
						listDiemThiSinh.remove(removeIndex);
						showDataDiemThiSinh();
						

						ThiSinhDao dao = new ThiSinhDao();
						if(dao.deleteDiem(textFieldQliMaTs.getText())) {
							MessageDialogHelper.showMessageDialog(null, "Điểm  thí sinh đã được xóa", "Thông báo");
						}
						else {
							MessageDialogHelper.showMessageDialog(null, "Điểm thí sinh không được xóa do không tồn tại","Cảnh báo");
						}
				}
				catch(Exception ex) {
					ex.printStackTrace();
					MessageDialogHelper.showErrorDialog(null,ex.getMessage(),"Lỗi" );
					}				
			}	
			}
		);
		
			
		btnButtonQlXoa.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnButtonQlXoa.setIcon(new ImageIcon("C:\\Users\\DELL\\Downloads\\Delete-icon (1).png"));
		btnButtonQlXoa.setBounds(509, 218, 114, 34);
		panel_QuanLiDiem.add(btnButtonQlXoa);
		
		JLabel lblNewLabelAnh = new JLabel("");
		lblNewLabelAnh.setIcon(new ImageIcon("C:\\Users\\DELL\\Downloads\\graduate-icon (2).png"));
		lblNewLabelAnh.setBounds(758, 227, 345, 254);
		panel_QuanLiDiem.add(lblNewLabelAnh);
		
		showTableDiemThiSinh();
		
		JPanel panel_GioiThieu = new JPanel();
		panel.add(panel_GioiThieu, "name_115663010978300");
		panel_GioiThieu.setLayout(null);
		
		//Giao diện giới thiệu
		JLabel lblNewLabel = new JLabel("Giới thiệu về phần mềm");
		lblNewLabel.setForeground(new Color(0, 0, 255));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblNewLabel.setBounds(30, 11, 388, 37);
		panel_GioiThieu.add(lblNewLabel);
		
		JTextArea jTextAreaGioiThieu = new JTextArea("1.Xin cảm ơn vì đã tin tưởng và đồng hành cùng ứng dụng \n"
				                                 +   "2.Giới thiệu ứng dụng quản lí thi THPT \n"
				                                 +   "    Ứng dụng cho phép người dùng quản lí thông tin và điểm của thí sinh tham gia kì thi\n"
				                                 +   "    Ứng dụng cho phép học sinh tra cứu thông tin điểm của mình và ứng dụng có thể tính điểm từng khối \n    cho từng thí sinh dự thi\n"
				                                 +   "3.Xin chào và hẹn gặp lại."+"\n \n \n"
				                                 +   "1.Thank you for trusting and accompanying the application\n"
				                                 + "2.Introduce the high school exam management application\n"
				                                 + "    The application allows users to manage information and scores of students participating in the exam\n"
				                                 + "    The application allows students to look up their score information and the application can calculate \n    the score for each block for each candidate\n"
				                                 + "3.Thank you and see you soon.");
		jTextAreaGioiThieu.setEditable(false);
		jTextAreaGioiThieu.setFont(new Font("Monospaced", Font.ITALIC, 16));
		jTextAreaGioiThieu.setBackground(new Color(255, 255, 255)); 
		jTextAreaGioiThieu.setForeground(new Color(0, 0, 0));
		jTextAreaGioiThieu.setBounds(91, 80, 948, 390);
		panel_GioiThieu.add(jTextAreaGioiThieu);
		mntmNewMenuItemGioiThieu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				HomeView homeView = new HomeView();
				panel_QuanLiDiem.setVisible(false);
				panel_QuanLiThiSinh.setVisible(false);
				panel_GioiThieu.setVisible(true);	
			}
		});
		
		panel_QuanLiThiSinh.setVisible(true);
		panel_QuanLiDiem.setVisible(false);
		panel_GioiThieu.setVisible(false);
		
		JSeparator separator_3 = new JSeparator();
		getContentPane().add(separator_3, "name_101510708469700");
		this.setVisible(true);	
	}
	
	//Hiện thị bảng điểm thí sinh khi chạy chương trình
	public void showTableDiemThiSinh() {
		for (DiemThiSinh s : listDiemThiSinh) {
			modelDiemThiSinh.addRow(new Object[] {
					 s.getMaTS(),s.getToan(),s.getVan(),s.getAnh(),s.getLy(),s.getHoa(),s.getSinh()
			});
		}
	}
	
	//Cập nhật bảng dđiểm  esau khi thực hiện chức năng
	public void showResultDiemThiSinh() {
		DiemThiSinh s = listDiemThiSinh.get(listDiemThiSinh.size()-1);
		modelDiemThiSinh.addRow(new Object[] {
			s.getMaTS(),s.getToan(),s.getVan(),s.getAnh(),s.getLy(),s.getHoa(),s.getSinh()
		});
		showDataDiemThiSinh();
	}
	
	//Cập nhật bảng điểm sau khi thực hiện chức năng
	public void showDataDiemThiSinh() {
		modelDiemThiSinh.setRowCount(0);
		for (DiemThiSinh s : listDiemThiSinh) {
			modelDiemThiSinh.addRow(new Object[] {
					s.getMaTS(),s.getToan(),s.getVan(),s.getAnh(),s.getLy(),s.getHoa(),s.getSinh()
			});
		}
	}
	
	//Hiện thị bảng  Thí sinh khi chạy chương trình
	public void showTableThiSinh() {
		for (ThiSinh s : listThiSinh) {
			modelThiSinh.addRow(new Object[] {
					 s.getMaThiSinh(),s.getTenThiSinh(),s.getGioiTinh(),s.getNgaySinh(),s.getLop(),s.getTruong(),s.getTinh()
			});
		}
	}
	//cập nhật bảng thị sinh sau khi thức hienj chức năng
	public void showResultThiSinh() {
		ThiSinh s = listThiSinh.get(listThiSinh.size()-1);
		modelThiSinh.addRow(new Object[] {
				s.getMaThiSinh(),s.getTenThiSinh(),s.getGioiTinh(),s.getNgaySinh(),s.getLop(),s.getTruong(),s.getTinh()
		});
		showDataThiSinh();
	}
	
	//câp nhật bảng thí sinh sau khi thực hiện chức năng
	public void showDataThiSinh() {
		modelThiSinh.setRowCount(0);
		for (ThiSinh s : listThiSinh) {
			modelThiSinh.addRow(new Object[] {
					s.getMaThiSinh(),s.getTenThiSinh(),s.getGioiTinh(),s.getNgaySinh(),s.getLop(),s.getTruong(),s.getTinh()
			});
		}
	}
}
