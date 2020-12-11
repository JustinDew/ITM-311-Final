import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class GrowNGrow extends account{
	
	private JButton deposit;
	private JLabel message, depositMes;
	private JPanel panel;
	private JTextField field;
	private int depositNum;
	
	
	public GrowNGrow(int bal, String mes) {
		startFrame();
		setAccountName("Grow 'N Grow!");
		
	//Object instantiation
		deposit = new JButton("Deposit");
		message = new JLabel(mes, SwingConstants.CENTER);
		depositMes = new JLabel("Enter deposit amount: ");
		panel = new JPanel();
		field = new JTextField(10);
	
	//setting up components (setting location,size, and font)
		message.setBounds(0,190,500,50);
		message.setFont(new Font("Seriff",Font.BOLD,15));
		
		depositMes.setFont(new Font("Seriff", Font.PLAIN, 15));
		
		panel.setLayout(new FlowLayout());
		panel.setBounds(0,150,500,50);
		panel.add(depositMes);
		panel.add(field);
		
		
		
		deposit.setBounds(0,261,500,50);
		deposit.setFocusable(false);
		deposit.addActionListener(this);
		
	//adding all the components
		add(panel);
		add(deposit);
		add(message);
		addStuff(bal);
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		String text;
		//ensures that each account has their own numbers being stored im Main
		if(e.getSource()==deposit) {
			switch(Main.getAccount()) {
			case "Jonathan":
				if(field.getText().charAt(0) == '$' || field.getText().charAt(0) == '-') {
					text = field.getText().substring(1);
				}
				else {
					text = field.getText();
				}
				try {
					depositNum = Integer.parseInt(text);
					Main.setJonBalance(2, Main.getJonBalance(2) + depositNum);
					new PlanAhead(Main.getJonBalance(2), "Deposit Sucessful! You deposited $" + depositNum + " to your account!");
					setVisible(false);
				}
				catch(Exception i) {
					message.setText("Deposit Failed. Please input a number");
				}
				break;
			case "Sarah":
				if(field.getText().charAt(0) == '$' || field.getText().charAt(0) == '-') {
					text = field.getText().substring(1);
				}
				else {
					text = field.getText();
				}
				try {
					depositNum = Integer.parseInt(text);
					Main.setSarBalance(2, Main.getSarBalance(2) + depositNum);
					new PlanAhead(Main.getSarBalance(2), "Deposit Sucessful! You deposited $" + depositNum + " to your account!");
					setVisible(false);
				}
				catch(Exception i) {
					message.setText("Deposit Failed. Please input a number");
				}
				break;
			case "Joshua":
				if(field.getText().charAt(0) == '$' || field.getText().charAt(0) == '-') {
					text = field.getText().substring(1);
				}
				else {
					text = field.getText();
				}
				try {
					depositNum = Integer.parseInt(text);
					Main.setJosBalance(2, Main.getJosBalance(2) + depositNum);
					new PlanAhead(Main.getJosBalance(2), "Deposit Sucessful! You deposited $" + depositNum + " to your account!");
					setVisible(false);
				}
				catch(Exception i) {
					message.setText("Deposit Failed. Please input a number");
				}
				break;
			case "Elizabeth":
				if(field.getText().charAt(0) == '$' || field.getText().charAt(0) == '-') {
					text = field.getText().substring(1);
				}
				else {
					text = field.getText();
				}
				try {
					depositNum = Integer.parseInt(text);
					Main.setEliBalance(2, Main.getEliBalance(2) + depositNum);
					new PlanAhead(Main.getEliBalance(2), "Deposit Sucessful! You deposited $" + depositNum + " to your account!");
					setVisible(false);
				}
				catch(Exception i) {
					message.setText("Deposit Failed. Please input a number");
				}
				break;
			case "KPL":
				if(field.getText().charAt(0) == '$' || field.getText().charAt(0) == '-') {
					text = field.getText().substring(1);
				}
				else {
					text = field.getText();
				}
				try {
					depositNum = Integer.parseInt(text);
					Main.setKPLBalance(2, Main.getKPLBalance(2) + depositNum);
					new PlanAhead(Main.getKPLBalance(2), "Deposit Sucessful! You deposited $" + depositNum + " to your account!");
					setVisible(false);
				}
				catch(Exception i) {
					message.setText("Deposit Failed. Please input a number");
				}
				break;
			}
			
		}
		
		//takes you back to menus for each account
		if(e.getSource()==getBackBtn()) {
			setVisible(false);
			switch(Main.getAccount()) {
			case "Jonathan":
				new Jonathan();
				break;
			case "Sarah":
				new Sarah();
				break;
			case "Joshua":
				new Joshua();
				break;
			case "Elizabeth":
				new Elizabeth();
				break;
			case "KPL":
				new KPL();
				break;
			}
		}
	}
}
