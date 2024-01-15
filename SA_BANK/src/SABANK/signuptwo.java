package SABANK;
import java.awt.Color;
import java.awt.Font;
import java.util.*;

import javax.swing.*;

import java.awt.event.*;


public class signuptwo extends JFrame implements ActionListener{

	JRadioButton yes,no,eyes,eno;
	JTextField panfield,addharfield;
	JButton next;
	JComboBox Occupation,religion,categorybox,Income,education,Qualification;
	String formno ;
	
	signuptwo(String formno){
		this.formno = formno;
		setTitle("New Account Form page.....2");
		
		setLayout(null);
				
		JLabel additiondetails = new JLabel("Page 2: Addition Details");
		additiondetails.setFont(new Font("Raleway",Font.BOLD,22));
		additiondetails.setBounds(270, 80, 400, 30);
		add(additiondetails);
		
		JLabel Religion = new JLabel("Religion:");
		Religion.setFont(new Font("Raleway",Font.BOLD,22));
		Religion.setBounds(100, 140, 200, 30);
		Religion.setBackground(Color.white);
		add(Religion);
		
		String[] rel = {"Hindu","Muslim","Sikh","Christian","Others"};
		
		religion  = new JComboBox(rel); 
		religion.setBounds(300,140,400,30);
		add(religion);
		
		
		JLabel category = new JLabel("Category:");
		category.setFont(new Font("Raleway",Font.BOLD,22));
		category.setBounds(100, 190, 200, 30);
		add(category);
		
		String[] cat = {"General","Obc","Sc","St","Others"};
		categorybox = new JComboBox(cat);
		categorybox.setBounds(300, 190, 400, 30);
		categorybox.setBackground(Color.white);
		add(categorybox);
		
		JLabel income = new JLabel("Income:");
		income.setFont(new Font("Raleway",Font.BOLD,22));
		income.setBounds(100, 240, 200, 30);
		add(income);
		
		String[] incomecat = {"Null","<1,50,000","<2,50,000","<5,00,000","Up to 10,00,000"};
	    Income = new JComboBox(incomecat);
		Income.setBounds(300, 240, 400, 30);
		Income.setBackground(Color.white);
		add(Income);
		
		JLabel educational = new JLabel("Educational");
		educational.setFont(new Font("Raleway",Font.BOLD,22));
		educational.setBounds(100, 290, 200, 30);
		add(educational);
			
		JLabel qualification = new JLabel("Qualification:");
		qualification.setFont(new Font("Raleway",Font.BOLD,22));
		qualification.setBounds(100, 315, 200, 30);
		add(qualification);
		
		String[] qual = {"10th passed","12th Passed","Graduation","Post Graduation","Phd","Others"};
		Qualification = new JComboBox(qual);
		Qualification.setBounds(300, 300, 400, 30);
		Qualification.setBackground(Color.white);
		add(Qualification);
			
		JLabel occupation = new JLabel("Occupation:");
		occupation.setFont(new Font("Raleway",Font.BOLD,22));
		occupation.setBounds(100, 365, 200, 30);
		add(occupation);
		
		String[] occu = {"Salaried","Self Employed","Bussiness","Student","Retired","Others"};
		Occupation = new JComboBox(occu);
		Occupation.setBounds(300, 365, 400, 30);
		Occupation.setBackground(Color.white);
		add(Occupation);
			
		JLabel panno = new JLabel("Pan No:");
		panno.setFont(new Font("Raleway",Font.BOLD,22));
		panno.setBounds(100, 415, 200, 30);
		add(panno);
		
		panfield = new JTextField(); 
		panfield.setFont(new Font("Raleway",Font.BOLD,14));
		panfield.setBounds(300, 415, 400, 30);
		add(panfield);
		
		JLabel addhar = new JLabel("Addhaar No:");
		addhar.setFont(new Font("Raleway",Font.BOLD,22));
		addhar.setBounds(100,465, 200, 30);
		add(addhar);
		
		addharfield = new JTextField(); 
		addharfield.setFont(new Font("Raleway",Font.BOLD,14));
		addharfield.setBounds(300, 465, 400, 30);
		add(addharfield);
		
		JLabel senior = new JLabel("Senior Citizen :");
		senior.setFont(new Font("Raleway",Font.BOLD,22));
		senior.setBounds(100, 515, 200, 30);
		add(senior);
		
		yes = new JRadioButton("Yes");
		yes.setFont(new Font("Raleway",Font.BOLD,14));
		yes.setBounds(300, 515, 100, 30);
		add(yes);
		
		no = new JRadioButton("No");
		no.setFont(new Font("Raleway",Font.BOLD,14));
		no.setBounds(400, 515, 100, 30);
		add(no);
		
		ButtonGroup sen = new ButtonGroup();
		sen.add(yes);
		sen.add(no);
		
		
		JLabel exist = new JLabel("Existing Account:");
		exist.setFont(new Font("Raleway",Font.BOLD,22));
		exist.setBounds(100, 565, 200, 30);
		add(exist);
		
		eyes = new JRadioButton("Yes");
		eyes.setFont(new Font("Raleway",Font.BOLD,14));
		eyes.setBounds(300, 565, 100, 30);
		add(eyes);
		
		eno = new JRadioButton("No");
		eno.setFont(new Font("Raleway",Font.BOLD,14));
		eno.setBounds(400, 565, 100, 30);
		add(eno);
		
		ButtonGroup ex = new ButtonGroup();
		ex.add(eyes);
		ex.add(eno);
		
		next = new JButton("NEXT");
		next.setBackground(Color.black);
		next.setForeground(Color.white);
		next.setFont(new Font("Raleway",Font.BOLD,14));
		next.setBounds(620,620,120,30);
		next.addActionListener(this);
		add(next);
		
		getContentPane().setBackground(Color.WHITE);
		setSize(850,800);
		setLocation(350,10);
		setVisible(true);
		
	}
	
	
	public void actionPerformed(ActionEvent ae) {
		
		String sreligion = (String)religion.getSelectedItem();
		String scategorybox = (String)categorybox.getSelectedItem();
		String sIncome = (String)Income.getSelectedItem();
		String sQualification = (String)Qualification.getSelectedItem();
		String sOccupation = (String)Occupation.getSelectedItem();
		String Pan = panfield.getText();
		String Addhar = addharfield.getText();
		String Senior ;
		
		if(yes.isSelected()) {
			Senior = "Yes";
		}
		else if(no.isSelected()) {
			Senior = "No";
		}
		else {
			Senior = "";
		}
		
		String Exist ;
		
		if(eyes.isSelected()) {
			Exist = "Yes";
		}
		else if(eno.isSelected()) {
			Exist = "No";
		}
		else {
			Exist = "";
		}
			
		
		try {
			if(sreligion.equals("")) {
				JOptionPane.showMessageDialog(null, "Religion can't be empty ");
			}
			else if(scategorybox.equals("")) {
				JOptionPane.showMessageDialog(null, "Category can't be empty ");
			}
			else if(sIncome.equals("")) {
				JOptionPane.showMessageDialog(null, " Select the Income ");
			}
			else if(sQualification.equals("")) {
				JOptionPane.showMessageDialog(null, "Select the Educational qualification ");
			}
			else if(sOccupation.equals("")) {
				JOptionPane.showMessageDialog(null, "Select the Occupation ");
			}
			else if(Pan.equals("")) {
				JOptionPane.showMessageDialog(null, "Pan No. can't be empty ");
			}
			else if(Addhar.equals("")) {
				JOptionPane.showMessageDialog(null, "Addhar no can't be empty ");
			}
			else if(Senior.equals("")) {
				JOptionPane.showMessageDialog(null, "Select the Senior Citizen Yes/No ");
			}
			else if(Exist.equals("")) {
				JOptionPane.showMessageDialog(null, "Select the Account Exist Yes/No ");
			}
			else {
				
				datacon c = new datacon();
				String query = "Insert Into signuptwo Values('"+formno+"','"+sreligion+"','"+scategorybox+"','"+sIncome+"','"+sQualification+"','"+sOccupation+"','"+Pan+"','"+Addhar+"','"+Senior+"','"+Exist+"')";
				c.stmt.executeUpdate(query);
				setVisible(false);
				new signupthree(formno).setVisible(true);
			}
			
		}
		catch(Exception e) {
			System.out.println(e);
		}
		
		
	}

	public static void main(String[] args) {
		new signuptwo("");
		
	}

}

