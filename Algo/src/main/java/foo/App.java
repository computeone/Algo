package foo;

import java.util.Random;

/**
 * Hello world!
 * 
 */
public class App {
	
	public void insertSort(Integer[] array) {
		int tmp=Integer.MAX_VALUE;
		int delete=0;
		int length = array.length;
		Integer[] arraytmp=array.clone();
		for (int i = length; i > 0; i--) {
			for (int j = 0; j < length; j++) {
				if (tmp > array[j]) {
					tmp = array[j];
					delete=j;
				}
				if(j==length-1){
					array[delete]=Integer.MAX_VALUE;
				}				
			}
			arraytmp[length-i]=tmp;
			tmp=Integer.MAX_VALUE;
		}
		for(int i=0;i<length;i++){
			array[i]=arraytmp[i];
			System.out.println(array[i]);
		}
	}
	public void Sort(int[] array){
		for(int i=0;i<array.length;i++){
			this.insert(array, i, array[i]);
		}
		
	}
	public void insert(int[] array,int pos,int value){
		int i=pos-1;
		while(i>=0&&array[i]>value){
			array[i+1]=array[i];
			i=i-1;
		}
		array[i+1]=value;
	}
	public static void main(String[] argv) {
		int[] array={12,45,36,2,45,41111};
	   // Integer array[]=new Integer[6];
	    java.util.Random random=new java.util.Random();
	   // for(int i=0;i<10000;i++){
	    //	array[i]=random.nextInt();
	   // }
		long START_TIME = System.currentTimeMillis();
		App app = new App();
		//app.insertSort(array);
		app.Sort(array);
	    for(int i=0;i<array.length;i++){
			System.out.println(array[i]);
		}
		long END_TIME = System.currentTimeMillis();
		System.out.println(END_TIME - START_TIME + "ms");

	}
}