/**
 * Smith Chart ÑÝÊ¾³ÌÐò
 * 
 * ChartPanel ×ø±êÏµ					Smith Chart ×ø±êÏµ
 * (0, 0)		(400, 0)			(-1, 1)			(1, 1)
 * 
 * 		(200, 200)							(0, 0)
 * 
 * (0, 400)		(400, 400)			(-1, -1)		(1, -1)
 * 
 */

package edu.bistu.hich;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.JTextField;

/**
 * Smith Chart Ö÷Ãæ°å
 * @author ³ðÖ®¶«
 * 05 - 26 - 2013
 */
public class SmithChart extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JPanel chartPane;
	private JTextField swrText;
	private JTextField clcText;
	private JTextField reIi;
	private JTextField imIi;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SmithChart frame = new SmithChart();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public SmithChart() {
		setTitle("\u53F2\u5BC6\u65AF\u5706\u56FE\u6F14\u793A\u7A0B\u5E8F");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(300, 100, 780, 550);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);
		
		/********************************************************************
		 * Í¼ÐÎÃæ°å
		 */
		chartPane = new ChartPanel();
		chartPane.setBackground(Color.BLACK);
		chartPane.setBounds(25, 25, 400, 400);
		chartPane.setSize(new Dimension(400, 400));
		MouseAction action = new MouseAction();
		chartPane.addMouseListener(action);
		contentPane.add(chartPane);
		/********************************************************************/
		
		/********************************************************************
		 * Êý¾ÝÃæ°å
		 */
		JPanel dataPanel = new JPanel();
		dataPanel.setBounds(435, 25, 320, 476);
		contentPane.add(dataPanel);
		dataPanel.setLayout(null);
		
		//-------------------------------------------------------------------
		JPanel reflectionCoefficient = new JPanel();
		reflectionCoefficient.setBorder(new LineBorder(new Color(0, 0, 255)));
		reflectionCoefficient.setBounds(20, 10, 278, 122);
		dataPanel.add(reflectionCoefficient);
		reflectionCoefficient.setLayout(null);
		
		JLabel rcTitleLabel = new JLabel("\u53CD\u5C04\u7CFB\u6570");
		rcTitleLabel.setFont(new Font("Î¢ÈíÑÅºÚ", Font.BOLD, 16));
		rcTitleLabel.setBounds(5, 5, 68, 22);
		reflectionCoefficient.add(rcTitleLabel);
		
		JLabel swrLabel = new JLabel("\u7535\u538B\u9A7B\u6CE2\u6BD4 \u03C1=");
		swrLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		swrLabel.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 13));
		swrLabel.setBounds(20, 35, 90, 18);
		reflectionCoefficient.add(swrLabel);
		
		JLabel crcLabel = new JLabel("\u7B49\u53CD\u5C04\u7CFB\u6570 \u0393=");
		crcLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		crcLabel.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 13));
		crcLabel.setBounds(20, 60, 90, 18);
		reflectionCoefficient.add(crcLabel);
		
		JLabel elLabel = new JLabel("\u7535\u957F\u5EA6");
		elLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		elLabel.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 13));
		elLabel.setBounds(20, 85, 85, 18);;
		reflectionCoefficient.add(elLabel);
		
		swrText = new JTextField();
		swrText.setEditable(false);
		swrText.setHorizontalAlignment(SwingConstants.TRAILING);
		swrText.setBounds(115, 35, 66, 18);
		reflectionCoefficient.add(swrText);
		swrText.setColumns(10);
		
		clcText = new JTextField();
		clcText.setHorizontalAlignment(SwingConstants.RIGHT);
		clcText.setEditable(false);
		clcText.setColumns(10);
		clcText.setBounds(115, 60, 66, 18);
		reflectionCoefficient.add(clcText);
		//-------------------------------------------------------------------
		
		//-------------------------------------------------------------------
		JPanel singlestubMatching = new JPanel();
		singlestubMatching.setBorder(new LineBorder(Color.BLUE));
		singlestubMatching.setBounds(20, 142, 278, 122);
		dataPanel.add(singlestubMatching);
		singlestubMatching.setLayout(null);
		
		JLabel smTitleLabel = new JLabel("\u5355\u652F\u8282\u5339\u914D");
		smTitleLabel.setFont(new Font("Î¢ÈíÑÅºÚ", Font.BOLD, 16));
		smTitleLabel.setBounds(5, 5, 80, 22);
		singlestubMatching.add(smTitleLabel);
		
		JLabel stubLenLabel = new JLabel("\u77ED\u622A\u7EBF\u957F\u5EA6");
		stubLenLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		stubLenLabel.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 13));
		stubLenLabel.setBounds(20, 40, 85, 22);
		singlestubMatching.add(stubLenLabel);
		
		JLabel stubPosLabel = new JLabel("\u77ED\u622A\u7EBF\u4F4D\u7F6E");
		stubPosLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		stubPosLabel.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 13));
		stubPosLabel.setBounds(20, 75, 85, 22);
		singlestubMatching.add(stubPosLabel);
		//-------------------------------------------------------------------
		
		//-------------------------------------------------------------------
		JPanel inputImpedance = new JPanel();
		inputImpedance.setBorder(new LineBorder(Color.BLUE));
		inputImpedance.setBounds(20, 274, 278, 122);
		dataPanel.add(inputImpedance);
		inputImpedance.setLayout(null);
		
		JLabel iiTitleLabel = new JLabel("\u8F93\u5165\u963B\u6297");
		iiTitleLabel.setFont(new Font("Î¢ÈíÑÅºÚ", Font.BOLD, 16));
		iiTitleLabel.setBounds(5, 5, 68, 22);
		inputImpedance.add(iiTitleLabel);
		
		JLabel iiLabel = new JLabel("\u8F93\u5165\u963B\u6297 Z=");
		iiLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		iiLabel.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 13));
		iiLabel.setBounds(20, 50, 90, 18);
		inputImpedance.add(iiLabel);
		
		reIi = new JTextField();
		reIi.setHorizontalAlignment(SwingConstants.TRAILING);
		reIi.setEditable(false);
		reIi.setColumns(10);
		reIi.setBounds(115, 50, 66, 18);
		inputImpedance.add(reIi);
		
		JLabel lblNewLabel = new JLabel("+j");
		lblNewLabel.setBounds(185, 50, 15, 18);
		inputImpedance.add(lblNewLabel);
		
		imIi = new JTextField();
		imIi.setHorizontalAlignment(SwingConstants.TRAILING);
		imIi.setEditable(false);
		imIi.setColumns(10);
		imIi.setBounds(200, 50, 66, 18);
		inputImpedance.add(imIi);
		//-------------------------------------------------------------------
		/********************************************************************/

		/********************************************************************
		 * ±êÌâÃæ°å
		 */
		JPanel titlePanel = new JPanel();
		titlePanel.setBounds(100, 435, 260, 50);
		contentPane.add(titlePanel);
		JLabel appTitle = new JLabel("\u53F2\u5BC6\u65AF\u5706\u56FE\u6F14\u793A\u7A0B\u5E8F");
		titlePanel.add(appTitle);
		appTitle.setFont(new Font("ËÎÌå", Font.PLAIN, 28));
		appTitle.setHorizontalAlignment(SwingConstants.CENTER);
		/********************************************************************/
	}
	
	class MouseAction implements MouseListener{
		
		public void mouseClicked(MouseEvent e) {
			System.out.println("Mouse Clicked!!!");
			
			Point mousePoint = e.getPoint();
			int x = mousePoint.x;
			int y = mousePoint.y;
			System.out.println("x --> " + x + ", y --> " + y);
			
			long tmp = (x - 200) * (x - 200) + (y - 200) * (y - 200);
			if (tmp < 40000) {
				ChartPanel.flag = !ChartPanel.flag;
				if(ChartPanel.flag == false){
					swrText.setText(ComputingUtils.subString(ComputingUtils.calRho(x, y) + ""));
					clcText.setText(ComputingUtils.subString(ComputingUtils.calGamma(x, y) + ""));
					reIi.setText(ComputingUtils.subString(ComputingUtils.calZReal(x, y) + ""));
					imIi.setText(ComputingUtils.subString(ComputingUtils.calZImag(x, y) + ""));
				}
			}
		}

		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		public void mousePressed(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
	}
}
