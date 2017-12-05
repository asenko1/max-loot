package main;
//This algorithm solves the fractional knapsack problem using a greedy algorithm

import java.util.Scanner;

public class LootOptimizer {
    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int capacity = scanner.nextInt();
        int[] values = new int[n];
        int[] weights = new int[n];
        for (int i = 0; i < n; i++) {
            values[i] = scanner.nextInt();
            weights[i] = scanner.nextInt();
        }
        System.out.println(getOptimalValue(capacity, values, weights));
    }
    
    public static double getOptimalValue(int capacity, int[] values, int[] weights) {
    	//Idea: take largest weight/value ratio and add to pack, then next largest, then next until full
        double value = 0;
        int[] weightValueRatio = new int[values.length];
        for(int i : values){
        	weightValueRatio[i] = values[i]/weights[i]; //unit: $/kg
        }
        
        //Could call Arrays.sort, but that would mess up the indexing. As is, 1 index in all arrays
        //refers to the same item. If greater performance is needed, this can be refactored to something faster
        
        int i = 0;
        while(capacity > 0 && i < values.length){
        	int max = 0; 
        	int index = 0;
        	//Find max, n^2 algorithm -> should refactor later
        	for(int j = 0; j < values.length; j++){
        		if(weightValueRatio[j] > max){
        			max = weightValueRatio[i];
        			index = j;
        		}
        	}
        	//now have index j which refers to max ratio item in all arrays
        	if(capacity >= weights[index]){
        		//take all of item
        		capacity = capacity - weights[index];
        		value = (double) values[index] * weights[index];
        	}
        	else{
        		//take fraction of item to fill capacity
        		value = (double) values[index] * (weights[index] - capacity);
        		capacity = 0;
        	}
        }
        return value;
    }
} 

