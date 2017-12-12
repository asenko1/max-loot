package main;

import static org.junit.Assert.*;

import org.junit.Test;

public class LootOptimizerTest {
	public int[] values;
	public int[] weights;
	public int capacity;
	
	@Test
	public void getOptimalValueCorrectnessTest() {
		LootOptimizer test = new LootOptimizer();
		
		//test correctness
		double expected = 180;
		values = new int[]{60,100,120};
		weights = new int[]{20,50,30};
		capacity = 50;
		assertEquals(expected, test.getOptimalValue(capacity, values, weights), 0);
		
		expected = (double) 500 / 3;
		values = new int[]{500};
		weights = new int[]{30};
		capacity = 10;
		assertEquals(expected, test.getOptimalValue(capacity, values, weights), 0);
	
	}
	
	@Test
	public void getOptimalValueEmptyTest(){
		LootOptimizer test = new LootOptimizer();
		//test empty
		values = new int[]{};
		weights = new int[]{};
		capacity = 0;
		assertEquals(0, test.getOptimalValue(capacity, values, weights), 0);
		capacity = 1;
		assertEquals(0, test.getOptimalValue(capacity, values, weights), 0);
	}
	
	@Test
	public void getOptimalValueNullTest(){
		LootOptimizer test = new LootOptimizer();
		//test null
		values = null;
		weights = null;
		capacity = 0;
		assertEquals(0, test.getOptimalValue(capacity, values, weights), 0);
		capacity = 1;
		assertEquals(0, test.getOptimalValue(capacity, values, weights), 0);
	}

}
