package framework.ui;

import framework.AccountFactory;
import framework.PartyFactory;
import framework.account.Account;
import framework.party.Party;

import java.awt.*;
import java.util.List;
import javax.swing.*;


public class JDialog_AddCompAcc extends JDialog
{
    private MainScreen main;
	private Object rowdata[];

	public JDialog_AddCompAcc(MainScreen main)
	{
		this.main = main;
		//{{ INIT_CONTROLS 
		setTitle("Add compamy account");
		setModal(true);
		getContentPane().setLayout(null);
		setSize(298,339);
		setVisible(false);
		JLabel1.setText("Name");
		getContentPane().add(JLabel1);
		JLabel1.setForeground(Color.black);
		JLabel1.setBounds(12,96,48,24);
		JLabel2.setText("Street");
		getContentPane().add(JLabel2);
		JLabel2.setForeground(Color.black);
		JLabel2.setBounds(12,120,48,24);
		JLabel3.setText("City");
		getContentPane().add(JLabel3);
		JLabel3.setForeground(Color.black);
		JLabel3.setBounds(12,144,48,24);
		JLabel4.setText("State");
		getContentPane().add(JLabel4);
		JLabel4.setForeground(Color.black);
		JLabel4.setBounds(12,168,48,24);
		JLabel5.setText("Zip");
		getContentPane().add(JLabel5);
		JLabel5.setForeground(Color.black);
		JLabel5.setBounds(12,192,48,24);
		JLabel6.setText("No of employees");
		getContentPane().add(JLabel6);
		JLabel6.setForeground(Color.black);
		JLabel6.setBounds(12,216,96,24);
		JLabel7.setText("Email");
		getContentPane().add(JLabel7);
		JLabel7.setForeground(Color.black);
		JLabel7.setBounds(12,240,48,24);
		getContentPane().add(JTextField_NAME);
		JTextField_NAME.setBounds(120,96,156,20);
		getContentPane().add(JTextField_CT);
		JTextField_CT.setBounds(120,144,156,20);
		getContentPane().add(JTextField_ST);
		JTextField_ST.setBounds(120,168,156,20);
		getContentPane().add(JTextField_STR);
		JTextField_STR.setBounds(120,120,156,20);
		getContentPane().add(JTextField_ZIP);
		JTextField_ZIP.setBounds(120,192,156,20);
		getContentPane().add(JTextField_EM);
		JTextField_EM.setBounds(120,240,156,20);

		JButton_OK.setText("OK");
		JButton_OK.setActionCommand("OK");
		getContentPane().add(JButton_OK);
		JButton_OK.setBounds(48,276,84,24);

		JButton_Calcel.setText("Cancel");
		JButton_Calcel.setActionCommand("Cancel");
		getContentPane().add(JButton_Calcel);
		JButton_Calcel.setBounds(156,276,84,24);

		JLabel8.setText("Acc Nr");
		getContentPane().add(JLabel8);
		JLabel8.setForeground(Color.black);
		JLabel8.setBounds(12,72,48,24);
		getContentPane().add(JTextField_ACNR);
		JTextField_ACNR.setBounds(120,72,156,20);
		//}}
	
		//{{REGISTER_LISTENERS
		SymAction lSymAction = new SymAction();
		JButton_OK.addActionListener(lSymAction);
		JButton_Calcel.addActionListener(lSymAction);
		//}}
	}


	//{{DECLARE_CONTROLS
	JLabel JLabel1 = new JLabel();
	JLabel JLabel2 = new JLabel();
	JLabel JLabel3 = new JLabel();
	JLabel JLabel4 = new JLabel();
	JLabel JLabel5 = new JLabel();
	JLabel JLabel6 = new JLabel();
	JLabel JLabel7 = new JLabel();
	JTextField JTextField_NAME = new JTextField();
	JTextField JTextField_CT = new JTextField();
	JTextField JTextField_ST = new JTextField();
	JTextField JTextField_STR = new JTextField();
	JTextField JTextField_ZIP = new JTextField();
	JTextField JTextField_EM = new JTextField();
	JButton JButton_OK = new JButton();
	JButton JButton_Calcel = new JButton();
	JLabel JLabel8 = new JLabel();
	JTextField JTextField_ACNR = new JTextField();
	//}}


	class SymAction implements java.awt.event.ActionListener
	{
		public void actionPerformed(java.awt.event.ActionEvent event)
		{
			Object object = event.getSource();
			if (object == JButton_OK)
				JButtonOK_actionPerformed(event);
			else if (object == JButton_Calcel)
				JButtonCalcel_actionPerformed(event);
		}
	}

	void JButtonOK_actionPerformed(java.awt.event.ActionEvent event)
	{
		String accountNumber = JTextField_ACNR.getText();
		String name = JTextField_NAME.getText();
		String street = JTextField_STR.getText();
		String city = JTextField_CT.getText();
		String state = JTextField_ST.getText();
		int zip = Integer.parseInt(JTextField_ZIP.getText());
		String email = JTextField_EM.getText();

		Party newCompany = PartyFactory.createCompany(name, street, city, state, zip, email);

		List<Party> parties = main.finCo.getParties();
		List<Account> accounts = main.finCo.getAccounts();

		if (!parties.contains(newCompany)) {
			parties.add(newCompany);
		} else {
			int index = parties.indexOf(newCompany);
			newCompany = parties.get(index);
		}

		Account account = AccountFactory.getInstance().createAccount(newCompany, accountNumber);
		newCompany.addAccount(account);
		accounts.add(account);
		rowdata = new Object[main.model.getColumnCount()];
		rowdata[0] = account.getAccountNumber();
		rowdata[1] = newCompany.getName();
		rowdata[2] = newCompany.getCity();
		rowdata[3] = newCompany.getState();
		rowdata[4] = newCompany.getClass().getSimpleName();
		rowdata[5] = "0";
		main.model.addRow(rowdata);

		dispose();
	}

	void JButtonCalcel_actionPerformed(java.awt.event.ActionEvent event)
	{
		dispose();
	}
}