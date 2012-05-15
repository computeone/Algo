package test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import foo.Midsort;
import junit.framework.Assert;
public class MidsortTest {
	private Midsort midsort;
	long start_time;
	long end_time;
	int[] array={15,9,8,1,4,7};
	int[] array1={15,9,8,1,4,11,7,12,13,6,5,3,16,2,10,14,5454,-4,4564,4564,-5454561,0,1};
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		midsort=new Midsort();
	}
	
	@After
	public void tearDown()throws Exception{
		int[] arraytmp={15,8,9,1,4,7};
		for(int i=0;i<array.length;i++){
			array[i]=arraytmp[i];
		}
	}

	@Test
	public void testPartition() {
		int p=midsort.partition(array1, 0, 15,9);
		int p1=midsort.partition(array, 2, 4, 3);
		Assert.assertEquals(2, p1);
		Assert.assertEquals(5,p);
	}

	@Test
	public void testSelectKth(){
		int mid=midsort.selectKth(array, 3, 0, 5);
		Assert.assertEquals(7,array[mid]);
	}
	
	@Test
	public void testMedianSort() {
	}

	@Test
	public void testGetMid() {
		int mid=midsort.getMid(101);
		Assert.assertEquals(51, mid);
	}

	@Test
	public void testSort() {
		midsort.sort(array);
		int[] testarray={1,4,7,8,9,15};
		for(int i=0;i<array.length;i++){
		Assert.assertEquals(array[i], testarray[i]);
		}
		
	}

}
