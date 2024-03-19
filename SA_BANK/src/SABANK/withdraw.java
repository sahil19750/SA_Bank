package SABANK;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.Date;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class withdraw extends JFrame implements ActionListener {
	JTextField withdraw;
	JButton withdrawl,back;
	String pinnumber;
	withdraw(String pinnumber){
		this.pinnumber = pinnumber;
		//this.pinnumber = pinnumber;

		ImageIcon i1 =  new ImageIcon(ClassLoader.getSystemResource("Images/atm.jpg"));
		Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		JLabel image = new JLabel(i3);
		image.setBounds(0, 0, 900, 900);
		add(image);

		JLabel text = new JLabel("Enter the amount you want to withdraw");
		text.setForeground(Color.white);
		text.setBounds(170,300,400,20);
		text.setFont(new Font("System",Font.BOLD,16));
		image.add(text);

		withdraw = new JTextField(); 
		withdraw.setFont(new Font("Raleway",Font.BOLD,14));
		withdraw.setBounds(170, 350, 320, 25);
		image.add(withdraw);


		withdrawl = new JButton("withdraw"); 
		withdrawl.setFont(new Font("Raleway",Font.BOLD,14));
		withdrawl.setBounds(355, 485, 150, 30);
		withdrawl.addActionListener(this);
		image.add(withdrawl);

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
		if(ae.getSource()==withdrawl) {
			String num = withdraw.getText();
			Date date = new Date();
			if(num.equals("")) {
				JOptionPane.showMessageDialog(null, "Please Enter the amount you want to withdraw");

			}
			try {
				double amount = Double.parseDouble(num);
			}
			catch(Exception e){
				JOptionPane.showMessageDialog(null, "Please Enter the valid amount");

			}
			if(Integer.parseInt(num)<0) {
				JOptionPane.showMessageDialog(null, "Please Enter the valid amount");
			}
			else{
				try {
					int balance = 0;
					datacon c = new datacon();
					ResultSet rs = c.stmt.executeQuery("select * from bank where pin = '"+pinnumber+"'");
					while (rs.next()) {
						if (rs.getString("type").equals("Deposit")) {
							balance += Integer.parseInt(rs.getString("amount"));
						} else {
							balance -= Integer.parseInt(rs.getString("amount"));
						}
					}
					
					if(balance > Integer.parseInt(num)) {
						String query = "insert into bank values('"+pinnumber+"','"+date+"','Withdrawl','"+num+"')";
						c.stmt.executeUpdate(query);
						JOptionPane.showMessageDialog(null, "Rs "+num+" withdraw Successfully");
						setVisible(false);
						new transaction(pinnumber).setVisible(true);
					}
					else {
						JOptionPane.showMessageDialog(null, " Transaction Failed! Insufficient Balance");

					}

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
		new withdraw("");
	}


}
