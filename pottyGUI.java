import java.util.*;
import javax.swing.*;
import java.io.*;
import java.net.URL;
 import java.awt.Color;
 import java.awt.*;
 import java.awt.event.ActionListener;
 import java.awt.event.*;
 
public class pottyGUI  {

	public static JFrame f = new JFrame(); //initializes gui jframe
	
	public static void main (String[] args) {
		
		JTextField name = new JTextField();
		name.setBounds(300, 300, 300, 40);
		
		f.add(name);
		
		JLabel nameLabel = new JLabel("Username/Email");
		nameLabel.setBounds(200, 200, 400, 40);
		f.add(nameLabel);
		
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
				repaintJFrame();
			}
		} ) ;
		
		
		f.add(sign_in);
		
		sign_in.setBackground(Color.YELLOW);
		
		JButton forgotPass = new JButton("Forgot Password?");
		forgotPass.setBounds(300, 400, 300, 15);
		
		forgotPass.addActionListener(new ActionListener() {
			@Override public void actionPerformed(ActionEvent e) {
				repaintJFrame();
			}
		} ) ;
		
		f.add(forgotPass);
		
		JButton createAccount = new JButton("Create Account");
		createAccount.setBounds(300, 550, 300, 15);
		
		createAccount.addActionListener(new ActionListener() {
			@Override public void actionPerformed(ActionEvent e) {
				repaintJFrame();
			}
		} ) ;
				

		
		f.add(createAccount);
		
		f.setSize(1000, 1000);
		f.setLayout(null);
		f.setVisible(true);
		
		
	}
		
	
	public static void addReview(JFrame pottyGUI2) {
		JTextField review = new JTextField();
		
		review.setBounds(350, 200, 250, 175);
		
		pottyGUI2.add(review);
		
		JButton sendReview = new JButton();
		
		sendReview.setBounds(475, 400, 100, 50);
		
		sendReview.setBackground(Color.YELLOW);
		
		pottyGUI2.add(sendReview);
		
		JButton addImages = new JButton();
		
		addImages.setBounds(375, 400, 100, 50);
		
		addImages.setBackground(Color.YELLOW);
		
		pottyGUI2.add(addImages);
		
	}
	
	public static void displayMap() {
		
		
	}
	
	public static void repaintJFrame () {

		f.dispose();
		
		JFrame pottyGUI2 = new JFrame();
		
		pottyGUI2.setSize(1000, 1000);
		pottyGUI2.setLayout(null);
		pottyGUI2.setVisible(true);
		
		addReview(pottyGUI2);
		
		
	}
	
}