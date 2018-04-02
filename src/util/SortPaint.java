package util;

import java.awt.Graphics;

import javax.swing.JFrame;

public class SortPaint {
	private JFrame window;
	private Graphics jg;
	private int rectWidth = 30;
	private int winHeight = 500;
	
	public SortPaint(String title, int[] initArray,int height) {
		window = new JFrame(title);
		window.setVisible(true);
		window.setSize((initArray.length+2) * rectWidth, winHeight);
		window.setLocation(50, height);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jg=window.getGraphics();
		for(int i = 0; i < initArray.length; i++) {
			paintRect(initArray[i], i);
		}
	}
	
	public void rePaint(int[] datas,int formerPos, int laterPos, int start, int end) {
		window.update(jg);
		for(int i = 0; i < datas.length; i++) {
			paintRect(datas[i], i);
		}
		jg.drawString("▲", rectWidth*formerPos+rectWidth, winHeight-25);
		jg.drawString("△", rectWidth*laterPos+rectWidth, winHeight-25);
		jg.drawLine(rectWidth*start+3*rectWidth/2, winHeight-20, rectWidth*end+3*rectWidth/2, winHeight-20);
		try {
			Thread.sleep(50);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	private void paintRect(int height, int postion) {
    	jg.drawRect(rectWidth*postion+rectWidth, winHeight-50-height/2, rectWidth, height/2);
    	
    	//输出数量--当方格过小的时候请注释
//    	jg.drawString(String.valueOf(height), rectWidth*postion+rectWidth, winHeight-35);
    }

	public void clear() {
		// TODO Auto-generated method stub
		window.update(jg);
	}
}
