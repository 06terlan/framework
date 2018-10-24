package banking.ui;

import banking.BankAccount;
import banking.Banking;
import creditcard.CCAccount;
import framework.FinCo;
import framework.account.Account;
import framework.ui.MainScreen;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.WindowEvent;

/**
 * A basic JFC based application.
 **/
public class BankFrm extends MainScreen
{
    private DefaultTableModel model;
    private JTable JTable1;
    private JScrollPane JScrollPane1;
    BankFrm myframe;
    private Object rowdata[];
    private Banking banking;

	JPanel JPanel1 = new JPanel();
	JButton JButton_NewCCAccount = new JButton();
	JButton JButton_GenBill = new JButton();
	JButton JButton_Deposit = new JButton();
	JButton JButton_Withdraw = new JButton();
	JButton JButton_Exit = new JButton();


	public Banking getBanking() {
		return banking;
	}

	public BankFrm(Banking banking)
	{
		myframe = this;
		this.banking = banking;
		setTitle(getTitle());
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		getContentPane().setLayout(new BorderLayout(0,0));
		setSize(590,330);
		setVisible(false);
		JPanel1.setLayout(null);
		getContentPane().add(BorderLayout.CENTER, JPanel1);
		JPanel1.setBounds(0,0,575,310);

        /*
		/Add five buttons on the pane
		/for Adding personal account, Adding company account
		/Deposit, Withdraw and Exit from the system
		*/
		JScrollPane1 = new JScrollPane();
		model = getModel();
		JTable1 = new JTable(model);
		rowdata = new Object[model.getColumnCount()];
		System.out.println(model.getRowCount());

		newAccount = false;

		JPanel1.add(JScrollPane1);
		JScrollPane1.setBounds(12,92,444,160);
		JScrollPane1.getViewport().add(JTable1);
		JTable1.setBounds(0, 0, 420, 0);

		JButton_PerAC.setText("Add personal account");
		JPanel1.add(JButton_PerAC);
		JButton_PerAC.setBounds(24,20,192,33);
		JButton_PerAC.setActionCommand("jbutton");

		JButton_CompAC.setText("Add company account");
		JPanel1.add(JButton_CompAC);
		JButton_CompAC.setBounds(240,20,192,33);
		JButton_CompAC.setActionCommand("jbutton");

		JButton_Deposit.setText("Deposit");
		JPanel1.add(JButton_Deposit);
		JButton_Deposit.setBounds(468,104,96,33);

		JButton_Withdraw.setText("Withdraw");
		JPanel1.add(JButton_Withdraw);
		JButton_Withdraw.setBounds(468,164,96,33);

		JButton_AddInterest.setText("Add interest");
		JPanel1.add(JButton_AddInterest);
		JButton_AddInterest.setBounds(448,20,106,33);

		JButton_Exit.setText("Exit");
		JPanel1.add(JButton_Exit);
		JButton_Exit.setBounds(468,248,96,31);


		BankFrm.SymWindow aSymWindow = new BankFrm.SymWindow();
		this.addWindowListener(aSymWindow);
		MainScreen.SymAction lSymAction = new BankFrm.SymAction();
		JButton_Exit.addActionListener(lSymAction);
		JButton_PerAC.addActionListener(lSymAction);
		JButton_CompAC.addActionListener(lSymAction);
		JButton_Deposit.addActionListener(lSymAction);
		JButton_Withdraw.addActionListener(lSymAction);
		JButton_AddInterest.addActionListener(lSymAction);

	}

	@Override
	protected void JButtonPerAC_actionPerformed(ActionEvent event)
	{
		JDialog_AddPAccount pac = new JDialog_AddPAccount(myframe);
		pac.setBounds(450, 20, 300, 330);
		pac.setVisible(true);

		JTable1.getSelectionModel().setAnchorSelectionIndex(-1);
	}

	@Override
	protected void JButtonCompAC_actionPerformed(ActionEvent event)
	{
		JDialog_AddCompAcc pac = new JDialog_AddCompAcc(myframe);
		pac.setBounds(450, 20, 300, 330);
		pac.setVisible(true);

		JTable1.getSelectionModel().setAnchorSelectionIndex(-1);
	}

	@Override
	protected DefaultTableModel getModel() {
		DefaultTableModel model = new DefaultTableModel();
		model.addColumn("AccountNr");
		model.addColumn("Name");
		model.addColumn("Street");
		model.addColumn("City");
		model.addColumn("State");
		model.addColumn("P/C");
		model.addColumn("Ch/S");
		model.addColumn("Amount");
		return model;
	}

    @Override
    public void updateTable() {
        model.setRowCount(0);
        for (BankAccount account : banking.getAccounts()) {
            rowdata = new Object[model.getColumnCount()];
			rowdata[0] = account.getAccountNumber();
            rowdata[1] = account.getOwner().getName();
            rowdata[2] = account.getOwner().getStreet();
            rowdata[3] = account.getOwner().getCity();
            rowdata[4] = account.getOwner().getState();
            rowdata[5] = account.getOwner().getClass().getSimpleName();
            rowdata[6] = ((BankAccount)account).getType();
            rowdata[7] = account.getBalance();
            model.addRow(rowdata);
        }
    }


	
}
