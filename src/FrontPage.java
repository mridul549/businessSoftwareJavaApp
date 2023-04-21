import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.SystemColor;
import javax.swing.JDesktopPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

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
		setBackground(new Color(56, 62, 70));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 647, 422);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(56, 62, 70));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		

		JButton btnNewButton = new JButton("Sale Entry");
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setBackground(new Color(0, 173, 181));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				new SalePage().setVisible(true);
			}
		});
		btnNewButton.setBounds(93, 160, 129, 44);
		contentPane.add(btnNewButton);
		
		JButton btnPurchaseEntry = new JButton("Purchase Entry");
		btnPurchaseEntry.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				new Purchase().setVisible(true);
			}
		});
		btnPurchaseEntry.setForeground(new Color(255, 255, 255));
		btnPurchaseEntry.setBackground(new Color(0, 173, 181));
		btnPurchaseEntry.setBounds(374, 160, 142, 44);
		contentPane.add(btnPurchaseEntry);
		
		JButton btnViewSales = new JButton("View Sales");
		btnViewSales.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				new ViewSale().setVisible(true);
			}
		});
		btnViewSales.setForeground(new Color(255, 255, 255));
		btnViewSales.setBackground(new Color(0, 173, 181));
		btnViewSales.setBounds(93, 259, 129, 44);
		contentPane.add(btnViewSales);
		
		JButton btnCalculator = new JButton("Calculator");
		btnCalculator.setForeground(new Color(255, 255, 255));
		btnCalculator.setBackground(new Color(0, 173, 181));
		btnCalculator.setBounds(374, 259, 142, 44);

		contentPane.add(btnCalculator);
		
		JLabel lblNewLabel = new JLabel("Visual Cat Pro");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setBackground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Helvetica", Font.PLAIN, 40));
		lblNewLabel.setBounds(180, 39, 270, 44);
		contentPane.add(lblNewLabel);
	}
}
