package View;

import javax.swing.JPanel;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Serializable;
import java.sql.Date;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Vector;

import javax.swing.JRadioButton;
import javax.swing.AbstractAction;
import javax.swing.ButtonGroup;
import javax.swing.InputMap;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JToggleButton;
import javax.swing.KeyStroke;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;

import DAO.ConnectDanhgiaRL;
import DAO.ConnectLoginTeacher;

import DAO.connectThongTinSinhVien;
import DAO.conectSinhvien;
import DAO.connSinhVienDn;
import DAO.connSinhvienDangNhap;
import DAO.connectDiemdanh;
import Model.Danhgiarenluyen;
import Model.Thisinh;
import Model.Tinh;
import ModelInterface.InterfaceSinhvien;

import javax.swing.JFormattedTextField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.Component;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.JComponent;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.ActionEvent;
import javax.swing.event.PopupMenuListener;
import javax.swing.event.PopupMenuEvent;
import java.awt.SystemColor;
import java.awt.Canvas;
import com.jgoodies.forms.factories.DefaultComponentFactory;
import com.toedter.calendar.JDateChooser;
import javax.swing.ImageIcon;

public class SinhVien extends JPanel implements InterfaceSinhvien {
	private JTextField textField;
	private JScrollPane scrollPane2;
	connectDiemdanh conDiemdanh; 
	JDateChooser jdate=new JDateChooser();
    public JPanel panelsv;
	public static  JTable table_1;
	private JTextField txtS;
	private JTextField textField_2;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	 private ButtonGroup btgroup;
	 private JRadioButton rdbtnNu;
	 private JRadioButton rdbtnNam;
	 private JComboBox comboBox;
	 private JButton btnThem;
	 private JTextField textFieldiem;
	 private JTextField textField_8;
	 public JComboBox cbxhocky;
	 SimpleDateFormat outputFormat = new SimpleDateFormat("yyyy-MM-dd");
	private List listTs;
	public JComboBox cbblop;
	private JTextField textHo;
	private JButton btnAddDB;
	public SinhVien() {
		setBackground(new Color(128, 255, 128));
		setLayout(null);
		JScrollPane scrollPane_1 = new JScrollPane((Component) null);
		scrollPane_1.setBounds(20, 63, 1058, 227);
		add(scrollPane_1);
		table_1 = new JTable();
		table_1.setFillsViewportHeight(true);
		table_1.setColumnSelectionAllowed(true);
		table_1.setCellSelectionEnabled(true);
		table_1.setBackground(new Color(151, 203, 232));
		table_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		table_1.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"STT", "MASV", "H\u1ECC ", "T\u00CAN ", "QU\u00CA QU\u00C1N ", "NG\u00C0Y SINH", "GI\u1EDAI T\u00CDNH", "L\u1EDAP", "H\u1ECCC K\u1EF2", "X\u00C3 H\u1ED8I", "T\u01AF T\u01AF\u1EDENG", "NH\u1EACP M\u00D4N", "TBINH"
			}
		));
		table_1.getColumnModel().getColumn(0).setPreferredWidth(55);
		table_1.getColumnModel().getColumn(1).setPreferredWidth(98);
		table_1.getColumnModel().getColumn(2).setPreferredWidth(90);
		table_1.getColumnModel().getColumn(3).setPreferredWidth(113);
		table_1.getColumnModel().getColumn(11).setPreferredWidth(102);
		table_1.setRowHeight(25);
		table_1.setShowVerticalLines(false);
		table_1.setShowHorizontalLines(false);
		table_1.setShowGrid(false);
		scrollPane_1.setViewportView(table_1);
		
		 panelsv = new JPanel();
		 panelsv.setBackground(new Color(151, 203, 232));
		panelsv.setBounds(10, 310, 1058, 305);
		add(panelsv);
		panelsv.setLayout(null);
		
		JLabel lblMa = new JLabel("MASV");
		lblMa.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblMa.setBounds(10, 18, 80, 25);
		panelsv.add(lblMa);
	    JLabel lblH = new JLabel("Họ");
		lblH.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblH.setBounds(10, 75, 53, 25);
	    panelsv.add(lblH);
		JLabel lblTn = new JLabel("TÊN");
		lblTn.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblTn.setBounds(10, 135, 53, 25);
		panelsv.add(lblTn);
		
		JLabel lblNgySinh = new JLabel("NGÀY SINH");
		lblNgySinh.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNgySinh.setBounds(10, 185, 80, 25);
		panelsv.add(lblNgySinh);
		
		JLabel lblQuQun = new JLabel("QUÊ QUÁN ");
		lblQuQun.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblQuQun.setBounds(304, 135, 80, 25);
		panelsv.add(lblQuQun);
		
		JLabel lblimTon = new JLabel("CHUNGHIAXAHOI");
		lblimTon.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblimTon.setBounds(677, 17, 129, 25);
		panelsv.add(lblimTon);
		
		JLabel lblL = new JLabel("TUTUONG HCM");
		lblL.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblL.setBounds(677, 75, 106, 25);
		panelsv.add(lblL);
		
		JLabel lblHa = new JLabel("NHAPMONTINOC");
		lblHa.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblHa.setBounds(686, 143, 120, 25);
		panelsv.add(lblHa);
		
		txtS = new JTextField();
		txtS.setBackground(new Color(64, 128, 128));
		txtS.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				 int key=e.getKeyCode();
				     if(e.getSource()==txtS)
				     {
				        if(key==KeyEvent.VK_ENTER)
				        { 
				        	
				        	textHo.requestFocusInWindow(); 
				        
				        }
				    }
			   }
		});
		txtS.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtS.setBounds(79, 11, 190, 36);
		panelsv.add(txtS);
		txtS.setColumns(10);
		
		  textHo = new JTextField();
		  textHo.setFont(new Font("Tahoma", Font.PLAIN, 14));
		  textHo.setColumns(10);
		  textHo.addKeyListener(new KeyAdapter() {
				@Override
				public void keyPressed(KeyEvent e) {
					 int key=e.getKeyCode();
					     if(e.getSource()==textHo)
					     {
					        if(key==KeyEvent.VK_ENTER)
					        { 
					        	
					        	textField_2.requestFocusInWindow(); 
					        
					        }
					    }
				   }
			});
	   textHo.setBackground(new Color(174, 225, 225));
	   textHo.setBounds(79, 69, 190, 36);
	   panelsv.add(textHo);
		  
		textField_2 = new JTextField();
		textField_2.setBackground(new Color(175, 238, 238));
		textField_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textField_2.setColumns(10);
		textField_2.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				 int key=e.getKeyCode();
				     if(e.getSource()==textField_2)
				     {
				        if(key==KeyEvent.VK_ENTER)
				        { 
				        	
				        	jdate.requestFocusInWindow(); 
				        
				        }
				    }
			   }
		});
		textField_2.setBounds(79, 129, 190, 36);
		panelsv.add(textField_2);
		
		textField_4 = new JTextField();
		textField_4.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				 int key=e.getKeyCode();
				    if(e.getSource()==textField_4)
				    {
				        if(key==KeyEvent.VK_ENTER)
				        { 
				           if( (CheckDiemkiemTra(Float.parseFloat(textField_4.getText()),textField_4))<=10
				        		   ||(CheckDiemkiemTra(Float.parseFloat(textField_4.getText()),textField_4))>=0) {
				        	   textField_5.requestFocusInWindow(); 
				           }

				        }
				    }
			}
		});
		textField_4.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textField_4.setBackground(Color.LIGHT_GRAY);
		textField_4.setColumns(10);
		textField_4.setBounds(857, 11, 129, 36);
		panelsv.add(textField_4);
		
		textField_5 = new JTextField();
		textField_5 .addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				 int key=e.getKeyCode();
				     if(e.getSource()==textField_5 )
				     {
				        if(key==KeyEvent.VK_ENTER)
				        { 
				        	
				        	if( (CheckDiemkiemTra(Float.parseFloat(textField_5.getText()),textField_5))<=10
					        		   ||(CheckDiemkiemTra(Float.parseFloat(textField_5.getText()),textField_5))>=0) {
					        	   textField_6.requestFocusInWindow(); 
					           }
				        
				        }
				    }
			   }
		});
		textField_5.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textField_5.setBackground(Color.LIGHT_GRAY);
		textField_5.setColumns(10);
		textField_5.setBounds(857, 69, 129, 36);
		panelsv.add(textField_5);
		
		textField_6 = new JTextField();
		textField_6.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textField_6.setBackground(Color.LIGHT_GRAY);
		textField_6.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				 int key=e.getKeyCode();
				     if(e.getSource()==textField_6)
				     {
				        if(key==KeyEvent.VK_ENTER)
				        { 
				        	if( (CheckDiemkiemTra(Float.parseFloat(textField_6.getText()),textField_6))<=10
					        		  ||(CheckDiemkiemTra(Float.parseFloat(textField_6.getText()),textField_6))>=0) {
					        	  
					           }
				        	btnThem.doClick();  
				        
				        }
				    }
			   }
		});
		textField_6.setColumns(10);
		textField_6.setBounds(857, 129, 129, 36);
		panelsv.add(textField_6);
		jdate.getCalendarButton().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
			}
		});
		
		
		jdate .setBackground(Color.LIGHT_GRAY);
		// đây là cái mà ô text tại vị trí hiên tại
		jdate .addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				 int key=e.getKeyCode();
				     if(e.getSource()==jdate)
				     {
				        if(key==KeyEvent.VK_ENTER)
				        { // đât là o text tại vị trí tiếp theo mà mình muốn next
				        	 cbblop.requestFocusInWindow(); 
				        }
				    }
			   }
		});
	 comboBox = new JComboBox();
	 comboBox.addActionListener(new ActionListener() {
	 	public void actionPerformed(ActionEvent e) {
	 		textField_4.requestFocusInWindow(); 
	 	}
	 	
	 });
	 comboBox.setEditable(true);
	 comboBox.setBackground(new Color(250, 226, 252));

	 comboBox.setFont(new Font("Tahoma", Font.PLAIN, 14));
	 comboBox .addItem("");
		comboBox.setBounds(394, 129, 173, 36);
		ArrayList<Tinh>tinhthanh=Tinh.getDSTinh();
		  for(Tinh tinh: tinhthanh) {
			comboBox .addItem(tinh);
		  }
		panelsv.add(comboBox);
		
		rdbtnNu = new JRadioButton("Nữ");
		rdbtnNu.setBackground(Color.MAGENTA);
		rdbtnNu.setFont(new Font("Tahoma", Font.PLAIN, 13));
		rdbtnNu.setBounds(414, 75, 59, 23);
		panelsv.add(rdbtnNu);
		
		rdbtnNam = new JRadioButton("Nam");
		rdbtnNam.setBackground(Color.YELLOW);
		rdbtnNam.setFont(new Font("Tahoma", Font.PLAIN, 13));
		rdbtnNam.setBounds(508, 75, 59, 23);
		panelsv.add(rdbtnNam);
		btgroup=new ButtonGroup();
    	btgroup.add(rdbtnNu);
 		btgroup.add(rdbtnNam);
		
		JLabel lblGiiTnh = new JLabel("Giới Tính");
		lblGiiTnh.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblGiiTnh.setBounds(304, 81, 59, 25);
		panelsv.add(lblGiiTnh);
		
		textFieldiem = new JTextField();
		textFieldiem.setEditable(false);
		textFieldiem.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textFieldiem.setBackground(Color.CYAN);
		textFieldiem.setBounds(857, 179, 129, 36);
		panelsv.add(textFieldiem);
		textFieldiem.setColumns(10);
		
		JLabel lblimTb = new JLabel("Điểm TB");
		lblimTb.setForeground(Color.RED);
		lblimTb.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblimTb.setBounds(677, 185, 80, 25);
		panelsv.add(lblimTb);
		
		JLabel lblNewLabel = new JLabel("Lớp");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel.setBounds(316, 16, 80, 24);
		panelsv.add(lblNewLabel);
		 
		 JPanel panel_1 = new JPanel();
		 panel_1.setBackground(Color.GREEN);
		 panel_1.setBounds(10, 229, 1005, 65);
		 panelsv.add(panel_1);
		 panel_1.setLayout(null);
		 
		  btnThem = new JButton("Thêm");
		  btnThem.setFont(new Font("Tahoma", Font.BOLD, 14));
		  btnThem.setBackground(UIManager.getColor("Button.focus"));
		  btnThem.setBounds(31, 15, 112, 33);
		  btnThem.addActionListener(new ActionListener() {
			  	public void actionPerformed(ActionEvent e) {
			  		  nhapsv();
			  		 setFormNull();
			  	}
			  });
		  panel_1.add(btnThem);
		  btnThem.setBackground(UIManager.getColor("textHighlight"));
		  
		  JButton btnNewButton_2 = new JButton("SetForm");
		  btnNewButton_2.setBounds(870, 15, 99, 33);
		  panel_1.add(btnNewButton_2);
		  btnNewButton_2.addActionListener(new ActionListener() {
		  	public void actionPerformed(ActionEvent e) {
		  	    setFormNull();
		  	}
		  });
		  btnNewButton_2.setBackground(UIManager.getColor("ComboBox.background"));
		  btnNewButton_2.setFont(new Font("Tahoma", Font.BOLD, 13));
		  
		  JButton btnAll = new JButton("ShowAll");
		  btnAll.setFont(new Font("Tahoma", Font.BOLD, 13));
		  btnAll.setBounds(662, 16, 106, 33);
		  panel_1.add(btnAll);
		  btnAll.setBackground(Color.MAGENTA);
		  
		  JButton btnxoa = new JButton("Xóa");
		  btnxoa.setFont(new Font("Tahoma", Font.BOLD, 13));
		// thucs hien taoj phims tat
			String mapKey = "KEY_DELETE";
			InputMap inputMap = btnxoa.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
			inputMap.put(KeyStroke.getKeyStroke("delete"), mapKey); 
			btnxoa.getActionMap().put(mapKey, new AbstractAction() {
			    public void actionPerformed(ActionEvent evt) {
			    Xoasv();
			    }
			});
		  btnxoa.setBounds(221, 16, 106, 33);
		  panel_1.add(btnxoa);
		  btnxoa.setBackground(UIManager.getColor("Button.background"));
		  
		  JButton btnsua = new JButton("Cap Nhat");
		  btnsua.setFont(new Font("Tahoma", Font.BOLD, 14));
		  btnsua.setBounds(418, 20, 127, 29);
		  panel_1.add(btnsua);
		  btnsua.setForeground(Color.RED);
		  btnsua.setBackground(Color.MAGENTA);
		  jdate.getCalendarButton().setFont(new Font("Tahoma", Font.PLAIN, 13));
		  jdate.setBounds(79, 185, 190, 36);
		  panelsv.add(jdate);
		  
		   cbblop = new JComboBox();
		   cbblop.setEditable(true);
		   cbblop.addItem("");
		   try {
			for(String lop : conectSinhvien.getInforSV().getAllLop()) {
				cbblop.addItem(lop);
			   }
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		  cbblop.setBounds(388, 12, 190, 36);
		  panelsv.add(cbblop);
		  
		   cbxhocky = new JComboBox();
		   cbxhocky.setFont(new Font("Tahoma", Font.PLAIN, 14));
		   cbxhocky.addItem("");
		   cbxhocky.addItem("hk1:2022-2023");
		   cbxhocky.addItem("hk2:2022-2023");
		   cbxhocky.addItem("hk1:2023-2024");
		   cbxhocky.addItem("hk2:2023-2024");
		   cbxhocky.addItem("hk1:2024-2025");
		   cbxhocky.addItem("hk2:2024-2025");
		   cbxhocky.addItem("hk1:2025-2026");
		   cbxhocky.addItem("hk1:2025-2026");
		  cbxhocky.setBounds(392, 185, 175, 35);
		  panelsv.add(cbxhocky);
		  
		  JLabel lblHcK = new JLabel("HỌC KỲ");
		  lblHcK.setFont(new Font("Tahoma", Font.BOLD, 12));
		  lblHcK.setBounds(304, 185, 80, 25);
		  panelsv.add(lblHcK);
		 
		  btnsua.addActionListener(new ActionListener() {
		  	public void actionPerformed(ActionEvent e) {
		  		capNhatSuaThongTin();
		  	}
		  });
		  btnxoa.addActionListener(new ActionListener() {
		  	public void actionPerformed(ActionEvent e) {
		  		Xoasv();
		  		 setFormNull();
		  	}
		  });
		  btnAll.addActionListener(new ActionListener() {
		  	public void actionPerformed(ActionEvent e) {
		  		
		  		SelectDsSinhVienInTable();
		  	}
		  });		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(128, 128, 128));
		panel_2.setBounds(10, 11, 1024, 41);
		add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblTimqq = new JLabel("Tìm Điểm TB");
		lblTimqq.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblTimqq.setBounds(0, 0, 91, 30);
		panel_2.add(lblTimqq);
		
		JLabel tetxhoac = new JLabel("Hoặc");
		tetxhoac.setFont(new Font("Tahoma", Font.BOLD, 14));
		tetxhoac.setBounds(238, 0, 64, 30);
		
		 
		panel_2.add(tetxhoac);
		
		JLabel lblMasv = new JLabel("Tìm Masv");
		lblMasv.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblMasv.setBounds(312, 0, 64, 30);
		panel_2.add(lblMasv);
		
		textField_7 = new JTextField();
		textField_7.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textField_7.setBounds(401, 2, 189, 33);
		panel_2.add(textField_7);
		textField_7.setColumns(10);
		
		JButton btnNewButton = new JButton("");
		btnNewButton.setIcon(new ImageIcon(SinhVien.class.getResource("/img/Treetog-I-Search.32 (1).png")));
		btnNewButton.setBorderPainted(false);
		btnNewButton.setBackground(new Color(128, 128, 128));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(textField_8.getText().equals("")) {
				    
	    		     timKiem();
	    		     textField_7.setText("");
	    		 	textField_8.setText("");
	    	   }else if(textField_7.getText().equals("")) { 
	    		      TimKiemIndiem();
	    		      textField_7.setText("");
		    		 	textField_8.setText("");
	    	   }else if(textField_8.getText().equals("")&&textField_7.getText().equals("")){
	    		 
	    		   alertTimkiem();
	    		   textField_7.setText("");
	    		 	textField_8.setText("");
	    		   return ;
	    	   }
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton.setBounds(588, -2, 64, 36);
		panel_2.add(btnNewButton);
		
		textField_8 = new JTextField();
		textField_8.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textField_8.setColumns(10);
		textField_8.setBounds(87, 1, 129, 33);
		panel_2.add(textField_8);
		
		JButton btnNewButton_1 = new JButton("Hủy Tìm");
		 btnNewButton_1.setBorderPainted(false);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				HuyTim();
			}
		});
		btnNewButton_1.setBackground(new Color(128, 255, 255));
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnNewButton_1.setBounds(656, 1, 103, 34);
		panel_2.add(btnNewButton_1);
		
		btnAddDB = new JButton("Add Excel->Database");
		btnAddDB.setBackground(Color.GRAY);
		btnAddDB.setBorderPainted(false);
		btnAddDB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addAllDataBaseOntoTable();
				}
		});
		btnAddDB.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 12));
		btnAddDB.setBounds(838, 1, 176, 29);
		panel_2.add(btnAddDB);
		
	
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 63, 707, -5);
		add(scrollPane);
		
		table_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				getjTable1MouseClicked();
			}
		});
	}
