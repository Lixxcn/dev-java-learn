package cn.lixx.designpatterns.bridge;

import cn.lixx.designpatterns.bridge.bridge.BossCar;
import cn.lixx.designpatterns.bridge.bridge.ElectricEngine;
import cn.lixx.designpatterns.bridge.bridge.HybridEngine;
import cn.lixx.designpatterns.bridge.bridge.RefinedCar;
import cn.lixx.designpatterns.bridge.bridge.TinyCar;

/**
 * Learn Java from https://www.liaoxuefeng.com/
 * 
 * @author liaoxuefeng
 */
public class Main {

	public static void main(String[] args) {
		RefinedCar car1 = new BossCar(new HybridEngine());
		car1.drive();
		RefinedCar car2 = new TinyCar(new ElectricEngine());
		car2.drive();
	}
}
