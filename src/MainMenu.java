import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MainMenu extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	
	JLabel menuTitle = new JLabel("PT Pudding");
	JButton insertBtn = new JButton("Insert Menu Baru");
	JButton viewBtn = new JButton("View Menu");
	JButton updateBtn = new JButton("Update Menu");
	JButton deleteBtn = new JButton("Delete Menu");
	
	public MainMenu() {
		ViewMenu();
	}
	
	public void ViewMenu() {
		setTitle("PT Pudding");
		setSize(800, 600);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLayout(new BorderLayout());
		setResizable(false);
		setLocation(450,150);
		setVisible(true);
		
		
		createMenuTitle();
		setMainMenu();
	}

	private void createMenuTitle() {
		JLabel menuTitle = new JLabel("PT Pudding");
		menuTitle.setHorizontalAlignment(JLabel.CENTER);
		add(menuTitle, BorderLayout.NORTH);
	}
	
	private void setMainMenu() {
		JPanel MainMenu = new JPanel();
		MainMenu.setLayout(new GridLayout(2, 1));
		
		JPanel top = new JPanel();
		top.setLayout(new GridLayout(1,2));
		top.add(insertBtn);
		top.add(viewBtn);
		
		JPanel mid = new JPanel();
		mid.setLayout(new GridLayout(1,2));
		mid.add(updateBtn);
		mid.add(deleteBtn);
		
		MainMenu.add(top);
		MainMenu.add(mid);
		
		insertBtn.addActionListener(this);
		viewBtn.addActionListener(this);
		updateBtn.addActionListener(this);
		deleteBtn.addActionListener(this);
		
		add(MainMenu);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource().equals(insertBtn)) {
			new InsertMenu();
			setVisible(false);
		}
		else if(e.getSource().equals(viewBtn)) {
			new ViewMenu();
			setVisible(false);
		}
		else if(e.getSource().equals(updateBtn)) {
			new UpdateMenu();
			setVisible(false);
		}
		else if(e.getSource().equals(deleteBtn)) {
			new DeleteMenu();
			setVisible(false);
		}
		
	}

}
