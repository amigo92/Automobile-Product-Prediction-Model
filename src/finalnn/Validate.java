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
import static finalnn.FinalNN.Input_NeurNum;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Validate {

   public Frame mainFrame;
   private Label headerLabel;
   private Label statusLabel;
   private Panel controlPanel;

   public Validate(){
      prepareGUI();
   }

   public static void main(){
      Validate  awtControlDemo = new Validate();
      awtControlDemo.showTextFieldDemo();
   }

   private void prepareGUI(){
      mainFrame = new Frame("Test");
      mainFrame.setSize(1000,1000);
      mainFrame.setExtendedState(JFrame.MAXIMIZED_BOTH);
      mainFrame.setLayout(new FlowLayout());
      mainFrame.addWindowListener(new WindowAdapter() {
         public void windowClosing(WindowEvent windowEvent){
            mainFrame.setVisible(false);
            //System.exit(0);
         }        
      });    
       
      headerLabel = new Label();
      headerLabel.setAlignment(Label.CENTER);
      statusLabel = new Label();        
      statusLabel.setAlignment(Label.CENTER);
      //statusLabel.setSize(650,200);

      controlPanel = new Panel();
      controlPanel.setLayout(new GridLayout());
      

      //mainFrame.add(headerLabel);
     // mainFrame.add(controlPanel);
      //mainFrame.add(statusLabel);
      Color c = new Color(253,206,206);
        Color c3 = new Color(120,0,120);
        mainFrame.setBackground(c);
        controlPanel.setBackground(c);
        statusLabel.setBackground(c);
        statusLabel.setForeground(c3);
      Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize(); 
Dimension frameSize = mainFrame.getSize(); 
if (frameSize.height !=screenSize.height) 
{ 
frameSize.height = screenSize.height; 
} 
if (frameSize.width != screenSize.width) 
{ 
frameSize.width = screenSize.width; 
} 
mainFrame.setLocation((screenSize.width - frameSize.width) / 2, 
(screenSize.height - frameSize.height) / 2); 
mainFrame.setSize(screenSize.height,screenSize.width);
mainFrame.setSize(1366,768);
      mainFrame.setVisible(true);  
     

   
   }

   private void showTextFieldDemo(){
    
      Button loginButton = new Button("Test");
      ImageIcon image = new ImageIcon("eon.jpg");
   JLabel jlb = new JLabel(image);
   ImageIcon image1 = new ImageIcon("santafe.jpg");
   JLabel jlb1 = new JLabel(image1);
   ImageIcon image2 = new ImageIcon("i10.jpg");
   JLabel jlb2 = new JLabel(image2);
   ImageIcon image3 = new ImageIcon("i10grand.jpg");
   JLabel jlb3 = new JLabel(image3);
   ImageIcon image4 = new ImageIcon("xcent.jpg");
   JLabel jlb4 = new JLabel(image4);
   ImageIcon image5 = new ImageIcon("i20elite.jpg");
   JLabel jlb5 = new JLabel(image5);
   ImageIcon image6 = new ImageIcon("i20active.jpg");
   JLabel jlb6 = new JLabel(image6);
   ImageIcon image7 = new ImageIcon("fluidicverna.jpg");
   JLabel jlb7 = new JLabel(image7);
   Color d = new Color(253,206,206);
   jlb.setBackground(d);
   jlb1.setBackground(d);
  jlb2.setBackground(d);
  jlb3.setBackground(d);
  jlb4.setBackground(d);
  jlb5.setBackground(d);
  jlb6.setBackground(d);
  jlb7.setBackground(d);
      
             
                
    String lol;
    File f=new File("userTemp.txt");
    Scanner sc = null;
                 try {
                     sc = new Scanner(f);
                 } catch (FileNotFoundException ex) {
                     Logger.getLogger(Validate.class.getName()).log(Level.SEVERE, null, ex);
                 }
    String c;
     int inputs[] = new int[Input_NeurNum];
     
        while(sc.hasNext()){
            
                c=sc.nextLine();
                System.out.println(c);
                for(int k=0;k<Input_NeurNum;k++){
                   // c=sc.next().charAt(0);
                //trainInputs[i][k]=c;
                    System.out.println("k= "+k);
                    //System.out.println("i= "+i);
                    inputs[k]=Integer.parseInt(c.substring(k,k+1));
                //System.out.println("DATA "+inputs[k]);
                }
                
            }
        System.out.println("DATA "+inputs);
        double ins[] =new double[Input_NeurNum];
        for(int i = 0; i < 20; i++)
{
   ins[i] = (double) inputs[i];
}
           
          lol=FinalNN.validate(ins);
                 System.out.println("Great Weather");
            String data = "Hyundai "+lol+" is a perfect car for you.";
            if(lol=="EON"){
                              //data=data+"( 3.2-4.5L )";
                              mainFrame.add(jlb);
            jlb.setIcon(image);  
            }
            if(lol=="I10"){
                 System.out.println("Great Weather1");             //data=data+"( 3.2-4.5L )";
                              mainFrame.add(jlb2);
            jlb.setIcon(image2);  
            }
            if(lol=="I10 Grand"){
                System.out.println("Great Weather2");
                              //data=data+"( 3.2-4.5L )";
                              mainFrame.add(jlb3);
            jlb.setIcon(image3);  
            }
            if(lol=="Xcent"){
                              //data=data+"( 3.2-4.5L )";
                              mainFrame.add(jlb4);
            jlb.setIcon(image4);  
            }
            if(lol=="I20 Elite Series"){
                              //data=data+"( 3.2-4.5L )";
                              mainFrame.add(jlb5);
            jlb.setIcon(image5);  
            }
            if(lol=="I20 Active Series"){
                              //data=data+"( 3.2-4.5L )";
                              mainFrame.add(jlb6);
            jlb.setIcon(image6);  
            }
            if(lol=="Fluidic Verna"){
                              //data=data+"( 3.2-4.5L )";
                              mainFrame.add(jlb7);
            jlb.setIcon(image7);  
            }
            if(lol=="Santafe"){
                              //data=data+"( 3.2-4.5L )";
                              mainFrame.add(jlb1);
            jlb.setIcon(image1);  
            }
           // data += ", Password: " + passwordText.getText();
            //statusLabel.setText(data);
           
            
           mainFrame.setVisible(true);    
         }

      //controlPanel.add(passwordLabel);       
      //controlPanel.add(passwordText);
 
      
   
}