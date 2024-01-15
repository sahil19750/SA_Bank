package SABANK;

import java.awt.*;

import java.sql.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

import javax.swing.*;

	public class deposit extends JFrame implements ActionListener{
		JTextField amount;
		JButton deposit,back;
		String pinnumber;
		deposit(String pinnumber){
			this.pinnumber = pinnumber;
			//this.pinnumber = pinnumber;
			
			ImageIcon i1 =  new ImageIcon(ClassLoader.getSystemResource("Images/atm.jpg"));
			Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
			ImageIcon i3 = new ImageIcon(i2);
			JLabel image = new JLabel(i3);
			image.setBounds(0, 0, 900, 900);
			add(image);
			
			JLabel text = new JLabel("Enter the amount you want to Deposit");
			text.setForeground(Color.white);
			text.setBounds(170,300,400,20);
			text.setFont(new Font("System",Font.BOLD,16));
			image.add(text);
			
			amount = new JTextField(); 
			amount.setFont(new Font("Raleway",Font.BOLD,14));
			amount.setBounds(170, 350, 320, 25);
			image.add(amount);
			
			
			deposit = new JButton("Deposit"); 
			deposit.setFont(new Font("Raleway",Font.BOLD,14));
			deposit.setBounds(355, 485, 150, 30);
			deposit.addActionListener(this);
			image.add(deposit);
			
			back = new JButton("Back"); 
			back.setFont(new Font("Raleway",Font.BOLD,14));
			back.setBounds(355, 520, 150, 30);
			back.addActionListener(this);
			image.add(back);

		
			setLayout(null);
			setSize(900,900);
			setLocation(300,0);
			setUndecorated(true);
			setVisible(true);
			
		
	}
	
	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource()==deposit) {
			String num = amount.getText();
			Date date = new Date();
			if(num.equals("")) {
				JOptionPane.showMessageDialog(null, "Please Enter the amount you want to deposit");

			}
			else{
				try {
					datacon c = new datacon();
                    String query = "insert into bank values('"+pinnumber+"','"+date+"','Deposit','"+num+"')";
					c.stmt.executeUpdate(query);
					JOptionPane.showMessageDialog(null, "Rs "+num+" Deposited Successfully");
					setVisible(false);
					new transaction(pinnumber).setVisible(true);

				}
				catch(Exception e) {
					System.out.println(e);
				}
			}
		}
		else if(ae.getSource()==back) {
			setVisible(true);
			new transaction(pinnumber).setVisible(true);
		}
	}
	

	public static void main(String[] args) {
		new deposit("");
	}


}