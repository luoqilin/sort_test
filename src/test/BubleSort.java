package test;

import util.SortPaint;
import util.Timer;

public class BubleSort implements Runnable {
	
	private int[] arrToSort;
	private SortPaint sp;
	Timer t = new Timer();
	private boolean isOpenGUI = true;
	
	public BubleSort(int[] arr) {
		arrToSort = new int[arr.length];
		if(arr.length>100)isOpenGUI=false;
		for(int i = 0; i < arr.length; i++) {
			arrToSort[i] = arr[i];
		}
		if(isOpenGUI)sp=new SortPaint("冒泡排序", arrToSort, 10);
	}
	
	@Override
	public void run() {
		sort();
		t.stop();
		System.out.println("冒泡排序用时：" + t.getTime());
	}
	public void sort() {
		for(int i = arrToSort.length-1; i > 0; i--) {
			for(int j = 0; j < i; j++) {
				if(isOpenGUI)sp.rePaint(arrToSort, j, j, 0, i);
				if(arrToSort[j] > arrToSort[j+1]) {
					int tmp = arrToSort[j];
					arrToSort[j] = arrToSort[j+1];
					arrToSort[j+1] = tmp;
					if(isOpenGUI)sp.rePaint(arrToSort, j, j, 0, i);
				}
				
			}
		}
	}
}
