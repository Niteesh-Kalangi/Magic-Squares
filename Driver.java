import java.util.Scanner;
public class Driver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		Scanner z=new Scanner(System.in);
		int num;
		System.out.println("What dimension?");
		num=z.nextInt();
		MagicSquare x=new MagicSquare(num);
	
		boolean i=true;
		String y="";
		

		while(x.checkIfMagic()==false||i==true) {
		x.randomize();
		
		if(x.checkIfMagic()==true) {
			
			System.out.println("If you want to see another magic square, press any key. Type 'no' if you don't.");
			y=z.nextLine();
		if(y.equals("no"))
			break; 
		System.out.println(x);
		
			
			
		
		}
		}
		
	
		
	
		
		

		
		
		
		

	}


	 	

	
}