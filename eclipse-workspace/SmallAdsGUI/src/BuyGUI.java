import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

public class BuyGUI {

	private JFrame frmBidbuy;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BuyGUI window = new BuyGUI();
					window.frmBidbuy.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public BuyGUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmBidbuy = new JFrame();
		frmBidbuy.setTitle("Bid/Buy");
		frmBidbuy.setBounds(100, 100, 261, 124);
		frmBidbuy.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		frmBidbuy.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JLabel lblEnterYourBidbuy = new JLabel("Enter your bid/buy price:");
		lblEnterYourBidbuy.setBounds(10, 25, 129, 14);
		panel.add(lblEnterYourBidbuy);
		
		textField = new JTextField();
		textField.setBounds(149, 22, 86, 20);
		panel.add(textField);
		textField.setColumns(10);
		
		JButton btnBidbuy = new JButton("Bid/Buy");
		btnBidbuy.setBounds(80, 53, 89, 23);
		panel.add(btnBidbuy);
	}
}
