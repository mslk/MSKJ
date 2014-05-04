package com.meibaolian.util;

import java.math.BigDecimal;

/**
 * 报价转换器
 * 1、转换计算公式：
	按立方报价转成套
	A=1立方米=1/【（长/1000）*（宽/1000）*（厚/1000）】/4   套    取整数
	立方报价转成套报价=立方报价/ A   四舍五入，保留两位小数
	套报价转成立方报价=套报价* A   四舍五入，保留两位小数
 * 2、总价计算公式：
	立方报价总价=立方报价*立方数+物流费用   四舍五入，保留两位小数
	套报价总价=套报价*套数+物流费用    四舍五入，保留两位小数
	单价=总价/数量
 *
 * @author Kawin
 */
public class OfferTransverterUtil {
	  
	/*
	 * 议价器每次价格递减值,默认1毛钱
	 * */
	private final static float decreaseValue = 0.1F;
	
	 
	/**
	 * 获得议价器
	 * sear_to_feight_rates 套海到价
	 * number 立方数
	 * @return
	 */
	public static double[][] getDiscuss(double sear_to_feight_rates, int number){
		//将套报价转换成立方报价
		double cubeoffer = coverofferTransverterCubeoffer(sear_to_feight_rates, number);
		//3行2列,第1列是立方海到价 ,第2列是套海到价
		double discuss_prices[][] = new double[3][2];

		//套 海到价
		discuss_prices[0][1] = sear_to_feight_rates;//第一行第二列
		discuss_prices[1][1] = sear_to_feight_rates - decreaseValue;//第二行第二列
		discuss_prices[2][1] = sear_to_feight_rates - (decreaseValue*2);//第三行第二列
		//立方 海到价
		discuss_prices[0][0] = cubeoffer;//第一行第一列
		discuss_prices[1][0] = coverofferTransverterCubeoffer(discuss_prices[1][1], number);//第二行第一列
		discuss_prices[2][0] = coverofferTransverterCubeoffer(discuss_prices[2][1], number);//第三行第一列
		return discuss_prices;
	}
	
	 /**
	  * 获取套,根据立方数,长,宽,厚     
	  * 立方转套 A=1立方米=1/【（长/1000）*（宽/1000）*（厚/1000）】/4   套    取整数
	  * 立方总数 长 宽 厚
	  */
	 public static int getCoverBycubeLengthWidthThincknessint(int cubeNum, double length, double width, double thicknessint){
		 if(length < 1 || width < 1 || thicknessint <= 0)  
			 return 0;
		 int result = (int) ( cubeNum / ((length/1000) * (width/1000) * (thicknessint/1000)) / 4  ) ;
		 return result;
	 }
	 
	 /**
	  * 获取每套报价, 根据立方报价,套数
	  * 立方报价转成套报价 = 立方报价/ A   四舍五入，保留两位小数
	  * 立方报价 套数
	  */
	 public static double getCoverofferByCubeofferCoverNum(double cubeoffer, int coverNum){
		 if(coverNum < 1)
			 return 0;
		 double result = cubeoffer / coverNum;
		 return roundAndRetaiTwo(result);
	 }
	 
	 /**
	  * 获取每套报价, 根据立方数, 立方报价,长,宽,厚
	  * 立方报价转成套报价 = 立方报价/ A   四舍五入，保留两位小数
	  * 立方报价 套数
	  */
	 public static double getCoverofferByCubeofferCoverNum(int cubeNum, double cubeoffer,double length, double width, double thicknessint){
		 //获取套
		 int coverNum = getCoverBycubeLengthWidthThincknessint(cubeNum, length, width, thicknessint);
		  if(coverNum < 1) return 0;
		  double result = getCoverofferByCubeofferCoverNum(cubeoffer, coverNum);
		 return roundAndRetaiTwo(result);
	 }
	 
//	 /**
//	  * 获取海汽到价, 根据立方数, 立方报价,长,宽,厚,运费
//	  * 海汽到价 = 每套报价 + 运费
//	  */
//	 public static double getToFreightRates(int cubeNum, double cubeoffer,double length, double width, double thicknessint,double freightRates){
//		 if(freightRates < 1) return 0D; 
//		 double coveroffer = getCoverofferByCubeofferCoverNum(cubeNum, cubeoffer, length, width, thicknessint);
//		 if(coveroffer < 1 ) return 0;
//		 double result = roundAndRetaiTwo(coveroffer) + freightRates;
//		 return result;
//	 }
	
	 
	 
	 /**
	  * 获取立方报价,根据套报价,套数
	  * 套报价转成立方报价 = 套报价 * A   四舍五入，保留两位小数
	  */
	 public static double coverofferTransverterCubeoffer(double coveroffer, int coverNum){
		 double result = coveroffer * coverNum;
		 return roundAndRetaiTwo(result);
	 }
	 
	 /**
	  * 获取立方报价总价,根据立方报价,立方数,运费
	  * 立方报价总价=立方报价*立方数+物流费用   四舍五入，保留两位小数
	  * @return
	  */
	 public static double totalCobePrice(double cobeoffer, int cobeNum, double logisticsPrice){
		 double result = cobeoffer * cobeNum + logisticsPrice;
		 return roundAndRetaiTwo(result);
	 }
	 
	 /**
	  * 获取套报价总价,根据套报价, 套数, 运费
	  * 套报价总价= 套报价*套数+物流费用    四舍五入，保留两位小数
	  * @return
	  */
	 public static double totalCoverPrice(double coveroffer, int coverNum, double logisticsPrice){
		 double result = coveroffer * coverNum + logisticsPrice;
		 return roundAndRetaiTwo(result);
	 }
	 
	 /**
	  * 四舍五入后取后两位
	  * @param value
	  * @return
	  */
	 public static double roundAndRetaiTwo(double value){
		 BigDecimal temp = new BigDecimal(value);
		 return temp.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
	 }
	 
	 public static void main(String[] args) {
		 double  f   =   1000;
		 double  f2   =   0;
		 double d = getCoverofferByCubeofferCoverNum(100, 0);
		 System.out.println(d);
		 System.out.println(roundAndRetaiTwo(f));
		 System.out.println(roundAndRetaiTwo(f2)); 
	}
}
