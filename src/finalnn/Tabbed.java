/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package finalnn;

/**
 *
 * @author DELL
 */
//import static finalnn.FinalNN.NofSamples;
//import static finalnn.FinalNN.NofSamples;
import java.awt.Color;
import java.awt.Frame;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import javax.swing.DefaultCellEditor;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableModel;

public class Tabbed {

        //TextField text=new TextField(20);
  public static void main(File f) {
      
int NofSampless= 0;
      try{
    try (BufferedReader reader = new BufferedReader(new FileReader(f))) {
        while (reader.readLine() != null) NofSampless++;
    }
         System.out.println("Heloooo"+NofSampless);
  }catch(IOException e){}
      Object[][] data=new Object[NofSampless][NofSampless];
      File input=f;
      try{
          
      Scanner sc=new Scanner(input);
        
       
         
         
            // bw.write(trainInputs[i][1]+'\n');
          //  bw.close();
        String c;
        while(sc.hasNext()){
            for(int i=0;i<NofSampless;i++){
                c=sc.nextLine();
                //System.out.println(c);
                for(int k=0;k<FinalNN.Input_NeurNum+FinalNN.Output_NeurNum;k++){
                   // c=sc.next().charAt(0);
                //trainInputs[i][k]=c;
                    
                    data[i][k]=Integer.parseInt(c.substring(k,k+1));
                //System.out.println("DATA "+trainInputs[i][k]);
                }
                //for(int j=0;j<Output_NeurNum;j++){
                //trainOutput[i][j]=Integer.parseInt(c.substring(12+j,13+j));
                  //System.out.println(trainOutput[i][j]);
//                }
            }
            }
      }catch(IOException e){}
      
      
      
    JFrame frame = new JFrame();
 //   frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    
    String[] columnTitles = { "Age:20-30","30-50",">50","Male","Female","Dependent","Business","Professional","Income 12-25","25-35","35-45","45-60",">75","Family has <4",">4","credit:low","high","prev car? yes","no", "EON", "I10","I10 Grand","Xcent", "I20 Elite","I20 Active","Fluiduc Verna",  "Santafe" };
    Object[][] dataEntries =data; /*{ { "Saravan","", "Pantham", new Integer(50), "B", new Boolean(false) },
        { "Eric","", "", new Integer(180), "O", new Boolean(true) },
        { "John","", "", new Integer(120), "AB", new Boolean(false) },
        { "Mathew","", "", new Integer(140), "A", new Boolean(true) }, };*/
    
    TableModel model = new EditableTableModel(columnTitles, dataEntries);
    JTable table = new JTable(model);
    table.createDefaultColumnsFromModel();
    TableModel model1 = new EditableTableModel(columnTitles, dataEntries);
    JTable table1 = new JTable(model1);
    table1.createDefaultColumnsFromModel();
JButton btn4 = new JButton("Exit");
    String[] bloodGroups = { "0","1" };
    JComboBox comboBox = new JComboBox(bloodGroups);
    table.getColumnModel().getColumn(3).setCellEditor(new DefaultCellEditor(comboBox));
    table1.getColumnModel().getColumn(3).setCellEditor(new DefaultCellEditor(comboBox));
    frame.add(new JScrollPane(table));
    frame.add(new JScrollPane(table1));
    //frame.add(btn4);
    frame.setSize(300, 200);
    
    Color c = new Color(253,206,206);
        table1.setBackground(c);
        table.setBackground(c);
        frame.setBackground(c);
     frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
    frame.setVisible(true);
          WindowListener exitListener;

    exitListener = new WindowAdapter() {
      public void windowClosing(WindowEvent e) {
	Window window = e.getWindow();
	window.setVisible(false);
	window.dispose();
	System.exit(0);
      }
    };
    
  }

}

class ButtonListener1 implements ActionListener {
//public static File f=null;

//static void setFile(File fi){
//f=fi;
//}
    ButtonListener1() {
  }

  public void actionPerformed(ActionEvent e) {
  /*  if (e.getActionCommand().equals("Choose File")) {
      FileChooserDemo.createAndShowGUI();  
      System.out.println("Button1 has been clicked");
    }
    if (e.getActionCommand().equals("Show Input Content")) {
      System.out.println("Button2 has been clicked");
      Tabbed.main(f);
    }*/
     if (e.getActionCommand().equals("exit")) {
         System.exit(1);
      System.out.println("Button3 has been clicked");
      //FinalNN.haveFile(f);
      
    }
  }
}
           
     
class EditableTableModel extends AbstractTableModel {
  String[] columnTitles;

  Object[][] dataEntries;

  int rowCount;

  public EditableTableModel(String[] columnTitles, Object[][] dataEntries) {
    this.columnTitles = columnTitles;
    this.dataEntries = dataEntries;
  }

  public int getRowCount() {
    return dataEntries.length;
  }

  public int getColumnCount() {
    return columnTitles.length;
  }

  public Object getValueAt(int row, int column) {
    return dataEntries[row][column];
  }

  public String getColumnName(int column) {
    return columnTitles[column];
  }

  public Class getColumnClass(int column) {
    return getValueAt(0, column).getClass();
  }

  public boolean isCellEditable(int row, int column) {
    return true;
  }

  public void setValueAt(Object value, int row, int column) {
    dataEntries[row][column] = value;
  }
}