// ==================================Sư lý sư kiên ===================================================
		  
public void AddVaoTable(Thisinh ts) {  
	if(ts!=null) {
		 	  DefaultTableModel mode=(DefaultTableModel)table_1.getModel();
		   	        	 mode.addRow(new Object[] {
		   	        		 mode.getRowCount()+1,// so thứ tự
		   	    		      ts.getMasv()+"",
		   	    		      ts.getHo()+"".toUpperCase(),
		   	    	          ts.getTen()+"".toUpperCase(),
		   	    	          ts.getQuequan().gettenTinh()+"",
		   	    	          (ts.getNgaysinh())+"",
		   	    	          (ts.isGioitinh()? "Nam" : "Nữ")+"",
		   	    	          ts.getLop().toUpperCase()+"",
		   	    	          ts.getHocky()+"",
		   	    	          ts.getDiemtoan()+"",
		   	    	          ts.getDiemli()+"",
		   	    	          ts.getDiemhoa()+"",
		   	    	          ts.getDiemtb()+""});
		      }
}

@Override
public void kiemtra(Thisinh ts) throws SQLException {
 	if(conectSinhvien.getInforSV().kiemtraId(ts.getMasv())==true) {
        		 int luachon=JOptionPane.showConfirmDialog(this,"ma sv nhập bị trùng");
		             if(luachon==JOptionPane.YES_OPTION){
			             return ;
                   }
	        }else if(conectSinhvien.getInforSV().kiemtraId(ts.getMasv())==false) { 
	           DefaultTableModel model=(DefaultTableModel)table_1.getModel();
					int soluongDong=model.getRowCount();
					if(soluongDong==0) { 
						this.AddVaoTable(ts);
						 conectSinhvien.getInforSV().insert(ts);
						 connectDiemdanh.insertMasvInTableDiemDanh(ts.getMasv(),ts.getHocky()); 
						 connectDiemdanh.insertmasvaotablePhanTram(ts.getMasv(),ts.getHocky());
					     ConnectDanhgiaRL.danhgia().insertInto(ts.getMasv(),ts.getHo(),ts.getTen(),ts.getDiemtb(),ts.getHocky(),ts.getLop());
					     connSinhVienDn.DangNhap().insertMASVdangNhap(ts.getMasv());
					     connectThongTinSinhVien.getInforSV().insertInforSv(ts.getMasv());
						return;
					}
					else if(soluongDong>0){ 
					
					try {
						
						 conectSinhvien.getInforSV().insert(ts);
						 connectDiemdanh.insertMasvInTableDiemDanh(ts.getMasv(),ts.getHocky()); 
						 connectDiemdanh.insertmasvaotablePhanTram(ts.getMasv(),ts.getHocky());
                         connSinhVienDn.DangNhap().insertMASVdangNhap(ts.getMasv());
                         connectThongTinSinhVien.getInforSV().insertInforSv(ts.getMasv());
					     ConnectDanhgiaRL.danhgia().insertInto(ts.getMasv(),ts.getHo(),ts.getTen(),ts.getDiemtb(),ts.getHocky(),ts.getLop());
						 ReloadDataTable(model,ts,soluongDong);
					}catch (Exception e) {
						e.printStackTrace();
					}
		         }
		      }
          }
        
    //=======================HAM CHO SINH VIEN ===========================================
