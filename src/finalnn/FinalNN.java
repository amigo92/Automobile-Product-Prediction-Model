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
import java.util.Random;
import java.text.DecimalFormat;
import java.util.Scanner;
import java.io.*;

public class FinalNN {

 


//public static FinalNN(){
    static final int Input_NeurNum = 20;
     static final int Hidden_NeurNum = 22;
    static final int Output_NeurNum = 8;

     static final double LEARN_RATE = 0.35;    // Rho.
     static final double NOISE_FACTOR = 0.10;
     static final int TRAINING_REPS = 10000;

    // Input to Hidden Weights (with Biases).
     static double wih[][] = new double[Input_NeurNum + 1][Hidden_NeurNum];

    // Hidden to Output Weights (with Biases).
     static double who[][] = new double[Hidden_NeurNum + 1][Output_NeurNum];

    // Activations.
     static double inputs[] = new double[Input_NeurNum];
   static double hidden[] = new double[Hidden_NeurNum];
   static double target[] = new double[Output_NeurNum];
    static double actual[] = new double[Output_NeurNum  ];
 static double valinput[] = new double[Input_NeurNum];
    // Unit errors.
    static double erro[] = new double[Output_NeurNum];
    static double errh[] = new double[Hidden_NeurNum];
    int NofSampless= 0;
      
    static int NofSamples=400;
    
    static int trainInputs[][] = new int[NofSamples][Input_NeurNum]/*{{0,1,0,1,0,0,1,0,0,1,1,0},
                                                      {1,0,0,1,0,1,0,0,0,1,1,0}, 
                                                      {0,1,0,1,0,0,1,0,0,1,1,0}, 
                                                      {0,1,1,0,0,0,1,0,0,1,1,0},
                                                      {1,0,0,1,0,0,1,0,0,1,1,0},
                                                      {0,1,1,0,0,1,0,0,0,1,0,1},
                                                      {0,1,1,0,0,0,1,0,1,0,0,1},
                                                      {0,1,1,0,0,0,1,1,0,0,0,1},
                                                      {1,0,0,1,0,0,1,0,0,1,1,0},
                                                      {1,0,0,1,0,1,0,0,1,0,0,1},
                                                      {0,1,1,0,0,1,0,0,1,0,0,1},
                                                      {0,1,1,0,0,0,1,0,1,0,1,0},
                                                      {0,1,1,0,1,0,0,0,0,1,1,0},
                                                      {0,1,0,1,0,0,1,0,0,1,1,0},
                                                      {1,0,1,0,0,0,1,0,0,1,0,1},
                                                      {0,1,1,0,0,0,1,0,0,1,0,1},
                                                      {0,1,0,1,0,1,0,0,1,0,0,1}}*/;
                                                       
    static int trainOutput[][] = new int[NofSamples][8] /*{{0,0,1,0,0},
        {0,0,1,0,0},{0,0,1,0,0},{0,0,1,0,0},{0,1,0,0,0},{0,0,0,0,1},{0,1,0,0,0},{1,0,0,0,0},{0,1,0,0,0},{1,0,0,0,0},{0,0,1,0,0},{0,0,1,0,0},{0,0,1,0,0},{0,0,1,0,0},{0,0,1,0,0},{0,0,0,0,1},{1,0,0,0,0}}*/;

public static File haveFile(File f){
//FinalNN(); 
//NofSamples=a;
    File filen=f;
    System.out.println("Heeey");
   
    File sure=NeuralNetwork(filen);
    
    return sure;
}
    
