package edu.bistu.hich;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

import javax.swing.JPanel;

/**
 * Chart Panel 图形面板
 * @author 仇之东
 * 05 - 26 - 2013
 */
public class ChartPanel extends JPanel {
	private static final long serialVersionUID = 1L;
	public static boolean flag = true;

	public void paint(Graphics g) {
		super.paint(g);
		
		g.setColor(Color.BLUE);
		DrawingUtils.drawCircleThroughCenter(g, 200, 200, 200);
		g.drawLine(0, 200, 400, 200);

		for (int i = 1; i < 8; i++) {
			int x = 400 - 25 * i;
			int y = 200;
			int r = 25 * i;
			DrawingUtils.drawCircleThroughCenter(g, x, y, r);
		}

		for (int i = 1; i < 5; i++) {
			int x = 400;
			int y = 200 - 50 * i;
			int r = 50 * i;
			DrawingUtils.drawArcThroughCenter(g, x, y, r);
		}

		DrawingUtils.drawArcThroughCenter(g, 400, 100, 300);
		DrawingUtils.drawArcThroughCenter(g, 400, -100, 500);
		DrawingUtils.drawArcThroughCenter(g, 400, -800, 1200);

		for (int i = 0; i < 5; i++) {
			int x = 400;
			int y = 200 + 50 * i;
			int r = 50 * i;
			DrawingUtils.drawArcThroughCenter(g, x, y, r);
		}

		DrawingUtils.drawArcThroughCenter(g, 400, 500, 300);
		DrawingUtils.drawArcThroughCenter(g, 400, 700, 500);
		DrawingUtils.drawArcThroughCenter(g, 400, 1400, 1200);

		MouseAction action = new MouseAction();
		this.addMouseMotionListener(action);
	}
	
	int tmp_x = 0, tmp_y = 0;

	class MouseAction implements MouseMotionListener {

		public void mouseMoved(MouseEvent e) {
			if (flag) {
				Point mousePoint = e.getPoint();
				int x = mousePoint.x;
				int y = mousePoint.y;

				if (tmp_x == x && tmp_y == y) {
					return;
				}

				//System.out.println("x --> " + x + ", y --> " + y);
				Graphics g = ChartPanel.this.getGraphics();
				update(g);

				tmp_x = x;
				tmp_y = y;

				long tmp = (x - 200) * (x - 200) + (y - 200) * (y - 200);
				if (tmp < 40000) {
					DrawingUtils.drawResistanceCircle(g, x, y);
					DrawingUtils.drawImpedanceArc(g, x, y);
					DrawingUtils.drawReflectionCoefficientCircle(g, x, y);
				} else {
					return;
				}
			}
		}

		public void mouseDragged(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
	}
}
