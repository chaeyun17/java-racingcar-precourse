package racinggame.model;

import java.util.HashSet;
import java.util.Set;

import nextstep.utils.Randoms;

public class Race {

	private final int turnCount;

	public Race(int turnCount) {
		this.turnCount = turnCount;
	}

	public Set<Car> start(Set<String> carNames) {
		Set<Car> cars = createCars(carNames);
		playTurns(cars, this.turnCount);
		return cars;
	}

	public Set<Car> createCars(Set<String> names) {
		Set<Car> cars = new HashSet<>();
		for (String name : names) {
			cars.add(new Car(name));
		}
		return cars;
	}

	public void playTurns(Set<Car> cars, int turnCount) {
		for (int i = 0; i < turnCount; i++) {
			driveCars(cars);
		}
	}

	private void driveCars(Set<Car> cars) {
		for (Car car : cars) {
			car.drive(getRandomNumber());
		}
	}

	private int getRandomNumber() {
		return Randoms.pickNumberInRange(0, 9);
	}

}