     static File NeuralNetwork(File f)
    {
        File file=new File("networkInfo.txt");
        File input;//=new File("input.txt");
        
       // System.out.println("File Created !!");
        input=f;
        int nofSamples=0;
        //File file1 = new File("/home/amigo/Desktop/OS2/D/ServerDataWrite.txt");
        
        try{
            //FileWriter fw = new FileWriter(file1.getAbsoluteFile(),true);
            //BufferedWriter bw = new BufferedWriter(fw);
        PrintStream output=new PrintStream("networkInfo.txt");
        //PrintStream infile=new PrintStream("input.txt");
         //  System.out.println("I am Here");
        Scanner sc=new Scanner(input);
        Scanner samples=new Scanner(input);
     System.out.println("Hereeeeeee");  
        
     BufferedReader bufferedReader = new BufferedReader(new FileReader(input)); 
                int lines = 0; 
                String str; 
                //Iterate through lines in the file
                while( (str = bufferedReader.readLine()) != null) { 
                        nofSamples++; 
                } 
                bufferedReader.close();
                System.out.println("Line count: " + nofSamples);
     //while(samples.hasNextLine()){
          // nofSamples++;
             
       //  System.out.println("Heloooo finalnn"+nofSamples);   
         //}
            // bw.write(trainInputs[i][1]+'\n');
          //  bw.close();
      //   NofSamples=nofSamples;
        String c;
        while(sc.hasNext()){
            for(int i=0;i<nofSamples;i++){
                c=sc.nextLine();
                //System.out.println(c);
                for(int k=0;k<Input_NeurNum;k++){
                   // c=sc.next().charAt(0);
                //trainInputs[i][k]=c;
                    System.out.println("k= "+k);
                    System.out.println("i= "+i);
                    trainInputs[i][k]=Integer.parseInt(c.substring(k,k+1));
                System.out.println("DATA "+trainInputs[i][k]);
                }
                for(int j=0;j<8;j++){
                     System.out.println(Integer.parseInt(c.substring(20+j,20+1+j))+" orig ");
                trainOutput[i][j]=Integer.parseInt(c.substring(20+j,20+1+j));
                  System.out.println(trainOutput[i][j]+" j is "+j);
                }
            }
            }
        
        
    
        
        
        
        
        int sample = 0;

        assignRandomWeights();
         
        // Train the network.
        for(int epoch = 0; epoch < TRAINING_REPS; epoch++)
        {
            sample += 1;
            if(sample == nofSamples){
                sample = 0;
            }

            for(int i = 0; i < Input_NeurNum; i++)
            {
                inputs[i] = trainInputs[sample][i];
            } // i

            for(int i = 0; i < Output_NeurNum; i++)
            {
                target[i] = trainOutput[sample][i];
            } // i

            feedForward();

            backPropagate();

        } // epoch

        getTrainingStats();
		
        System.out.println("\nTest network against original input:");
        testNetworkTraining();
		
        System.out.println("\nTest network against noisy input:");
        testNetworkWithNoise1();
       /*try{
             PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("read.txt", true)));
            //while(){
                
           // }
        for(int l=0;l<=Input_NeurNum;l++){
            for(int u=0;u<Output_NeurNum;u++){
            out.print(wih[l][u]);
            }
            out.println();
        }
        }catch(IOException e){}
		*/
       /* System.out.println("Hidden= "+Hidden_NeurNum);
        for(int l=0;l<=Input_NeurNum;l++){
            for(int u=0;u<Output_NeurNum;u++){
            System.out.print(wih[l][u]+"yo "+u+"hi ");
            
            }
            
            System.out.println("thnx");
            
        }*/
        
        //try{
            
             //PrintWriter outfile = new PrintWriter(new BufferedWriter(new FileWriter("readpls.text", true)));
            // PrintStream outfile=new PrintStream(new FileOutputStream("read.txt"));
            //PrintStream outfile = new PrintStream(new BufferedOutputStream(new FileOutputStream(file, true)));
        
                output.print("Input Given : ");
        output.println();
        output.println();
        for(int i=0;i<nofSamples;i++){
            for(int j=0;j<trainInputs[i].length;j++){
            output.print(trainInputs[i][j]);
   //         infile.print(trainInputs[i][j]);
            }
            for(int k=0;k<trainOutput[i].length;k++){
                
            output.print(trainOutput[i][k]);
     //       infile.print(trainOutput[i][k]);
            
            }
            output.println();
       //     infile.println();
        }
             double temp=0;
              output.println();
                output.print("Weights between Input Layer Neurons and Hidden Layer Neurons : ");
        output.println();
        output.println();
        for(int inp = 0; inp <= Input_NeurNum; inp++) // Do not subtract 1 here.
        {
            for(int hid = 0; hid < Hidden_NeurNum; hid++)
            {
                
                System.out.print(wih[inp][hid]+" ");
                temp=wih[inp][hid];
                 output.print(temp+"    ");
            } // hid
            System.out.println();
             output.println();
        } // inp
        
        System.out.println();
        output.println();
        
        
        output.println();
                output.print("Weights between Hidden Layer Neurons and Output Layer Neurons: ");
        output.println();
        output.println();
        for(int hid = 0; hid <= Hidden_NeurNum; hid++) // Do not subtract 1 here.
        {
            for(int out = 0; out < Output_NeurNum; out++)
            {
                
                System.out.print(who[hid][out]+" ");
                temp=who[hid][out];
                
                 output.print(temp+"    ");
            } // out
            System.out.println();
             output.println();
        } // hid
        
        }catch(IOException e){}
        return file;
    }

     static void getTrainingStats()
    {
        double sum = 0.0;
        for(int i = 0; i < NofSamples; i++)
        {
            for(int j = 0; j < Input_NeurNum; j++)
            {
                inputs[j] = trainInputs[i][j];
            } // j

            for(int j = 0; j < Output_NeurNum; j++)
            {
                target[j] = trainOutput[i][j];
            } // j

            feedForward();

            if(maximum(actual) == maximum(target)){
                sum += 1;
            }else{
                System.out.println(inputs[0] + "\t" + inputs[1] + "\t" + inputs[2] + "\t" + inputs[3]);
              System.out.println(maximum(actual) + "\t" + maximum(target));
            }
        } // i

        System.out.println("Network is " + ((double)sum / (double)NofSamples * 100.0) + "% correct.");

        return;
    }

