package edu.bistu.hich;

/**
 * 数据计算工具
 * @author 仇之东
 * 05 - 29 - 2013
 */
public class ComputingUtils {
	
	/**
	 * 转换x坐标
	 * @param x ChartPanel x坐标值
	 * @return SmithChart x坐标值
	 */
	public static double translateX(int x){
		return ((double)(x - 200) / 200);
	}
	
	/**
	 * 转换y坐标
	 * @param y ChartPanel y坐标值
	 * @return SmithChart y坐标值
	 */
	public static double translateY(int y){
		return ((double)(y - 200) / 200);
	}
	
	/**
	 * 显示长度控制
	 * @param string 要显示的字符串
	 * @return 前10个字符
	 */
	public static String subString(String string){
		if(string.length() > 10){
			string = string.substring(0, 9);
		}
		return string;
	}
	
	/**
	 * 计算反射系数绝对值
	 * @param x 鼠标x坐标
	 * @param y 鼠标y坐标
	 * @return 计算结果
	 */
	public static double calGamma(int x, int y){
		double tmpX = translateX(x);
		double tmpY = translateY(y);
		return tmpX * tmpX + tmpY * tmpY;
	}
	
	/**
	 * 计算电压驻波比
	 * @param x 鼠标x坐标
	 * @param y 鼠标y坐标
	 * @return 计算结果
	 */
	public static double calRho(int x, int y){
		double tmpGamma = calGamma(x, y);
		return (1 + tmpGamma) / (1 - tmpGamma);
	}
	
	/**
	 * 计算输入阻抗实部
	 * @param x 鼠标x坐标
	 * @param y 鼠标y坐标
	 * @return 计算结果
	 */
	public static double calZReal(int x, int y){
		double r = (((double)x * x + y * y - 800 * x - 400 * y + 200000) / (800 - 2 * x)) / 200;
		return (1 - r) / r;
	}
	
	/**
	 * 计算输入阻抗虚部
	 * @param x 鼠标x坐标
	 * @param y 鼠标y坐标
	 * @return 计算结果
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
