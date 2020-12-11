import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class SpendIt extends account implements ActionListener{
	
	private JRadioButton d10, d15, d25, d50, d100, custom;
	private JPanel panel;
	private int spend = 0;
	private int customValue = 0;
	private ButtonGroup group;
	private JTextField customtxt;
	private JLabel message;
	private JButton spendBtn;
	boolean customPress = false, btnPress = false;;
	
	public SpendIt(int bal, String mes) {
		
		setAccountName("Spend It!");
		startFrame();
		
	//Object instantiation
		panel = new JPanel();
		d10 = new JRadioButton("$10");
		d15 = new JRadioButton("$15");
		d25 = new JRadioButton("$25");
		d50 = new JRadioButton("$50");
		d100 = new JRadioButton("$100");
		custom = new JRadioButton("Custom");
		group = new ButtonGroup();
		customtxt = new JTextField(5);
		message = new JLabel(mes, SwingConstants.CENTER);
		spendBtn = new JButton("Spend");
		
	//component setup
		d10.setFocusable(false);
		d10.addActionListener(this);
		
		d15.setFocusable(false);
		d15.addActionListener(this);
		
		d25.setFocusable(false);
		d25.addActionListener(this);
		
		d50.setFocusable(false);
		d50.addActionListener(this);
		
		d100.setFocusable(false);
		d100.addActionListener(this);
		
		custom.setFocusable(false);
		custom.addActionListener(this);
		
		message.setBounds(0,180,500,50);
		message.setFont(new Font("Seriff",Font.BOLD,15));
	
		spendBtn.setBounds(0,261,500,50);
		spendBtn.setFocusable(false);
		spendBtn.addActionListener(this);
		
		panel.setBounds(0,125,500,36);
		panel.setLayout(new FlowLayout());
		
		///adds components
		panel.add(d10);
		panel.add(d15);
		panel.add(d25);
		panel.add(d50);
		panel.add(d100);
		panel.add(custom);
		panel.add(customtxt);
		
		group.add(d10);
		group.add(d15);
		group.add(d25);
		group.add(d50);
		group.add(d100);
		group.add(custom);
		
		add(panel);
		add(message);
		add(spendBtn);
		addStuff(bal);
	
	}

//gets the custom radiobutton working for each account
	private void switchCustomBtn() {
		String text = "";
		switch(Main.getAccount()) {
		case "Jonathan":
			if(btnPress && Main.getJonBalance(0) > 0) {
				if(customPress) {
					if(customtxt.getText().charAt(0) == '$' || customtxt.getText().charAt(0) == '-') {
						text = customtxt.getText().substring(1);
					}
					else
					{
						text = customtxt.getText();
					}
					try{
						customValue = Integer.parseInt(text);
						spend = customValue;
						if(spend > Main.getJonBalance(0)) {
							spend = Main.getJonBalance(0);
							System.out.println("this is spend " + spend);
						}
						Main.setJonBalance(0, Main.getJonBalance(0) - spend);
						new SpendIt(Main.getJonBalance(0), "Transaction Sucessful! You spent $" + spend);
						setVisible(false);
					}
					catch(Exception i) {
						spend = 0;
						System.out.println("rrr");
						message.setText("Transaction Failed. Please input a number.");
					}
				}
				else {
					if(spend > Main.getJonBalance(0)) {
						spend = Main.getJonBalance(0);
					}
					Main.setJonBalance(0, Main.getJonBalance(0) - spend);
					new SpendIt(Main.getJonBalance(0), "Transaction Sucessful! You spent $" + spend);
					setVisible(false);
				}
				System.out.println(customPress);
				System.out.println(Main.getJonBalance(0));
			}
			else if(Main.getJonBalance(0) == 0) {
				message.setText("Transaction Failed. Not enough funds");
			}
			else {
				message.setText("Please choose and option");
			}
			break;
		case "Sarah":
			if(btnPress && Main.getSarBalance(0) > 0) {
				if(customPress) {
					if(customtxt.getText().charAt(0) == '$' || customtxt.getText().charAt(0) == '-') {
						text = customtxt.getText().substring(1);
					}
					else
					{
						text = customtxt.getText();
					}
					try{
						customValue = Integer.parseInt(text);
						spend = customValue;
						if(spend > Main.getSarBalance(0)) {
							spend = Main.getSarBalance(0);
							System.out.println("this is spend " + spend);
						}
						Main.setSarBalance(0, Main.getSarBalance(0) - spend);
						new SpendIt(Main.getSarBalance(0), "Transaction Sucessful! You spent $" + spend);
						setVisible(false);
					}
					catch(Exception i) {
						spend = 0;
						System.out.println("rrr");
						message.setText("Transaction Failed. Please input a number.");
					}
				}
				else {
					if(spend > Main.getSarBalance(0)) {
						spend = Main.getSarBalance(0);
					}
					Main.setSarBalance(0, Main.getSarBalance(0) - spend);
					new SpendIt(Main.getSarBalance(0), "Transaction Sucessful! You spent $" + spend);
					setVisible(false);
				}
				System.out.println(customPress);
				System.out.println(Main.getSarBalance(0));
			}
			else if(Main.getSarBalance(0) == 0) {
				message.setText("Transaction Failed. Not enough funds");
			}
			else {
				message.setText("Please choose and option");
			}
			break;
		case "Joshua":
			if(btnPress && Main.getJosBalance(0) > 0) {
				if(customPress) {
					if(customtxt.getText().charAt(0) == '$' || customtxt.getText().charAt(0) == '-') {
						text = customtxt.getText().substring(1);
					}
					else
					{
						text = customtxt.getText();
					}
					try{
						customValue = Integer.parseInt(text);
						spend = customValue;
						if(spend > Main.getJosBalance(0)) {
							spend = Main.getJosBalance(0);
							System.out.println("this is spend " + spend);
						}
						Main.setJosBalance(0, Main.getJosBalance(0) - spend);
						new SpendIt(Main.getJosBalance(0), "Transaction Sucessful! You spent $" + spend);
						setVisible(false);
					}
					catch(Exception i) {
						spend = 0;
						System.out.println("rrr");
						message.setText("Transaction Failed. Please input a number.");
					}
				}
				else {
					if(spend > Main.getJosBalance(0)) {
						spend = Main.getJosBalance(0);
					}
					Main.setJosBalance(0, Main.getJosBalance(0) - spend);
					new SpendIt(Main.getJosBalance(0), "Transaction Sucessful! You spent $" + spend);
					setVisible(false);
				}
				System.out.println(customPress);
				System.out.println(Main.getJosBalance(0));
			}
			else if(Main.getJosBalance(0) == 0) {
				message.setText("Transaction Failed. Not enough funds");
			}
			else {
				message.setText("Please choose and option");
			}
			break;
		case "Elizabeth":
			if(btnPress && Main.getEliBalance(0) > 0) {
				if(customPress) {
					if(customtxt.getText().charAt(0) == '$' || customtxt.getText().charAt(0) == '-') {
						text = customtxt.getText().substring(1);
					}
					else
					{
						text = customtxt.getText();
					}
					try{
						customValue = Integer.parseInt(text);
						spend = customValue;
						if(spend > Main.getEliBalance(0)) {
							spend = Main.getEliBalance(0);
							System.out.println("this is spend " + spend);
						}
						Main.setEliBalance(0, Main.getEliBalance(0) - spend);
						new SpendIt(Main.getEliBalance(0), "Transaction Sucessful! You spent $" + spend);
						setVisible(false);
					}
					catch(Exception i) {
						spend = 0;
						System.out.println("rrr");
						message.setText("Transaction Failed. Please input a number.");
					}
				}
				else {
					if(spend > Main.getEliBalance(0)) {
						spend = Main.getEliBalance(0);
					}
					Main.setJonBalance(0, Main.getEliBalance(0) - spend);
					new SpendIt(Main.getEliBalance(0), "Transaction Sucessful! You spent $" + spend);
					setVisible(false);
				}
				System.out.println(customPress);
				System.out.println(Main.getEliBalance(0));
			}
			else if(Main.getEliBalance(0) == 0) {
				message.setText("Transaction Failed. Not enough funds");
			}
			else {
				message.setText("Please choose and option");
			}
			break;
		case "KPL":
			if(btnPress && Main.getKPLBalance(0) > 0) {
				if(customPress) {
					if(customtxt.getText().charAt(0) == '$' || customtxt.getText().charAt(0) == '-') {
						text = customtxt.getText().substring(1);
					}
					else
					{
						text = customtxt.getText();
					}
					try{
						customValue = Integer.parseInt(text);
						spend = customValue;
						if(spend > Main.getKPLBalance(0)) {
							spend = Main.getKPLBalance(0);
							System.out.println("this is spend " + spend);
						}
						Main.setKPLBalance(0, Main.getKPLBalance(0) - spend);
						new SpendIt(Main.getKPLBalance(0), "Transaction Sucessful! You spent $" + spend);
						setVisible(false);
					}
					catch(Exception i) {
						spend = 0;
						System.out.println("rrr");
						message.setText("Transaction Failed. Please input a number.");
					}
				}
				else {
					if(spend > Main.getKPLBalance(0)) {
						spend = Main.getKPLBalance(0);
					}
					Main.setKPLBalance(0, Main.getKPLBalance(0) - spend);
					new SpendIt(Main.getKPLBalance(0), "Transaction Sucessful! You spent $" + spend);
					setVisible(false);
				}
				System.out.println(customPress);
				System.out.println(Main.getKPLBalance(0));
			}
			else if(Main.getKPLBalance(0) == 0) {
				message.setText("Transaction Failed. Not enough funds");
			}
			else {
				message.setText("Please choose and option");
			}
			break;
		}
		
	}

	//events for spending button and each radio button
	@Override
	public void actionPerformed(ActionEvent e) {	
		if(e.getSource()==spendBtn) {
			switchCustomBtn();
		}
		if(e.getSource()==d10) {
			spend = 10;
			customPress = false;
			btnPress = true;
		}
		else if(e.getSource()==d15) {
			spend = 15;
			customPress = false;
			btnPress = true;

		}
		else if(e.getSource()==d25) {
			spend = 25;
			customPress = false;
			btnPress = true;

		}
		else if(e.getSource()==d50) {
			spend = 50;
			customPress = false;
			btnPress = true;

		}
		else if(e.getSource()==d100) {
			spend = 100;
			customPress = false;
			btnPress = true;

		}
		else if(e.getSource()==custom) {
			customPress = true;
			btnPress = true;

		}
		
		//sends you back to the correct menus
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
