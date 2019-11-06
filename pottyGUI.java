import java.util.*;
import javax.swing.*;
import java.io.*;
import java.net.URL;
 import java.awt.Color;
 import java.awt.*;
 import java.awt.event.ActionListener;
 
public class pottyGUI {
	
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
		
		f.add(sign_in);
		
		sign_in.setBackground(Color.YELLOW);
		
		JButton forgotPass = new JButton("Forgot Password?");
		forgotPass.setBounds(300, 400, 300, 15);
		
		f.add(forgotPass);
		
		JButton createAccount = new JButton("Create Account");
		createAccount.setBounds(300, 550, 300, 15);
		
		f.add(createAccount);
		
		f.setSize(1000, 1000);
		f.setLayout(null);
		f.setVisible(true);
		
		
		while (true) {
			
		boolean pressed = isButtonPressed(forgotPass, sign_in, createAccount);
		
		if (pressed == true) { repaintJFrame(); }
		
		}
		//sets size of j frame and opens
	//f.setSize(1000, 1000);
		//f.setLayout(null);
		//f.setVisible(true);
		
	}
		
	public static boolean isButtonPressed(JButton forgotPass, JButton createAccount, JButton sign_in ) {
		
		//ADD ACTION LISTENER HERE//
		if (sign_in.getModel().isPressed() || forgotPass.getModel().isPressed() || createAccount.getModel().isPressed()) {
			System.out.println("pressed");
			return true;
			
		}
		else {System.out.println();
		return false;}

	}
	
	public static void addReview(JFrame pottyGUI2) {
		JTextField review = new JTextField();
		
		review.setBounds(375, 200, 250, 250);
		
		pottyGUI2.add(review);
		
		JButton addImages = new JButton();
		
		addImages.setBounds(375, 450, 100, 45);
		
		pottyGUI2.add(addImages);
		
		JButton sendReview = new JButton();
		
		sendReview.setBounds(800, 800, 300, 95);
		
		pottyGUI2.add(sendReview);
		
		
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