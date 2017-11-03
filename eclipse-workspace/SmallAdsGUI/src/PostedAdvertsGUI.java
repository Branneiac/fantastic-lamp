import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.GridLayout;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JList;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollBar;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import net.jini.core.entry.Entry;
import net.jini.space.JavaSpace;

public class PostedAdvertsGUI implements Entry{

	JavaSpace space;
	private JFrame frmListings;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PostedAdvertsGUI window = new PostedAdvertsGUI();
					window.frmListings.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public PostedAdvertsGUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmListings = new JFrame();
		frmListings.setTitle("Listings");
		frmListings.setBounds(100, 100, 450, 300);
		frmListings.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmListings.getContentPane().setLayout(new GridLayout(1, 0, 0, 0));
		
		JPanel panel = new JPanel();
		frmListings.getContentPane().add(panel);
		panel.setLayout(null);
		
		JButton btnNewButton = new JButton("Bid/Buy");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				BuyGUI b = new BuyGUI();
				b.main(null);
				
			}
		});
		btnNewButton.setBounds(59, 206, 89, 23);
		panel.add(btnNewButton);
		
		JButton btnCreateAdvert = new JButton("Create Advert");
		btnCreateAdvert.setBounds(245, 206, 118, 23);
		panel.add(btnCreateAdvert);
		btnCreateAdvert.addActionListener(new ActionListener()
				{
					public void actionPerformed(ActionEvent arg0) {
						AdGUI a = new AdGUI();
						a.main(null);
					}
			
				});
		
		JList advertList = new JList();
		advertList.setBounds(59, 11, 304, 181);
		panel.add(advertList);
		
	}
}
