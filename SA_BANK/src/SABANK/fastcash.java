package SABANK;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.awt.*;

import javax.swing.*;
import java.util.Date;

public class fastcash extends JFrame implements ActionListener {
	
	JButton deposit,withdrawl,fastcash,mini,pinchange,exit,balance;
	String pinnumber ;
	
	fastcash(String pinnumber){
		this.pinnumber = pinnumber;
		
		ImageIcon i1 =  new ImageIcon(ClassLoader.getSystemResource("Images/atm.jpg"));
		Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		JLabel image = new JLabel(i3);
		image.setBounds(0, 0, 900, 900);
		add(image);
		
		JLabel text = new JLabel("Please select your Transaction");
		text.setForeground(Color.white);
		text.setBounds(210,300,700,35);
		text.setFont(new Font("System",Font.BOLD,16));
		image.add(text);
		
		
		deposit = new JButton("100");
		deposit.setBounds(170, 415, 150, 30);
		deposit.addActionListener(this);
		image.add(deposit);
		
		withdrawl = new JButton("200");
		withdrawl.setBounds(355, 415, 150, 30);
		withdrawl.addActionListener(this);
		image.add(withdrawl);
		
		fastcash = new JButton("500");
		fastcash.setBounds(170, 450, 150, 30);
		fastcash.addActionListener(this);
		image.add(fastcash);
		
		mini = new JButton("1000");
		mini.setBounds(355, 450, 150, 30);
		mini.addActionListener(this);
		image.add(mini);
		
		pinchange = new JButton("5000");
		pinchange.setBounds(170, 485, 150, 30);
		pinchange.addActionListener(this);
		image.add(pinchange);
		
		balance = new JButton("10000");
		balance.setBounds(355, 485, 150, 30);
		balance.addActionListener(this);
		image.add(balance);
		
		exit = new JButton("Exist");
		exit.setBounds(355, 520, 150, 30);
		exit.addActionListener(this);
		image.add(exit);
		
		
		setLayout(null);
		setSize(900,900);
		setLocation(300,0);
		setUndecorated(true);
		setVisible(true);
		
		
	}
	
	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource()==exit) {
			setVisible(false);
			new transaction(pinnumber).setVisible(true);
		}
		else {
			String amount = ((JButton)ae.getSource()).getText().substring(3);
			datacon c = new datacon();
			try {
				int balance = 0;
				ResultSet rs = c.stmt.executeQuery("select * from sbank where pin ='"+pinnumber+"'");
				while (rs.next()) {
	                if (rs.getString("mode").equals("Deposit")) {
	                    balance += Integer.parseInt(rs.getString("amount"));
	                } else {
	                    balance -= Integer.parseInt(rs.getString("amount"));
	                }
	            } String num = "17";
	            if (ae.getSource() != exit && balance < Integer.parseInt(amount)) {
	                JOptionPane.showMessageDialog(null, "Insuffient Balance");
	                return;
	            }

	            if (ae.getSource() == exit) {
	                this.setVisible(false);
	                new transaction(pinnumber).setVisible(true);
	            }
	            else{
	                Date date = new Date();
	                c.stmt.executeUpdate("insert into bank values('"+pinnumber+"', '"+date+"', 'Withdrawl', '"+amount+"')");
	                JOptionPane.showMessageDialog(null, "Rs. "+amount+" Debited Successfully");
	                    
	                setVisible(false);
	                new transaction(pinnumber).setVisible(true);
	            }
				
			}
			catch(Exception e) {
				
			}
		}
	}
	
	public static void main(String[] args) {
		new fastcash("");
	}

}
