package operation;

// division without using div operator
public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int a=10, b=2;
		int count=0;
		while(a>=b){
			a=a-b;
			count++;
		}
System.out.println("a/b=  "+count);
	}

}
