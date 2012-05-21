package foo;
import java.util.*;
public class BuildHeap {
	/**
	 * @param args
	 */
	public void buildHeap(int[] array){//堆排序
		int mid=Midsort.getMid(array.length-1);
		for(int i=mid-1;i>=0;i--){
			heapify(array,i,array.length); 
		}
	}
	public void heapify(int[] array,int idx,int max){//维持堆性质
		int left=2*idx+1;
		int right=2*idx+2;
		int largest;
		if(left<max&&array[left]>array[idx]){
			largest=left;
		}
		else largest=idx;
		if(right<max&&array[right]>array[largest]){
			largest=right;
		}
		if(largest!=idx){
			int tmp=array[idx];
			array[idx]=array[largest];
			array[largest]=tmp;
			heapify(array,largest,max);
		}
	}
	public ArrayList<Integer> createBuckets(){
        ArrayList<Integer> array=new ArrayList<Integer>();
        return array;
	}
	public void countSort(int[] array){ //计数排序
		ArrayList<Integer> buckets=this.createBuckets();
		for(int i=0;i<10;i++){
			buckets.add(0);
		}
		for(int i=0;i<array.length;i++){//计数
			int tmp=buckets.get(array[i])+1;
			buckets.set(array[i],tmp);
			}
	    int idx=0;
	    for(int i=0;i<buckets.size();i++){//重新排序
	    	while(buckets.get(i)!=0){
	    		array[idx++]=i;
	    		int tmp1=buckets.get(i)-1;
	    		buckets.set(i, tmp1);
	    	}
	    }
	 }
	public void sort(int[]  array){
		buildHeap(array);
		for(int i=array.length-1;i>0;i--){
		    int tmp=array[0];
		    array[0]=array[i];
		    array[i]=tmp;
			heapify(array,0,i);
		}
	}
	public int getHash(int elem){
		return (int)(elem/4);
	}
	public void bucketSort(int[] array){
		ArrayList<LinkedList<Integer>> buckets=new ArrayList<LinkedList<Integer>>();
		for(int i=0;i<5;i++){
			buckets.add(new LinkedList<Integer>());
		}
		for(int i=0;i<array.length;i++){
			LinkedList<Integer> linkedlist=buckets.get(this.getHash(array[i]));
			linkedlist.add(array[i]);
		}
		int sum=0;
		for(int i=0;i<buckets.size();i++){//取出桶中的元素
			Iterator<Integer> iterator=buckets.get(i).iterator();
			while(iterator.hasNext()){
				for(int j=sum;j<array.length;j++){
					if(iterator.hasNext()){
						array[j]=(Integer)iterator.next();
					}
					else{
						this.insertSort(array, sum+1, j);
						sum=j;
						break;
					}
				}
			}
		}
	}
	public void insertSort(int[] array,int start,int end){
		for(int i=start;i<end;i++){
			int pos=i-1;
			int value=array[i];
			while(pos>=0&&array[pos]>value){
				array[pos+1]=array[pos];
				pos--;
			}
			array[pos+1]=value;
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] array={0,1,4,2,3,4,1,2,3,2,3};
		int []array1={5,3,16,2,10,14,12,11};
		BuildHeap buildheap=new BuildHeap();
		//buildheap.countSort(array);
		//buildheap.sort(array1);
	    buildheap.bucketSort(array1);
		buildheap.insertSort(array1, 1, 8);
		System.out.println();

	}

}
