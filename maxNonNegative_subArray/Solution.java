package interviewBit_MaxNonNegative_SubArray;

import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * 
 * @author Ashwini Find out the maximum sub-array of non negative numbers from
 *         an array. The sub-array should be continuous. That is, a sub-array
 *         created by choosing the second and fourth element and skipping the
 *         third element is invalid.
 * 
 *         Maximum sub-array is defined in terms of the sum of the elements in
 *         the sub-array. Sub-array A is greater than sub-array B if sum(A) >
 *         sum(B).
 * 
 *         Example:
 * 
 *         A : [1, 2, 5, -7, 2, 3] The two sub-arrays are [1, 2, 5] [2, 3]. The
 *         answer is [1, 2, 5] as its sum is larger than [2, 3]
 */

public class Solution {

	public static ArrayList<Integer> maxset(ArrayList<Integer> A) {
		long sum = 0, max_sum = 0;
		ArrayList<Integer> subList = new ArrayList<Integer>();

		ArrayList<Integer> max_sumList = new ArrayList<Integer>();
		
		for (int i = 0; i < A.size(); i++) {
			if (A.get(i) < 0) {
				if (sum >= max_sum) {
					max_sum = sum;
					// max_sumList.clear();
					max_sumList = new ArrayList<Integer>();
					max_sumList.addAll(subList);
					sum = 0;
					// subList.clear();
					subList = new ArrayList<Integer>();
				} else if (sum <= max_sum)
					sum = 0;
				subList.clear();
			} else {
				sum += A.get(i);
				subList.add(A.get(i));
				if (sum > max_sum) {
					max_sum = sum;
					max_sumList.clear();
					max_sumList.addAll(subList);
				}
			}
		}
		return max_sumList;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Integer> A1 = new ArrayList<Integer>();
		

		A1.add(1);
		A1.add(3);
		A1.add(5);
		A1.add(-9);
		A1.add(11); 

		

		ArrayList<Integer> resultList1 = maxset(A1);
		for (int i : resultList1) {
			System.out.println(i);
		}
		

	}

}


// one more approach
public ArrayList<Integer> maxset(ArrayList<Integer> a) {
	    long max=-1;
	    long max1=0;
	    int start_index=0,last_index=0,temp=0;
	    Integer [] arr=a.toArray(new Integer[a.size()]);
        Integer [] arr1=a.toArray(new Integer[a.size()]);
	    int n=a.size();
	    for(int i=0;i<n;i++)
	    {
	        if(i!=0 && arr[i-1]>=0 && arr[i]>=0)
	        {
	            max1+=arr[i];
	            if(i==n-1 && max<max1)
	            {
	                max=max1;
	                last_index=i;
	                start_index=temp;
	            }else if(i==n-1 && max== max1)
	            {
	                int length1=last_index- start_index+1;
	                int lenght2=i-temp+1;
	                if(lenght2>length1)
	                {
	                    last_index=i;
	                    start_index=temp;
	                }
	            }
	        }
	        else if(arr[i]>=0)
	        {
	            temp=i;
	            max1=arr[i];
	            if(i==n-1 && max<max1)
	            {
	                max=max1;
	                last_index=i;
	                start_index=temp;
	            }
	            else if(i==n-1 && max== max1)
	            {
	                int length1=last_index- start_index+1;
	                int lenght2=i-temp+1;
	                if(lenght2>length1)
	                {
	                    last_index=i;
	                    start_index=temp;
	                }
	            }
	        }
	        else if(i!=0 && arr[i]<0 && arr[i-1]>=0)
	        {
	            if(max<max1){
	                max=max1;
	                max1=0;
	                start_index=temp;
	                last_index=i-1;
	            }
	            else if(max == max1)
	            {
	                max1=0;
	                int length1=last_index- start_index+1;
	                int lenght2=i-1 -temp+1;
	                if(lenght2>length1)
	                {
	                    last_index=i-1;
	                    start_index=temp;
	                }
	            }
	        }
	    }
	    a.clear();
	    if(max==-1)
	        return a;
	    for(int i=start_index;i<=last_index;i++)
	    {
	        
	        a.add(arr1[i]);
	    }
	    
	    return a;
	}

