package cn.lixx.designpatterns.bridge.bridge;

public abstract class Car {

	protected Engine engine;

	public Car(Engine engine) {
		this.engine = engine;
	}

	public abstract void drive();
}
