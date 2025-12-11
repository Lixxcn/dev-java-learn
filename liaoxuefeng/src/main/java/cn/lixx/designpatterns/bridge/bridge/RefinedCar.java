package cn.lixx.designpatterns.bridge.bridge;

public abstract class RefinedCar extends Car {

	public RefinedCar(Engine engine) {
		super(engine);
	}

	public void drive() {
		this.engine.start();
		System.out.println("Drive " + getBrand() + " car...");
	}

	public abstract String getBrand();
}
