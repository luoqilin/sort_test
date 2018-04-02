package test;


public class Main{
	
	static int amount = 40;
	
	public static void main(String[] args) {
		int arr[] = new int[amount];
		
		
		for(int i = 0; i < amount; i++) {
			arr[i] = Math.toIntExact((long) (Math.random()*2000))%800 + 1;
		}
		BubleSort bublesort = new BubleSort(arr);
		QuickSort quicksort = new QuickSort(arr);
		
		
		Thread ta = new Thread(bublesort);
		Thread tb = new Thread(quicksort);
		
		ta.start();
		tb.start();
    }
}