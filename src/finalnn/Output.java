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
import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
 
public class Output extends JFrame {
    public static File last=null;
    public Output() {
        initialize();
    }
 
    private void initialize() {
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize(); 
Dimension frameSize = getSize(); 
if (frameSize.height !=screenSize.height) 
{ 
frameSize.height = screenSize.height; 
} 
if (frameSize.width != screenSize.width) 
{ 
frameSize.width = screenSize.width; 
} 
setLocation((screenSize.width - frameSize.width) / 2, 
(screenSize.height - frameSize.height) / 2); 
setSize(screenSize.height,screenSize.width);
        setSize(300, 300);
         setExtendedState(JFrame.MAXIMIZED_BOTH);
        setTitle("Network Information");
        setLayout(new BorderLayout());
       // setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         WindowListener exitListener;

    exitListener = new WindowAdapter() {
      public void windowClosing(WindowEvent e) {
	Window window = e.getWindow();
	window.setVisible(false);
	window.dispose();
	System.exit(0);
      }
    };
        String show=null;
        JTextArea textArea = new JTextArea();
        JScrollPane scrollPane = new JScrollPane(textArea);
        try {
        Scanner sc=new Scanner(last);
        while(sc.hasNext()){
        
            show=sc.nextLine();
            System.out.println(show);
            textArea.append(show+"\n");
        }
        
        System.out.println("LOLOL \n");
        
            //
            // Read some text from the resource file to display in
            // the JTextArea.
            //
           // textArea.read(new InputStreamReader(
            //         getClass().getResourceAsStream("")),
             //       null);
        } catch (IOException e) {
            e.printStackTrace();
        }
 
        getContentPane().add(scrollPane, BorderLayout.CENTER);
        Color c = new Color(253,206,206);
        getContentPane().setBackground(c);
        scrollPane.setBackground(c);
        textArea.setBackground(c);
        
    }
 
    public static void main(File f) {
        last=f;
         new Output().setVisible(true);
       
    }
}