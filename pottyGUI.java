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
	
	public static JButton return_to_login;
	
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
				final String username = name.getText();
				final String user_password = password.getText();
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
		pottyGUI2.setVisible(false);
		
		JFrame review_frame = new JFrame();
		
		review_frame.setSize(1000, 1000);
		review_frame.setLayout(null);
		review_frame.setVisible(true);
		
		JTextField author = new JTextField();
		author.setBounds(100, 100, 200, 100);
		review_frame.add(author);
		
		JTextField gender = new JTextField();
		gender.setBounds(100, 200, 100, 100);
		review_frame.add(gender);
		
		JTextField shower = new JTextField();
		shower.setBounds(200, 200, 100, 100);
		review_frame.add(shower);
		
		JTextField sink = new JTextField();
		sink.setBounds(100, 300, 100, 100);
		review_frame.add(sink);
		
		JTextField paper_towels = new JTextField();
		paper_towels.setBounds(200, 300, 100, 100);
		review_frame.add(paper_towels);
		
		JTextField location = new JTextField();
		location.setBounds(100, 400, 100, 100);
		review_frame.add(location);
		
		JTextField building = new JTextField();
		building.setBounds(200, 400, 100, 100);
		review_frame.add(building);
		
		JTextField floor = new JTextField();
		floor.setBounds(100, 500, 100, 100);
		review_frame.add(floor);
		
		JTextField hours = new JTextField();
		hours.setBounds(200, 500, 100, 100);
		review_frame.add(hours);
		
		//JTextField rating = new JTextField();
		//rating.setBounds(100, 600, 100, 100);
		//review_frame.add(rating);
		
		//JTextField date = new JTextField();
		//date.setBounds(200, 100, 100, 100);
		//review_frame.add(date);
		
		JTextField long_comment = new JTextField();
		long_comment.setBounds(100, 600, 200, 100);
		review_frame.add(long_comment);
		
		
		
		JButton sendReview = new JButton();
		
		sendReview.setBounds(475, 400, 100, 50);
		
		sendReview.setBackground(Color.YELLOW);
		
		review_frame.add(sendReview);
		
		sendReview.addActionListener(new ActionListener() {
			@Override public void actionPerformed(ActionEvent e) {
				JLabel new_comment = new JLabel();
				new_comment.setBounds(600, 100, 400, 800);
				review_frame.add(new_comment);
				
				final String author_comment = author.getText();
				final String gender_comment = gender.getText();
				final String shower_comment = shower.getText();
				final String sink_comment = sink.getText();
				final String paper_towels_comment = paper_towels.getText();
				final String location_comment = location.getText();
				final String building_comment = building.getText();
				final String floor_comment = floor.getText();
				final String hours_comment = hours.getText();
				final String long_comment_comment = long_comment.getText(); //lmfao nice variable names ;-))
				//addReviewToSide(review_frame);
				
				new_comment.setText(author_comment);
				//repaintJFrame();
			}
		} ) ;
		
		/*
		
		JButton addImages = new JButton();
		
		addImages.setBounds(375, 400, 100, 50);
		
		addImages.setBackground(Color.YELLOW);
		
		review_frame.add(addImages);
		
		*/
		
		return_to_login = new JButton();
		
		return_to_login.setBounds(25, 25, 25, 25);
		return_to_login.setBackground(Color.BLACK);
		review_frame.add(return_to_login);
		return_to_login.setVisible(true);
		
		return_to_login.addActionListener(new ActionListener() {
			@Override public void actionPerformed(ActionEvent e) {
				review_frame.setVisible(false);
				pottyGUI2.setVisible(true);
			}
			
		});	
		
	}
	
	/*
	public static void addReviewToSide(JFrame review_frame) {
		JLabel user_comment = new JLabel(author_comment);
		author_comment.setBounds(50, 50, 50, 50);
		review_frame.add(author_comment);
		
		/*
		final String author_comment = author.getText();
				final String gender_comment = gender.getText();
				final String shower_comment = shower.getText();
				final String sink_comment = sink.getText();
				final String paper_towels_comment = paper_towels.getText();
				final String location_comment = location.getText();
				final String building_comment = building.getText();
				final String floor_comment = floor.getText();
				final String hours_comment = hours.getText();
				final String long_comment_comment = long_comment.getText();
		
		
		
		
	}
	*/

	
	/*
	
	public static boolean is_button_added() {
		
		
		
		
	}
	
	public static void newReviewTable() {
		JTextField author = new JTextField();
		author.setBounds(300, 300, 300, 40);
		
		f.add(name);
		
		
		
		
		
	}
	
	public static void cathyReview() {
		JTextField author = new JTextField();
		author.setBounds(300, 300, 300, 40);
		
		f.add(name);
		
		
		
		
	}
	
	public static void hillmanReview() {
		
		
		
		
	}
	
	public static void peteReview() {
		
		
		
		
	}
	
	*/
	public static void displayMap(JFrame pottyGUI2) {
		ImageIcon image = new ImageIcon("C:\\Users\\micha\\Desktop\\_\\1530\\pitt_map.gif");
		JLabel imageLabel = new JLabel(image);
		pottyGUI2.add(imageLabel);
		imageLabel.setBounds(50, 50, 800, 800);
		imageLabel.setVisible(true);
		
		JLabel location_list = new JLabel("add hillman, cathy, or the pete(exactly as written).");
		location_list.setBounds(600, 5, 300, 200);
		pottyGUI2.add(location_list);
		location_list.setVisible(true);
		
		JTextField location_field = new JTextField();
		location_field.setBounds(50, 10, 100, 50);
		pottyGUI2.add(location_field);
		location_field.setVisible(true);
		
		final String request_location = location_field.getText();
			
		
		JButton the_pete = new JButton();
		the_pete.setBounds(100, 350, 25, 25);
		the_pete.setBackground(Color.YELLOW);
		imageLabel.add(the_pete);
		the_pete.setVisible(true);
		
		JButton hillman_button = new JButton();
		hillman_button.setBounds(575, 475, 25, 25);
		hillman_button.setBackground(Color.YELLOW);
		imageLabel.add(hillman_button);
		hillman_button.setVisible(true);
		
		JButton cathy_button = new JButton();
		cathy_button.setBounds(625, 300, 25, 25);
		cathy_button.setBackground(Color.YELLOW);
		imageLabel.add(cathy_button);
		cathy_button.setVisible(true);
		
		//if (request_location == "hillman")
			
		//if(request_location == "cathy")
			
		
		//if(request_location == "the pete" && !(the_pete.setVisible(true)))
			//the_pete.setVisible(true);
		//else {addReview();}
		
		return_to_login = new JButton();
		
		return_to_login.setBounds(25, 25, 25, 25);
		return_to_login.setBackground(Color.BLACK);
		imageLabel.add(return_to_login);
		return_to_login.setVisible(true);
		
		return_to_login.addActionListener(new ActionListener() {
			@Override public void actionPerformed(ActionEvent e) {
				pottyGUI2.setVisible(false);
				f.setVisible(true);
			}
			
		});	
		
		the_pete.addActionListener(new ActionListener() {
			@Override public void actionPerformed(ActionEvent e) {
				addReview(pottyGUI2);
			}
		} ) ;
		
		hillman_button.addActionListener(new ActionListener() {
			@Override public void actionPerformed(ActionEvent e) {
				addReview(pottyGUI2);
			}
		} ) ;
		
		
		
			cathy_button.addActionListener(new ActionListener() {
			@Override public void actionPerformed(ActionEvent e) {
				addReview(pottyGUI2);
			}
		} ) ;
		
		
	}
	
	public static void repaintJFrame () {

		f.setVisible(false);
		
		JFrame pottyGUI2 = new JFrame();
		
		pottyGUI2.setSize(1000, 1000);
		pottyGUI2.setLayout(null);
		pottyGUI2.setVisible(true);
		
		displayMap(pottyGUI2);
		
		//addReview(pottyGUI2);
		
		
	}
	
}