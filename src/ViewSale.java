import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.Component;

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
import javax.swing.table.TableCellRenderer;

import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;

public class ViewSale extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JTable spEntries;
	private JButton purchaseEntries;
	private JButton saleEntries;
	Connection con;
	PreparedStatement pst;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ViewSale frame = new ViewSale();
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
	
	public void getSalesData()
	{
		try {
            Statement s = con.createStatement();
            ResultSet rs = s.executeQuery("SELECT invoiceid, brandName, productName, noOfUnits, unitPrice FROM sales");
            
            while(rs.next())
            {
            	String id = rs.getString(1);
            	String bname = rs.getString(2);
            	String pname = rs.getString(3);
            	String nou = rs.getString(4);
            	String uprice = rs.getString(5);
            	
            	Object values[] = {id, bname, pname, Integer.parseInt(nou), Double.parseDouble(uprice)};
            	DefaultTableModel tbModel = (DefaultTableModel)spEntries.getModel();
            	tbModel.addRow(values);
            }
            
        } catch (Exception ex) {
            ex.printStackTrace();
        }   
	}
	
	public void getPurchaseData()
	{
		try {
            Statement s = con.createStatement();
            ResultSet rs = s.executeQuery("SELECT vendorName, brandName, productName, noOfUnits, unitPrice FROM purchase");
            
            while(rs.next())
            {
            	String vname = rs.getString(1);
            	String bname = rs.getString(2);
            	String pname = rs.getString(3);
            	String nou = rs.getString(4);
            	String uprice = rs.getString(5);
            	
            	Object values[] = {vname, bname, pname, Integer.parseInt(nou), Double.parseDouble(uprice)};
            	DefaultTableModel tbModel = (DefaultTableModel)spEntries.getModel();
            	tbModel.addRow(values);
            }
            
        } catch (Exception ex) {
            ex.printStackTrace();
        }   
	}
	
	/**
	 * Create the frame.
	 */
	public ViewSale() {
		setBackground(new Color(34, 40, 48));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1100, 790);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(56, 62, 70));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(33, 149, 1034, 587);
		contentPane.add(scrollPane);
		
		spEntries = new JTable() {
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
		scrollPane.setViewportView(spEntries);
		spEntries.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Invoice No/Vendor", "Brand Name", "Product Name", "Unit(s)", "Unit Price"
			}
		) {
			Class[] columnTypes = new Class[] {
				String.class, String.class, String.class, Integer.class, Double.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 173, 181));
		panel.setBounds(0, 0, 1100, 115);
		contentPane.add(panel);
		panel.setLayout(null);
		
		saleEntries = new JButton("View Sale Entries");
		saleEntries.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				saleEntries.setBackground(new Color(255, 217, 61));
				purchaseEntries.setBackground(new Color(255, 255, 255));
				saleEntries.setForeground(new Color(255, 255, 255));
				purchaseEntries.setForeground(new Color(0, 0, 0));
				DefaultTableModel model = (DefaultTableModel)spEntries.getModel();
				model.setRowCount(0);
				getSalesData();
			}
		});
		
		saleEntries.setForeground(new Color(0, 0, 0));
		saleEntries.setBackground(new Color(255, 255, 255));
		saleEntries.setFont(new Font("Dialog", Font.BOLD, 18));
		saleEntries.setBounds(207, 27, 247, 59);
		panel.add(saleEntries);
		
		purchaseEntries = new JButton("View Purchase Entries");
		purchaseEntries.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				saleEntries.setBackground(new Color(255, 255, 255));
				purchaseEntries.setBackground(new Color(255, 217, 61));
				saleEntries.setForeground(new Color(0, 0, 0));
				purchaseEntries.setForeground(new Color(255, 255, 255));
				DefaultTableModel model = (DefaultTableModel)spEntries.getModel();
				model.setRowCount(0);
				getPurchaseData();
			}
		});
		purchaseEntries.setBackground(new Color(255, 255, 255));
		purchaseEntries.setFont(new Font("Dialog", Font.BOLD, 18));
		purchaseEntries.setBounds(598, 27, 247, 59);
		panel.add(purchaseEntries);
		
		Connect();

	}
}