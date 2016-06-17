package com.brandenkeck.physicsapp;
import java.util.*;

public class Directory {
	
	public static double G = 6.673*Math.pow(10,-11);
	public static double pi = Math.PI;
	public static double g = -9.8;
	
	public static double getGravityDistance(double mass1, double mass2, double force){
		double gravDist=Math.sqrt((G*mass1*mass2)/force);
		return gravDist;
	}
	
	public static double getGravityForce(double mass1, double mass2, double dist){
		double gravForce = (G*mass1*mass2)/(Math.pow(dist, 2));
		return gravForce;
	}
	
	public static double getGravityMass(double mass2, double force, double dist){
		double gravMass=(force*Math.pow(dist, 2))/(G*mass2);
		return gravMass;
	}
	
	public static double getGravityPotential(double mass1, double mass2, double dist){
		double gravPotential=(G*mass1*mass2)/(dist);
		return gravPotential;
	}
	
	public static double getProjectileDistance(double vel, double angle, double time){
		double velx = vel*Math.cos(angle/360*2*pi);
		double dist = velx*time;
		return dist;
	}
	
	public static double getProjectileHeight(double vel, double angle, double time){
		double vely = vel*Math.sin(angle/360*2*pi);
		double height = vely*time+.5*g*Math.pow(time, 2);
		return height;
	}
	
	public static double getFinalVelocity(double vel, double angle, double height){
		double velx = vel*Math.cos(angle/360*2*pi);
		double vely = vel*Math.sin(angle/360*2*pi);
		double velyf = Math.sqrt(Math.pow(vely,2)+2*g*height);
		double velf = Math.sqrt(Math.pow(velx, 2) + Math.pow(velyf, 2));
		return velf;
	}
	
	public static double getAirTime(double vel, double angle, double height){
		double vely = vel*Math.sin(angle/360*2*pi);
		double velyf = Math.sqrt(Math.pow(vely,2)+2*g*height);
		double time = (velyf-vely)/g;
		return time;
	}
	
	
	
}
