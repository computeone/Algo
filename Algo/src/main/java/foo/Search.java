package foo;

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
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Search search=new Search();
		Integer[] array={1,2,5,8,10,14};
		boolean result=search.binarySearch(array, 1);
		System.out.println(result);

	}

}
