package edu.bistu.hich;

import java.awt.Color;
import java.awt.Graphics;

/**
 * ��ͼ����
 * @author ��֮��
 * 05 - 27 - 2013
 */
public class DrawingUtils {
	
	/**
	 * ͨ��Բ�ĺͰ뾶��Բ��
	 * @param g Graphics
	 * @param x Բ��x����
	 * @param y Բ��y����
	 * @param r Բ�뾶
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
	 * ͨ��Բ�ĺͰ뾶��Բ
	 * @param g Graphics
	 * @param x Բ��x����
	 * @param y Բ��y����
	 * @param r Բ�뾶
	 */
	public static void drawCircleThroughCenter(Graphics g, int x, int y, int r) {
		int tmp_x = x - r;
		int tmp_y = y - r;
		int tmp_width = 2 * r;
		int tmp_height = 2 * r;
		g.drawOval(tmp_x, tmp_y, tmp_width, tmp_height);
	}
	
	/**
	 * ͨ������ͷ����������Բ
	 * @param g	Graphics
	 * @param x ��ͷx����
	 * @param y ��ͷy����
	 */
	public static void drawResistanceCircle(Graphics g, int x, int y){
		g.setColor(Color.RED);
		int r = (int)((double)x * x + y * y - 800 * x - 400 * y + 200000) / (800 - 2 * x);
		int tmp_x = 400 - r;
		int tmp_y = 200;
		drawCircleThroughCenter(g, tmp_x, tmp_y, r);
	}
	
	/**
	 * ͨ������ͷ�������翹Բ������
	 * @param g	Graphics
	 * @param x ��ͷx����
	 * @param y ��ͷy����
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
	 * ͨ������ͷ����������ϵ��Բ
	 * @param g	Graphics
	 * @param x ��ͷx����
	 * @param y ��ͷy����
	 */
	public static void drawReflectionCoefficientCircle(Graphics g, int x, int y){
		g.setColor(Color.GREEN);
		int r = (int)Math.sqrt((double)(x - 200) * (x - 200) + (y - 200) * (y - 200));
		drawCircleThroughCenter(g, 200, 200, r);
		g.drawLine(x, y, 200, 200);
	}
}