     static void testNetworkTraining() throws FileNotFoundException, IOException
    {
        BufferedReader bufferedReader = new BufferedReader(new FileReader("input.txt")); 
                int lines = 0; 
                String str; 
                int nofSamples=0;
                //Iterate through lines in the file
                while( (str = bufferedReader.readLine()) != null) { 
                        nofSamples++; 
                } 
                bufferedReader.close();
                System.out.println("Line count: " + nofSamples);
        // This function simply tests the training vectors against network.
        for(int i = 0; i < nofSamples; i++)
        {
            for(int j = 0; j < Input_NeurNum; j++)
            {
                inputs[j] = trainInputs[i][j];
            } // j
            
            feedForward();
            
            for(int j = 0; j < Input_NeurNum; j++)
            {
                System.out.print(inputs[j] + "\t");
            } // j
            
            System.out.print("Predicted Output: " + maximum(actual) + "\n");
        } // i
        
        return;
    }

     static void testNetworkWithNoise1() throws FileNotFoundException, IOException
    {
        // This function adds a random fractional value to all the training
        // inputs greater than zero.
        DecimalFormat dfm = new java.text.DecimalFormat("###0.0");
        int nofSamples=0;
        File input=new File("input.txt");
         File analyze =new File("analysis.txt"); 
            PrintStream analysis=new PrintStream("analysis.txt");
         BufferedReader bufferedReader = new BufferedReader(new FileReader(input)); 
         FileWriter fw = new FileWriter("analysis.txt");
 
	//for (int i = 0; i < 10; i++) {
	//	fw.write("something");
	//}
 
	//fw.close();
                int lines = 0; 
                String str; 
                //Iterate through lines in the file
                while( (str = bufferedReader.readLine()) != null) { 
                        nofSamples++; 
                } 
                bufferedReader.close();
        
       int count=0;
for(int i = 0; i < nofSamples; i++)
        {
            if(trainInputs[i][9]==1 /*|| trainInputs[i][13]==1 || trainInputs[i][12]==1 || trainInputs[i][11]==1|| trainInputs[i][10]==1 ||trainInputs[i][8]==1*/ ){
                System.out.println("        "+"this is i"+i+"\n");
analysis.println("\n        "+"this is i"+i+"\n");
//fw.newLine();
// analysis.append("\n        "+"this is i"+i+"\n");
                for(count=0;count<3;count++){
            for(int j = 0; j < Input_NeurNum; j++)
            {
   inputs[j] = trainInputs[i][j];
                    if(count==1){
                if( j==10){
                    inputs[j] = 1;
                    inputs[j-1] = 0;
                
                }
                }
                    if(count==0){
                    if(j==11){
                    
                        inputs[j-2] =0;
                        inputs[j] = 1;
                    }
                    }
                if(count==2){
                    if(j==12){
                    
                        inputs[j] = 1;
                
                inputs[j-3] =0;
                    }
                    }
                if(count==3){
                    if(j==11){
                    
                        inputs[j] = 1;
                
                inputs[j-2] =0;
                    }
                    }
                if(count==4){
                    if(j==12){
                    
                        inputs[j] = 1;
                
                inputs[j-3] =0;
                    }
                    }
                if(count==5){
                    if(j==13){
                    
                        inputs[j] = 1;
                
                inputs[j-4] =0;
                    }
                    }
                } // j
            
            feedForward();
           
            for(int j = 0; j < Input_NeurNum; j++)
            {
                System.out.print(dfm.format(((inputs[j] * 1000.0) / 1000.0))+"  " );
//fw.write("\n"+dfm.format(((inputs[j] * 1000.0) / 1000.0)) + "  "+"\n");              
  analysis.print("\n"+dfm.format(((inputs[j] * 1000.0) / 1000.0)) + "  "+"\n");
            } // j
            System.out.print("Predicted Output: " + maximum(actual) + "\n");
            analysis.println("\n"+"Predicted Output: " + maximum(actual) + "  "+ "\n");
           // fw.write("\n"+"Predicted Output: " + maximum(actual) + "\n");
                }  
        } // i
            
/**/}
fw.close();
        return;
    }

     static int maximum(final double[] vector)
    {
        // This function returns the index of the maximum of vector().
        int sel = 0;
        double max = vector[sel];

        for(int index = 0; index < Output_NeurNum; index++)
        {
            if(vector[index] > max){
                max = vector[index];
                sel = index;
            }
        }
        return sel;
    }

