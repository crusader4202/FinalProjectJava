import java.awt.*;
import java.awt.event.*;
import java.util.Vector;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class UpdateMenu extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	
	private JButton cancelBtn = new JButton("Cancel");
	private JButton updateBtn = new JButton("Update");
	
	JLabel updateLabel = new JLabel("Input ID: ");
	JTextField updateInput = new JTextField();
	
	JTable table;
	String id = "";
	
	public UpdateMenu() {
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
		createDataView();
		createBtn();
	}
	
	private void createMenuTitle() {
		JLabel menuTitle = new JLabel("PT Pudding");
		menuTitle.setHorizontalAlignment(JLabel.CENTER);
		add(menuTitle, BorderLayout.NORTH);
	}
	
	private void createDataView() {
		DatabaseController data = new DatabaseController();
		Vector<String> columns = new Vector<>();
		
		columns.add("ID");
		columns.add("Name");
		columns.add("Price");
		columns.add("Stock");
		
		DefaultTableModel tableModel = new DefaultTableModel(data.getData(), columns) 
		{
			private static final long serialVersionUID = 1L;
			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
				}
		};
		
		JTable table = new JTable(tableModel);
		table.isCellEditable(0,0);
		JScrollPane sp = new JScrollPane(table);
		add(sp);
		
	}

	private void createBtn() {
		JPanel btnPanel = new JPanel();
		btnPanel.setLayout(new GridLayout(2,2));
		
		btnPanel.add(updateLabel);
		btnPanel.add(updateInput);
		btnPanel.add(cancelBtn);
		btnPanel.add(updateBtn);
		
		cancelBtn.addActionListener(this);
		updateBtn.addActionListener(this);
		
		add(btnPanel, BorderLayout.SOUTH);
	}

	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource().equals(updateBtn)) {
			UpdateMenuValues inputUpdate = new UpdateMenuValues();
			id = updateInput.getText();
			inputUpdate.setId(id);
			setVisible(false);
			inputUpdate.setVisible(true);
		}
		else if(e.getSource().equals(cancelBtn)){
			new Main();
			setVisible(false);
		}
		
	}
	

}