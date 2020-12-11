import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Menus extends JFrame implements ActionListener{

	private JPanel panel;
	private JButton spend, shortSave, longSave, transfer, logout;
	private JLabel spendTitle, planTitle, growTitle, transTitle;
	private int[] balances = new int[3];
	
	public void start(int x, int y, int z){
		balances[0] = x;
		balances[1] = y;
		balances[2] = z;
		
	//Object instantiations
		panel = new JPanel();
		spend = new JButton();
		shortSave = new JButton();
		longSave = new JButton();
		transfer = new JButton();
		logout = new JButton("Logout");
		spendTitle = new JLabel("Spend It");
		planTitle = new JLabel("Plan Ahead");
		growTitle = new JLabel("Grow N Grow");
		transTitle = new JLabel("Transfer");
				
	//sets up the JFrame
		this.setSize(800,538);
		this.setResizable(false);
		this.setLayout(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	//sets up JPanel
		panel.setSize(800,400);
		panel.setLayout(new GridLayout(1, 4));
				
		makeMenuButton(spend, balances[0]);
		spendTitle.setBounds(47,10,100,30);
		spendTitle.setFont(new Font("Seriff",Font.BOLD, 25));
				
		makeMenuButton(shortSave, balances[1]);
		planTitle.setBounds(30,10,200,30);
		planTitle.setFont(new Font("Seriff",Font.BOLD, 25));
				
		makeMenuButton(longSave, balances[2]);
		growTitle.setBounds(25,10,200,30);
		growTitle.setFont(new Font("Seriff",Font.BOLD, 25));
				
	//sets up transfer JButton
		transfer.setLayout(null);
		transTitle.setBounds(47,10,100,30);
		transTitle.setFont(new Font("Seriff",Font.BOLD, 25));
			
	//sets up logout JButton
		logout.setFont(new Font("Seriff", Font.BOLD, 30));
		logout.setFocusable(false);
		logout.setBounds(0,400,800,100);
		logout.addActionListener(this);
				
	//adds action listeners to each JButton
		spend.addActionListener(this);
		shortSave.addActionListener(this);
		longSave.addActionListener(this);
		transfer.addActionListener(this);
				
	//adds titles to JButtons
		spend.add(spendTitle);
		shortSave.add(planTitle);
		longSave.add(growTitle);
		transfer.add(transTitle);
			
	//adds JButtons to JPanel
		panel.add(spend);
		panel.add(shortSave);
		panel.add(longSave);
		panel.add(transfer);
			
	//adds JPanel and logout button to JFrame
		this.add(panel);
		this.add(logout);
		this.setVisible(true);
				
	}
	
//These three methods are for getting balances for spend it, plan ahead, and grow n grow
	public int getSpendBal() {
		return balances[0];
	}
	public int getPlanBal() {
		return balances[1];
	}
	public int getGrowBal() {
		return balances[2];
	}
	
	public JButton getLogout() {
		return logout;
	}
	public JButton getSpend() {
		return spend;
	}
	public JButton getPlan() {
		return shortSave;
	}
	public JButton getGrow() {
		return longSave;
	}
	public JButton getTrans() {
		return transfer;
	}
	
	
//These three methods are for setting balances for spend it, plan ahead, and grow n grow
	public void setSpend(int spend) {
		balances[0] = spend;
	}
	public void setPlan(int plan) {
		balances[1] = plan;
	}
	public void setGrow(int grow) {
		balances[2] = grow;
	}
	
//sets up the button to display the balance
	private static void makeMenuButton(JButton button, int num) {
		button.setText("$" + num);
		button.setFocusable(false);
		button.setFont(new Font("Seriff",Font.PLAIN, 20));
		button.setLayout(null);
	}

//does stuff when the buttons are clicked
	
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==logout) {
			new Login();
			this.setVisible(false);
		}
	}
	
}
