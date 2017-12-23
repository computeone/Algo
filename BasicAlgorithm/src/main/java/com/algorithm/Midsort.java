package com.algorithm;
import java.util.Random;
public class Midsort {
	
	public int partition(int[] array,int left,int right,int pivotIndex){
		int tmp=array[right];
		array[right]=array[pivotIndex];
		array[pivotIndex]=tmp; //move pivoteIndex to right location
		
		int store=left;
		for(int i=left;i<right;i++){  
			if(array[i]<=array[right]){
				int tmp1=array[i];
				array[i]=array[store];
			    array[store]=tmp1;	
			    store++;
			}
		}
		int tmp2=array[right];
		array[right]=array[store];
		array[store]=tmp2;
		return store;
	}

	/**
	 * @param args
	 */
	public int selectIndex(int[] array,int left,int right,String cmd){
		if(cmd=="random"){
			Random random=new Random();
			int idx;
			while(true){
				idx=random.nextInt(right);
			     if(idx<left){
			    	continue;
			     }
			     else{
			    	 return idx;
			     }
			}
		}
		if(cmd=="left"){
			return left;
		}
		if(cmd=="mid"){
			return this.getMid(right-left+1);
		}
		if(cmd=="right"){
			return right;
		}
		else{
			return -1;
		}
	}
	public int  selectKth(int[] array,int k,int left,int right){//选择第K大元素
		/**
		 * 获取中值
		 */
		int idx=this.selectIndex(array, left, right,"left");
		int pivotIndex=this.partition(array, left, right, idx);
        if(left+k-1==pivotIndex){
        	return pivotIndex;
        }
        if(left+k-1<pivotIndex){
        	return this.selectKth(array, k, left, pivotIndex-1);
        }
        else {
        	return this.selectKth(array, k-(pivotIndex-left+1), pivotIndex+1, right);
        }
     }
	public static int getMid(int length){//得到一个数的中值
		if(length%2==0){
			return length/2;
		}
		else{
			return (length+1)/2;
		}
	}
	public void medianSort(int[] array,int left,int right){//中值排序
		if(left<right){
			int me=this.selectKth(array, this.getMid(right-left+1), left, right);
			int mid=this.getMid(right-left+1)-1+left;
			/**
			 * swap mid and me
			 */
			int tmp=array[mid];
			array[mid]=array[me];
			array[me]=tmp;
			/**
			 * 将比中值大的数与小于等于的数交换
			 */
			for(int i=left;i<mid;i++){
				if(array[i]>array[mid]){
					for(int j=mid+1;j<=right;j++){
						if(array[j]<=array[mid]){
							int tmp1=array[j];
							array[j]=array[mid];
							array[mid]=tmp1;
							break;
						}
					}
				}
			}
			this.medianSort(array, left, mid-1);//递归排序这个较小的子序列
			this.medianSort(array, mid+1,right);//递归排序这个较大的子序列
		}
	}
	public void quickSort(int[] array,int left,int right){
		if(left<right){
			int idx=this.selectIndex(array, left, right,"random");
			int pi=this.partition(array, left, right, idx);
			quickSort(array,left,pi-1);
			quickSort(array,pi+1,right);
		}
	}
	public void sort(int[] array){
		medianSort(array,0,array.length-1);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] array={15,9,8,1,4,7};
		int[] array1={15,9,8,1,4,11,7,12,13,6,5,3,16,2,10,14};
		Midsort midsort=new Midsort();
		long start_time=System.currentTimeMillis();
		//int mid=midsort.partition(array1,4,array1.length-8,5);
		//int mid=midsort.getMid(array.length);
		//int midnumber=midsort.selectKth(array, mid,0,array.length-1);
		//midsort.sort(array);
		//System.out.println("mid is "+mid);
		//System.out.println("midnumber is "+array[midnumber]);
		//midsort.sort(array1);
		midsort.quickSort(array1, 0, 15);
		long end_time=System.currentTimeMillis();
		System.out.println(end_time-start_time+"ms");

	}

}
