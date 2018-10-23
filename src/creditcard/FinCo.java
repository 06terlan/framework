package creditcard;

import java.awt.event.ActionEvent;

import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;


public class FinCo extends framework.FinCo {

	public boolean newaccount = false;
    private DefaultTableModel model = null;

    public FinCo () {
    	super();
    	System.out.println("itsme");
    }
    
    public static void main(String[] args) {
        try {
            // Add the following code if you want the Look and Feel
            // to be set to the Look and Feel of the native system.

            try {
                UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            }
            catch (Exception e) {
            }

            //Create a new instance of our application's frame, and make it visible.
            (new FinCo()).setVisible(true);
        }
        catch (Throwable t) {
            t.printStackTrace();
            //Ensure the application exits with an error condition.
            System.exit(1);
        }
    }
    
    @Override
    public DefaultTableModel getModel() {
    	DefaultTableModel model = new DefaultTableModel();
        model.addColumn("AccountNr");
        model.addColumn("Name");
        model.addColumn("City");
        model.addColumn("asdasd");
        return model;
    }
   
    
    
}
