package test;
import junit.framework.Assert;
import foo.BuildHeap;
import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class BuildHeapTest {
	
	private int[] array={1,2,5,77,5,-11,0,2,41};
    private BuildHeap buildheap;
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		buildheap=new BuildHeap();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testBuildHeap() {
		//buildheap.buildHeap(array);
	}

	@Test
	public void testHeapify() {
	}

	@Test
	public void testCreateBuckets() {
	}

	@Test
	public void testCountSort() {
	}

	@Test
	public void testSort() {
		int[] arraytest={-11,0,1,2,2,5,5,41,77};
		//buildheap.sort(array);
		for(int i=0;i<array.length;i++){
			if(array[i]!=arraytest[i]){
				Assert.fail();
			}
		}
	}

}
