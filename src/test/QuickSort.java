package test;

import util.SortPaint;
import util.Timer;

public class QuickSort implements Runnable {
	
	private int[] arrToSort;
	private SortPaint sp;
	private Timer t = new Timer();
	private boolean isOpenGUI = true;
	
	public QuickSort(int[] arr) {
		arrToSort = new int[arr.length];
		if(arr.length>100)isOpenGUI=false;
		for(int i = 0; i < arr.length; i++) {
			arrToSort[i] = arr[i];
		}
		if(isOpenGUI) {
			sp=new SortPaint("快速排序", arrToSort,510);
		}
	}
	
	public void sort(int start, int end) {
		if(start<end) {
			int former=start,later=end;
			int idx = arrToSort[(start+end)/2];
			while(former<=later) {
				while(arrToSort[former]<idx) {
					former++;
					if(isOpenGUI)sp.rePaint(arrToSort, former, later, start, end);
				}
				while(arrToSort[later]>idx) {
					later--;
					if(isOpenGUI)sp.rePaint(arrToSort, former, later, start, end);
				}
				if(former<later) {
					int tmp = arrToSort[former];
					arrToSort[former] = arrToSort[later];
					arrToSort[later] = tmp;
					former++;
					later--;
					if(isOpenGUI)sp.rePaint(arrToSort, former, later, start, end);
				} else if(former==later) {
					former++;
				}
			}
			sort(start, later);
			sort(former,end);
		}
	}

	@Override
	public void run() {
		sort(0, arrToSort.length-1);
		t.stop();
		System.out.println("快速排序用时：" + t.getTime());
	}
}
