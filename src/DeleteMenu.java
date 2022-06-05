import java.awt.*;
import java.awt.event.*;
import java.util.Vector;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class DeleteMenu extends JFrame implements ActionListener {
	
	private static final long serialVersionUID = 1L;
	
	private JButton cancelBtn = new JButton("Cancel");
	private JButton deleteBtn = new JButton("Delete");
	
	JLabel deleteLabel = new JLabel("Input ID: ");
	JTextField deleteInput = new JTextField();
	
	JTable table;
	JButton delItemBtn;
	String id = "", name="";
	
	public DeleteMenu() {
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
		
		btnPanel.add(deleteLabel);
		btnPanel.add(deleteInput);
		btnPanel.add(cancelBtn);
		btnPanel.add(deleteBtn);
		
		cancelBtn.addActionListener(this);
		deleteBtn.addActionListener(this);
		
		add(btnPanel, BorderLayout.SOUTH);
	}


	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource().equals(deleteBtn)) {
			DatabaseController controller = new DatabaseController();
			controller.deleteMenu(deleteInput.getText());
			deleteInput.setText(null);
			setVisible(false);
			new MainMenu();
		}
		else if(e.getSource().equals(cancelBtn)) {
			new MainMenu();
			setVisible(false);
		}
		
	}

	
}
