package com.brandenkeck.physicsapp;
import javax.swing.*;
import javax.imageio.*;

import java.io.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.util.*;

public class ChoiceClass extends JPanel {
	
	//Creating Variables for Layout
	private JButton myButt;
	private JComboBox choice;
	private BufferedImage NKB;
	private ImageIcon ButtonIcon = new ImageIcon("res/Button.png");
	private MainClass OptOut = new MainClass();
	private int option;
	
	public ChoiceClass(){
		//important... or something
		setLayout(null);
		
		//Testing background image
		try{
			NKB = ImageIO.read(new File("res/NKB.png"));
		}catch(IOException e){
			System.out.println("ERROR");
		}
		
		//Making the DropDown
		String[] optStr = {null,"Gravity","Projectiles"};
		choice = new JComboBox(optStr);
		
		//Records DropDown Choice
		choice.addItemListener(
				new ItemListener(){
					public void itemStateChanged(ItemEvent e){
						if(e.getStateChange()==ItemEvent.SELECTED){
							option = choice.getSelectedIndex();
						}
					}
				});
		choice.setBounds(590,523,100,25);
		add(choice);
		
		//Making the Button
		myButt = new JButton("", ButtonIcon);
		HandleMeGently handler = new HandleMeGently();
		myButt.addActionListener(handler);
		myButt.setBounds(405, 578, 200, 100);
		add(myButt);
	}
	
	
	//Creation of Background
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		g.drawImage(NKB, 0, 0, 1000, 800, null);
	}
	
	
	//Implements button based on dropdown choice
	public class HandleMeGently implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			if(choice!=null && e.getSource()==myButt){
			OptOut.ChangeScreens(option);
			}
		}
		
	}
}
