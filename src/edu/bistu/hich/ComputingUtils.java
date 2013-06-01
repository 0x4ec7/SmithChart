package edu.bistu.hich;

/**
 * ���ݼ��㹤��
 * @author ��֮��
 * 05 - 29 - 2013
 */
public class ComputingUtils {
	
	/**
	 * ת��x����
	 * @param x ChartPanel x����ֵ
	 * @return SmithChart x����ֵ
	 */
	public static double translateX(int x){
		return ((double)(x - 200) / 200);
	}
	
	/**
	 * ת��y����
	 * @param y ChartPanel y����ֵ
	 * @return SmithChart y����ֵ
	 */
	public static double translateY(int y){
		return ((double)(y - 200) / 200);
	}
	
	/**
	 * ��ʾ���ȿ���
	 * @param string Ҫ��ʾ���ַ���
	 * @return ǰ10���ַ�
	 */
	public static String subString(String string){
		if(string.length() > 10){
			string = string.substring(0, 9);
		}
		return string;
	}
	
	/**
	 * ���㷴��ϵ������ֵ
	 * @param x ���x����
	 * @param y ���y����
	 * @return ������
	 */
	public static double calGamma(int x, int y){
		double tmpX = translateX(x);
		double tmpY = translateY(y);
		return tmpX * tmpX + tmpY * tmpY;
	}
	
	/**
	 * �����ѹפ����
	 * @param x ���x����
	 * @param y ���y����
	 * @return ������
	 */
	public static double calRho(int x, int y){
		double tmpGamma = calGamma(x, y);
		return (1 + tmpGamma) / (1 - tmpGamma);
	}
	
	/**
	 * ���������迹ʵ��
	 * @param x ���x����
	 * @param y ���y����
	 * @return ������
	 */
	public static double calZReal(int x, int y){
		double r = (((double)x * x + y * y - 800 * x - 400 * y + 200000) / (800 - 2 * x)) / 200;
		return (1 - r) / r;
	}
	
	/**
	 * ���������迹�鲿
	 * @param x ���x����
	 * @param y ���y����
	 * @return ������
	 */
	public static double calZImag(int x, int y){
		double r = 0;
		
		if(y < 200){
			r = ((double)(200000 - 800 * x - 400 * y + x * x + y * y) / (400 - 2 * y)) / 200;
		}
		if(y > 200){
			r = ((double)(200000 - 800 * x - 400 * y + x * x + y * y) / (2 * y - 400)) / 200;
		}
		
		return 1/ r;
	}
	
}
