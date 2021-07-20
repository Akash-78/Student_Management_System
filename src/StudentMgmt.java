import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.lang.reflect.Array;
import java.util.Arrays;

public class StudentMgmt {
    public String[] colName = new String[]{"Delete","ID","Name","Age","Standard"};
    public static Object[][] studentList= new Object[][]{{false,1,"AKASH",21,12}};

    public DefaultTableModel studentModel;
    public JTable studentTable;
    private StudentMgmt(){
        JFrame jFrame = new JFrame("Student magnement Application GUI");
        jFrame.setBounds(100,100,500,300);
        jFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        JTabbedPane jTabbedPane = new JTabbedPane();
        CreateUpdateStudentPanel createUpdateStudentPanel = new CreateUpdateStudentPanel();
        ReadDeleteStudentPanel readDeleteStudentPanel = new ReadDeleteStudentPanel();
        jTabbedPane.addTab("Create Student",createUpdateStudentPanel);
        jTabbedPane.setMnemonicAt(0, KeyEvent.VK_1);
        jTabbedPane.addTab("Read/Delete Student",readDeleteStudentPanel);
        jTabbedPane.setMnemonicAt(1,KeyEvent.VK_2);
        jFrame.setContentPane(jTabbedPane);
        jFrame.setVisible(true);
    }

    public static void main(String[] args) {
        new StudentMgmt();
    }
    static JTextField addLabelAndTextField(String labelText, int Ypos, Container containingPanel){
        JLabel jLabel = new JLabel(labelText);
        GridBagConstraints gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.fill = GridBagConstraints.BOTH;
        gridBagConstraints.insets = new Insets(0,0,5,5);
        gridBagConstraints.gridx =0;
        gridBagConstraints.gridy = Ypos;
        containingPanel.add(jLabel,gridBagConstraints);
        JTextField jTextField = new JTextField();
        GridBagConstraints gridBagConstraints1 = new GridBagConstraints();
        gridBagConstraints1.fill = GridBagConstraints.BOTH;
        gridBagConstraints1.insets = new Insets(0,0,5,5);
        gridBagConstraints1.gridx = 1;
        gridBagConstraints1.gridy=Ypos;
        containingPanel.add(jTextField,gridBagConstraints1);
        jTextField.setColumns(10);
        return jTextField;
    }
    static JButton addButton(String btnText, int Ypos, Container containingPanel){
        JButton jButton = new JButton(btnText);
        GridBagConstraints gridBagConstraintsForButton = new GridBagConstraints();
        gridBagConstraintsForButton.fill = GridBagConstraints.BOTH;
        gridBagConstraintsForButton.insets = new Insets(0,0,5,5);
        gridBagConstraintsForButton.gridx =0;
        gridBagConstraintsForButton.gridy=Ypos;
        containingPanel.add(jButton,gridBagConstraintsForButton);
        return  jButton;
    }
    static void append(Object[][] array, Object[] value){
        Object[][] result = Arrays.copyOf(array,array.length + 1);
        result[result.length - 1] = value;
        StudentMgmt.studentList = result;

    }
}
