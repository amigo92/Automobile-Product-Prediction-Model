package finalnn;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Index extends JPanel{
    JPanel pn=new JPanel();

  public Index() {

    
     JPanel pn1=new JPanel();
 pn1.setLayout(new FlowLayout());
 pn.add(pn1);
      JPanel pn2=new JPanel();
 pn2.setLayout(new GridLayout(5,1));
 
    
      JButton btn1 = new JButton("Choose File");
    JButton btn2 = new JButton("Show Input Content");
    JButton btn3 = new JButton("Run Neural Network Training Inputs");
     JButton btn4 = new JButton("Show Network Information about Weights");
     JButton btn5 = new JButton("Test Network");
     JLabel label=new JLabel("NOTE: Choose an input file containting 17 test cases with 12 binary inputs , then run the network. In order to Test on custom inputs, Click Test Network.");
    btn1.addActionListener(new ButtonListener());
    btn2.addActionListener(new ButtonListener());
    btn3.addActionListener(new ButtonListener());
     btn4.addActionListener(new ButtonListener());
     btn5.addActionListener(new ButtonListener());
    pn1.add(label);
    pn.add(pn2);
     pn2.add(btn1);
    pn2.add(btn2);
    pn2.add(btn3);
    pn2.add(btn4);
    pn2.add(btn5);
    Color c = new Color(253,206,206);
  
        pn1.setBackground(c);
        pn2.setBackground(c);
        
        Color c3 = new Color(120,0,120);
        Color c4 = new Color(0,160,160);
         btn1.setBackground(c4);
        btn1.setForeground(c3);
        btn2.setBackground(c4);
        btn2.setForeground(c3);
        btn3.setBackground(c4);
        btn3.setForeground(c3);
        btn4.setBackground(c4);
        btn4.setForeground(c3);
        btn5.setBackground(c4);
        btn5.setForeground(c3);

  }

  public  void main() {
    JFrame frame = new JFrame();
    frame.setTitle("Automobile Product Preditcion with Neural Netwroks");
    
    pn.setLayout(new GridLayout(2,1));
     Color c = new Color(253,206,206);
   pn.setBackground(c);
   Index i=new Index();
   //pn.add(new Index());
   frame.add(pn); 
   
    
//frame.setLayout(new GridLayout(5,1));
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setSize(900, 900);
   
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


class ButtonListener implements ActionListener {
public static File f=null;
public static File finals=null;
static void setFile(File fi){
f=fi;
}
    ButtonListener() {
  }

  public void actionPerformed(ActionEvent e) {
    if (e.getActionCommand().equals("Choose File")) {
      Browser.createAndShowGUI();  
      System.out.println("Button1 has been clicked");
    }
    if (e.getActionCommand().equals("Show Input Content")) {
      System.out.println("Button2 has been clicked");
      Tabbed.main(f);
    }
     if (e.getActionCommand().equals("Run Neural Network Training Inputs")) {
      System.out.println("Button3 has been clicked");
      int NofSampless= 0;
      try{
        BufferedReader reader = new BufferedReader(new FileReader(f));

while (reader.readLine() != null) NofSampless++;
reader.close();
         System.out.println("Heloooo"+NofSampless);
  }catch(IOException ex){}
      
      finals=FinalNN.haveFile(f);
     }
     if (e.getActionCommand().equals("Show Network Information about Weights")) {
      System.out.println("Button4 has been clicked");
      
      Output.main(finals);
    }
     if (e.getActionCommand().equals("Test Network")) {
      Validate.main();
      
      //Output.main(finals);z
    } 
    
  }
}
           
     