     static void feedForward()
    {
        double sum = 0.0;

        // Calculate input to hidden layer.
        for(int hid = 0; hid < Hidden_NeurNum; hid++)
        {
            sum = 0.0;
            for(int inp = 0; inp < Input_NeurNum; inp++)
            {
                sum += inputs[inp] * wih[inp][hid];
            } // inp

            sum += wih[Input_NeurNum][hid]; // Add in bias.
            hidden[hid] = sigmoid(sum);
        } // hid

        // Calculate the hidden to output layer.
        for(int out = 0; out < Output_NeurNum; out++)
        {
            sum = 0.0;
            for(int hid = 0; hid < Hidden_NeurNum; hid++)
            {
                sum += hidden[hid] * who[hid][out];
            } // hid

            sum += who[Hidden_NeurNum][out]; // Add in bias.
            actual[out] = sigmoid(sum);
        } // out
        return;
    }

     static void backPropagate(){
       for(int out = 0; out < Output_NeurNum; out++) {   // Calculate the output layer error (step 3 for output cell).
                   erro[out] = (target[out] - actual[out]) * sigmoidDerivative(actual[out]);
        }
       for(int hid = 0; hid < Hidden_NeurNum; hid++) // Calculate the hidden layer error (step 3 for hidden cell).
        {
           errh[hid] = 0.0;
            for(int out = 0; out < Output_NeurNum; out++)
            {
                errh[hid] += erro[out] * who[hid][out];
            }
            errh[hid] *= sigmoidDerivative(hidden[hid]);
        }
         for(int out = 0; out < Output_NeurNum; out++) {   // Update the weights for the output layer (step 4).
            for(int hid = 0; hid < Hidden_NeurNum; hid++)
            {
                who[hid][out] += (LEARN_RATE * erro[out] * hidden[hid]);
            } // hid
            who[Hidden_NeurNum][out] += (LEARN_RATE * erro[out]); // Update the bias.
        } // out
        
        for(int hid = 0; hid < Hidden_NeurNum; hid++)      // Update the weights for the hidden layer (step 4).
        {
            for(int inp = 0; inp < Input_NeurNum; inp++)
            {
                wih[inp][hid] += (LEARN_RATE * errh[hid] * inputs[inp]);
            } // inp
            wih[Input_NeurNum][hid] += (LEARN_RATE * errh[hid]); // Update the bias.
        } // hid
        return;
    }

     static void assignRandomWeights()
    {
        for(int inp = 0; inp <= Input_NeurNum; inp++) // Do not subtract 1 here.
        {
            for(int hid = 0; hid < Hidden_NeurNum; hid++)
            {
                // Assign a random weight value between -0.5 and 0.5
                wih[inp][hid] = new Random().nextDouble() - 0.5;
            } // hid
        } // inp

        for(int hid = 0; hid <= Hidden_NeurNum; hid++) // Do not subtract 1 here.
        {
            for(int out = 0; out < Output_NeurNum; out++)
            {
                // Assign a random weight value between -0.5 and 0.5
                who[hid][out] = new Random().nextDouble() - 0.5;
            } // out
        } // hid
        return;
    }

     static double sigmoid(final double val)
    {
        return (1.0 / (1.0 + Math.exp(-val)));
    }

     static double sigmoidDerivative(final double val)
    {
        return (val * (1.0 - val));
    }
     
     static double normalizeInput(double a, double max){
         
         double tempans;
         tempans=a/max;
         
         return tempans;
     }
     public static String validate(double[] tests){
     System.out.println("Enter the inputs without spaces EX: 1001100...\n");
        //Scanner sc1=new Scanner(System.in);
        
        File f= new File("input.txt");
          NeuralNetwork(f);
          for(int b=0;b<Input_NeurNum;b++){
                inputs[b]=tests[b];
            }
            feedForward();
            
            for(int h=0;h<Input_NeurNum;h++){
                System.out.print("\n input for validation \n"+inputs[h]);
            }
            System.out.print("Predicted Output: " + maximum(actual) + "\n");
            if(maximum(actual)==0){
                return "EON";
            }
            if(maximum(actual)==1){
                return "I10";
            }
            if(maximum(actual)==2){
                return "I10 Grand";
            }
            if(maximum(actual)==3){
                return "Xcent";
            }
            if(maximum(actual)==4){
                return "I20 Elite Series";
            }
            if(maximum(actual)==5){
                return "I20 Active Series";
            }
            if(maximum(actual)==6){
                return "Fluidic Verna";
            }
            else{
                return "Santafe";
                }
        }
    
    public static void main(String[] args)
    {
        
        //validate();
        //EditableTable.main(trainInputs,trainOutput);
        int flag=0;
        if(flag==0){
        
       // EditableTable.main();
        //flag=1;
        }
             //  if(flag==1){ NeuralNetwork();}
        
        return;
    }

}
    

