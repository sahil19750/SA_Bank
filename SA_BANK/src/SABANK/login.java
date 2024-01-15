package SABANK;
import java.awt.Color;


import java.awt.Font;
import java.awt.Image;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;

public class login extends JFrame implements ActionListener{
	
	JButton signup,clear,login;
	JTextField cardTextField;
	JPasswordField pinTextField;
	
	login(){
		
		setLayout(null); 
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("Images/bankicon.jpg"));
		Image i2 = i1.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		JLabel label = new JLabel(i3);
		label.setBounds(70, 10, 100, 100);

		add(label);
		
		JLabel text = new JLabel("Wecome To SBANK");
		text.setBounds(200, 40, 400, 40);
		text.setFont(new Font("Oswald",Font.BOLD,38));
		add(text);	
		
		JLabel cardno = new JLabel("Card No :");
		cardno.setBounds(120, 150, 150, 30);
		cardno.setFont(new Font("Raleway",Font.BOLD,28));
		add(cardno);
		
		cardTextField = new JTextField();
		cardTextField.setBounds(300, 150, 230, 30);
		cardTextField.setFont(new Font("Aeria",Font.BOLD,14));
		add(cardTextField); 
		
		JLabel pin = new JLabel("Pin No    :");
		pin.setBounds(120, 220, 250, 40);
		pin.setFont(new Font("Raleway",Font.BOLD,28));
		add(pin);
		
		pinTextField = new JPasswordField();
		pinTextField.setBounds(300, 220, 230, 30);
		pinTextField.setFont(new Font("Aeria",Font.BOLD,14));
		add(pinTextField);
		
		
		login = new JButton("SIGN IN");
		login.setBounds(300, 280, 100, 30);
		login.setBackground(Color.black);
		login.setForeground(Color.white);
		login.addActionListener(this);
		add(login);
		
		clear = new JButton("CLEAR");
		clear.setBounds(430, 280, 100, 30);
		clear.setBackground(Color.black);
		clear.setForeground(Color.white);
		clear.addActionListener(this);
		add(clear);
		
		signup = new JButton("SIGN UP");
		signup.setBounds(300, 330, 230, 30);
		signup.setBackground(Color.black);
		signup.setForeground(Color.white);
		signup.addActionListener(this);
		add(signup);
		
		getContentPane().setBackground(Color.white);
		setTitle("SBANK");
		setSize(800,480);
		setVisible(true);
		setLocation(300,200);
	}
	
	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource()==clear) {
			cardTextField.setText("");
			pinTextField.setText("");
		}
		else if(ae.getSource()==login) {
			datacon c = new datacon();
			String cardnumber = cardTextField.getText();
			String pinnumber = pinTextField.getText();
			String query = "select * from login where cardnumber = '"+cardnumber+"'and pin = '"+pinnumber+"'";
		try {	
			ResultSet rs = c.stmt.executeQuery(query);
			if(rs.next()) {
				setVisible(false);
				new transaction(pinnumber).setVisible(true);
			}
			else {
				JOptionPane.showMessageDialog(null,"Incorrect Atm number or pin "); 
			}
		}
		catch(Exception e){
			System.out.println(e);
		}
		}
		else if(ae.getSource()==signup) {
			setVisible(false);
			new signupone().setVisible(true);
		}
		
	}

	public static void main(String[] args) {
		new login();
	}

}
