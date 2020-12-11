import java.awt.event.ActionEvent;


public class Sarah extends Menus{
	
//creates its own version of menus
	Sarah(){
		this.start(Main.getSarBalance(0), Main.getSarBalance(1), Main.getSarBalance(2));
	}

//menus button events
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==getLogout()) {
			new Login();
			setVisible(false);
			
		}	
		else if(e.getSource()==getSpend()) {
			System.out.println("Spend!");
			setVisible(false);
			new SpendIt(Main.getSarBalance(0), "Welcome, " + Main.getAccount() + "! This is your SpendIt! account.");
		}
		else if(e.getSource()==getPlan()) {
			System.out.println("Plan Ahead!");
			setVisible(false);
			new PlanAhead(Main.getSarBalance(1), "Welcome, " + Main.getAccount() + "! This is your Plan Ahead! account.");
		}
		else if(e.getSource()==getGrow()) {
			System.out.println("Grow N Grow!");
			setVisible(false);
			new GrowNGrow(Main.getSarBalance(2), "Welcome, " + Main.getAccount() + "! This is your Grow 'N Grow! account");
		}
		else if(e.getSource()==getTrans()) {
			System.out.println("Transfer!");
			setVisible(false);
			new Transfer();
		}
	}
	
}
