import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.SwingConstants;

public class account extends JFrame implements ActionListener{
	
	public JPanel topPanel,balancePanel, mainPanel;
	private JLabel accountLabel, balanceLabel;
	private String accountName = "";
	private JButton backBtn;

//method to create JFrame
	public void startFrame() {
		this.setSize(500,400);
		this.setResizable(false);
		this.setLayout(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
//method to create things to go inside JFrame
	public void addStuff(int balanceNum){
		topPanel = new JPanel();
		mainPanel = new JPanel();
		balancePanel = new JPanel();
		accountLabel = new JLabel(accountName, SwingConstants.CENTER);
		balanceLabel = new JLabel("Balance: $" + Integer.toString(balanceNum),SwingConstants.CENTER);
		backBtn = new JButton("Back");
		
		accountLabel.setBounds(0, 0, 500, 50);
		accountLabel.setFont(new Font("Seriff",Font.BOLD,35));
	
		balanceLabel.setBounds(0,50,500,50);
		balanceLabel.setFont(new Font("Seriff", Font.BOLD,25));
		balanceLabel.setHorizontalTextPosition(JLabel.CENTER);
		
		backBtn.setFocusable(false);
		backBtn.addActionListener(this);
		backBtn.setBounds(0,311,500,50);
		
		this.add(accountLabel);
		this.add(balanceLabel);
		this.add(backBtn);
		this.add(topPanel);
		this.setVisible(true);

	}
//sets the name of account
	public void setAccountName(String name) {
		accountName = name;
	}
	public JButton getBackBtn() {
		return backBtn;
	}


	public void actionPerformed(ActionEvent e) {
		
	}
	
}
