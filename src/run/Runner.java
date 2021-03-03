package run;

import controll.ControllCraps;
import gui.MainWindow;
import model.ActionsCraps;

public class Runner {
	
	 public static void main(String[] args) {
		 
		 	ActionsCraps view=null;
			view=new MainWindow();
			
			ControllCraps controll=new ControllCraps(view);
			view.setControll(controll);
			view.begin();

	}
}
