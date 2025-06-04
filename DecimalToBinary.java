import java.util.Scanner;
public class DecimalToBinary{
	public static void main(String[]args){
		Scanner input=new Scanner(System.in);
		int decimal=input.nextInt();
		int result=decimal;
		String binary="";
		if(decimal!=0){
			while(result>0){
				int rem=result%2;
				binary=rem+binary;
				result=result/2;
			}
			System.out.println("conversion of decimal to binary"+binary);
		}else{
			System.out.println("the binary equalivalent of" +decimal+"is 0."); 
			}
	}
}
	
