package racinggame.model;

import java.util.List;

import nextstep.utils.Randoms;

public class Race {

	private int turnCount;

	public Race(int turnCount){
		this.turnCount = turnCount;
	}

	public List<Car> start(List<Car> carList) {
		playTurns(carList, this.turnCount);
		return carList;
	}

	private void playTurns(List<Car> cars, int turnCount) {
		for (int i = 0; i < turnCount; i++) {
			driveCars(cars);
		}
	}

	private void driveCars(List<Car> cars) {
		for (Car car : cars) {
			car.drive(getRandomNumber());
		}
	}

	private int getRandomNumber() {
		return Randoms.pickNumberInRange(0, 9);
	}

}
