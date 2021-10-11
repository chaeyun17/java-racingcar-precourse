package racinggame.model;

import static org.assertj.core.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class RaceTest {

	@Test
	@DisplayName("주행횟수와 차 이름들이 주어지면, 경주를 하고, 차별 주행기록을 반환해야한다")
	void startTest() {

		// given
		int turnCount = 3;
		Race race = new Race(turnCount);
		List<String> carNameList = new ArrayList<>();
		carNameList.add("CAR01");
		carNameList.add("CAR02");
		carNameList.add("CAR03");

		// when
		RaceCars cars = race.start(carNameList);

		// then
		for (String carName : cars.getNames()) {
			Car car = cars.get(carName);
			CarDriveHistory history = car.getCarDriveHistory();
			assertThat(history.getTotal()).isEqualTo(turnCount);
			isInDriveStatusTest(turnCount, history);
		}
	}

	void isInDriveStatusTest(int turnCount, CarDriveHistory history) {
		for (int i = 0; i < turnCount; i++) {
			DriveStatus driveStatus = history.get(i);
			assertThat(driveStatus).isIn(DriveStatus.STOP, DriveStatus.FORWARD);
		}
	}

	@Test
	@DisplayName("주행횟수가 주어지면, 자동차 주행을 하고, 주행상태를 반환해야 한다")
	void playTurnTest() {
		// given
		int turnCount = 3;
		Race race = new Race(turnCount);
		List<Car> carList = new ArrayList<>();
		carList.add(new Car("CAR01"));
		carList.add(new Car("CAR02"));
		carList.add(new Car("CAR03"));
		RaceCars raceCars = new RaceCars(carList);

		// when
		race.playTurns(raceCars, turnCount);

		// then
		for (Car car : carList) {
			CarDriveHistory history = car.getCarDriveHistory();
			assertThat(history.getTotal()).isEqualTo(turnCount);
			isInDriveStatusTest(turnCount, history);
		}
	}

	@Test
	@DisplayName("차 이름이 주어지면, 자동차들을 생성하고, 반환합니다")
	void createCarsTest() {
		// given
		List<String> carNameList = new ArrayList<>();
		carNameList.add("CAR01");
		carNameList.add("CAR02");
		carNameList.add("CAR03");
		Race race = new Race(3);

		// when
		RaceCars cars = race.createCars(carNameList);

		// then
		assertThat(cars.getTotal()).isEqualTo(carNameList.size());
		for (String carName : carNameList) {
			assertThat(cars.isContains(carName)).isTrue();
		}
	}

}
