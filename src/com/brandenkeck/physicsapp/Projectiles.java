package com.brandenkeck.physicsapp;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;


public class Projectiles extends JPanel {
	
	private BufferedImage proj, info;
	private MainClass OptOut = new MainClass();
	private Directory Dir = new Directory();
	private ImageIcon BB = new ImageIcon("res/BackButton.png");
	private ImageIcon ButtonIcon = new ImageIcon("res/Button.png");
	private ImageIcon InfoIcon = new ImageIcon("res/Info.png");
	private ImageIcon InfoPane = new ImageIcon("res/ProjInfo.png");
	private JButton BackButton, GoButton, InfoButton;
	private JComboBox CalcType;
	private JTextField Variable1, Variable2, Variable3;
	private double Var1, Var2, Var3, answer;
	private boolean vBool1, vBool2, vBool3, aBool;
	private int CalcChoice;
	
	public Projectiles(){
		//Used for customization
		setLayout(null);
		
		//Testing background image
		try{
			proj = ImageIO.read(new File("res/proj.png"));
		}catch(IOException e){
			System.out.println("ERROR");
		}
		
		try{
			info = ImageIO.read(new File("res/ProjInfo.png"));
		}catch(IOException e){
			System.out.println("ERROR");
		}
		
		BackButton = new JButton("", BB);
		BackButton.setBounds(25,25,75,50);
		BackHandle BH = new BackHandle();
		BackButton.addActionListener(BH);
		add(BackButton);
		
		Variable1 = new JTextField(10);
		Variable2 = new JTextField(10);
		Variable3 = new JTextField(10);
		Variable1.setBounds(262, 430, 125, 25);
		Variable2.setBounds(262, 560, 125, 25);
		Variable3.setBounds(262, 690, 125, 25);
		add(Variable1);
		add(Variable2);
		add(Variable3);
		
		String[] projOpt = {null, "Find Distance", "Find Height", "Find Velocity", "Find Time"};
		CalcType = new JComboBox(projOpt);
		
		CalcType.addItemListener(new ItemListener(){
			public void itemStateChanged(ItemEvent e){
				if(e.getStateChange()==ItemEvent.SELECTED){
					CalcChoice = CalcType.getSelectedIndex();
					OptOut.ChangeScreens(2);
				}
			}
		});
		
		CalcType.setBounds(760, 265, 125, 25);
		add(CalcType);
		
		GoButton = new JButton("", ButtonIcon);
		GoButton.setBounds(755,665,200,100);
		HandleMeGently HMG = new HandleMeGently();
		GoButton.addActionListener(HMG);
		add(GoButton);
		
		JLabel labelMe = new JLabel(InfoPane);
        labelMe.setBounds(0, 0, 1000, 800);
        labelMe.setVisible(false);
        add(labelMe);
		
		InfoButton = new JButton("", InfoIcon);
		InfoButton.setRolloverEnabled(true);
		
		InfoButton.getModel().addChangeListener(new ChangeListener() {
		    @Override
		    public void stateChanged(ChangeEvent e) {
		        ButtonModel model = (ButtonModel) e.getSource();
		        if (model.isRollover()) {
		        	System.out.println("Code 1");
		        	labelMe.setVisible(true);
		        	Variable1.setVisible(false);
		        	Variable2.setVisible(false);
		        	Variable3.setVisible(false);
		        }
		        else{
		        	labelMe.setVisible(false);
		        	Variable1.setVisible(true);
		        	Variable2.setVisible(true);
		        	Variable3.setVisible(true);
		        }
		    }
		});
		

		InfoButton.setBounds(925, 25, 50, 50);
		add(InfoButton);
		
	}


	//Creation of Background
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		g.drawImage(proj, 0, 0, 1000, 800, null);
		
		g.setFont(new Font("Arial", 0, 28));
		g.setColor(Color.BLACK);
		
		if(CalcChoice==0){
			g.drawString("(Select Calculation Type)", 262, 410);
			g.drawString("(Select Calculation Type)", 262, 540);
			g.drawString("(Select Calculation Type)", 262, 670);
		}
		
		if(CalcChoice==1 || CalcChoice==2){
			g.drawString("Enter Initial Velocity (m/s):", 262, 410);
			g.drawString("Enter Launch Angle (deg):", 262, 540);
			g.drawString("Enter Time (s):", 262, 670);
		}
		
		if(CalcChoice==3 || CalcChoice==4){
			g.drawString("Enter Initial Velocity (m/s):", 262, 410);
			g.drawString("Enter Launch Angle (deg):", 262, 540);
			g.drawString("Enter Height (m):", 262, 670);
		}
		
		g.setColor(Color.BLACK);
		g.drawString("Answer:", 820, 540);
		String ans = String.format("%.3E",answer);
		g.drawString(ans, 820, 580);
	}
	
	//Handles BackButtons
	public class BackHandle implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			if(e.getSource()==BackButton){
			OptOut.ChangeScreens(0);
			}
		}
	}
	
	
	//Implements calculation based on variable choice
		public class HandleMeGently implements ActionListener {

			@Override
			public void actionPerformed(ActionEvent e) {
				if(e.getSource()==GoButton){
				    try {
				        int Var1=Integer.parseInt(Variable1.getText());
				        int Var2=Integer.parseInt(Variable2.getText());
				        int Var3=Integer.parseInt(Variable3.getText());
				        
				        if(CalcChoice==1){
							answer = Dir.getProjectileDistance(Var1, Var2, Var3);
							aBool = true;
						}
						if(CalcChoice==2){
							answer = Dir.getProjectileHeight(Var1, Var2, Var3);
							aBool = true;
						}
						if(CalcChoice==3){
							answer = Dir.getFinalVelocity(Var1, Var2, Var3);
							aBool = true;
						}
						if(CalcChoice==4){
							answer = Dir.getAirTime(Var1, Var2, Var3);
							aBool = true;
						}
				      }
				      catch (NumberFormatException ex) {
				     }
					OptOut.ChangeScreens(2);
				}
			}
		}
}