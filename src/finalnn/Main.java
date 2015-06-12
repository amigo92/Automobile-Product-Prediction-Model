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


import java.awt.*;
import java.awt.event.*;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import javax.swing.*;

class Main extends JPanel implements ActionListener {
   
    JButton b1;
    JTextField t1,t2,t3;
    JLabel l1,l2,l3,l4,l5,l6,l7,l8,l9,l10,l11,l12;
    //JCheckBox c1,c2,c3;
    JRadioButton r1,r2,r3,r4;
    JRadioButton k1,k2,k3,k4,k5,k6,k7,k8,k9,k10,k11,k12,k13,k14,k15,k16;
    ButtonGroup bg1,bg2,bg3,bg4,bg5,bg6,bg7;
    static  JFrame frame = new JFrame("Automobile Marketing Team Tool");
    static JPanel control = new JPanel();
    
   	public boolean isNumber(String n) {
		try {
	for (int i = 0; i < n.length(); i++) {
            System.out.println(n+" "+n.charAt(i)+" "+Character.isDigit(n.charAt(i)));
      if (!Character.isDigit(n.charAt(i))){
        System.out.println("Returning False"+" i="+i+" chat at "+i+"--"+n.charAt(i));
          return false;
      }
    }
        System.out.println("Returning True");
    return true;
  }
                catch(NumberFormatException e){
                    System.out.println("Returning False from catch");
                    return false;
                }
      
        }
   // int flag;
    
