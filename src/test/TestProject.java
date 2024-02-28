package test;

import javax.swing.UIManager;

import view.HomeView;
import view.LoginView;

public class TestProject {
	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
			new LoginView();
				}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
}

