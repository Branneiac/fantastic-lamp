import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.GridLayout;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;

import net.jini.core.lease.Lease;
import net.jini.space.JavaSpace;

import javax.swing.JButton;

public class AdGUI {

	private JFrame frmCreateAdvert;
	private JTextField itemTextField;
	private JTextField descrTextField;
	private JTextField fixedTextField;
	int startingID = 0;
	String name = "me";
	JavaSpace space;



	/**
	 * Create the application.
	 */
	public AdGUI() {		
		space = SpaceUtils.getSpace();
		if (space == null){
		    System.err.println("Failed to find the javaspace");
		    System.exit(1);
		}
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	public void initialize() {
		frmCreateAdvert = new JFrame();
		frmCreateAdvert.setTitle("Create Advert");
		frmCreateAdvert.setBounds(100, 100, 389, 399);
		frmCreateAdvert.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmCreateAdvert.getContentPane().setLayout(new GridLayout(1, 0, 0, 0));
		
		JPanel jPanel1 = new JPanel();
		frmCreateAdvert.getContentPane().add(jPanel1);
		jPanel1.setLayout(null);
		
		JLabel lblItem = new JLabel("Item");
		lblItem.setBounds(34, 68, 46, 14);
		jPanel1.add(lblItem);
		
		JLabel lblDescription = new JLabel("Description");
		lblDescription.setBounds(34, 101, 65, 14);
		jPanel1.add(lblDescription);
		
		itemTextField = new JTextField();
		itemTextField.setBounds(102, 65, 86, 20);
		jPanel1.add(itemTextField);
		itemTextField.setColumns(10);
		
		descrTextField = new JTextField();
		descrTextField.setBounds(102, 98, 86, 20);
		jPanel1.add(descrTextField);
		descrTextField.setColumns(10);
		
		JLabel lblFixedPrice = new JLabel("Fixed Price");
		lblFixedPrice.setBounds(34, 198, 65, 14);
		jPanel1.add(lblFixedPrice);
		
		fixedTextField = new JTextField();
		fixedTextField.setBounds(102, 195, 86, 20);
		jPanel1.add(fixedTextField);
		fixedTextField.setColumns(10);
		

		
		JButton btnCreateAdvert = new JButton("Create Advert");
		btnCreateAdvert.setBounds(207, 326, 118, 23);
		jPanel1.add(btnCreateAdvert);
		
		btnCreateAdvert.addActionListener(new java.awt.event.ActionListener () {
			public void actionPerformed (java.awt.event.ActionEvent evt) {
				System.out.println("Adding item...");
				addPricedAdvert (evt);
		            }
			}  );
			}
		
	

	
	private void addPricedAdvert(java.awt.event.ActionEvent evt) {
		try {
			JRAdvertQueue adItem = new JRAdvertQueue();

			
			int advertNumber = startingID;
			System.out.println(advertNumber + " created");
			String itemName = itemTextField.getText();
			String description = descrTextField.getText();
			Double price = Double.parseDouble(fixedTextField.getText());
			
			JRSetPriceAdvert newListing = new JRSetPriceAdvert(advertNumber, itemName, description, price, name);
			System.out.println(advertNumber + itemName + description + price);
			space.write(newListing, null, Lease.FOREVER);
			System.out.println("Posted advert " + advertNumber);
			startingID++;
		
		}
		catch ( Exception e) {
		    e.printStackTrace();
		}
}
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdGUI window = new AdGUI();
					window.frmCreateAdvert.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
