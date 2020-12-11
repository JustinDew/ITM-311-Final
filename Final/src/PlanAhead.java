import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class PlanAhead extends account{
	
	private JButton deposit;
	private JLabel message, depositMes;
	private JPanel panel;
	private JTextField field;
	private int depositNum;
	
	
	public PlanAhead(int bal, String mes) {
		startFrame();
		setAccountName("Plan Ahead!");
		
		//object instantiation
		deposit = new JButton("Deposit");
		message = new JLabel(mes, SwingConstants.CENTER);
		depositMes = new JLabel("Enter deposit amount: ");
		panel = new JPanel();
		field = new JTextField(10);
		
		//component setup
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
		
		//adding components
		add(panel);
		add(deposit);
		add(message);
		addStuff(bal);
	}
	
	//action event for each account
	@Override
	public void actionPerformed(ActionEvent e) {
		String text;
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
					Main.setJonBalance(1, Main.getJonBalance(1) + depositNum);
					new PlanAhead(Main.getJonBalance(1), "Deposit Sucessful! You deposited $" + depositNum + " to your account!");
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
					Main.setSarBalance(1, Main.getSarBalance(1) + depositNum);
					new PlanAhead(Main.getSarBalance(1), "Deposit Sucessful! You deposited $" + depositNum + " to your account!");
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
					Main.setJosBalance(1, Main.getJosBalance(1) + depositNum);
					new PlanAhead(Main.getJosBalance(1), "Deposit Sucessful! You deposited $" + depositNum + " to your account!");
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
					Main.setEliBalance(1, Main.getEliBalance(1) + depositNum);
					new PlanAhead(Main.getEliBalance(1), "Deposit Sucessful! You deposited $" + depositNum + " to your account!");
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
					Main.setKPLBalance(1, Main.getKPLBalance(1) + depositNum);
					new PlanAhead(Main.getKPLBalance(1), "Deposit Sucessful! You deposited $" + depositNum + " to your account!");
					setVisible(false);
				}
				catch(Exception i) {
					message.setText("Deposit Failed. Please input a number");
				}
				break;
			}
			
		}
		//once again another button to send you back to the correct menus
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
