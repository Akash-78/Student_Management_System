import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class CreateUpdateStudentPanel extends JPanel {
    private JTextField idTextField;
    private JTextField nameTextField;
    private  JTextField ageTextField;
    private  JTextField stdTextField;
    private DefaultTableModel studentModel;

    CreateUpdateStudentPanel(){
        Border border =  getBorder();
        Border margin = new EmptyBorder(10,10,10,10);
        setBorder(new CompoundBorder(border,margin));
        GridBagLayout gridBagLayout = new GridBagLayout();
        gridBagLayout.columnWidths = new int[]{86,86,0};
        gridBagLayout.rowHeights = new int[]{20,20,20,20,0};
        gridBagLayout.columnWeights = new double[]{0.0,1.0,Double.MIN_VALUE};
        gridBagLayout.rowWeights = new double[]{0.0,0.0,0.0,0.0,0.0,Double.MIN_VALUE};
        setLayout(gridBagLayout);

        idTextField = StudentMgmt.addLabelAndTextField("ID:",0,this);
        nameTextField = StudentMgmt.addLabelAndTextField("Name:",1,this);
        ageTextField = StudentMgmt.addLabelAndTextField("Age:",2,this);
        stdTextField = StudentMgmt.addLabelAndTextField("Standard:",3,this);
        JButton createStudentBtn = StudentMgmt.addButton("Create",4,this);
        createStudentBtn.addActionListener(e -> createStudent());
    }
    private void createStudent(){
        String studentId = idTextField.getText();
        String studentName = nameTextField.getText();
        String studentAge = ageTextField.getText();
        String studentStd = stdTextField.getText();

        Object[] studentData = new Object[]{false,studentId,studentName,studentAge,stdTextField};
        StudentMgmt.append(StudentMgmt.studentList,studentData);
        studentModel.addRow(studentData);
        idTextField.setText("");
        nameTextField.setText("");
        ageTextField.setText("");
        stdTextField.setText("");
    }
}

