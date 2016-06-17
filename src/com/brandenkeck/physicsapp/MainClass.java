package com.brandenkeck.physicsapp;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.CardLayout;

import javax.swing.*;

public class MainClass{

	private static ChoiceClass Choose = new ChoiceClass();
	private static Gravity Gravity = new Gravity();
	private static Projectiles Projectiles = new Projectiles();
	private static JFrame myFrame = new JFrame("Physics App");
	private static JPanel PanelCard = new JPanel();
	private static CardLayout cLay = new CardLayout();
	
	public static void MainClass(){
		myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		myFrame.setSize(1005, 820);
		myFrame.setLayout(null);
		myFrame.setVisible(true);
		myFrame.setResizable(false);
		myFrame.setContentPane(PanelCard);

		ChangeScreens(0);
		
	}
	
	public static void ChangeScreens(int opt){
		
		PanelCard.setLayout(cLay);
		PanelCard.add(Choose, "Choose");
		PanelCard.add(Gravity, "Gravity");
		PanelCard.add(Projectiles, "Projectiles");
		
		switch(opt){
		case 1:
			cLay.show(PanelCard, "Gravity");;
			break;
		case 2:
			cLay.show(PanelCard, "Projectiles");;
			break;
		default:
			cLay.show(PanelCard, "Choose");
			break;
		}
	}
	
	public static void main(String args[]){
		SwingUtilities.invokeLater(new Runnable(){
			public void run(){
				MainClass();
			}
		});
	}
	
}
