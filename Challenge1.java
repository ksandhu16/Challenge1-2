
import java.util.Scanner; 
import java.lang.String;
import java.math.RoundingMode;
import java.text.DecimalFormat;

class Main {
 //This fuction is used to get spread to benchmark up to two decimal places
      private static DecimalFormat df = new DecimalFormat("0.00");
     

//Spread to benchmark for C1 and G1
    private static double spread_to_benchmark(){
    double C1yield = 5.3; 	
  	double G1yield = 3.7;
    double totalyield = C1yield - G1yield;
    return totalyield;
     }

//Spread to benchmark for C1 and G2
    private static double spread_to_benchmark2(){
    double C1yield = 5.3; 	
  	double G2yield = 4.8;
    double totalyield = C1yield - G2yield;
    return totalyield;
     }

  public static void main(String[] args) {
     double  c1,g1,g2;
    double termC1, termG1, termG2;
    
 	Scanner sc = new Scanner(System.in); 
   System.out.println("Enter the bond type");
     // String input 
        String bond = sc.nextLine(); 
    
    System.out.println("The bond entered is : " + bond);
   
    System.out.println("Enter the SECOND bond type");
    // String input 
        String bond2 = sc.nextLine(); 
    
    System.out.println("The bond entered is : " + bond2);
    System.out.println("------------------------------");
   if((bond.contains("C1")) && (bond2.contains("G1"))){
   //Calling function to view the spread to benchmark
    double total = spread_to_benchmark();
    System.out.println("bond,benchmark,spread_to_benchmark");
    System.out.println(bond + "," + bond2 + "," + df.format(total) + "%");
   }

   else if((bond.contains("C1")) && (bond2.contains("G2"))){
   //Calling function to view the spread to benchmark
    double total = spread_to_benchmark2();
    System.out.println("bond,benchmark,spread_to_benchmark");
    System.out.println(bond + "," + bond2 + "," + df.format(total) + "%");

   }
   else {
	   //testing if any bond entered is incorrect output the followin statement
    System.out.println("You Entered an Illegal Bond");

   }


  }
}
