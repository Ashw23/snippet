package pitDepth;

public class Solution {

public static  int solution(int[] A){
	int depth = 0;

    int first = 0;
    int mid = -1; 
    int last = -1;

    for (int i = 1; i < A.length; i++)
    {
        if (mid < 0 && A[i] >= A[i-1]) 
            mid = i-1;

        if ((mid >= 0 && last < 0) && 
            (A[i] <= A[i-1] || i + 1 == A.length))
        {
            if (A[i] <= A[i-1])
                last = i - 1;
            else
                last = i;
            depth = Math.max(depth, Math.min(A[first]-A[mid], A[last]-A[mid]));
            first = i - 1; 
            mid = last = -1;
        }
    }
    if (depth == 0) depth = -1;
    return depth;
	
}



}
