
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class ViewMenu extends JFrame implements ActionListener{
	
	private static final long serialVersionUID = 1L;
	
	JButton backBtn = new JButton("Back");
	
	public ViewMenu() {
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
		btnPanel.setLayout(new GridLayout(1,1));
		btnPanel.add(backBtn);
		add(btnPanel, BorderLayout.SOUTH);
		backBtn.addActionListener(this);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource().equals(backBtn)) {
			new MainMenu();
			setVisible(false);
		}
		
	}
}
