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

public class ViewSale extends JFrame {

	private JPanel contentPane;
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
	public ViewSale() {
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
		customerDetails.setBounds(12, 100, 322, 571);
		panel.add(customerDetails);
		customerDetails.setLayout(null);
		
		JButton clearBtn = new JButton("Sale Entry");
		clearBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		clearBtn.setBounds(35, 325, 239, 65);
		customerDetails.add(clearBtn);
		clearBtn.setBackground(new Color(238, 238, 238));
		
		JButton btnAddProduct = new JButton("Purchase Product");
		btnAddProduct.setBounds(35, 137, 239, 65);
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

