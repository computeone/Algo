package test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import foo.Midsort;
import junit.framework.Assert;
public class MidsortTest {
	private Midsort midsort;
	long start_time;
	long end_time;
	int[] array={15,8,9,1,4,7};
	int[] array1={15,9,8,1,4,11,7,12,13,6,5,3,16,2,10,14};
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		midsort=new Midsort();
	}

	@Test
	public void testPartition() {
		int p=midsort.partition(array1, 0, 15,9);
		int p1=midsort.partition(array, 2, 4, 3);
		Assert.assertEquals(2, p1);
		Assert.assertEquals(5,p);
	}

	@Test
	public void testMedianSort() {
		
	}

	@Test
	public void testGetMid() {
		
	}

	@Test
	public void testSort() {
		
	}

}
