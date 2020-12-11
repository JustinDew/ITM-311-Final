import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class Transfer extends JFrame implements ActionListener{
	
	private JLabel accountName, desc, message;
	private JButton backBtn, transferBtn;
	private JCheckBox send;
	private JComboBox senders, receivers;
	private static String[] yourAccounts = {"Spend It!", "Plan Ahead!", "Grow 'N Grow!"};
	private JTextField field;	
	private int num = 0;
 	
	public Transfer() {
	//setting up frame.
		this.setSize(500,400);
		this.setResizable(false);
		this.setLayout(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	//Object instantiation
		accountName = new JLabel("Transfer", SwingConstants.CENTER);
		backBtn = new JButton("Back");
		transferBtn = new JButton("Transfer");
		desc = new JLabel("Transfer funds within your own accounts", SwingConstants.CENTER);
		senders = new JComboBox(yourAccounts);
		receivers = new JComboBox(yourAccounts);
		message = new JLabel("", SwingConstants.CENTER);
		field = new JTextField();
		
	//setting up components
		accountName.setBounds(0, 0, 500, 50);	
		accountName.setFont(new Font("Seriff",Font.BOLD,35));
		
		desc.setBounds(0,50,500,50);
		desc.setFont(new Font("Seriff",Font.PLAIN,12));
		
		senders.setBounds(50, 100, 110, 20);
		senders.setFocusable(false);
		
		field.setBounds(225,100,50,20);
		field.addActionListener(this);
		
		receivers.setBounds(330, 100, 110, 20);
		receivers.setFocusable(false);

		message.setBounds(0,180,500,50);
		message.setFont(new Font("Seriff",Font.PLAIN,15));
		
		transferBtn.setBounds(0,261,500,50);
		transferBtn.setFocusable(false);
		transferBtn.addActionListener(this);
		
		backBtn.setFocusable(false);
		backBtn.addActionListener(this);
		backBtn.setBounds(0,311,500,50);
		
	//adding components
		add(field);
		add(receivers);
		add(senders);
		add(desc);
		add(message);
		add(transferBtn);
		add(backBtn);
		add(accountName);
		this.setVisible(true);
	}
	
	public static String[] getYourAccounts() {
		return yourAccounts;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String text;
	//transfers the correct amount to correct account. Also deals with '$' just in case someone inputs that
		if(e.getSource()==transferBtn) {
			if(field.getText().charAt(0) == '$' || field.getText().charAt(0) == '-') {
				text = field.getText().substring(1);
			}
			else
			{
				text = field.getText();
			}
			try {
				num = Integer.parseInt(text);
				System.out.println("Yay! " + num);
			}
			catch(Exception i) {
				message.setText("Transfer Failed. Please enter a number.");
			}
			switch(Main.getAccount()) {
			case "Jonathan":
				if(senders.getSelectedItem() == receivers.getSelectedItem()) {
					message.setText("You cannot transfer money from one account to itself.");
				}
				else {
					switch(senders.getSelectedItem().toString()) {
					case "Spend It!":
						if(num > Main.getJonBalance(0)) {
							num = Main.getJonBalance(0);
						}
						else if(Main.getJonBalance(0) == 0){
							message.setText("Transfer Failed. Not enough Funds");
						}
						else {
							Main.setJonBalance(0, Main.getJonBalance(0) - num);
							message.setText("Transfer Sucessful! You transfered $" + num);
							switch(receivers.getSelectedItem().toString()) {
							case "Spend It!":
								Main.setJonBalance(0, Main.getJonBalance(0) + num);
								break;
							case "Plan Ahead!":
								Main.setJonBalance(1, Main.getJonBalance(1) + num);
								break;
							case "Grow 'N Grow!":
								Main.setJonBalance(2, Main.getJonBalance(2) + num);
								break;
							}
						}
					break;
					case "Plan Ahead!":
						if(num > Main.getJonBalance(1)) {
							num = Main.getJonBalance(1);
						}
						else if(Main.getJonBalance(1) == 0){
							message.setText("Transfer Failed. Not enough Funds");
						}
						else {
							Main.setJonBalance(1, Main.getJonBalance(1) - num);
							message.setText("Transfer Sucessful! You transfered $" + num);
							switch(receivers.getSelectedItem().toString()) {
							case "Spend It!":
								Main.setJonBalance(0, Main.getJonBalance(0) + num);
								break;
							case "Plan Ahead!":
								Main.setJonBalance(1, Main.getJonBalance(1) + num);
								break;
							case "Grow 'N Grow!":
								Main.setJonBalance(2, Main.getJonBalance(2) + num);
								break;
							}
						}
					break;
					case "Grow 'N Grow!":
						if(num > Main.getJonBalance(2)) {
							num = Main.getJonBalance(2);
						}
						else if(Main.getJonBalance(2) == 0){
							message.setText("Transfer Failed. Not enough Funds");
						}
						else {
							Main.setJonBalance(2, Main.getJonBalance(2) - num);
							message.setText("Transfer Sucessful! You transfered $" + num);
							switch(receivers.getSelectedItem().toString()) {
							case "Spend It!":
								Main.setJonBalance(0, Main.getJonBalance(0) + num);
								break;
							case "Plan Ahead!":
								Main.setJonBalance(1, Main.getJonBalance(1) + num);
								break;
							case "Grow 'N Grow!":
								Main.setJonBalance(2, Main.getJonBalance(2) + num);
								break;
							}
						}
					break;
					}
				}
			break;
			
			case "Sarah":
				if(senders.getSelectedItem() == receivers.getSelectedItem()) {
					message.setText("You cannot transfer money from one account to itself.");
				}
				else {
					switch(senders.getSelectedItem().toString()) {
					case "Spend It!":
						if(num > Main.getSarBalance(0)) {
							num = Main.getSarBalance(0);
						}
						else if(Main.getSarBalance(0) == 0){
							message.setText("Transfer Failed. Not enough Funds");
						}
						else {
							Main.setSarBalance(0, Main.getSarBalance(0) - num);
							message.setText("Transfer Sucessful! You transfered $" + num);
							switch(receivers.getSelectedItem().toString()) {
							case "Spend It!":
								Main.setSarBalance(0, Main.getSarBalance(0) + num);
								break;
							case "Plan Ahead!":
								Main.setSarBalance(1, Main.getSarBalance(1) + num);
								break;
							case "Grow 'N Grow!":
								Main.setSarBalance(2, Main.getSarBalance(2) + num);
								break;
							}
						}
					break;
					case "Plan Ahead!":
						if(num > Main.getSarBalance(1)) {
							num = Main.getSarBalance(1);
						}
						else if(Main.getSarBalance(1) == 0){
							message.setText("Transfer Failed. Not enough Funds");
						}
						else {
							Main.setSarBalance(1, Main.getSarBalance(1) - num);
							message.setText("Transfer Sucessful! You transfered $" + num);
							switch(receivers.getSelectedItem().toString()) {
							case "Spend It!":
								Main.setSarBalance(0, Main.getSarBalance(0) + num);
								break;
							case "Plan Ahead!":
								Main.setSarBalance(1, Main.getSarBalance(1) + num);
								break;
							case "Grow 'N Grow!":
								Main.setSarBalance(2, Main.getSarBalance(2) + num);
								break;
							}
						}
					break;
					case "Grow 'N Grow!":
						if(num > Main.getSarBalance(2)) {
							num = Main.getSarBalance(2);
						}
						else if(Main.getSarBalance(2) == 0){
							message.setText("Transfer Failed. Not enough Funds");
						}
						else {
							Main.setSarBalance(2, Main.getSarBalance(2) - num);
							message.setText("Transfer Sucessful! You transfered $" + num);
							switch(receivers.getSelectedItem().toString()) {
							case "Spend It!":
								Main.setSarBalance(0, Main.getSarBalance(0) + num);
								break;
							case "Plan Ahead!":
								Main.setSarBalance(1, Main.getSarBalance(1) + num);
								break;
							case "Grow 'N Grow!":
								Main.setSarBalance(2, Main.getSarBalance(2) + num);
								break;
							}
						}
					break;
					}
				}
			break;
			
			case "Joshua":
				if(senders.getSelectedItem() == receivers.getSelectedItem()) {
					message.setText("You cannot transfer money from one account to itself.");
				}
				else {
					switch(senders.getSelectedItem().toString()) {
					case "Spend It!":
						if(num > Main.getJosBalance(0)) {
							num = Main.getJosBalance(0);
						}
						else if(Main.getJosBalance(0) == 0){
							message.setText("Transfer Failed. Not enough Funds");
						}
						else {
							Main.setJosBalance(0, Main.getJosBalance(0) - num);
							message.setText("Transfer Sucessful! You transfered $" + num);
							switch(receivers.getSelectedItem().toString()) {
							case "Spend It!":
								Main.setJosBalance(0, Main.getJosBalance(0) + num);
								break;
							case "Plan Ahead!":
								Main.setJosBalance(1, Main.getJosBalance(1) + num);
								break;
							case "Grow 'N Grow!":
								Main.setJosBalance(2, Main.getJosBalance(2) + num);
								break;
							}
						}
					break;
					case "Plan Ahead!":
						if(num > Main.getJosBalance(1)) {
							num = Main.getJosBalance(1);
						}
						else if(Main.getJosBalance(1) == 0){
							message.setText("Transfer Failed. Not enough Funds");
						}
						else {
							Main.setJosBalance(1, Main.getJosBalance(1) - num);
							message.setText("Transfer Sucessful! You transfered $" + num);
							switch(receivers.getSelectedItem().toString()) {
							case "Spend It!":
								Main.setJosBalance(0, Main.getJosBalance(0) + num);
								break;
							case "Plan Ahead!":
								Main.setJosBalance(1, Main.getJosBalance(1) + num);
								break;
							case "Grow 'N Grow!":
								Main.setJosBalance(2, Main.getJosBalance(2) + num);
								break;
							}
						}
					break;
					case "Grow 'N Grow!":
						if(num > Main.getJosBalance(2)) {
							num = Main.getJosBalance(2);
						}
						else if(Main.getJosBalance(2) == 0){
							message.setText("Transfer Failed. Not enough Funds");
						}
						else {
							Main.setJosBalance(2, Main.getJosBalance(2) - num);
							message.setText("Transfer Sucessful! You transfered $" + num);
							switch(receivers.getSelectedItem().toString()) {
							case "Spend It!":
								Main.setJosBalance(0, Main.getJosBalance(0) + num);
								break;
							case "Plan Ahead!":
								Main.setJosBalance(1, Main.getJosBalance(1) + num);
								break;
							case "Grow 'N Grow!":
								Main.setJosBalance(2, Main.getJosBalance(2) + num);
								break;
							}
						}
					break;
					}
				}
			break;
			
			case "Elizabeth":
				if(senders.getSelectedItem() == receivers.getSelectedItem()) {
					message.setText("You cannot transfer money from one account to itself.");
				}
				else {
					switch(senders.getSelectedItem().toString()) {
					case "Spend It!":
						if(num > Main.getEliBalance(0)) {
							num = Main.getEliBalance(0);
						}
						else if(Main.getEliBalance(0) == 0){
							message.setText("Transfer Failed. Not enough Funds");
						}
						else {
							Main.setEliBalance(0, Main.getEliBalance(0) - num);
							message.setText("Transfer Sucessful! You transfered $" + num);
							switch(receivers.getSelectedItem().toString()) {
							case "Spend It!":
								Main.setEliBalance(0, Main.getEliBalance(0) + num);
								break;
							case "Plan Ahead!":
								Main.setEliBalance(1, Main.getEliBalance(1) + num);
								break;
							case "Grow 'N Grow!":
								Main.setEliBalance(2, Main.getEliBalance(2) + num);
								break;
							}
						}
					break;
					case "Plan Ahead!":
						if(num > Main.getEliBalance(1)) {
							num = Main.getEliBalance(1);
						}
						else if(Main.getEliBalance(1) == 0){
							message.setText("Transfer Failed. Not enough Funds");
						}
						else {
							Main.setEliBalance(1, Main.getEliBalance(1) - num);
							message.setText("Transfer Sucessful! You transfered $" + num);
							switch(receivers.getSelectedItem().toString()) {
							case "Spend It!":
								Main.setEliBalance(0, Main.getEliBalance(0) + num);
								break;
							case "Plan Ahead!":
								Main.setEliBalance(1, Main.getEliBalance(1) + num);
								break;
							case "Grow 'N Grow!":
								Main.setEliBalance(2, Main.getEliBalance(2) + num);
								break;
							}
						}
					break;
					case "Grow 'N Grow!":
						if(num > Main.getEliBalance(2)) {
							num = Main.getEliBalance(2);
						}
						else if(Main.getEliBalance(2) == 0){
							message.setText("Transfer Failed. Not enough Funds");
						}
						else {
							Main.setEliBalance(2, Main.getEliBalance(2) - num);
							message.setText("Transfer Sucessful! You transfered $" + num);
							switch(receivers.getSelectedItem().toString()) {
							case "Spend It!":
								Main.setEliBalance(0, Main.getEliBalance(0) + num);
								break;
							case "Plan Ahead!":
								Main.setEliBalance(1, Main.getEliBalance(1) + num);
								break;
							case "Grow 'N Grow!":
								Main.setEliBalance(2, Main.getEliBalance(2) + num);
								break;
							}
						}
					break;
					}
				}	
			break;
			
			case "KPL":
				if(senders.getSelectedItem() == receivers.getSelectedItem()) {
					message.setText("You cannot transfer money from one account to itself.");
				}
				else {
					switch(senders.getSelectedItem().toString()) {
					case "Spend It!":
						if(num > Main.getKPLBalance(0)) {
							num = Main.getKPLBalance(0);
						}
						else if(Main.getKPLBalance(0) == 0){
							message.setText("Transfer Failed. Not enough Funds");
						}
						else {
							Main.setKPLBalance(0, Main.getKPLBalance(0) - num);
							message.setText("Transfer Sucessful! You transfered $" + num);
							switch(receivers.getSelectedItem().toString()) {
							case "Spend It!":
								Main.setKPLBalance(0, Main.getKPLBalance(0) + num);
								break;
							case "Plan Ahead!":
								Main.setKPLBalance(1, Main.getKPLBalance(1) + num);
								break;
							case "Grow 'N Grow!":
								Main.setKPLBalance(2, Main.getKPLBalance(2) + num);
								break;
							}
						}
					break;
					case "Plan Ahead!":
						if(num > Main.getKPLBalance(1)) {
							num = Main.getKPLBalance(1);
						}
						else if(Main.getKPLBalance(1) == 0){
							message.setText("Transfer Failed. Not enough Funds");
						}
						else {
							Main.setKPLBalance(1, Main.getKPLBalance(1) - num);
							message.setText("Transfer Sucessful! You transfered $" + num);
							switch(receivers.getSelectedItem().toString()) {
							case "Spend It!":
								Main.setKPLBalance(0, Main.getKPLBalance(0) + num);
								break;
							case "Plan Ahead!":
								Main.setKPLBalance(1, Main.getKPLBalance(1) + num);
								break;
							case "Grow 'N Grow!":
								Main.setKPLBalance(2, Main.getKPLBalance(2) + num);
								break;
							}
						}
					break;
					case "Grow 'N Grow!":
						if(num > Main.getKPLBalance(2)) {
							num = Main.getKPLBalance(2);
						}
						else if(Main.getKPLBalance(2) == 0){
							message.setText("Transfer Failed. Not enough Funds");
						}
						else {
							Main.setKPLBalance(2, Main.getKPLBalance(2) - num);
							message.setText("Transfer Sucessful! You transfered $" + num);
							switch(receivers.getSelectedItem().toString()) {
							case "Spend It!":
								Main.setKPLBalance(0, Main.getKPLBalance(0) + num);
								break;
							case "Plan Ahead!":
								Main.setKPLBalance(1, Main.getKPLBalance(1) + num);
								break;
							case "Grow 'N Grow!":
								Main.setKPLBalance(2, Main.getKPLBalance(2) + num);
								break;
							}
						}
					break;
					}
				}
			break;
			}
			field.setText("");
		}
		//brings you back to the correct menus
		if(e.getSource()==backBtn) {
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
