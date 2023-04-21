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
import javax.swing.JTextPane;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Purchase extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_7;
	private JTextField textField_8;
	private JTextField textField_9;
	private JTable table;
	private JTable table_1;

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
		customerDetails.setBounds(12, 12, 322, 659);
		panel.add(customerDetails);
		customerDetails.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Vendor Name");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel.setForeground(new Color(238, 238, 238));
		lblNewLabel.setBounds(12, 12, 105, 15);
		customerDetails.add(lblNewLabel);
		
		JTextPane textPane = new JTextPane();
		textPane.setBounds(146, 12, 162, 28);
		customerDetails.add(textPane);
		
		JLabel lblCustomerName = new JLabel("Product Code");
		lblCustomerName.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblCustomerName.setForeground(SystemColor.window);
		lblCustomerName.setBounds(12, 62, 105, 15);
		customerDetails.add(lblCustomerName);
		
		JLabel lblCustomerContact = new JLabel("Intial Quantity");
		lblCustomerContact.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblCustomerContact.setForeground(SystemColor.window);
		lblCustomerContact.setBounds(12, 272, 113, 15);
		customerDetails.add(lblCustomerContact);
		
		JLabel lblCustomerAddress = new JLabel("Reorder Level");
		lblCustomerAddress.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblCustomerAddress.setForeground(SystemColor.window);
		lblCustomerAddress.setBounds(12, 320, 123, 15);
		customerDetails.add(lblCustomerAddress);
		
		textField = new JTextField();
		textField.setBounds(146, 60, 162, 28);
		customerDetails.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(146, 110, 162, 28);
		customerDetails.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setHorizontalAlignment(SwingConstants.LEFT);
		textField_2.setColumns(10);
		textField_2.setBounds(146, 162, 162, 28);
		customerDetails.add(textField_2);
		
		JLabel lblNewLabel_1 = new JLabel("Product Type");
		lblNewLabel_1.setBounds(12, 115, 147, 15);
		customerDetails.add(lblNewLabel_1);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		
		textField_3 = new JTextField();
		textField_3.setBounds(146, 210, 162, 28);
		customerDetails.add(textField_3);
		textField_3.setColumns(10);
		
		JLabel lblNewLabel_1_1 = new JLabel("Product Name");
		lblNewLabel_1_1.setBounds(12, 167, 147, 15);
		customerDetails.add(lblNewLabel_1_1);
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_1_1.setForeground(Color.WHITE);
		
		textField_4 = new JTextField();
		textField_4.setBounds(146, 267, 162, 28);
		customerDetails.add(textField_4);
		textField_4.setColumns(10);
		
		JLabel lblNewLabel_1_2 = new JLabel("Brand Name");
		lblNewLabel_1_2.setBounds(12, 215, 147, 15);
		customerDetails.add(lblNewLabel_1_2);
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_1_2.setForeground(Color.WHITE);
		
		textField_5 = new JTextField();
		textField_5.setBounds(146, 315, 162, 28);
		customerDetails.add(textField_5);
		textField_5.setColumns(10);
		
		JLabel lblNewLabel_1_4 = new JLabel("Unit Price");
		lblNewLabel_1_4.setBounds(12, 368, 147, 15);
		customerDetails.add(lblNewLabel_1_4);
		lblNewLabel_1_4.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_1_4.setForeground(Color.WHITE);
		
		textField_7 = new JTextField();
		textField_7.setBounds(146, 363, 162, 28);
		customerDetails.add(textField_7);
		textField_7.setColumns(10);
		
		JLabel lblNewLabel_1_5 = new JLabel("No. of Units");
		lblNewLabel_1_5.setBounds(12, 420, 147, 15);
		customerDetails.add(lblNewLabel_1_5);
		lblNewLabel_1_5.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_1_5.setForeground(Color.WHITE);
		
		textField_8 = new JTextField();
		textField_8.setBounds(146, 415, 162, 28);
		customerDetails.add(textField_8);
		textField_8.setColumns(10);
		
		JLabel lblNewLabel_1_6 = new JLabel("Total Price");
		lblNewLabel_1_6.setBounds(12, 458, 147, 15);
		customerDetails.add(lblNewLabel_1_6);
		lblNewLabel_1_6.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_1_6.setForeground(Color.WHITE);
		
		textField_9 = new JTextField();
		textField_9.setBounds(146, 453, 162, 28);
		customerDetails.add(textField_9);
		textField_9.setColumns(10);
		
		JButton clearBtn = new JButton("Clear");
		clearBtn.setBounds(25, 569, 110, 36);
		customerDetails.add(clearBtn);
		clearBtn.setBackground(new Color(238, 238, 238));
		
		JButton btnAddProduct = new JButton("Order");
		btnAddProduct.setBounds(156, 569, 131, 36);
		customerDetails.add(btnAddProduct);
		btnAddProduct.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnAddProduct.setBackground(new Color(255, 217, 102));
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(88, 96, 108));
		panel_1.setBounds(356, 559, 733, 220);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JButton btnNewButton = new JButton("New Bill");
		btnNewButton.setBackground(new Color(238, 238, 238));
		btnNewButton.setBounds(12, 183, 84, 25);
		panel_1.add(btnNewButton);
		
		JButton btnSaveBill = new JButton("Save Bill");
		btnSaveBill.setBackground(new Color(238, 238, 238));
		btnSaveBill.setBounds(108, 183, 86, 25);
		panel_1.add(btnSaveBill);
		
		JButton btnPrintBill = new JButton("Print Bill");
		btnPrintBill.setBackground(new Color(238, 238, 238));
		btnPrintBill.setBounds(206, 183, 93, 25);
		panel_1.add(btnPrintBill);
		
		JLabel lblNewLabel_2 = new JLabel("Sub Total Price");
		lblNewLabel_2.setFont(new Font("Dialog", Font.BOLD, 14));
		lblNewLabel_2.setForeground(new Color(238, 238, 238));
		lblNewLabel_2.setBackground(new Color(238, 238, 238));
		lblNewLabel_2.setBounds(392, 22, 115, 15);
		panel_1.add(lblNewLabel_2);
		
		JTextPane textPane_1 = new JTextPane();
		textPane_1.setBackground(new Color(155, 162, 183));
		textPane_1.setBounds(507, 12, 214, 35);
		panel_1.add(textPane_1);
		
		JTextPane textPane_2 = new JTextPane();
		textPane_2.setBounds(468, 59, 39, 35);
		panel_1.add(textPane_2);
		
		JTextPane textPane_2_1 = new JTextPane();
		textPane_2_1.setBounds(468, 106, 39, 35);
		panel_1.add(textPane_2_1);
		
		JLabel lblNewLabel_2_1 = new JLabel("Total Price");
		lblNewLabel_2_1.setForeground(SystemColor.window);
		lblNewLabel_2_1.setFont(new Font("Dialog", Font.BOLD, 14));
		lblNewLabel_2_1.setBackground(SystemColor.window);
		lblNewLabel_2_1.setBounds(423, 163, 84, 15);
		panel_1.add(lblNewLabel_2_1);
		
		JTextPane textPane_1_1 = new JTextPane();
		textPane_1_1.setBackground(new Color(155, 162, 183));
		textPane_1_1.setBounds(507, 153, 214, 35);
		panel_1.add(textPane_1_1);
		
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
		
		JTextPane textPane_2_2 = new JTextPane();
		textPane_2_2.setBackground(new Color(155, 162, 183));
		textPane_2_2.setBounds(548, 59, 173, 35);
		panel_1.add(textPane_2_2);
		
		JTextPane textPane_2_2_1 = new JTextPane();
		textPane_2_2_1.setBackground(new Color(155, 162, 183));
		textPane_2_2_1.setBounds(548, 106, 173, 35);
		panel_1.add(textPane_2_2_1);
		
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
		
		table_1 = new JTable();
		table_1.setModel(new DefaultTableModel(
			new Object[][] {
				{"Product 1", "Code 1", 2, 2.3, "Mridul Private Limited"},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
			},
			new String[] {
				"Product Name", "Product Code", "Quantity", "Unit Price", "Vendor Name"
			}
		) {
			Class[] columnTypes = new Class[] {
				String.class, String.class, Integer.class, Double.class, String.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		table_1.setBounds(354, 35, 735, 508);
		contentPane.add(table_1);
		

	}
}