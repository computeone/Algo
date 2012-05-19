package foo;
import java.util.*;
public class Search {

	/**
	 * @param args
	 */
	public boolean search(Integer[] array,int p){//线性查找
		for(int i=0;i<array.length;i++){
			if(array[i]==p){
				return true;
			}
		}
		return false;
	}
	public boolean binarySearch(Integer[] array,int p){
		int low=0;
		int mid=0;
		int high=array.length-1;
		while(low<=high){
			mid=(Integer)(high+low)/2;
			if(array[mid]==p){
				return true;
			}
			else if(p<array[mid]){
				high=mid-1;
			}
			else if(p>array[mid]){
				low=mid+1;
			}
		}
		return false;
	}
	public ArrayList<LinkedList<Integer>> createHashTable(int size,Integer[] array){
		ArrayList<LinkedList<Integer>> hashTable=new ArrayList<LinkedList<Integer>>();
		for(int i=0;i<size;i++){
			hashTable.add(new LinkedList<Integer>());
		}
		for(int i=0;i<array.length;i++){
			int key=array[i]%size;
			LinkedList<Integer> list=hashTable.get(key);
			list.add(array[i]);
		}
		return hashTable;
	}
	public boolean hashSearch(Integer[] array,int p){
		ArrayList<LinkedList<Integer>> hashTable=this.createHashTable(4, array);
		int key=p%4;
		LinkedList<Integer> list=hashTable.get(key);
	    boolean result=list.contains(p);
		return result;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Search search=new Search();
		Integer[] array={1,2,5,8,10,14,34,55,0,66,100,458546};
		boolean result=search.binarySearch(array, 1);
		boolean result1=search.hashSearch(array, 100);
		System.out.println(result+" "+result1);

	}

}
