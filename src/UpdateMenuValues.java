import java.awt.*;
import java.awt.event.*;
import java.util.Vector;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class UpdateMenuValues extends JFrame implements ActionListener {
	
	private static final long serialVersionUID = 1L;

	JLabel idLabel = new JLabel("ID: ");
	JTextField idInput = new JTextField();
	
	JLabel priceLabel = new JLabel("Price: ");
	JTextField priceInput = new JTextField();
	
	JLabel stockLabel = new JLabel("Stock: ");
	JTextField stockInput = new JTextField();
	
	JButton submitBtn = new JButton("Submit");
	JButton cancelBtn = new JButton ("Cancel");
	
	
	public UpdateMenuValues() {
		ViewMenu();
	}
	
	private void ViewMenu() {
		setTitle("PT Pudding");
		setSize(800, 600);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLayout(new BorderLayout());
		setResizable(false);
		setLocation(450,150);
		setVisible(true);
		
		createMenuTitle();
		createInputs();
	}

	private void createMenuTitle() {
		JLabel menuTitle = new JLabel("PT Pudding");
		menuTitle.setHorizontalAlignment(JLabel.CENTER);
		add(menuTitle, BorderLayout.NORTH);
	}
	
	public void setId(String id) {
		idInput.setText(id);
	}
	
	private void createInputs() {
		JPanel insertInput = new JPanel();
		insertInput.setLayout(new GridLayout(4,2));
		
		idInput.setEditable(false);
		
		insertInput.add(idLabel);
		insertInput.add(idInput);
		
		insertInput.add(priceLabel);
		insertInput.add(priceInput);
		
		insertInput.add(stockLabel);
		insertInput.add(stockInput);
		
		insertInput.add(cancelBtn);
		insertInput.add(submitBtn);
		
		add(insertInput);
		
		cancelBtn.addActionListener(this);
		submitBtn.addActionListener(this);
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource().equals(submitBtn)) {
			DatabaseController controller = new DatabaseController();
			controller.updateMenu(idInput.getText(), priceInput.getText(), stockInput.getText());
			setVisible(false);
			new MainMenu();
		}
		else if(e.getSource().equals(cancelBtn)){
			new MainMenu();
			setVisible(false);
		}
		
	}
	
	
}
