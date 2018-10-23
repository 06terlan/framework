package framework.ui;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.WindowEvent;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import framework.FinCo;
import framework.party.Party;

public class MainScreen extends JFrame{
	
	MainScreen myframe;
	public String accountnr, clientName, street, city, zip, state, accountType, amountDeposit;
	JPanel JPanel1 = new JPanel();
    JButton JButton_PerAC = new JButton();
    JButton JButton_CompAC = new JButton();
    JButton JButton_Deposit = new JButton();
    JButton JButton_Withdraw = new JButton();
    JButton JButton_AddInterest = new JButton();
    JButton JButton_Exit = new JButton();
    private JScrollPane JScrollPane1;
    private JTable JTable1;
    protected DefaultTableModel model;
    protected List<Party> parties;
    private Object rowdata[];
    public boolean newAccount;
    
	public MainScreen(List<Party> parties) {
		myframe = this;
		this.parties = parties;
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


        SymWindow aSymWindow = new SymWindow();
        this.addWindowListener(aSymWindow);
        SymAction lSymAction = new SymAction();
        JButton_Exit.addActionListener(lSymAction);
        JButton_PerAC.addActionListener(lSymAction);
        JButton_CompAC.addActionListener(lSymAction);
        JButton_Deposit.addActionListener(lSymAction);
        JButton_Withdraw.addActionListener(lSymAction);
        JButton_AddInterest.addActionListener(lSymAction);
	}
	
    protected DefaultTableModel getModel() {
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("AccountNr");
        model.addColumn("Name");
        model.addColumn("City");
        model.addColumn("State");
        model.addColumn("P/C");
        model.addColumn("Amount");
        return model;
    }
    
    class SymWindow extends java.awt.event.WindowAdapter
    {
        public void windowClosing(WindowEvent event)
        {
            Object object = event.getSource();
            if (object == MainScreen.this)
                FinCo_windowClosing(event);
        }
    }
    
    void FinCo_windowClosing(WindowEvent event)
    {
        FinCo_windowClosing_Interaction1(event);
    }
    
    void FinCo_windowClosing_Interaction1(WindowEvent event) {
        try {
            this.exitApplication();
        } catch (Exception e) {
        }
    }
    
    void exitApplication()
    {
        try {
            this.setVisible(false);    // hide the Frame
            this.dispose();            // free the system resources
            System.exit(0);            // close the application
        } catch (Exception e) {
        }
    }
    
    class SymAction implements java.awt.event.ActionListener
    {
        public void actionPerformed(ActionEvent event)
        {
            Object object = event.getSource();
            if (object == JButton_Exit)
                JButtonExit_actionPerformed(event);
            else if (object == JButton_PerAC)
                JButtonPerAC_actionPerformed(event);
            else if (object == JButton_CompAC)
                JButtonCompAC_actionPerformed(event);
            else if (object == JButton_Deposit)
                JButtonDeposit_actionPerformed(event);
            else if (object == JButton_Withdraw)
                JButtonWithdraw_actionPerformed(event);
            else if (object == JButton_AddInterest)
                JButtonAddinterest_actionPerformed(event);

        }
    }
    
  //When the Exit button is pressed this code gets executed
    //this will exit from the system
    void JButtonExit_actionPerformed(ActionEvent event)
    {
        System.exit(0);
    }

    public void JButtonPerAC_actionPerformed(ActionEvent event)
    {
//        JDialog_AddPAcc pac = new JDialog_AddPAcc(myframe);
//        pac.setBounds(450, 20, 300, 330);
//        pac.setVisible(true);
//
//        if (newAccount){
//            // add row to table
//            rowdata[0] = accountnr;
//            rowdata[1] = clientName;
//            rowdata[2] = city;
//            rowdata[3] = "P";
//            rowdata[4] = accountType;
//            rowdata[5] = "0";
//            model.addRow(rowdata);
//            JTable1.getSelectionModel().setAnchorSelectionIndex(-1);
//            newAccount=false;
//        }

    }

    void JButtonCompAC_actionPerformed(ActionEvent event)
    {
        JDialog_AddCompAcc pac = new JDialog_AddCompAcc(parties, model);
        pac.setBounds(450, 20, 300, 330);
        pac.setVisible(true);

        if (newAccount){
            // add row to table
            rowdata[0] = accountnr;
            rowdata[1] = clientName;
            rowdata[2] = city;
            rowdata[3] = "C";
            rowdata[4] = accountType;
            rowdata[5] = "0";
            model.addRow(rowdata);
            JTable1.getSelectionModel().setAnchorSelectionIndex(-1);
            newAccount=false;
        }

    }

    void JButtonDeposit_actionPerformed(ActionEvent event)
    {
        // get selected name
//        int selection = JTable1.getSelectionModel().getMinSelectionIndex();
//        if (selection >=0){
//            String accnr = (String)model.getValueAt(selection, 0);
//
//            //Show the dialog for adding deposit amount for the current mane
//            JDialog_Deposit dep = new JDialog_Deposit(myframe,accnr);
//            dep.setBounds(430, 15, 275, 140);
//            dep.show();
//
//            // compute new amount
//            long deposit = Long.parseLong(amountDeposit);
//            String samount = (String)model.getValueAt(selection, 5);
//            long currentamount = Long.parseLong(samount);
//            long newamount=currentamount+deposit;
//            model.setValueAt(String.valueOf(newamount),selection, 5);
//        }


    }

    void JButtonWithdraw_actionPerformed(ActionEvent event)
    {
        // get selected name
//        int selection = JTable1.getSelectionModel().getMinSelectionIndex();
//        if (selection >=0){
//            String accnr = (String)model.getValueAt(selection, 0);
//
//            //Show the dialog for adding withdraw amount for the current mane
//            JDialog_Withdraw wd = new JDialog_Withdraw(myframe,accnr);
//            wd.setBounds(430, 15, 275, 140);
//            wd.show();
//
//            // compute new amount
//            long deposit = Long.parseLong(amountDeposit);
//            String samount = (String)model.getValueAt(selection, 5);
//            long currentamount = Long.parseLong(samount);
//            long newamount=currentamount-deposit;
//            model.setValueAt(String.valueOf(newamount),selection, 5);
//            if (newamount <0){
//                JOptionPane.showMessageDialog(JButton_Withdraw, " Account "+accnr+" : balance is negative: $"+String.valueOf(newamount)+" !","Warning: negative balance",JOptionPane.WARNING_MESSAGE);
//            }
//        }


    }

    void JButtonAddinterest_actionPerformed(ActionEvent event)
    {
        JOptionPane.showMessageDialog(JButton_AddInterest, "Add interest to all accounts","Add interest to all accounts",JOptionPane.WARNING_MESSAGE);
    }
}
