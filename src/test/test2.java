package test;

import Helper.Connect;

public class test2 {
	public static void main(String[] args) {
		Connect cn = new Connect();
		try {
			cn.openConnection();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
