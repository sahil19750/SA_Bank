package SABANK;
import java.awt.Color;



import java.awt.Font;
import java.util.*;

import javax.swing.*;

import com.toedter.calendar.JDateChooser;

import SABANK.signuptwo;

import java.awt.event.*;

public class signupone extends JFrame implements ActionListener {
	
	JRadioButton male,female,married,unmarried,others;
	JTextField namefield,fnamefield,emailfield,addressfield,statefield,phonefield,pinfield;
	JButton next;
	JDateChooser datechooser;
	Long random;
	
	signupone(){
		
		setLayout(null);
		
		Random ran = new Random();
		random = Math.abs((ran.nextLong()%900L)+100L);
	//	System.out.println(ran);
		JLabel formno = new JLabel("APPLICATION FORM NO."+random);
		formno.setFont(new Font("Raleway",Font.BOLD,38));
		formno.setBounds(140, 20, 600, 40);
		add(formno);
		
		JLabel personaldetails = new JLabel("Page 1: Personal Details");
		personaldetails.setFont(new Font("Raleway",Font.BOLD,22));
		personaldetails.setBounds(270, 80, 400, 30);
		add(personaldetails);
		
		JLabel name = new JLabel("Name:");
		name.setFont(new Font("Raleway",Font.BOLD,22));
		name.setBounds(100, 140, 200, 30);
		add(name);
		
		namefield = new JTextField(); 
		namefield.setFont(new Font("Raleway",Font.BOLD,14));
		namefield.setBounds(300, 140, 400, 30);
		add(namefield);
		
		JLabel fathername = new JLabel("Father's Name:");
		fathername.setFont(new Font("Raleway",Font.BOLD,22));
		fathername.setBounds(100, 190, 200, 30);
		add(fathername);
		
		fnamefield = new JTextField(); 
		fnamefield.setFont(new Font("Raleway",Font.BOLD,14));
		fnamefield.setBounds(300, 190, 400, 30);
		add(fnamefield);
		
		JLabel DOB = new JLabel("D.O.B:");
		DOB.setFont(new Font("Raleway",Font.BOLD,22));
		DOB.setBounds(100, 240, 200, 30);
		add(DOB);
		
		datechooser = new JDateChooser();
		datechooser.setBounds(300,240,400,30); 
		datechooser.setForeground(Color.black);
		add(datechooser);
		
		JLabel gender = new JLabel("Gender:");
		gender.setFont(new Font("Raleway",Font.BOLD,22));
		gender.setBounds(100, 290, 200, 30);
		add(gender);
		
		male = new JRadioButton("MALE");
		male.setBounds(300,290,60,30);
		male.setBackground(Color.white);
		add(male);
		
		female = new JRadioButton("FEMALE");
		female.setBounds(450,290,120,30);
		female.setBackground(Color.white);
		add(female);
		
		ButtonGroup gendergroup = new ButtonGroup();
		gendergroup.add(female);
		gendergroup.add(male);
			
		JLabel email = new JLabel("Email:");
		email.setFont(new Font("Raleway",Font.BOLD,22));
		email.setBounds(100, 340, 200, 30);
		add(email);
		
		emailfield = new JTextField(); 
		emailfield.setFont(new Font("Raleway",Font.BOLD,14));
		emailfield.setBounds(300, 340, 400, 30);
		add(emailfield);
		
		JLabel marital = new JLabel("Marital status:");
		marital.setFont(new Font("Raleway",Font.BOLD,22));
		marital.setBounds(100, 390, 200, 30);
		add(marital);
		
		married = new JRadioButton("Married");
		married.setBounds(300,390,100,30);
		married.setBackground(Color.white);
		add(married);
		
		unmarried = new JRadioButton("Unmarried");
		unmarried.setBounds(450,390,100,30);
		unmarried.setBackground(Color.white);
		add(unmarried);
		
		others = new JRadioButton("Others");
		others.setBounds(630,390,100,30);
		others.setBackground(Color.white);
		add(others);
		
		ButtonGroup maritalgroup = new ButtonGroup();
		maritalgroup.add(married);
		maritalgroup.add(unmarried);
		maritalgroup.add(others);
		
		JLabel address = new JLabel("Address:");
		address.setFont(new Font("Raleway",Font.BOLD,22));
		address.setBounds(100, 440, 200, 30);
		add(address);
		
		addressfield = new JTextField(); 
		addressfield.setFont(new Font("Raleway",Font.BOLD,14));
		addressfield.setBounds(300, 440, 400, 30);
		add(addressfield);
		
		JLabel state = new JLabel("State:");
		state.setFont(new Font("Raleway",Font.BOLD,22));
		state.setBounds(100,490, 200, 30);
		add(state);
		
		statefield = new JTextField(); 
		statefield.setFont(new Font("Raleway",Font.BOLD,14));
		statefield.setBounds(300, 490, 400, 30);
		add(statefield);
		
		JLabel pincode = new JLabel("Pincode:");
		pincode.setFont(new Font("Raleway",Font.BOLD,22));
		pincode.setBounds(100, 540, 200, 30);
		add(pincode);
		
		pinfield = new JTextField(); 
		pinfield.setFont(new Font("Raleway",Font.BOLD,14));
		pinfield.setBounds(300, 540, 400, 30);
		add(pinfield);
		
		JLabel phoneno = new JLabel("Phone No:");
		phoneno.setFont(new Font("Raleway",Font.BOLD,22));
		phoneno.setBounds(100, 590, 200, 30);
		add(phoneno);
		
	    phonefield = new JTextField(); 
		phonefield.setFont(new Font("Raleway",Font.BOLD,14));
		phonefield.setBounds(300, 590, 400, 30);
		add(phonefield);
		
		next = new JButton("NEXT");
		next.setBackground(Color.black);
		next.setForeground(Color.white);
		next.setFont(new Font("Raleway",Font.BOLD,14));
		next.setBounds(620,660,80,20);
		next.addActionListener(this);
		add(next);
		
		getContentPane().setBackground(Color.WHITE);
		setSize(850,800);
		setLocation(350,10);
		setVisible(true);
		
	}
	
	
	public void actionPerformed(ActionEvent ae) {
		
		String formno = ""+random;
		String name = namefield.getText();
		String fname = fnamefield.getText();
		String dob = ((JTextField)datechooser.getDateEditor().getUiComponent()).getText();
		String gender ;
		
		if(male.isSelected()) {
			gender = "Married";
		}
		else if(female.isSelected()) {
			gender = "Unmarried";
		}
		else {
			gender = "";
		}
		
		String email = emailfield.getText();
		String marital = null;
		if(married.isSelected()) {
			marital = "Married";
		}
		else if(unmarried.isSelected()) {
			marital = "Unmarried";
		}
		else if(others.isSelected()) {
			marital = "Other";
		}
		else {
			marital = "";
		}
		
		String address = addressfield.getText();
		String state = statefield.getText();
		String pincode = pinfield.getText();
		String phoneno = phonefield.getText();
		
		String regex = ".*[0-9\\W_].*";

		try {
			if(name.equals("") ||  name.matches(regex)) {
				
				JOptionPane.showMessageDialog(null, "Name can't be empty ");
			}
			else if(fname.equals("")) {
				JOptionPane.showMessageDialog(null, "Father's Name can't be empty ");
			}
			else if(dob.equals("")) {
				JOptionPane.showMessageDialog(null, "DOB can't be empty ");
			}
			else if(gender.equals("")) {
				JOptionPane.showMessageDialog(null, "Please Select the gender ");
			}
			else if(email.equals("")) {
				JOptionPane.showMessageDialog(null, "Email can't be empty ");
			}
			else if(marital.equals("")) {
				JOptionPane.showMessageDialog(null, "Please select the Marital status ");
			}
			else if(address.equals("")) {
				JOptionPane.showMessageDialog(null, "address can't be empty ");
			}
			else if(state.equals("")) {
				JOptionPane.showMessageDialog(null, "State can't be empty ");
			}
			else if(pincode.equals("")) {
				JOptionPane.showMessageDialog(null, "Please Enter the pincode ");
			}
			else if(phoneno.equals("")) {
				JOptionPane.showMessageDialog(null, "Please enter the mobile number ");
			}
			else {
				
				datacon c = new datacon();
				String query = "Insert Into signup Values('"+formno+"','"+name+"','"+fname+"','"+dob+"','"+gender+"','"+email+"','"+marital+"','"+address+"','"+state+"','"+pincode+"','"+phoneno+"')";
				c.stmt.executeUpdate(query);
				setVisible(false);
				new signuptwo(formno).setVisible(true);
			}
			
		}
		catch(Exception e) {
			System.out.println(e);
		}
		
		
	}

	public static void main(String[] args) {
		new signupone();
		
	}

}
