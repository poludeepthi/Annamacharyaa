import java.util.Scanner;
class Swap{
	public static void main(String[] args){
		Scanner input=new Scanner(System.in);
		System.out.println("enter the values of a and b");
		int a=input.nextInt();
		int b=input.nextInt();
		System.out.println("before swapping:a="+a+" and b="+b);
		a=a+b;
		b=a-b;
		a=a-b;
		System.out.println("after swapping:a="+a+" and b="+b);
	}
}