   // JComboBox cb;
    //String str="Game : ";
    //JCheckBox c[] = new JCheckBox[3];
    public Main()
    {
        // JPanel panel = new JPanel();
      //panel.setBackground(Color.darkGray);
      //panel.setSize(200,200);
      //FlowLayout layout = new FlowLayout();
      //layout.setHgap(10);              
      //layout.setVgap(10);
      //panel.setLayout(layout); 
      // frame.add(panel);
        setLayout(new GridLayout(12,1));
        JPanel pn=new JPanel();
        JPanel pn1=new JPanel();
        JPanel pn2=new JPanel();
        JPanel pn3=new JPanel();
         JPanel pn4=new JPanel();
          JPanel pn5=new JPanel();
           JPanel pn6=new JPanel();
            JPanel pn7=new JPanel();
             JPanel pn8=new JPanel();
              JPanel pn9=new JPanel();
              JPanel pn10=new JPanel();
              JPanel pn11=new JPanel();
        pn.setLayout(new FlowLayout());
       
//        / JPanel pn1=new JPanel();
        pn.setLayout(new FlowLayout());
        pn1.setLayout(new FlowLayout());
        pn2.setLayout(new FlowLayout());
        pn3.setLayout(new FlowLayout());
        pn4.setLayout(new FlowLayout());
        pn5.setLayout(new FlowLayout());
        pn6.setLayout(new FlowLayout());
        pn7.setLayout(new FlowLayout());
         pn8.setLayout(new FlowLayout());
        pn9.setLayout(new FlowLayout());
        pn10.setLayout(new FlowLayout());
        pn11.setLayout(new FlowLayout());
        
        add(pn11);
        add(pn);
        add(pn1);
        add(pn2);
        add(pn3);
        add(pn4);
        add(pn5);
        add(pn6);
        add(pn7);
        add(pn8);
        add(pn9);
        add(pn10);
        
        
        b1 = new JButton("Submit");
        t1 = new JTextField("",10);
        t2 = new JTextField("",10);
        t3 = new JTextField("",10);
        l4=new JLabel("Enter Customer Details");
        l1 = new JLabel("Name:");
        l2 = new JLabel("Ph Number:");
        l3 = new JLabel("Email ID:");
        l5 = new JLabel("Age:");
        l6 = new JLabel("Gender:");
        l7 = new JLabel("Occupation:");
        l8 = new JLabel("Income:");
        l9 = new JLabel("Family Members:");
        l10 = new JLabel("Loan Amount:");
        l11 = new JLabel("2nd Car?:");
        l12 = new JLabel("Gender:");
        
        
        //l4 = new JLabel("Occupation");
        r1 = new JRadioButton("20-30");
        r1.setActionCommand("Age 20-30");
        /*Occupation: Student Business Professional 

Income: 15k-30k 30k-50k >50k

Number of family members: <=4  >4*/
        r2 = new JRadioButton("30-50");
        r2.setActionCommand("30-50");
        r3 = new JRadioButton(">50");
        r3.setActionCommand(">50");
        r4 = new JRadioButton("Male");
        r4.setActionCommand("Male");
        k9 = new JRadioButton("Female");
        k9.setActionCommand("Female");
         k8 = new JRadioButton("Dependent");
        k8.setActionCommand("Occupation:Dependent");
                k6 = new JRadioButton("Business");
        k6.setActionCommand("Business");
        k7 = new JRadioButton("Professional");
        k7.setActionCommand("Professional");
       
        k1 = new JRadioButton("15k-25k");
        k1.setActionCommand("Income:15k-25k");
        k2 = new JRadioButton("25-35k");
        k2.setActionCommand("25-35k");
        k3 = new JRadioButton("35-45k");
        k3.setActionCommand("35-45k");
        k10 = new JRadioButton("45-60k");
        k10.setActionCommand("45-60k");
        k11 = new JRadioButton("60-75k");
        k11.setActionCommand("60-75k");
        k12 = new JRadioButton(">75k");
        k12.setActionCommand(">75k");
        k4 = new JRadioButton("<=4");
        k4.setActionCommand("Number of Family Members:<=4");
        k5 = new JRadioButton(">4");
        k5.setActionCommand("Number of Family Members:>4");
        
         k13 = new JRadioButton("Low");
        k13.setActionCommand("Credit Amount: Low");
        k14 = new JRadioButton("High");
        k14.setActionCommand("High");
        
         k15 = new JRadioButton("Yes");
        k15.setActionCommand("2nd Car? Yes");
        k16 = new JRadioButton("No");
        k16.setActionCommand("No");

       
        //r4 = new JRadioButton("Age>30");
        //r4.setActionCommand("age>30");
        
       // c1 = new JCheckBox("Cricket");
        //c2 = new JCheckBox("FootBall");
        //c3 = new JCheckBox("VollyBall");
       /// cb = new JComboBox();
        bg1 = new ButtonGroup();
       bg2 = new ButtonGroup();
        bg3 = new ButtonGroup();
       bg4 = new ButtonGroup();
       bg5 = new ButtonGroup();
       bg6 = new ButtonGroup();
       bg7 = new ButtonGroup();
       
        //cb.addItem("Occupation");
        //cb.addItem("Business");
        //cb.addItem("Professional");
        //cb.addItem("Student");
       
        b1.addActionListener(this);
        bg1.add(r1);
        bg1.add(r2);
        bg1.add(r3);
       bg2.add(r4);
       bg2.add(k9);
       bg3.add(k8);
       bg3.add(k6);
       bg3.add(k7);
       bg4.add(k1);
       bg4.add(k2);
       bg4.add(k3);
       bg4.add(k10);
       bg4.add(k11);
       bg4.add(k12);
       bg5.add(k4);
       bg5.add(k5);
       bg6.add(k13);
       bg6.add(k14);
       bg7.add(k15);
       bg7.add(k16);
l4.setFont(new Font("Serif", Font.BOLD, 22));
        pn11.add(l4);
        pn.add(l1);
        pn.add(t1);
        pn1.add(l2);
        
        pn1.add(t2);
        pn2.add(l3);
        pn2.add(t3);   
       // add(l4);
        //add(cb);
        pn3.add(l5);
        pn3.add(r1);
        pn3.add(r2);
        pn3.add(r3);
        pn4.add(l6);
       pn4.add(r4);
       pn4.add(k9);
       pn5.add(l7);
       pn5.add(k8);
       pn5.add(k6);
       pn5.add(k7);
       pn6.add(l8);
       pn6.add(k1);
       pn6.add(k2);
       pn6.add(k3);
       
       pn6.add(k10);
       pn6.add(k11);
       pn6.add(k12);
       pn7.add(l9);
       pn7.add(k4);
       pn7.add(k5);
       pn8.add(l10);
       pn8.add(k13);
       pn8.add(k14);
       pn9.add(l11);
       pn9.add(k15);
       pn9.add(k16);
    //    add(c1);add(c2);add(c3);
        pn10.add(b1);
       // Color c = new Color(250,208,160);
        Color c = new Color(253,206,206);
        Color c3 = new Color(120,0,120);
        Color c1 = new Color(0,0,160);
        Color c2 = new Color(0,51,0);
        
        Color c4 = new Color(0,160,160);
        b1.setBackground(c4);
        b1.setForeground(c3);
        pn.setBackground(c);
        pn1.setBackground(c);
        pn2.setBackground(c);
        pn3.setBackground(c);
        pn4.setBackground(c);
        pn5.setBackground(c);
        pn6.setBackground(c);
        pn7.setBackground(c);
        pn8.setBackground(c);
        pn9.setBackground(c);
        pn10.setBackground(c);
        pn11.setBackground(c);
        l5.setForeground(c3);
         l1.setForeground(c3);
         l2.setForeground(c3);
        l3.setForeground(c3);
         l6.setForeground(c3);
         l7.setForeground(c3);
         l8.setForeground(c3);
         l9.setForeground(c3);
         l10.setForeground(c3);
         l11.setForeground(c3);
        r1.setBackground(c);
        r2.setBackground(c);
        r3.setBackground(c);
        r4.setBackground(c);
        r1.setForeground(c1);
        r2.setForeground(c1);
        r3.setForeground(c1);
        r4.setForeground(c1);
    k1.setBackground(c);
    k1.setForeground(c1);
    k2.setBackground(c);
    k2.setForeground(c1);
    k3.setBackground(c);
    k3.setForeground(c1);
    k4.setBackground(c);
    k4.setForeground(c1);
    k5.setBackground(c);
    k5.setForeground(c1);
    k6.setBackground(c);
    k6.setForeground(c1);
    k7.setBackground(c);
    k7.setForeground(c1);
    k8.setBackground(c);
    k8.setForeground(c1);
    k9.setBackground(c);
    k9.setForeground(c1);
    k10.setBackground(c);
    k10.setForeground(c1);
    k11.setBackground(c);
    k12.setBackground(c);
    k13.setBackground(c);
    k14.setBackground(c);
    k15.setBackground(c);
    k16.setBackground(c);
    k11.setForeground(c1);
    k12.setForeground(c1);
    k13.setForeground(c1);
    k14.setForeground(c1);
    k15.setForeground(c1);
    k16.setForeground(c1);
    setVisible(true);

 

   
    }
   public void actionPerformed(ActionEvent e)
   {
           BufferedWriter bw = null;
           BufferedWriter bw1 = null;
         int[] arr=new int[20];
      try {
         // APPEND MODE SET HERE
         bw = new BufferedWriter(new FileWriter("checkbook.xls", true));
         //bw1 = new BufferedWriter(new FileWriter("userTemp.txt", true));
         
       String name = t1.getText();
       System.out.println("Name : "+name);
       bw.write("Name\t"+name);
       //bw.newLine();
       String branch = t2.getText();
       System.out.println("Ph Number : "+branch);
       bw.newLine();
       bw.write("Ph Number\t"+branch);
       System.out.println(isNumber(branch));
       if(isNumber(branch)!=true){
           JOptionPane.showMessageDialog(null,"No chars allowed !");
       return;
       }
       String add = t3.getText();
       System.out.println("Address : "+add);
      bw.newLine();
       bw.write("Address\t"+add);
   //    String car = (String)cb.getSelectedItem()();
       
     //  System.out.println("Car : "+car);
      //bw.write("Car : "+car+" ");
       if(bg1.getSelection().getActionCommand().equals("Age 20-30"))
       {
            System.out.println("Age: 20-30");
       bw.newLine();
            bw.write("Age\t20-30");
            arr[0]=1;
            arr[1]=0;
            arr[2]=0;
       }
       else if(bg1.getSelection().getActionCommand().equals("30-50"))
       {
            System.out.println("Age: 30-50");
            bw.newLine();
            bw.write("Age\t30-50");
            arr[0]=0;
            arr[1]=1;
            arr[2]=0;
       }
       
       else
       {
            System.out.println("Age: >50");
            bw.newLine();
            bw.write("Age\t>50");
            arr[0]=0;
            arr[1]=0;
            arr[2]=1;
       }
       
       if(bg2.getSelection().getActionCommand().equals("Male"))
       {
            System.out.println("Gender: Male");
            bw.newLine();
            bw.write("Gender"+"\t"+"Male");
            arr[3]=1;
            arr[4]=0;
       }
       else
       {
            System.out.println("Gender: Female");
            bw.newLine();
            bw.write("Gender\tFemale");
            arr[3]=0;
            arr[4]=1;
       }
        
       
       if(bg3.getSelection().getActionCommand().equals("Occupation:Dependent"))
       {
            System.out.println("Occupation:Dependent");
            bw.newLine();
            bw.write("Occupation\tDependent");
            arr[5]=1;
            arr[6]=0;
            arr[7]=0;
       }
       else if(bg3.getSelection().getActionCommand().equals("Business"))
       {
            System.out.println("Occupation: Business");
            bw.newLine();
            bw.write("Occupation\tBusiness");
            arr[5]=0;
            arr[6]=1;
            arr[7]=0;
            
       }
       else
       {
            System.out.println("Occupation: Professional");
            bw.newLine();
            bw.write("Occupation\tProfessional");
            arr[5]=0;
            arr[6]=0;
         arr[7]=1;
       }
       if(bg4.getSelection().getActionCommand().equals("Income:15k-25k"))
       {
            System.out.println("Income:15k-25k");
            bw.newLine();
            bw.write("Income\t15k-25k");
            arr[8]=1;
            arr[9]=0;
            arr[10]=0;
            arr[11]=0;
            arr[12]=0;
            arr[13]=0;
            
       }
      else if(bg4.getSelection().getActionCommand().equals("25-35k"))
       {
            System.out.println("Income:25k-35k");
            bw.newLine();
            bw.write("Income\t25k-35k");
            arr[8]=0;
            arr[9]=1;
            arr[10]=0;
            arr[11]=0;
            arr[12]=0;
            arr[13]=0;
            
       }
       else if(bg4.getSelection().getActionCommand().equals("35-45k"))
       {
            System.out.println("Income:35k-45k");
            bw.newLine();
            bw.write("Income\t35k-45k");
            arr[8]=0;
            arr[9]=0;
            arr[10]=1;
            arr[11]=0;
            arr[12]=0;
            arr[13]=0;
            
       }
       else if(bg4.getSelection().getActionCommand().equals("45-60k"))
       {
            System.out.println("Income:45k-60k");
            bw.newLine();
            bw.write("Income\t45k-60k");
            arr[8]=0;
            arr[9]=0;
            arr[10]=0;
            arr[11]=1;
            arr[12]=0;
            arr[13]=0;
            
       }
       else if(bg4.getSelection().getActionCommand().equals("60-75k"))
       {
            System.out.println("Income:60k-75k");
            bw.newLine();
            bw.write("Income\t60k-75k");
            arr[8]=0;
            arr[9]=0;
            arr[10]=0;
            arr[11]=0;
            arr[12]=1;
            arr[13]=0;
            
       }
       else
       {
            System.out.println("Income: >75k");
            bw.newLine();
            bw.write("Income\t>75k");
          
            arr[8]=0;
            arr[9]=0;
            arr[10]=0;
            arr[11]=0;
            arr[12]=0;
            arr[13]=1;
       
       }
       
       if(bg5.getSelection().getActionCommand().equals("Number of Family Members:<=4"))
       {
            System.out.println("Number of Family Members:<=4");
            bw.newLine();
            bw.write("Number of Family Members\t<=4");
            arr[14]=1;
            arr[15]=0;
         
       }
       
       else
       {
            System.out.println("Number of Family Members:>4");
            bw.newLine();
            bw.write("Number of Family Members\t<=4");
            arr[14]=0;
           
            arr[15]=1;
       }
       if(bg6.getSelection().getActionCommand().equals("Credit Amount: Low"))
       {
            System.out.println("Credit Amount: Low");
            bw.newLine();
            bw.write("Credit Amount\tLow");
            arr[16]=1;
            arr[17]=0;
         
       }
       
       else
       {
            System.out.println("Credit Amount: High");
            bw.newLine();
            bw.write("Credit Amount\tLow");
            arr[16]=0;
           
            arr[17]=1;
       }
       
       if(bg7.getSelection().getActionCommand().equals("2nd Car? Yes"))
       {
            System.out.println("2nd Car? Yes");
            bw.newLine();
            bw.write("2nd Car?\tYes");
            arr[18]=1;
            arr[19]=0;
         
       }
       
       else
       {
            System.out.println("2nd Car? No");
            bw.newLine();
            bw.write("2nd Car?\tNo");
            arr[18]=0;
           
            arr[19]=1;
       }
      /*  if(c1.isSelected())
        { 
           str = str +"Cricket ";
          
        }
        if(c2.isSelected())
        {
           str = str+"+ FootBall";   
          
        }
        if(c3.isSelected())
        {
            str = str+ "+ VollyBall ";         
        }
        System.out.println(" "+str);
     
     bw.write(str+" ");*/
     bw.newLine();
     bw.newLine();
     bw.newLine();
     bw.flush();
     PrintWriter pr = new PrintWriter("userTemp.txt");    
     System.out.println("OUR DAtA");
for (int i=0; i<arr.length ; i++){            
pr.print("" + arr[i]);    
 System.out.println("" + arr[i]);
}        
pr.close();
   //  bw1.write(Arrays.toString(arr));
     // bw1.newLine();
     //bw1.flush();
      } catch (IOException ioe) {
     ioe.printStackTrace();
      } finally {                       // always close the file
     if (bw != null) try {
        bw.close();
     } catch (IOException ioe2) {
        // just ignore it
     }
      } // end try/catch/finally
 Index i=new Index();
 frame.setVisible(false);
 i.main();
 
 
   }
   public static void main(String args[])
   {
      
  
        frame.addWindowListener(new WindowAdapter()
        {
            public void windowClosing(WindowEvent e)
            {
                System.exit(0);
            }
        });

        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize(); 
Dimension frameSize = frame.getSize(); 
if (frameSize.height !=screenSize.height) 
{ 
frameSize.height = screenSize.height; 
} 
if (frameSize.width != screenSize.width) 
{ 
frameSize.width = screenSize.width; 
} 
frame.setLocation((screenSize.width - frameSize.width) / 2, 
(screenSize.height - frameSize.height) / 2); 
frame.setSize(screenSize.height,screenSize.width);
frame.setSize(500,500);
//frame.setLayout(new GridLayout(3, 1));
 //JPanel controlPanel = new JPanel();
   //   controlPanel.setLayout(new FlowLayout());
     // frame.add(controlPanel);
 // frame.pack();
          //frame.getContentPane().add(new Main());
      Color c = new Color(0,255,120);
//frame.getContentPane().setLayout(new GridLayout(1,1));
    Container con = frame.getContentPane();
//JPanel control = new JPanel();
    con.setBackground( c );
    
 frame.getContentPane().add(control);
 control.setLayout(new GridLayout());
 control.add(new Main());
      frame.setExtendedState(JFrame.MAXIMIZED_BOTH);

        frame.setVisible(true);
        //MyPanel.setLayout( new FlowLayout() );
        //frame.getContentPane().add(MyPanel, "Center");
         
   }
}