public void  ReloadDataTable( DefaultTableModel model,Thisinh ts,int soluongDong) {
	  
    ArrayList<Thisinh>listTs=new ArrayList<Thisinh>();
	  listTs.add(ts);
if(soluongDong==0) {
	       listTs=null;
	       return  ;
}else {
	 // lấyy lại toàn bộ dữ liệu của table xong sau đó ser thực hiện làm
	 // rỗng table vad săps sếp ccas giá trị mới của table
	   for(int i=0;i<model.getRowCount();i++) {
		   String masv= ""+ model.getValueAt(i,1);
		   String ho= model.getValueAt(i,2 )+"";	
		   String ten= model.getValueAt(i,3)+"";	    
		   Tinh diachi =Tinh.getTinhByTen(model.getValueAt(i,4 )+"");
		   Date ngaysinh= Date.valueOf( model.getValueAt(i,5 )+"");
		   String TextGioiTinh=model.getValueAt(i,6)+"";
		   boolean chonGioiTinh=TextGioiTinh.equals("Nam");
		   String lop=model.getValueAt(i,7)+"";
		   String hocky=model.getValueAt(i,8)+"";
		   float mon1=Float.valueOf(model.getValueAt(i,9)+"");
		   float mon2=Float.valueOf(model.getValueAt(i,10)+"");
		   float mon3=Float.valueOf(model.getValueAt(i,11 )+"");
		   float diemtb=Float.valueOf(model.getValueAt(i,12)+"");
		   
		   Thisinh ts2 =new Thisinh(masv,ho,ten,diachi,ngaysinh,chonGioiTinh,lop,hocky,mon1,mon2,mon3,diemtb);
		    
		   listTs.add(ts2);
		   }
	      }
	  while(model.getRowCount()!=0) { 
				model.removeRow(0);
	   }
	
	  for(Thisinh tsinh: SapSep(listTs)){
		 this.AddVaoTable(tsinh);
	  }

}
@Override
 public void nhapsv() { 
    	
	        this.txtS.setEditable(true);
		    boolean gioitinh=true;
		    if(this.rdbtnNam.isSelected()) {
		     		// isSelected()là hàm có sẳn chỉ định chọn 1 trong 2 và ko cần action
		     	     gioitinh=true;	
		    }else if(this.rdbtnNu.isSelected()) {
		     	     gioitinh=false;	
		     	  }
		   
		    String masv=txtS.getText();
		    String ho=textHo.getText().toUpperCase();
		    String ten=textField_2.getText().toUpperCase();
		  Date ngkh=Date.valueOf(outputFormat.format(jdate.getDate()));
		    int tinh= comboBox.getSelectedIndex();
		    Tinh quequan=Tinh.getTinhById(tinh-1);
		    String lop=  ((String) cbblop.getSelectedItem()).toUpperCase();
		    String hocky=(String) cbxhocky.getSelectedItem();
		   if(this.textField_4.getText().equals("")||this.textField_5.getText().equals("")||this.textField_6.getText().equals("")) {
			   JOptionPane.showConfirmDialog(this,"vui lòng nhập đủ thông tin");
			  return ;
		   }
            float mon1=Float.parseFloat(this.textField_4.getText());
	        float mon2=Float.parseFloat(this.textField_5.getText());
		    float mon3=Float.parseFloat(this.textField_6.getText());
		   
		    System.out.println(mon1+"hdhsd");
		    if(masv.equals("")||ho.equals("")||ten.equals("")||ngkh.equals("")||quequan.equals("")||lop.equals("")||hocky.equals("")) {
		    	 JOptionPane.showConfirmDialog(this,"vui lòng nhập đủ thông tin");
			          return ;
		    }
		    if(mon1<0||mon1>10||mon2<0||mon3<0||mon2>10||mon3>10) {
				        int luachon=JOptionPane.showConfirmDialog(this,"vui lòng nhập điểm trong khoảng 0 đến 10 ");
					    if(luachon==JOptionPane.YES_OPTION) {
				          return ;
					    }
			 }else {
				 
				    float diemtb= Math.round((mon1+mon2+mon3)/3);
				    Thisinh thisinh=new Thisinh(masv,ho,ten,quequan,ngkh,gioitinh,lop,hocky,mon1,mon2,mon3,diemtb);
				  
		     try {
		    	
				this.kiemtra(thisinh);
			
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		     
		     setFormNull();
			 };	
    }

// =============================== tìm kiếm sinh vien theo ma sv =======================================
@Override
public void timKiem() {
	
	if(this.textField_7.getText().equals("")) {
    	  int luachon=JOptionPane.showConfirmDialog(this,"vui lòng nhập masv vào");
    		if(luachon==JOptionPane.YES_OPTION) {
    			return ;
            }
       }else {
			 while(true) { 
				
				DefaultTableModel model=(DefaultTableModel)table_1.getModel();
				int soluongDong=model.getRowCount();
				if(soluongDong==0) {
					break;
				}else {
					try {
					model.removeRow(0);
				}catch (Exception e) {
					e.printStackTrace();
				}
			  }
			 }
        }
	  
		this.AddVaoTable(conectSinhvien.getInforSV().slectByid(this.textField_7.getText()));		
}
//================================================================================
@Override
public void TimKiemIndiem() {
	
	  if(this.textField_8.getText().equals("")) {
   	     int luachon=JOptionPane.showConfirmDialog(this,"vui lòng nhập điểm");
   		if(luachon==JOptionPane.YES_OPTION) {
   			return ;
           }
       }else {
			 while(true) {
				DefaultTableModel model=(DefaultTableModel)table_1.getModel();
				  int soluongDong=model.getRowCount();
				if(soluongDong==0) {
					break;
				}else {
					try {
					model.removeRow(0);
				}catch (Exception e) {
					e.printStackTrace();
				   }
			     }
			 }
		 ArrayList<Thisinh>list= conectSinhvien.getInforSV().selectByCondition(Float.parseFloat(textField_8.getText()));
				
				 for(Thisinh tsinh: SapSep(list)){
					this.AddVaoTable(tsinh);
			       }
           }  
}
@Override
public void setFormNull() {
			this.txtS.setEditable(true);
		
		    textField_4.setText("");
		    textField_2.setText("");
		    textHo.setText("");
		    comboBox.setSelectedIndex(-1); 
		    jdate.setDate(null);
		    textField_5.setText("");
		    this.cbblop.setSelectedItem("");
		    this.cbxhocky.setSelectedItem("");
		    this.txtS.setText("");
		    this.rdbtnNam.setSelected(false);
		    this.rdbtnNu.setSelected(false);
		    this.textField_6.setText("");
		    textField_7.setText("");
		    textFieldiem.setText("");
}
@Override
public void SelectDsSinhVienInTable(){
	DefaultTableModel model=(DefaultTableModel)table_1.getModel();
	while(true) {
		int soluongDong=model.getRowCount();
		if(soluongDong==0) {
			break;
		}else {
			try {
			model.removeRow(0);
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
}

    ArrayList<Thisinh>list= conectSinhvien.getInforSV().selectAll();
    list = SapSep(list);
	for(Thisinh tsinh:list){
		this.AddVaoTable(tsinh);
	}
}
@Override
public void HuyTim() {
	   this.textField_7.setText("");
	   this.textField_8.setText("");
  }

/* 
 * hàm này có chức năng là tảoa cái hiển thị thông báo khi ta thực hiện cho chức năng tìm kiếm 
 * 
 */
@Override
public void alertTimkiem() {
	 int luachon=JOptionPane.showConfirmDialog(this,"vui lòng nhập điểm hoặc nhập  masv vào ");
		if(luachon==JOptionPane.YES_OPTION) {
			return ;
		}
}
@Override
public float CheckDiemkiemTra(float diem, JTextField text) {
	 if(diem>10||diem<0) {
		    int luachon=JOptionPane.showConfirmDialog(this,"vui lòng nhập điểm trong khoảng 0 đến 10 ");
			if(luachon==JOptionPane.YES_OPTION) {
				text.setText("");	
			}
	 }
	 return diem;
	   
}
@Override
public void Xoasv() {
	/*
	 * khi ta thực hiện click vào 1 hanngf trong table thì lập tức dữ liệu của nó sẻ 
	 * được lấy ra bởi phương thức getModel().và trong table có hỗ trợ phương thức 
	 * xóa đi hàng mà ta đã chọn . 
	 */
	DefaultTableModel model=(DefaultTableModel)table_1.getModel();
	int soHang=table_1.getSelectedRow();//chọn dong nao để xóa 
	int luachon=JOptionPane.showConfirmDialog(this,"bạn có chắc muốn xóa");
	if(luachon==JOptionPane.YES_OPTION) {
		Thisinh ts=getCapNhatThongTinSinhVien();
		/*
		getCapNhatThongTinSinhVien() Gọi lại phươn thức này cho phép nhận lại toàn bộ dữ liệu  
		của hàng mà ta đã chọn trong table để tạo thành 1 đối tượng sinh viên 
		*/
		model.removeRow(soHang);
		//ReloadDataTable( model,ts,model.getRowCount());
		//thưc hiện xóa ở đatabase khi dối tường sinh vien khi đưa vào mã sinh viên theo điều kiện where masv
		conectSinhvien.getInforSV().delete(ts); 
		
	}
}
//===========================================================================================
@Override
public  Thisinh getCapNhatThongTinSinhVien() {
	 DefaultTableModel model=(DefaultTableModel)table_1.getModel();
	 Thisinh thisinh = null;
	  	  int i_Row=table_1.getSelectedRow();
	  	   model.getValueAt(i_Row,12 );
	  	   String masv= ""+ model.getValueAt(i_Row,1 );
	  	   String ho= model.getValueAt(i_Row,2 )+"";	
	  	   String ten= model.getValueAt(i_Row,3 )+"";
	     
	  	   Tinh diachi =Tinh.getTinhByTen(model.getValueAt(i_Row,4)+"");
	  	   Date ngaysinh;
	  	
	  	   if((model.getValueAt(i_Row,5 )+"").equals("null")) {
	  	    	 ngaysinh= Date.valueOf( "2000-1-1");
	  	   }else {
	  	    	ngaysinh= Date.valueOf( model.getValueAt(i_Row,5)+"");
	  	      }
	  	    String TextGioiTinh=model.getValueAt(i_Row,6)+""; 
	  	    boolean chonGioiTinh=TextGioiTinh.equals("Nam");	
	  	    String lop=model.getValueAt(i_Row,7)+"";
	  	  String hocky=model.getValueAt(i_Row,8)+"";
		   float mon1=Float.valueOf(model.getValueAt(i_Row,9)+"");
		   float mon2=Float.valueOf(model.getValueAt(i_Row,10)+"");
		   float mon3=Float.valueOf(model.getValueAt(i_Row,11 )+"");
		   float diemtb=Float.valueOf(model.getValueAt(i_Row,12)+"");
	  	   thisinh=new Thisinh(masv,ho,ten,diachi,ngaysinh,chonGioiTinh,lop,hocky,mon1,mon2,mon3,diemtb);
	  	return thisinh;
	  	}


// ============================= sua thong tin trong table=====================================
@Override
public void CapNhatGiaTriTbale(Thisinh ts) {
	DefaultTableModel model=(DefaultTableModel)table_1.getModel();
    	  int SoluongDong= model.getRowCount();
             for(int i=0;i<SoluongDong;i++) {
             String id=model.getValueAt(i,1)+"";
            	if(id.equals(ts.getMasv()+"")) {
            		model.setValueAt(ts.getMasv()+"",i,1);
            		model.setValueAt(ts.getHo()+"",i,2);	
            		model.setValueAt(ts.getTen()+"",i,3);
            		model.setValueAt(ts.getQuequan()+"",i,4);
            		model.setValueAt(ts.getNgaysinh()+"",i,5);
            		model.setValueAt((ts.isGioitinh()? "Nam" : "Nữ")+"",i,6);
            		model.setValueAt(ts.getLop()+"",i,7);
            		model.setValueAt(ts.getHocky()+"",i,8);
            		model.setValueAt(ts.getDiemtoan()+"",i,9);
            		model.setValueAt(ts.getDiemli()+"",i,10);
            		model.setValueAt(ts.getDiemhoa()+"",i,11);
            		model.setValueAt(ts.getDiemtb()+"",i,12);
            	}
            }
}
//======================= lấy dữ liệu từ table khi clicj vào hàng ===================================
@Override
public void getjTable1MouseClicked() {
    // lấy ra gtri tư bảng trong hang so bao nhieu
	try {
		DefaultTableModel model=(DefaultTableModel)table_1.getModel();
		     if(table_1.getSelectedRow()<0){
		    	 return;
		     }
		    int i_Row=table_1.getSelectedRow();
		    System.out.println(i_Row);
		    model.getValueAt(i_Row,12 );		    
		    String masv= ""+ model.getValueAt(i_Row,1 );
		    String ho= model.getValueAt(i_Row,2 )+"";	
		    String ten= model.getValueAt(i_Row,3 )+"";
	        Tinh diachi =Tinh.getTinhByTen(model.getValueAt(i_Row,4 )+"");
		    String ngaysinh=   model.getValueAt(i_Row,5 )+"";
		    String TextGioiTinh=model.getValueAt(i_Row,6)+"";
		    boolean chonGioiTinh=TextGioiTinh.equals("Nam");	
		    String lop= ""+ model.getValueAt(i_Row,7 );
		    String hocky=""+model.getValueAt(i_Row,8);
		    float mon1=Float.valueOf(model.getValueAt(i_Row,9)+"");
		    float mon2=Float.valueOf(model.getValueAt(i_Row,10)+"");
			float mon3=Float.valueOf(model.getValueAt(i_Row,11 )+"");
			float diemtb=Float.valueOf(model.getValueAt(i_Row,12)+"");
			this.txtS.setText(masv);
			this.txtS.setEditable(false);// khi thưc hiện hàm này thì másv bị khóa và ko sửa được 
		    this.textHo.setText(ho);
			this.textField_2.setText(ten);
		    this.comboBox.setSelectedItem(diachi);
			this.jdate.setDate(Date.valueOf(ngaysinh));	
			 if(chonGioiTinh==true) {
		 	     this.rdbtnNam.setSelected(true);
		 	}else if(chonGioiTinh==false) {
		 	     this.rdbtnNu.setSelected(true);	
		 	}
			this.cbblop.setSelectedItem(lop);
			this.cbxhocky.setSelectedItem(hocky);
		    this.textField_4.setText(mon1+"");
		    this.textField_5.setText(mon2+"");
		    this.textField_6.setText(mon3+"");
		    this.textFieldiem.setText(diemtb+"");
	} catch (NullPointerException e) {
		System.out.println(e);
	   	}
			
}
//===================   sua thong tin trong co so du lieu    ====================================
@Override
public void capNhatSuaThongTin() {
		 String masv=this.txtS.getText();
		 String ho=this.textHo.getText();
	     String ten=this.textField_2.getText();
	     int quequan=this.comboBox.getSelectedIndex();
	     Tinh queHuong =Tinh.getTinhById(quequan-1);
		
	     Date date= Date.valueOf(outputFormat.format(jdate.getDate()));
	     boolean chonGioiTinh=true;

	    if(this.rdbtnNam.isSelected()) {
     	
	    	chonGioiTinh=true;	
       }else if(this.rdbtnNu.isSelected()) {
    	    chonGioiTinh=false;	
     	  }
	     String lop= (String) this.cbblop.getSelectedItem();
	     String hocky=(String) this.cbxhocky.getSelectedItem();
	     float mon1=Float.parseFloat(this.textField_4.getText());
	     float mon2=Float.parseFloat(this.textField_5.getText());
		 float mon3=Float.parseFloat(this.textField_6.getText());
		 float diemtb= Math.round((mon1+mon2+mon3)/3);
		 
		 if(mon1<0||mon1>10||mon2<0||mon3<0||mon3>10||mon2>10) {
		        int luachon=JOptionPane.showConfirmDialog(this,"vui lòng nhập điểm trong khoảng 0 đến 10 ");
				if(luachon==JOptionPane.YES_OPTION) {
			          return ;
				  }
		  }else {
				 Thisinh ts=new Thisinh(masv,ho,ten,queHuong,date,chonGioiTinh,lop,hocky,mon1,mon2,mon3,diemtb);
				 this.CapNhatGiaTriTbale(ts);
		 		
		 		conectSinhvien.getInforSV().upDATE(ts);
		 		conectSinhvien.getInforSV().capNhatChotableALL(ho, ten,lop,hocky, diemtb,masv );
		 		conectSinhvien.getInforSV().capNhatChotableALL(hocky,masv );
		 		conectSinhvien.getInforSV().capNhatChotableALLPhanTram(hocky,masv );
		 		conectSinhvien.getInforSV().capNhatChotablettsv(date,masv);
		 		this.txtS.setEditable(true);//tra lại nhập chuoi cho masv 
		 		this. setFormNull();
		 }
}

//==================================xuat file excel=======================================================

public static ArrayList<Thisinh> DanhSachDoituong(){
	  ArrayList<Thisinh>listTs=new ArrayList<Thisinh>();
	  DefaultTableModel model=(DefaultTableModel)table_1.getModel();
	  int soluongDong=model.getRowCount();
	   System.out.println(soluongDong);
	 if(model.getRowCount()==0) {
	       listTs=null;
	       return  listTs;
	 }else {
	   for(int i=0;i<model.getRowCount();i++) {
		   model.getValueAt(i,12);// lấy gía trị  của 12 cột
		   String masv= ""+ model.getValueAt(i,1);
		   String ho=model.getValueAt(i,2)+"";
		   String ten= model.getValueAt(i,3 )+"";	    
		   Tinh diachi =Tinh.getTinhByTen(model.getValueAt(i,4 )+"");
		   Date ngaysinh;
		   if((model.getValueAt(i,5 )+"").equals("null")) {
	  	    	 ngaysinh= Date.valueOf( "2000-1-1");
	  	   }else {
	  	    	ngaysinh= Date.valueOf( model.getValueAt(i,5)+"");
	  	   }
		   String TextGioiTinh=model.getValueAt(i,6)+"";
		   boolean chonGioiTinh=TextGioiTinh.equals("Nam");
		   String lop=model.getValueAt(i,7)+"";
		   String hocky=model.getValueAt(i,8)+"";
		   float mon1=Float.valueOf(model.getValueAt(i,9)+"");
		   float mon2=Float.valueOf(model.getValueAt(i,10)+"");
		   float mon3=Float.valueOf(model.getValueAt(i,11 )+"");
		   float diemtb=Float.valueOf(model.getValueAt(i,12)+"");
		   
		   Thisinh ts2 =new Thisinh(masv,ho,ten,diachi,ngaysinh,chonGioiTinh,lop,hocky,mon1,mon2,mon3,diemtb);
		  	 listTs.add(ts2);
	   }
   }  
	return  SapSep(listTs);  
}

public static void xuatExcel() throws IOException {
	
        if(DanhSachDoituong()!=null) {
			FileWriter fw=new FileWriter("src\\main\\java\\View\\EXCEL.csv");// tạo ra 1 fiel có đươngf dẫn là 
			fw.write("id,ho, ten, quequan, ngaysinh, gioitinh,lop,hocky,diem1, diem2,diem3, diemtb\n");// dòng đầu tiên được ghi vào excel
			for(Thisinh SV: DanhSachDoituong()) {
	        	
	        	fw.write(SV+"\n"); ;
			}
					fw.flush();
					fw.close();
        }
    }
public static  ArrayList<Thisinh> SapSep(ArrayList<Thisinh>listTs) {

	 Comparator <Thisinh> std=new  Comparator<Thisinh>(){
			@Override
			public int compare(Thisinh o1, Thisinh o2) {
				  if( (o1.getLop().compareTo(o2.getLop()))==0){
			           return o1.getTen().compareTo(o2.getTen());   
				  }else {
					  return o1.getLop().compareTo(o2.getLop());
				  }
			   }  
	        };
	   Collections.sort(listTs, std);
	   
	   return listTs;
}
@Override

public void addAllDataBaseOntoTable(){
		   for(Thisinh ts:DanhSachDoituong()) {
			   try {
				kiemtra( ts);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		 }
		   DefaultTableModel model=(DefaultTableModel)table_1.getModel();
		model.setRowCount(0);
     }
}