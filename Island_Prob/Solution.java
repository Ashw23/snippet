package Island_Prob;

public class Solution {
int x; // row length
int y; // col length
char[][] g ;//size

public void countIsland(char[][] grid){
	g=grid;
	x=g[0].length;
	System.out.println("x:"+x);
	y=g.length;
	int count = 0;
	
	for(int i=0;i<y;i++){
		for(int j=0;j<x;j++)
		{
			if(g[i][j]=='1') {count++;
			System.out.println(count+"within loop count"+g[i][j]);
			dfs(g,i,j);}
		}
	}
	System.out.println(count);
}
	
public void dfs(char[][] g, int i, int j){
	
	if(i<0||j<0||i>=y || j>=x || g[i][j] !='1')return;
	g[i][j]=0;
	dfs(g,i+1,j);
	dfs(g,i-1,j);
	dfs(g, i,j+1);
	dfs(g, i,j-1);
}


}
