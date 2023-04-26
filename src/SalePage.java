import java.awt.event.*;
import java.awt.EventQueue;
import java.awt.Color;
import java.awt.Component;
import java.awt.SystemColor;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JComboBox;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextPane;
import javax.swing.JTextField;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableModel;
import javax.swing.Timer;
import javax.swing.DefaultComboBoxModel;
import javax.swing.border.TitledBorder;

import java.text.SimpleDateFormat;

import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class SalePage extends JFrame {
	
	Connection con;
	PreparedStatement pst;
	
	public void Connect()
    {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost/MobStore", "TestDB", "12345678");
            
        } catch (ClassNotFoundException ex) {
               ex.printStackTrace();
        } catch (SQLException ex) {
               ex.printStackTrace();
        }
 
    }
	
	public void invoiceid()
    {
        try {
           
            Statement s = con.createStatement();
            ResultSet rs = s.executeQuery("SELECT MAX(invoiceid) FROM sales");
            rs.next();
            rs.getString("MAX(invoiceid)");
            if (rs.getString("MAX(invoiceid)") == null) {
            	invoiceNumber.setText("E-0000001");     
            } else {
                long id = Long.parseLong(rs.getString("MAX(invoiceid)").substring(2, rs.getString("MAX(invoiceid)").length()));
                id++;
                invoiceNumber.setText("E-" + String.format("%07d", id));
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }      
    }
	
	private JPanel contentPane;
	private JTextField custName;
	private JTextField custContact;
	private JTextField custAdd;
	private JTextField productName;
	private JTextField brandName;
	private JTextField unitPrice;
	private JTextField noOfUnits;
	private JTable saleEntriesTable;
	private JLabel dateLabel;
	private JLabel timeLabel;
	private JLabel subTotalPrice;
	private JLabel finalAfterDiscount;
	private JLabel finalAfterTax;
	private JLabel totalPriceLabel;
	
	Double totalPrice=0.0;
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SalePage frame = new SalePage();
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
	public SalePage() {
		
		setBackground(new Color(34, 40, 48));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1920, 1080);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(56, 62, 70));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel custProductPanel = new JPanel();
		custProductPanel.setBackground(new Color(77, 170, 179));
		custProductPanel.setBounds(0, 0, 344, 823);
		contentPane.add(custProductPanel);
		custProductPanel.setLayout(null);
		
		JButton clearBtn = new JButton("Clear");
		clearBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
	            productName.setText("");
	            unitPrice.setText("");
	            brandName.setText("");
	            noOfUnits.setText("");
	            brandName.requestFocus();
			}
		});
		clearBtn.setBackground(new Color(238, 238, 238));
		clearBtn.setBounds(144, 754, 66, 25);
		custProductPanel.add(clearBtn);
		
		JButton btnAddProduct = new JButton("Add Product");
		btnAddProduct.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String id = invoiceNumber.getText();
				String bname = brandName.getText();
	            String pname = productName.getText();
	            String uprice = unitPrice.getText();
	            String nou = noOfUnits.getText();
	            String cname = custName.getText();
	            String ccont = custContact.getText();
	            String cadd = custAdd.getText();
	            
		        try {
		            pst = con.prepareStatement("insert into sales values(?,?,?,?,?,?,?,?)");
		            pst.setString(1,id);
		            pst.setString(2,bname);
		            pst.setString(3,pname);
		            pst.setString(4,uprice);
		            pst.setString(5,nou);
		            pst.setString(6,cname);
		            pst.setString(7,ccont);
		            pst.setString(8,cadd);
		            
		            pst.executeUpdate();
		            Double currPrice=Double.parseDouble(nou)*Double.parseDouble(uprice);
		            totalPrice += Double.parseDouble(nou)*Double.parseDouble(uprice);

		            if(bname=="" || pname=="" || uprice=="" || nou=="" || cname=="" || ccont=="" || cadd=="") {
		            	JOptionPane.showMessageDialog(btnAddProduct, "Please Enter all data");
		            } else {
		            	Object values[] = {pname, Double.parseDouble(uprice), Integer.parseInt(nou), currPrice};
		            	DefaultTableModel tbModel = (DefaultTableModel)saleEntriesTable.getModel();
		            	tbModel.addRow(values);
		            }
		            Double dis = (Double)(totalPrice*Double.parseDouble(afterDiscount.getText()))/100;
		            Double tax = (Double)(totalPrice*Double.parseDouble(afterTax.getText()))/100;
		            subTotalPrice.setText(String.valueOf(totalPrice));
		            finalAfterDiscount.setText(String.valueOf(dis));
		            finalAfterTax.setText(String.valueOf(tax));
		            totalPriceLabel.setText(String.valueOf(totalPrice-dis+tax));
		            productName.setText("");
		            unitPrice.setText("");
		            brandName.setText("");
		            noOfUnits.setText("");
		            brandName.requestFocus();
		            
		            
		        } catch (SQLException ex) {
		        	Logger.getLogger(SalePage.class.getName()).log(Level.SEVERE, null, ex);
		        } 
			}
		});
		btnAddProduct.setBackground(new Color(255, 217, 102));
		btnAddProduct.setBounds(222, 754, 110, 25);
		custProductPanel.add(btnAddProduct);
		
		JPanel customerDetails = new JPanel();
		customerDetails.setBorder(new LineBorder(new Color(238, 238, 238), 1, true));
		customerDetails.setBackground(new Color(77, 170, 179));
		customerDetails.setBounds(12, 43, 320, 282);
		custProductPanel.add(customerDetails);
		customerDetails.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Invoice Number");
		lblNewLabel.setForeground(new Color(238, 238, 238));
		lblNewLabel.setBounds(12, 45, 105, 15);
		customerDetails.add(lblNewLabel);
		
		JLabel lblCustomerName = new JLabel("Customer Name");
		lblCustomerName.setForeground(SystemColor.window);
		lblCustomerName.setBounds(12, 95, 105, 15);
		customerDetails.add(lblCustomerName);
		
		JLabel lblCustomerContact = new JLabel("Customer Contact");
		lblCustomerContact.setForeground(SystemColor.window);
		lblCustomerContact.setBounds(12, 145, 123, 15);
		customerDetails.add(lblCustomerContact);
		
		JLabel lblCustomerAddress = new JLabel("Customer Address");
		lblCustomerAddress.setForeground(SystemColor.window);
		lblCustomerAddress.setBounds(12, 197, 123, 15);
		customerDetails.add(lblCustomerAddress);
		
		custName = new JTextField();
		custName.setBounds(146, 93, 162, 28);
		customerDetails.add(custName);
		custName.setColumns(10);
		
		custContact = new JTextField();
		custContact.setColumns(10);
		custContact.setBounds(146, 143, 162, 28);
		customerDetails.add(custContact);
		
		custAdd = new JTextField();
		custAdd.setHorizontalAlignment(SwingConstants.LEFT);
		custAdd.setColumns(10);
		custAdd.setBounds(146, 195, 162, 75);
		customerDetails.add(custAdd);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(238, 238, 238));
		panel.setBounds(146, 45, 162, 28);
		customerDetails.add(panel);
		panel.setLayout(null);
		
		invoiceNumber = new JLabel("");
		invoiceNumber.setFont(new Font("Dialog", Font.BOLD, 13));
		invoiceNumber.setBounds(12, 0, 122, 28);
		invoiceNumber.setForeground(new Color(0, 0, 0));
		panel.add(invoiceNumber);
		
		JLabel lblAddCustomer = new JLabel("Customer Details");
		lblAddCustomer.setFont(new Font("Dialog", Font.BOLD, 15));
		lblAddCustomer.setForeground(SystemColor.window);
		lblAddCustomer.setBounds(95, 12, 135, 15);
		customerDetails.add(lblAddCustomer);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(77, 170, 179));
		panel_2.setBorder(new TitledBorder(new LineBorder(new Color(184, 207, 229)), "Product Details", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(238, 238, 238)));
		panel_2.setBounds(7, 397, 325, 195);
		custProductPanel.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblNewLabel_1_2 = new JLabel("Brand Name");
		lblNewLabel_1_2.setBounds(12, 37, 144, 15);
		panel_2.add(lblNewLabel_1_2);
		lblNewLabel_1_2.setForeground(Color.WHITE);
		
		brandName = new JTextField();
		brandName.setBounds(158, 31, 155, 28);
		panel_2.add(brandName);
		brandName.setColumns(10);
		
		JLabel lblNewLabel_1_4 = new JLabel("Unit Price");
		lblNewLabel_1_4.setBounds(12, 119, 144, 15);
		panel_2.add(lblNewLabel_1_4);
		lblNewLabel_1_4.setForeground(Color.WHITE);
		
		unitPrice = new JTextField();
		unitPrice.setBounds(158, 113, 155, 28);
		panel_2.add(unitPrice);
		unitPrice.setColumns(10);
		
		JLabel lblNewLabel_1_5 = new JLabel("No. of Units");
		lblNewLabel_1_5.setBounds(12, 159, 144, 15);
		panel_2.add(lblNewLabel_1_5);
		lblNewLabel_1_5.setForeground(Color.WHITE);
		
		noOfUnits = new JTextField();
		noOfUnits.setBounds(158, 153, 155, 28);
		panel_2.add(noOfUnits);
		noOfUnits.setColumns(10);
		
		JLabel lblNewLabel_1_1 = new JLabel("Product Name");
		lblNewLabel_1_1.setBounds(12, 79, 144, 15);
		panel_2.add(lblNewLabel_1_1);
		lblNewLabel_1_1.setForeground(Color.WHITE);
		
		productName = new JTextField();
		productName.setBounds(158, 73, 155, 28);
		panel_2.add(productName);
		productName.setColumns(10);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(88, 96, 108));
		panel_1.setBounds(356, 559, 733, 220);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JButton newBillBtn = new JButton("New Bill");
		newBillBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DefaultTableModel model = (DefaultTableModel)saleEntriesTable.getModel();
				model.setRowCount(0);
				productName.setText("");
	            unitPrice.setText("");
	            brandName.setText("");
	            noOfUnits.setText("");
	            custName.setText("");
	            custContact.setText("");
	            custAdd.setText("");
	            brandName.requestFocus();
	            subTotalPrice.setText("");
	            totalPriceLabel.setText("");
	            afterDiscount.setText("0");
	            afterTax.setText("0");
	            finalAfterDiscount.setText("");
	            finalAfterTax.setText("");
	            custName.requestFocus();
	            invoiceid();
			}
		});
		newBillBtn.setBackground(new Color(238, 238, 238));
		newBillBtn.setBounds(12, 183, 84, 25);
		panel_1.add(newBillBtn);
		
		JButton btnPrintBill = new JButton("Print Bill");
		btnPrintBill.setBackground(new Color(238, 238, 238));
		btnPrintBill.setBounds(108, 183, 93, 25);
		panel_1.add(btnPrintBill);
		
		JLabel lblNewLabel_2 = new JLabel("Sub Total Price");
		lblNewLabel_2.setFont(new Font("Dialog", Font.BOLD, 14));
		lblNewLabel_2.setForeground(new Color(238, 238, 238));
		lblNewLabel_2.setBackground(new Color(238, 238, 238));
		lblNewLabel_2.setBounds(392, 22, 115, 15);
		panel_1.add(lblNewLabel_2);
		
		JLabel lblNewLabel_2_1 = new JLabel("Total Price");
		lblNewLabel_2_1.setForeground(SystemColor.window);
		lblNewLabel_2_1.setFont(new Font("Dialog", Font.BOLD, 14));
		lblNewLabel_2_1.setBackground(SystemColor.window);
		lblNewLabel_2_1.setBounds(423, 163, 84, 15);
		panel_1.add(lblNewLabel_2_1);
		
		JLabel lblNewLabel_2_2 = new JLabel("Discount");
		lblNewLabel_2_2.setForeground(SystemColor.window);
		lblNewLabel_2_2.setFont(new Font("Dialog", Font.BOLD, 14));
		lblNewLabel_2_2.setBackground(SystemColor.window);
		lblNewLabel_2_2.setBounds(392, 70, 69, 15);
		panel_1.add(lblNewLabel_2_2);
		
		JLabel lblNewLabel_2_3 = new JLabel("TAX");
		lblNewLabel_2_3.setForeground(SystemColor.window);
		lblNewLabel_2_3.setFont(new Font("Dialog", Font.BOLD, 14));
		lblNewLabel_2_3.setBackground(SystemColor.window);
		lblNewLabel_2_3.setBounds(422, 116, 39, 15);
		panel_1.add(lblNewLabel_2_3);
		
		JLabel percentText1 = new JLabel("%");
		percentText1.setForeground(SystemColor.window);
		percentText1.setFont(new Font("Dialog", Font.BOLD, 14));
		percentText1.setBackground(SystemColor.window);
		percentText1.setBounds(517, 70, 18, 15);
		panel_1.add(percentText1);
		
		JLabel precentText2 = new JLabel("%");
		precentText2.setForeground(SystemColor.window);
		precentText2.setFont(new Font("Dialog", Font.BOLD, 14));
		precentText2.setBackground(SystemColor.window);
		precentText2.setBounds(517, 116, 18, 15);
		panel_1.add(precentText2);
		
		JPanel calcPanel1 = new JPanel();
		calcPanel1.setBackground(new Color(157, 162, 181));
		calcPanel1.setBounds(525, 12, 196, 35);
		panel_1.add(calcPanel1);
		calcPanel1.setLayout(null);
		
		subTotalPrice = new JLabel("0");
		subTotalPrice.setForeground(new Color(255, 255, 255));
		subTotalPrice.setFont(new Font("Dialog", Font.BOLD, 16));
		subTotalPrice.setBounds(12, 12, 127, 15);
		calcPanel1.add(subTotalPrice);
		
		JPanel calcPanel2 = new JPanel();
		calcPanel2.setBackground(new Color(157, 162, 181));
		calcPanel2.setBounds(550, 59, 171, 35);
		panel_1.add(calcPanel2);
		calcPanel2.setLayout(null);
		
		finalAfterDiscount = new JLabel("0");
		finalAfterDiscount.setForeground(Color.WHITE);
		finalAfterDiscount.setFont(new Font("Dialog", Font.BOLD, 16));
		finalAfterDiscount.setBounds(12, 12, 127, 15);
		calcPanel2.add(finalAfterDiscount);
		
		JPanel calcPanel3 = new JPanel();
		calcPanel3.setBackground(new Color(157, 162, 181));
		calcPanel3.setBounds(548, 106, 173, 35);
		panel_1.add(calcPanel3);
		calcPanel3.setLayout(null);
		
		finalAfterTax = new JLabel("0");
		finalAfterTax.setForeground(Color.WHITE);
		finalAfterTax.setFont(new Font("Dialog", Font.BOLD, 16));
		finalAfterTax.setBounds(12, 12, 127, 15);
		calcPanel3.add(finalAfterTax);
		
		JPanel calcPanel4 = new JPanel();
		calcPanel4.setBackground(new Color(157, 162, 181));
		calcPanel4.setBounds(525, 153, 196, 35);
		panel_1.add(calcPanel4);
		calcPanel4.setLayout(null);
		
		totalPriceLabel = new JLabel("0");
		totalPriceLabel.setForeground(Color.WHITE);
		totalPriceLabel.setFont(new Font("Dialog", Font.BOLD, 16));
		totalPriceLabel.setBounds(12, 12, 127, 15);
		calcPanel4.add(totalPriceLabel);
		
		afterDiscount = new JTextField();
		afterDiscount.setAlignmentX(Component.RIGHT_ALIGNMENT);
		afterDiscount.setText("0");
		afterDiscount.setBounds(460, 61, 39, 35);
		panel_1.add(afterDiscount);
		afterDiscount.setColumns(10);
		
		afterTax = new JTextField();
		afterTax.setText("0");
		afterTax.setBounds(460, 107, 39, 35);
		panel_1.add(afterTax);
		afterTax.setColumns(10);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(354, 35, 735, 508);
		contentPane.add(scrollPane);
		
		saleEntriesTable = new JTable() {
			public Component prepareRenderer(TableCellRenderer renderer, int row, int column) {
				  Component returnComp = super.prepareRenderer(renderer, row, column);
				  Color alternateColor = new Color(242,242,242);
				  Color whiteColor = Color.WHITE;
				  if (!returnComp.getBackground().equals(getSelectionBackground())){
				  Color bg = (row % 2 == 0 ? alternateColor : whiteColor);
				  returnComp .setBackground(bg);
				  bg = null;
				}
				  return returnComp;
			}
		};
		
		scrollPane.setViewportView(saleEntriesTable);
		
		saleEntriesTable.setModel(new DefaultTableModel(
			new Object[][] {},
			new String[] {
				"Product Name", "Unit Price", "Unit(s)", "Total Price"
			}
		) {
			Class[] columnTypes = new Class[] {
				String.class, Double.class, Integer.class, Double.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		
		timeLabel = new JLabel("12:07:11 PM");
		timeLabel.setForeground(new Color(238, 238, 238));
		timeLabel.setBounds(904, 12, 88, 15);
		contentPane.add(timeLabel);
		
		dateLabel = new JLabel("20 April, 2023");
		dateLabel.setForeground(SystemColor.window);
		dateLabel.setBounds(993, 12, 96, 15);
		contentPane.add(dateLabel);
		
		times();
		dt();
		Connect();
		invoiceid();
	}
	
	public void dt()
	{
		Date d = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("dd MMM, yyyy");
		String dd = sdf.format(d);
		dateLabel.setText(dd);
	}
	
	Timer t;
	SimpleDateFormat st;
	private JLabel invoiceNumber;
	private JTextField afterDiscount;
	private JTextField afterTax;
	public void times()
	{
		t = new Timer(0, new ActionListener() {
		    @Override
		    public void actionPerformed(ActionEvent e) {
		    	Date dt = new Date();
				st = new SimpleDateFormat("hh:mm:ss a");
				String tt = st.format(dt);
				timeLabel.setText(tt);
		    }
		});
		t.start();
	}
}
