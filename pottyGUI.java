import java.util.*;
import javax.swing.*;
import java.io.*;
import java.net.URL;
 import java.awt.Color;
 import java.awt.*;
 import java.awt.event.ActionListener;
 import java.awt.event.*;
 
public class pottyGUI  {
	
	//private Jbutton[] buttons = new JButton[50];
	public static JFrame f = new JFrame(); //initializes gui jframe
	
	public static void main (String[] args) {
		
		//pottyGUI potApp = new pottyGUI("");
		//potApp.setVisible(true);
		JTextField name = new JTextField();
		name.setBounds(300, 300, 300, 40);
		
		f.add(name);
		
		JLabel nameLabel = new JLabel("Username/Email");
		nameLabel.setBounds(200, 200, 400, 40);
		f.add(nameLabel);
		//JButton emailUserButton = new JButton("Email or username");
		//emailUserButton.setBounds(300, 300, 300, 40);
		
		//f.add(emailUserButton);
		
		JTextField password = new JTextField();
		password.setBounds(300, 200, 300, 45);
		
		f.add(password);
		
		JLabel passwordLabel = new JLabel("Password");
		passwordLabel.setBounds(200, 300, 400, 40);
		f.add(passwordLabel);
		
		JButton sign_in = new JButton("Sign In");
		sign_in.setBounds(300, 500, 300, 40);
		
		sign_in.addActionListener(new ActionListener() {
			@Override public void actionPerformed(ActionEvent e) {
				//if (f.getComponentCount() > 0)
					//f.remove(0);
				repaintJFrame();
			}
		} ) ;
		
		
		f.add(sign_in);
		
		sign_in.setBackground(Color.YELLOW);
		
		JButton forgotPass = new JButton("Forgot Password?");
		forgotPass.setBounds(300, 400, 300, 15);
		
		forgotPass.addActionListener(new ActionListener() {
			@Override public void actionPerformed(ActionEvent e) {
				//if (f.getComponentCount() > 0)
					//f.remove(0);
				repaintJFrame();
			}
		} ) ;
		
		f.add(forgotPass);
		
		JButton createAccount = new JButton("Create Account");
		createAccount.setBounds(300, 550, 300, 15);
		
		createAccount.addActionListener(new ActionListener() {
			@Override public void actionPerformed(ActionEvent e) {
				//if (f.getComponentCount() > 0)
					//f.remove(0);
				repaintJFrame();
			}
		} ) ;
				

		
		f.add(createAccount);
		
		f.setSize(1000, 1000);
		f.setLayout(null);
		f.setVisible(true);
		
		
	}
		
		//int print_outs = 0;
		
		/*
		while (true) {
			
		boolean pressed = isButtonPressed(forgotPass, sign_in, createAccount);
		
		if (pressed == true) { repaintJFrame(); }
		
		}
		*/
		//sets size of j frame and opens
	//f.setSize(1000, 1000);
		//f.setLayout(null);
		//f.setVisible(true);
		
	
		
		/*
	public static boolean isButtonPressed(JButton forgotPass, JButton createAccount, JButton sign_in) {
		
		//ADD ACTION LISTENER HERE//
		if ((sign_in.getModel().isPressed() == true || forgotPass.getModel().isPressed() == true|| createAccount.getModel().isPressed()) == true) {
			System.out.println("pressed");
			return true;
			
		}
		else {
			System.out.println();
			//print_outs = print_outs+1;
		return false;}

	}
	*/
	
	public static void addReview(JFrame pottyGUI2) {
		JTextField review = new JTextField();
		
		review.setBounds(375, 200, 250, 250);
		
		pottyGUI2.add(review);
		
		JButton sendReview = new JButton();
		
		sendReview.setBounds(90, 90, 50, 50);
		
		pottyGUI2.add(sendReview);
		
		JButton addImages = new JButton();
		
		addImages.setBounds(100, 100, 100, 100);
		
		pottyGUI2.add(addImages);
		
		/*
		JButton addImages = new JButton();
		
		addImages.setBounds(375, 450, 100, 45);
		
		pottyGUI2.add(addImages);
		
		JTextField add_images_field = new JTextField();
		
		add_images_field.setBounds(450, 500, 500, 50);
		
		pottyGUI2.add(add_images_field);
		
		JButton sendReview = new JButton();
		
		sendReview.setBounds(50, 50, 50, 50);
		
		pottyGUI2.add(sendReview);
		*/
		
	}
	
	public static void repaintJFrame () {
		//JFrame pottyGUI2 = new JFrame(); 
		
		//pottyGUI2.setSize(1000, 1000);
		//pottyGUI2.setLayout(null);
		//pottyGUI2.setVisible(true);
		
		//f.getContentPane().removeAll();
		//f.repaint();
		
		f.dispose();
		
		JFrame pottyGUI2 = new JFrame();
		
		pottyGUI2.setSize(1000, 1000);
		pottyGUI2.setLayout(null);
		pottyGUI2.setVisible(true);
		
		/*JPanel center = new JPanel();
		center.setBackground(Color.YELLOW);
		JLabel potty = new JLabel("POTTY POLL");
		potty.setFont(new Font(null, 0, 50));
		
		potty.setVisible(true);
		*/
		
		//JPanel container = new JPanel();
		//JScrollPane scrPane = new JScrollPane(container);
		//f.add(scrPane);
		
		
		
		
		//return f;
		
		addReview(pottyGUI2);
		
		
	}
	
}