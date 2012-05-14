package foo;

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
	public int  medianSort(int[] array,int left,int right){
		/**
		 * 获取中值
		 */
		int mid;
		mid=this.getMid(right-left+1)+left-1;
		int p=this.partition(array, left, right, left);
        if(mid>p+1){
             left=p;
         }
         if(mid<p+1){
         	right=p;
         }
         if(mid==p+1){
        	 return p;
         }
         this.medianSort(array, left, right);
         return -1;
	}
	public int getMid(int length){
		if(length%2==0){
			return length/2;
		}
		else{
			return (length+1)/2;
		}
	}
	public void sort(int[] array){
		int length;
		length=array.length;
		int left=0;
		int right=length-1;
		int mid=this.getMid(length);
		while(true){	
			int p=this.medianSort(array, left, right);
			int tmp=array[mid-1];
			array[mid-1]=array[p];
			array[p]=tmp;
            int tmpleft=left;
            int tmpright=mid-1;
            mid=this.medianSort(array, tmpleft, tmpright);
            mid++;
            if(tmpleft==tmpright){
            	break;
            }
		}
		
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] array={15,9,8,1,4,7};
		int[] array1={15,9,8,1,4,11,7,12,13,6,5,3,16,2,10,14};
		Midsort midsort=new Midsort();
		long start_time=System.currentTimeMillis();
		//int mid=midsort.partition(array1,4,array1.length-8,5);
		int midnumber=midsort.medianSort(array, 1, array.length-1);
		//midsort.sort(array);
		//System.out.println("mid is "+mid);
		System.out.println("midnumber is "+midnumber);
		long end_time=System.currentTimeMillis();

	}

}
