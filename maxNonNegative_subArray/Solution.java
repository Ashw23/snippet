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
		ArrayList<Integer> A2 = new ArrayList<Integer>();
		ArrayList<Integer> A3 = new ArrayList<Integer>();
		ArrayList<Integer> A4 = new ArrayList<Integer>();
		ArrayList<Integer> A5 = new ArrayList<Integer>();
		ArrayList<Integer> A6 = new ArrayList<Integer>();

		A1.add(1);
		A1.add(3);
		A1.add(5);
		A1.add(-9);
		A1.add(11); // o/p

		A2.add(-846930886);
		A2.add(-1714636915);
		A2.add(424238335);
		A2.add(-1649760492); // o/p 424238335

		A3.add(1967513926);
		A3.add(1540383426);
		A3.add(-1303455736);
		A3.add(-521595368); // o/p [1967513926, 1540383426]

		A4.add(756898537);
		A4.add(-1973594324);
		A4.add(-2038664370);
		A4.add(-184803526);
		A4.add(1424268980); // o/p 1424268980

		A5.add(1);
		A5.add(2);
		A5.add(3);
		A5.add(-7);
		A5.add(4); // o/p [1,2,3]

		A6.add(0);
		A6.add(0);
		A6.add(-1);
		A6.add(0); // o/p [0, 0]

	/*	ArrayList<Integer> resultList1 = maxset(A1);
		for (int i : resultList1) {
			System.out.println(i);
		}
		ArrayList<Integer> resultList2 = maxset(A2);
		for (int i : resultList2) {
			System.out.println(i);
		}
		ArrayList<Integer> resultList3 = maxset(A3);
		for (int i : resultList3) {
			System.out.println(i);
		}
		ArrayList<Integer> resultList4 = maxset(A4);
		for (int i : resultList4) {
			System.out.println(i);
		}
		ArrayList<Integer> resultList5 = maxset(A5);
		for (int i : resultList5) {
			System.out.println(i);
		}*/
		ArrayList<Integer> resultList6 = maxset(A6);
		for (int i : resultList6) {
			System.out.println("A6: " + i);
		}

	}

}


/* Editorial
 * public ArrayList<Integer> maxset(ArrayList<Integer> a) {
	    long maxSum = 0;
	    long newSum = 0;
	    ArrayList<Integer> maxArray = new ArrayList<Integer>();
	    ArrayList<Integer> newArray = new ArrayList<Integer>();
	    for (Integer i : a) {
	        if (i >= 0) {
	            newSum += i;
	            newArray.add(i);
	        } else {
	            newSum = 0;
	            newArray = new ArrayList<Integer>();
	        }
	        if ((maxSum < newSum) || ((maxSum == newSum) && (newArray.size() > maxArray.size()))) {
	            maxSum = newSum;
	            maxArray = newArray;
	        }
	    }
	    return maxArray;
	} */

/*Fastest
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
	}*/

/*Light Weight
public ArrayList<Integer> maxset(ArrayList<Integer> a) {
long maxSums[] = new long[a.size()];
int maxSumEnding[] = new int[a.size()]; //the end of a sub array the starts at the index of this array
long wholeSum[] = new long[a.size()];
boolean hitNegative[] = new boolean[a.size()];

for(int ct=0;ct<a.size();ct++)
{
    maxSums[ct] = a.get(ct);
    maxSumEnding[ct] = ct;
    wholeSum[ct] = a.get(ct);
    hitNegative[ct] = a.get(ct) < 0;
    for(int ct2=0;ct2<ct;ct2++)
    {
        if(a.get(ct) < 0)
            hitNegative[ct2] = true;
        if(hitNegative[ct2])
            continue;
        
        wholeSum[ct2]+=a.get(ct);
        if(wholeSum[ct2] >= maxSums[ct2])
        {
            maxSums[ct2] = wholeSum[ct2];
            maxSumEnding[ct2] = ct;
        }
    }
}

long biggestSum = maxSums[0];
int biggestItr = 0;

for(int ct=1;ct<a.size();ct++)
{
    if(biggestSum < maxSums[ct])
    {
        biggestSum = maxSums[ct];
        biggestItr = ct;
    }
    else if(biggestSum == maxSums[ct])
    {
        if((maxSumEnding[ct] - ct) > ( maxSumEnding[biggestItr] - biggestItr))
        {
             biggestSum = maxSums[ct];
             biggestItr = ct;
        }
    }
}

ArrayList<Integer> solution = new ArrayList<Integer>();

if(biggestSum < 0)
    return solution;

for(int ct=biggestItr;ct<=maxSumEnding[biggestItr];ct++)
{
    solution.add(a.get(ct));
}

return solution;
} */