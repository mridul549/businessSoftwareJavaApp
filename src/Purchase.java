import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.SystemColor;
import javax.swing.border.LineBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextPane;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.awt.event.ActionEvent;

public class Purchase extends JFrame {

	private JPanel contentPane;
	private JTextField productName;
	private JTextField brandName;
	private JTextField unitPrice;
	private JTextField noOfUnits;
	private JTextField vendorName;
	private JTextField afterDiscount;
	private JTextField afterTax;
	private JLabel subTotalPrice;
	private JLabel finalAfterDiscount;
	private JLabel finalAfterTax;
	private JLabel totalPriceLabel;
	private JTable purchaseTable;

	Double totalPrice=0.0;
	Connection con;
	PreparedStatement pst;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Purchase frame = new Purchase();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

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
	
	public Purchase() {
		setBackground(new Color(34, 40, 48));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1920, 1080);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(56, 62, 70));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(77, 170, 179));
		panel.setBounds(0, 0, 344, 823);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JPanel customerDetails = new JPanel();
		customerDetails.setBorder(new LineBorder(new Color(238, 238, 238), 1, true));
		customerDetails.setBackground(new Color(77, 170, 179));
		customerDetails.setBounds(16, 77, 322, 221);
		panel.add(customerDetails);
		customerDetails.setLayout(null);
		
		vendorName = new JTextField();
		vendorName.setBounds(146, 10, 162, 28);
		customerDetails.add(vendorName);
		vendorName.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Vendor Name");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel.setForeground(new Color(238, 238, 238));
		lblNewLabel.setBounds(12, 12, 105, 15);
		customerDetails.add(lblNewLabel);
		
		productName = new JTextField();
		productName.setHorizontalAlignment(SwingConstants.LEFT);
		productName.setColumns(10);
		productName.setBounds(146, 52, 162, 28);
		customerDetails.add(productName);
		
		brandName = new JTextField();
		brandName.setBounds(146, 92, 162, 28);
		customerDetails.add(brandName);
		brandName.setColumns(10);
		
		JLabel lblNewLabel_1_1 = new JLabel("Product Name");
		lblNewLabel_1_1.setBounds(12, 57, 147, 15);
		customerDetails.add(lblNewLabel_1_1);
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_1_1.setForeground(Color.WHITE);
		
		JLabel lblNewLabel_1_2 = new JLabel("Brand Name");
		lblNewLabel_1_2.setBounds(12, 97, 147, 15);
		customerDetails.add(lblNewLabel_1_2);
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_1_2.setForeground(Color.WHITE);
		
		JLabel lblNewLabel_1_4 = new JLabel("Unit Price");
		lblNewLabel_1_4.setBounds(12, 137, 147, 15);
		customerDetails.add(lblNewLabel_1_4);
		lblNewLabel_1_4.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_1_4.setForeground(Color.WHITE);
		
		unitPrice = new JTextField();
		unitPrice.setBounds(146, 132, 162, 28);
		customerDetails.add(unitPrice);
		unitPrice.setColumns(10);
		
		JLabel lblNewLabel_1_5 = new JLabel("No. of Units");
		lblNewLabel_1_5.setBounds(12, 177, 147, 15);
		customerDetails.add(lblNewLabel_1_5);
		lblNewLabel_1_5.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_1_5.setForeground(Color.WHITE);
		
		noOfUnits = new JTextField();
		noOfUnits.setBounds(146, 172, 162, 28);
		customerDetails.add(noOfUnits);
		noOfUnits.setColumns(10);
		
		JButton clearBtn = new JButton("Clear");
		clearBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				productName.setText("");
	            unitPrice.setText("");
	            brandName.setText("");
	            noOfUnits.setText("");
	            vendorName.requestFocus();
	            vendorName.setText("");
			}
		});
		clearBtn.setBounds(29, 696, 110, 36);
		panel.add(clearBtn);
		clearBtn.setBackground(new Color(238, 238, 238));
		
		JButton btnAddProduct = new JButton("Order");
		btnAddProduct.setBounds(176, 696, 131, 36);
		panel.add(btnAddProduct);
		btnAddProduct.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String vname = vendorName.getText();
				String bname = brandName.getText();
				String pname = productName.getText();
				String nou = noOfUnits.getText();
				String uprice = unitPrice.getText();
				
				try {
		            pst = con.prepareStatement("insert into purchase values(?,?,?,?,?)");
		            pst.setString(1,vname);
		            pst.setString(2,bname);
		            pst.setString(3,pname);
		            pst.setString(4,nou);
		            pst.setString(5,uprice);
		            
		            pst.executeUpdate();
		            Double currPrice=Double.parseDouble(nou)*Double.parseDouble(uprice);
		            totalPrice += Double.parseDouble(nou)*Double.parseDouble(uprice);

		            if(bname=="" || pname=="" || uprice=="" || nou=="") {
		            	JOptionPane.showMessageDialog(btnAddProduct, "Please Enter all data");
		            } else {
		            	Object values[] = {pname, Double.parseDouble(uprice), Integer.parseInt(nou), currPrice};
		            	DefaultTableModel tbModel = (DefaultTableModel)purchaseTable.getModel();
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
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(88, 96, 108));
		panel_1.setBounds(356, 559, 733, 220);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JButton btnNewButton = new JButton("New Bill");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DefaultTableModel model = (DefaultTableModel)purchaseTable.getModel();
				model.setRowCount(0);
				vendorName.setText("");
				productName.setText("");
	            unitPrice.setText("");
	            brandName.setText("");
	            noOfUnits.setText("");
	            vendorName.requestFocus();
	            subTotalPrice.setText("");
	            totalPriceLabel.setText("");
	            afterDiscount.setText("0");
	            afterTax.setText("0");
	            finalAfterDiscount.setText("");
	            finalAfterTax.setText("");
			}
		});
		btnNewButton.setBackground(new Color(238, 238, 238));
		btnNewButton.setBounds(12, 183, 84, 25);
		panel_1.add(btnNewButton);
		
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
		
		JLabel lblNewLabel_2_3_1 = new JLabel("%");
		lblNewLabel_2_3_1.setForeground(SystemColor.window);
		lblNewLabel_2_3_1.setFont(new Font("Dialog", Font.BOLD, 14));
		lblNewLabel_2_3_1.setBackground(SystemColor.window);
		lblNewLabel_2_3_1.setBounds(517, 70, 18, 15);
		panel_1.add(lblNewLabel_2_3_1);
		
		JLabel lblNewLabel_2_3_2 = new JLabel("%");
		lblNewLabel_2_3_2.setForeground(SystemColor.window);
		lblNewLabel_2_3_2.setFont(new Font("Dialog", Font.BOLD, 14));
		lblNewLabel_2_3_2.setBackground(SystemColor.window);
		lblNewLabel_2_3_2.setBounds(517, 116, 18, 15);
		panel_1.add(lblNewLabel_2_3_2);
		
		JPanel calcPanel1 = new JPanel();
		calcPanel1.setLayout(null);
		calcPanel1.setBackground(new Color(157, 162, 181));
		calcPanel1.setBounds(525, 12, 196, 35);
		panel_1.add(calcPanel1);
		
		subTotalPrice = new JLabel("0");
		subTotalPrice.setForeground(Color.WHITE);
		subTotalPrice.setFont(new Font("Dialog", Font.BOLD, 16));
		subTotalPrice.setBounds(12, 12, 127, 15);
		calcPanel1.add(subTotalPrice);
		
		JPanel calcPanel2 = new JPanel();
		calcPanel2.setLayout(null);
		calcPanel2.setBackground(new Color(157, 162, 181));
		calcPanel2.setBounds(550, 59, 171, 35);
		panel_1.add(calcPanel2);
		
		finalAfterDiscount = new JLabel("0");
		finalAfterDiscount.setForeground(Color.WHITE);
		finalAfterDiscount.setFont(new Font("Dialog", Font.BOLD, 16));
		finalAfterDiscount.setBounds(12, 12, 127, 15);
		calcPanel2.add(finalAfterDiscount);
		
		JPanel calcPanel3 = new JPanel();
		calcPanel3.setLayout(null);
		calcPanel3.setBackground(new Color(157, 162, 181));
		calcPanel3.setBounds(548, 106, 173, 35);
		panel_1.add(calcPanel3);
		
		finalAfterTax = new JLabel("0");
		finalAfterTax.setForeground(Color.WHITE);
		finalAfterTax.setFont(new Font("Dialog", Font.BOLD, 16));
		finalAfterTax.setBounds(12, 12, 127, 15);
		calcPanel3.add(finalAfterTax);
		
		JPanel calcPanel1_1 = new JPanel();
		calcPanel1_1.setLayout(null);
		calcPanel1_1.setBackground(new Color(157, 162, 181));
		calcPanel1_1.setBounds(525, 153, 196, 35);
		panel_1.add(calcPanel1_1);
		
		totalPriceLabel = new JLabel("0");
		totalPriceLabel.setForeground(Color.WHITE);
		totalPriceLabel.setFont(new Font("Dialog", Font.BOLD, 16));
		totalPriceLabel.setBounds(12, 12, 127, 15);
		calcPanel1_1.add(totalPriceLabel);
		
		afterDiscount = new JTextField();
		afterDiscount.setText("0");
		afterDiscount.setColumns(10);
		afterDiscount.setAlignmentX(1.0f);
		afterDiscount.setBounds(468, 61, 39, 35);
		panel_1.add(afterDiscount);
		
		afterTax = new JTextField();
		afterTax.setText("0");
		afterTax.setColumns(10);
		afterTax.setBounds(468, 106, 39, 35);
		panel_1.add(afterTax);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(354, 35, 735, 508);
		contentPane.add(scrollPane);
		
		purchaseTable = new JTable();
		scrollPane.setViewportView(purchaseTable);
		purchaseTable.setModel(new DefaultTableModel(
			new Object[][] {
				
			},
			new String[] {
					"Vendor Name", "Product Name", "Unit Price", "Unit(s)", "Total Price"
			}
		) {
			Class[] columnTypes = new Class[] {
				String.class, String.class, Double.class, Integer.class, Double.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		Connect();

	}
}