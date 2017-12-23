package com.algorithm;

//图的矩阵表示及其相关算法
public class GraphMatrix {
	private Integer[][] matrix;
	public GraphMatrix(Integer[][] matrix){
		this.matrix=matrix;
	}
	
	public void setGraph(Integer[][] relation){
		for(int i=0;i<matrix.length;i++){
			for(int j=0;j<matrix.length;j++){
				matrix[i][j]=0;
			}
			int k=relation[i].length;
			for(int m=0;m<k;m++){
				int index=relation[i][m];
				matrix[i][index]=1;
			}
		}
	}

}
