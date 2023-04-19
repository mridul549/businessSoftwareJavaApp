import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.SystemColor;
import javax.swing.JDesktopPane;

public class FrontPage extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrontPage frame = new FrontPage();
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
	public FrontPage() {
		setEnabled(false);
		setBackground(new Color(34, 40, 48));
		
		setTitle("Billing Software");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 686, 412);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(56, 62, 70));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Visual Cat Pro");
		lblNewLabel.setBackground(new Color(238, 238, 238));
		lblNewLabel.setForeground(new Color(238, 238, 238));
		lblNewLabel.setFont(new Font("Helvetica", Font.BOLD, 38));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(6, 30, 674, 58);
		contentPane.add(lblNewLabel);
		
		JButton btnSaleButton = new JButton("Sale Entry");
		btnSaleButton.setForeground(new Color(254, 255, 255));
		btnSaleButton.setBorderPainted(false);
		btnSaleButton.setFont(new Font("Helvetica", Font.PLAIN, 17));
		btnSaleButton.setBackground(new Color(0, 173, 181));
		btnSaleButton.setBounds(94, 126, 139, 50);
		contentPane.add(btnSaleButton);
		
		JButton btnPurchaseEntry = new JButton("Purchase Entry");
		btnPurchaseEntry.setForeground(SystemColor.window);
		btnPurchaseEntry.setFont(new Font("Helvetica", Font.PLAIN, 17));
		btnPurchaseEntry.setBackground(new Color(0, 173, 181));
		btnPurchaseEntry.setBounds(419, 126, 139, 50);
		contentPane.add(btnPurchaseEntry);
		
		JButton btnViewEntries = new JButton("View Entries");
		btnViewEntries.setForeground(SystemColor.window);
		btnViewEntries.setFont(new Font("Helvetica", Font.PLAIN, 17));
		btnViewEntries.setBackground(new Color(0, 173, 181));
		btnViewEntries.setBounds(94, 243, 139, 50);
		contentPane.add(btnViewEntries);
		
		JButton btnCalculator = new JButton("Calculator");
		btnCalculator.setForeground(SystemColor.window);
		btnCalculator.setFont(new Font("Helvetica", Font.PLAIN, 17));
		btnCalculator.setBackground(new Color(0, 173, 181));
		btnCalculator.setBounds(419, 243, 139, 50);
		contentPane.add(btnCalculator);
	}
}
