package creditcard.ui;

import java.awt.*;
import java.time.LocalDate;

import javax.swing.*;

import creditcard.CCAccount;
import framework.account.Account;
import framework.account.IAccount;
import framework.account.entry.Entry;
import framework.account.entry.IEntry;
import framework.party.Custormer;

public class JDialogGenBill extends javax.swing.JDialog
{
	private CardFrm cardFrm;
    
	public JDialogGenBill(CardFrm cardFrm)
	{
		this.cardFrm = cardFrm;
		// This code is automatically generated by Visual Cafe when you add
		// components to the visual environment. It instantiates and initializes
		// the components. To modify the code, only use code syntax that matches
		// what Visual Cafe can generate, or Visual Cafe may be unable to back
		// parses  your Java file into its visual envirenment. 
		//{{ INIT_CONTROLS 
		getContentPane().setLayout(null);
		setSize(405,367);
		setVisible(false);
		getContentPane().add(JScrollPane1);
		JScrollPane1.setBounds(24,24,358,240);
		JScrollPane1.getViewport().add(JTextField1);
		JTextField1.setBounds(0,0,355,237);
		JButton_OK.setText("OK");
		JButton_OK.setActionCommand("OK");
		getContentPane().add(JButton_OK);
		JButton_OK.setBounds(156,276,96,24);

		// generate the string for the monthly bill
		
		String billstring = "";
		double previousBalance, totalCharges, totalCredits, newBalance;
		for(Custormer party: cardFrm.getFinCo().getParties()) {
			for(IAccount account: party.getAccounts()) {
				previousBalance = 0; totalCharges = 0; totalCredits = 0; newBalance = 0;
				CCAccount ccAccount = (CCAccount)account;
				
				for(IEntry entry: ccAccount.getEntries()) {
					if(entry.getDate().getMonthValue()<LocalDate.now().getMonthValue()) {
						previousBalance += entry.getAmount();
					}
					if(entry.getDate().getMonthValue()==LocalDate.now().getMonthValue()) {
						if(entry.getName().equals("Withdraw Money")) totalCharges += -1 * entry.getAmount();
						else if(entry.getName().equals("Deposit Money")) totalCredits += entry.getAmount();
					}
				}
				
				newBalance = (previousBalance-totalCredits+totalCharges+ccAccount.getInterestRate()*(previousBalance-totalCredits));
				
				billstring += "Name= "+party.getName()+"\r\n";
				billstring += "CC number = "+ccAccount.getAccountNumber()+"\r\n";
				billstring += "CC number = "+ccAccount.getType()+"\r\n";
				billstring += "Total Credits = $"+totalCredits+"\r\n";
				billstring += "Total Charges = $"+totalCharges+"\r\n";
				billstring += "New balance = $"+newBalance+"\r\n";
				billstring += "Total amount due = $"+ccAccount.getMP()*newBalance+"\r\n";
				billstring += "\r\n";		
				billstring += "\r\n";
			}
		}
		
		JTextField1.setText(billstring);
		
		SymAction lSymAction = new SymAction();
		JButton_OK.addActionListener(lSymAction);
	}

	//{{DECLARE_CONTROLS
	javax.swing.JScrollPane JScrollPane1 = new javax.swing.JScrollPane();
	javax.swing.JTextArea JTextField1 = new javax.swing.JTextArea();
	javax.swing.JButton JButton_OK = new javax.swing.JButton();
	//}}


	class SymAction implements java.awt.event.ActionListener
	{
		public void actionPerformed(java.awt.event.ActionEvent event)
		{
			Object object = event.getSource();
			if (object == JButton_OK)
				JButtonOK_actionPerformed(event);
		}
	}

	void JButtonOK_actionPerformed(java.awt.event.ActionEvent event)
	{
		dispose();
			 
	}
}
