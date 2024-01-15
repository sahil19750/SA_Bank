package SABANK;

import java.awt.event.ActionEvent;

import java.awt.event.ActionListener;
import java.awt.*;

import javax.swing.*;

public class transaction extends JFrame implements ActionListener {
	
	JButton deposit,withdrawl,fastcash,mini,pinchange,exit,balance;
	String pinnumber ;
	
	transaction(String pinnumber){
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
		
		
		deposit = new JButton("Deposit");
		deposit.setBounds(170, 415, 150, 30);
		deposit.addActionListener(this);
		image.add(deposit);
		
		withdrawl = new JButton("Withdrawl");
		withdrawl.setBounds(355, 415, 150, 30);
		withdrawl.addActionListener(this);
		image.add(withdrawl);
		
		fastcash = new JButton("Fast Cash");
		fastcash.setBounds(170, 450, 150, 30);
		fastcash.addActionListener(this);
		image.add(fastcash);
		
		mini = new JButton("Mini Statement");
		mini.setBounds(355, 450, 150, 30);
		mini.addActionListener(this);
		image.add(mini);
		
		pinchange = new JButton("Pin Change");
		pinchange.setBounds(170, 485, 150, 30);
		pinchange.addActionListener(this);
		image.add(pinchange);
		
		balance = new JButton("Balance Enquiry");
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
			System.exit(0);
		}
		else if(ae.getSource()==deposit) {
			setVisible(false);
			new deposit(pinnumber).setVisible(true);
		}
		else if(ae.getSource()==withdrawl) {
			setVisible(false);
			new withdraw(pinnumber).setVisible(true);
		}
		else if(ae.getSource()==fastcash) {
			setVisible(false);
			new fastcash(pinnumber).setVisible(true);
		}
		else if(ae.getSource()==pinchange) {
			setVisible(false);
			new Pin(pinnumber).setVisible(true);
		}
		else if(ae.getSource()==balance) {
			setVisible(false);
			new BalanceEnquiry(pinnumber).setVisible(true);
		}
		else if(ae.getSource()==mini) {

			new ministatement(pinnumber).setVisible(true);
		}
		
	}
	
	public static void main(String[] args) {
		new transaction("");
	}

}
