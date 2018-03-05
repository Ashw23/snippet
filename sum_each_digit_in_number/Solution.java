package sum_each_digit_in_number;

public class Solution {

	//Design a method to sum of each digit in a number i.e. 123 into 1+2+3
	public static void main(String[] args) {
		// TODO Auto-generated method stub
          
		 int  a=123, b,sum=0; 	 
		 while(a>0){
			 b=a%10;
			 sum=sum+b;
			 a=a/10;
		 }
		 System.out.println(sum);
	}

}
