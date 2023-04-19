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

public class SalePage extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;
	private JTextField textField_9;
	private JTable table;

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
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(77, 170, 179));
		panel.setBounds(0, 0, 344, 823);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JButton clearBtn = new JButton("Clear");
		clearBtn.setBackground(new Color(238, 238, 238));
		clearBtn.setBounds(144, 754, 66, 25);
		panel.add(clearBtn);
		
		JButton btnAddProduct = new JButton("Add Product");
		btnAddProduct.setBackground(new Color(255, 217, 102));
		btnAddProduct.setBounds(222, 754, 110, 25);
		panel.add(btnAddProduct);
		
		JPanel customerDetails = new JPanel();
		customerDetails.setBorder(new LineBorder(new Color(238, 238, 238), 1, true));
		customerDetails.setBackground(new Color(77, 170, 179));
		customerDetails.setBounds(12, 12, 320, 264);
		panel.add(customerDetails);
		customerDetails.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Invoice Number");
		lblNewLabel.setForeground(new Color(238, 238, 238));
		lblNewLabel.setBounds(12, 12, 105, 15);
		customerDetails.add(lblNewLabel);
		
		JTextPane textPane = new JTextPane();
		textPane.setBounds(146, 12, 162, 28);
		customerDetails.add(textPane);
		
		JLabel lblCustomerName = new JLabel("Customer Name");
		lblCustomerName.setForeground(SystemColor.window);
		lblCustomerName.setBounds(12, 62, 105, 15);
		customerDetails.add(lblCustomerName);
		
		JLabel lblCustomerContact = new JLabel("Customer Contact");
		lblCustomerContact.setForeground(SystemColor.window);
		lblCustomerContact.setBounds(12, 112, 113, 15);
		customerDetails.add(lblCustomerContact);
		
		JLabel lblCustomerAddress = new JLabel("Customer Address");
		lblCustomerAddress.setForeground(SystemColor.window);
		lblCustomerAddress.setBounds(12, 164, 123, 15);
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
		textField_2.setBounds(146, 162, 162, 75);
		customerDetails.add(textField_2);
		
		JLabel lblNewLabel_1 = new JLabel("Product Type");
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setBounds(12, 344, 147, 15);
		panel.add(lblNewLabel_1);
		
		textField_3 = new JTextField();
		textField_3.setBounds(158, 338, 174, 28);
		panel.add(textField_3);
		textField_3.setColumns(10);
		
		JLabel lblNewLabel_1_1 = new JLabel("Product Name");
		lblNewLabel_1_1.setForeground(Color.WHITE);
		lblNewLabel_1_1.setBounds(12, 387, 147, 15);
		panel.add(lblNewLabel_1_1);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(158, 381, 174, 28);
		panel.add(textField_4);
		
		JLabel lblNewLabel_1_2 = new JLabel("Brand Name");
		lblNewLabel_1_2.setForeground(Color.WHITE);
		lblNewLabel_1_2.setBounds(12, 427, 147, 15);
		panel.add(lblNewLabel_1_2);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(158, 421, 174, 28);
		panel.add(textField_5);
		
		JLabel lblNewLabel_1_3 = new JLabel("Serial Number");
		lblNewLabel_1_3.setForeground(Color.WHITE);
		lblNewLabel_1_3.setBounds(12, 467, 147, 15);
		panel.add(lblNewLabel_1_3);
		
		textField_6 = new JTextField();
		textField_6.setColumns(10);
		textField_6.setBounds(158, 461, 174, 28);
		panel.add(textField_6);
		
		JLabel lblNewLabel_1_4 = new JLabel("Unit Price");
		lblNewLabel_1_4.setForeground(Color.WHITE);
		lblNewLabel_1_4.setBounds(12, 507, 147, 15);
		panel.add(lblNewLabel_1_4);
		
		textField_7 = new JTextField();
		textField_7.setColumns(10);
		textField_7.setBounds(158, 501, 174, 28);
		panel.add(textField_7);
		
		JLabel lblNewLabel_1_5 = new JLabel("No. of Units");
		lblNewLabel_1_5.setForeground(Color.WHITE);
		lblNewLabel_1_5.setBounds(12, 547, 147, 15);
		panel.add(lblNewLabel_1_5);
		
		textField_8 = new JTextField();
		textField_8.setColumns(10);
		textField_8.setBounds(158, 541, 174, 28);
		panel.add(textField_8);
		
		JLabel lblNewLabel_1_6 = new JLabel("Total Price");
		lblNewLabel_1_6.setForeground(Color.WHITE);
		lblNewLabel_1_6.setBounds(12, 587, 147, 15);
		panel.add(lblNewLabel_1_6);
		
		textField_9 = new JTextField();
		textField_9.setColumns(10);
		textField_9.setBounds(158, 581, 174, 28);
		panel.add(textField_9);
		
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
		
		table = new JTable();
		table.setBounds(1085, 12, -728, 535);
		
		String[] columnNames = {"Type", "Product Description", "Identification Number", "Unit Price", "No. of Units", "Total Cost"};
		
		Object[][] data = new Object[6][10];
		for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 6; j++) {
                data[i][j] = "Row " + (i + 1) + ", Column " + (j + 1);
            }
        }

		JTable table = new JTable(data, columnNames);

        // Add the table to a JScrollPane and add the JScrollPane to the frame
//        JScrollPane scrollPane = new JScrollPane(table);
//        add(scrollPane);
		
		contentPane.add(table);
		

	}
}
