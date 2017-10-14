package com.landon.leetcode;

public class Friend_Circles_547 {

	//并查集
	public int findCircleNum(int[][] M) {
        int n = M.length;
		//初始化并查集的parent数组
		int []parent = new int[n];
		for(int i = 0; i < n; ++i){
			parent[i] = i;
		}
		
		for(int i= 0; i < n; ++i){
			for(int j = i + 1; j < n; j ++){
				if(M[i][j] == 1){
					int rooti = getRoot(parent, i);
					int rootj = getRoot(parent, j);
					if(rooti != rootj){
						parent[rooti] = rootj;
					}
				}
			}
		}
		int result = 0;
		for(int i = 0 ;i < n; ++i){
			if(parent[i] == i){
				result++;
			}
		}
		return result;
    }
    
    public int getRoot(int[] parent,int i){
		while(parent[i] != i){
			i = parent[i];
		}
		return i;
	}
}
