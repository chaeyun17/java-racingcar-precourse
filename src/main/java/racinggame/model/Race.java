package racinggame.model;

import java.util.List;

import nextstep.utils.Randoms;

public class Race {

	private final int turnCount;

	public Race(int turnCount) {
		this.turnCount = turnCount;
	}

	public RaceCars start(List<String> carNames) {
		RaceCars raceCars = createCars(carNames);
		playTurns(raceCars, this.turnCount);
		return raceCars;
	}

	public RaceCars createCars(List<String> names) {
		RaceCars raceCars = new RaceCars();
		for (String name : names) {
			raceCars.add(new Car(name));
		}
		return raceCars;
	}

	public void playTurns(RaceCars cars, int turnCount) {
		for (int i = 0; i < turnCount; i++) {
			driveCars(cars);
		}
	}

	private void driveCars(RaceCars cars) {
		for (String carName : cars.getNames()) {
			cars.get(carName).drive(getRandomNumber());
		}
	}

	private int getRandomNumber() {
		return Randoms.pickNumberInRange(0, 9);
	}

}
