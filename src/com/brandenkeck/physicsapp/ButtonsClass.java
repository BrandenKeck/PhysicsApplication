package com.brandenkeck.physicsapp;
import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;

public class ButtonsClass {
	
	private MainClass OptOut = new MainClass();
	
	//Handles BackButtons
	public class BackHandle implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			OptOut.ChangeScreens(0);
		}
		
	}
	
	
}
