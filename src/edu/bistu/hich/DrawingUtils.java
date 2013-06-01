package edu.bistu.hich;

import java.awt.Color;
import java.awt.Graphics;

/**
 * 画图工具
 * @author 仇之东
 * 05 - 27 - 2013
 */
public class DrawingUtils {
	
	/**
	 * 通过圆心和半径画圆弧
	 * @param g Graphics
	 * @param x 圆心x坐标
	 * @param y 圆心y坐标
	 * @param r 圆半径
	 */
	public static void drawArcThroughCenter(Graphics g, int x, int y, int r) {
		int tmp_x;
		int tmp_y;
		int tmp_width;
		int tmp_height;

		if (y < 200) {
			tmp_x = 400 - r;
			tmp_y = 200 - 2 * r;
			tmp_width = 2 * r;
			tmp_height = 2 * r;
			double angleTmp = (180 / Math.PI) * (Math.acos(((double) r * r - 40000) / (r * r + 40000)));
			int angle = (int) Math.rint(angleTmp);
			g.drawArc(tmp_x, tmp_y, tmp_width, tmp_height, 270 - angle, angle);
		} else {
			tmp_x = 400 - r;
			tmp_y = 200;
			tmp_width = 2 * r;
			tmp_height = 2 * r;
			double angleTmp = (180 / Math.PI) * (Math.acos(((double) r * r - 40000) / (r * r + 40000)));
			int angle = (int) Math.rint(angleTmp);
			g.drawArc(tmp_x, tmp_y, tmp_width, tmp_height, 90, angle);
		}
	}

	/**
	 * 通过圆心和半径画圆
	 * @param g Graphics
	 * @param x 圆心x坐标
	 * @param y 圆心y坐标
	 * @param r 圆半径
	 */
	public static void drawCircleThroughCenter(Graphics g, int x, int y, int r) {
		int tmp_x = x - r;
		int tmp_y = y - r;
		int tmp_width = 2 * r;
		int tmp_height = 2 * r;
		g.drawOval(tmp_x, tmp_y, tmp_width, tmp_height);
	}
	
	/**
	 * 通过鼠标箭头坐标作电阻圆
	 * @param g	Graphics
	 * @param x 箭头x坐标
	 * @param y 箭头y坐标
	 */
	public static void drawResistanceCircle(Graphics g, int x, int y){
		g.setColor(Color.RED);
		int r = (int)((double)x * x + y * y - 800 * x - 400 * y + 200000) / (800 - 2 * x);
		int tmp_x = 400 - r;
		int tmp_y = 200;
		drawCircleThroughCenter(g, tmp_x, tmp_y, r);
	}
	
	/**
	 * 通过鼠标箭头坐标作电抗圆（弧）
	 * @param g	Graphics
	 * @param x 箭头x坐标
	 * @param y 箭头y坐标
	 */
	public static void drawImpedanceArc(Graphics g, int x, int y){
		g.setColor(Color.YELLOW);
		int r = 0;
		
		if(y < 200){
			r = (int)((double)(200000 - 800 * x - 400 * y + x * x + y * y) / (400 - 2 * y));
			y = 200 - r;
		}
		if(y > 200){
			r = (int)((double)(200000 - 800 * x - 400 * y + x * x + y * y) / (2 * y - 400));
			y = 200 + r;
		}
		drawArcThroughCenter(g, x, y, r);
	}
	
	/**
	 * 通过鼠标箭头坐标作反射系数圆
	 * @param g	Graphics
	 * @param x 箭头x坐标
	 * @param y 箭头y坐标
	 */
	public static void drawReflectionCoefficientCircle(Graphics g, int x, int y){
		g.setColor(Color.GREEN);
		int r = (int)Math.sqrt((double)(x - 200) * (x - 200) + (y - 200) * (y - 200));
		drawCircleThroughCenter(g, 200, 200, r);
		g.drawLine(x, y, 200, 200);
	}
}
