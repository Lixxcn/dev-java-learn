package cn.lixx.designpatterns.bridge.bridge;

public class ElectricEngine implements Engine {

	@Override
	public void start() {
		System.out.println("Start Electric Engine...");
	}
}
