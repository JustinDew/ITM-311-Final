import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class Login implements ActionListener{
	
	private JFrame frame;
	private JPanel panel;
	private JLabel bank, user, pass, failed;
	private JTextField usertxt;
	private JPasswordField passtxt;
	private JButton loginButton;	
	
	
	Login(){
//Object instantiation
		frame = new JFrame("USBI Login");
		panel = new JPanel();
		bank = new JLabel("Universal State Bank of Illinois");
		user = new JLabel("Username:");
		pass = new JLabel("Password:");
		failed = new JLabel("");
		usertxt = new JTextField();
		passtxt = new JPasswordField();
		loginButton = new JButton("Login");
		
//sets up the JFrame
		frame.setSize(300,200);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.add(panel);
		
//adds the bank name to the top
		bank.setBounds(17, 10, 300, 25);
		bank.setFont(new Font("Serif",Font.PLAIN,20));
		panel.add(bank);
		
//removes layout from panel	
		panel.setLayout(null);
		
//adds user JLabel to a specific location
		user.setBounds(10,50,80,25);
		panel.add(user);
		
//adds usertxt JTextField to a specific location
		usertxt.setBounds(100,50,165,25);
		panel.add(usertxt);
		
//adds pass JLabel to a specific location	
		pass.setBounds(10, 80, 80, 25);
		panel.add(pass);
		
//adds passtxt JPasswordField to a specific location
		passtxt.setBounds(100, 80, 165, 25);
		panel.add(passtxt);
		
//adds loginButton JButton to a specific location	
		loginButton.setBounds(10, 110, 80, 25);
		loginButton.addActionListener(this);
		panel.add(loginButton);
		
//adds a the failed message to a specific location		
		failed.setBounds(100, 110, 300, 25);
		panel.add(failed);

		frame.setVisible(true);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==loginButton) {
//If the username is Jonathan, Sarah, Joshua, Elizabeth, or KPLawFirm and the password is "password" then you are logged in
			if(usertxt.getText().equals("Jonathan") && String.valueOf(passtxt.getPassword()).equals("password")) {
				failed.setText("Login Sucessful!");
				frame.setVisible(false);
				Main.setAccount("Jonathan");
				new Jonathan();
			}
			else if(usertxt.getText().equals("Sarah") && String.valueOf(passtxt.getPassword()).equals("password")) {
				failed.setText("Login Sucessful!");
				frame.setVisible(false);
				Main.setAccount("Sarah");
				new Sarah();
			}
			else if(usertxt.getText().equals("Joshua") && String.valueOf(passtxt.getPassword()).equals("password")) {
				failed.setText("Login Sucessful!");
				frame.setVisible(false);
				Main.setAccount("Joshua");
				new Joshua();
			}
			else if(usertxt.getText().equals("Elizabeth") && String.valueOf(passtxt.getPassword()).equals("password")) {
				failed.setText("Login Sucessful!");
				frame.setVisible(false);
				Main.setAccount("Elizabeth");
				new Elizabeth()
;			}
			else if(usertxt.getText().equals("KPLawFirm") && String.valueOf(passtxt.getPassword()).equals("password")) {
				failed.setText("Login sucessful!");
				frame.setVisible(false);
				Main.setAccount("KPL");
				new KPL();
			}
			else {
				failed.setText("Login failed. Please try again.");
				usertxt.setText("");
				passtxt.setText("");
			}
		}
		
	}

}
