import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class ReadDeleteStudentPanel extends JPanel {
    private final JTable studentTable;
    private final DefaultTableModel studentModel;
    char colName;


    private DefaultTableModel model;

    ReadDeleteStudentPanel(){
        setPreferredSize(new Dimension(400,200));
        JButton jButton = StudentMgmt.addButton("Delete",0,this);

        jButton.addActionListener(e -> deleteStudent());

        studentModel = new DefaultTableModel(StudentMgmt.studentList,colName);
        studentTable = new JTable(studentModel){
            public  Class<?> getColumnClass(int column){
             switch (column){
                 case 0:
                     return Boolean.class;
                 case 1:
                     return String.class;
                 case 2:
                     return String.class;
                 case 3:
                     return String.class;
                 case 4:
                     return  String.class;
                 default:
                     return Boolean.class;
             }
            }
        };
        studentTable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        JScrollPane jScrollPane = new JScrollPane(studentTable);
        add(jScrollPane,BorderLayout.CENTER);
    }
    public void deleteStudent(){
        DefaultTableModel defaultTableModel = (DefaultTableModel) studentTable.getModel();
        for (int i=0;i< defaultTableModel.getRowCount();i++){
            Boolean checked = (Boolean) defaultTableModel.getValueAt(i,0);
            if(checked !=null&& checked){
                model.removeRow(i);
                i--;
            }
        }

    }
}
