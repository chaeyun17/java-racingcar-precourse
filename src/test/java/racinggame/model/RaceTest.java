package racinggame.model;

import static org.assertj.core.api.Assertions.*;

import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class RaceTest {

	@Test
	@DisplayName("주행횟수와 차 이름들이 주어지면, 경주를 하고, 차별 주행기록을 반환해야한다")
	void startTest() {

		// given
		int turnCount = 3;
		Race race = new Race(turnCount);
		Set<String> carNameList = new HashSet<>();
		carNameList.add("CAR01");
		carNameList.add("CAR02");
		carNameList.add("CAR03");

		// when
		Set<Car> cars = race.start(carNameList);

		// then
		for (Car car : cars) {
			CarDriveHistory history = car.getCarDriveHistory();
			assertThat(history.getTotal()).isEqualTo(turnCount);
			isInDriveStatusTest(turnCount, history);
		}
	}

	void isInDriveStatusTest(int turnCount, CarDriveHistory history){
		for (int i = 0; i < turnCount; i++) {
			DriveStatus driveStatus = history.get(i);
			assertThat(driveStatus).isIn(DriveStatus.STOP, DriveStatus.FORWARD);
		}
	}

	@Test
	@DisplayName("")
	void playTurnTest(){
		// given
		int turnCount = 3;
		Race race = new Race(turnCount);
		Set<Car> cars = new HashSet<>();
		cars.add(new Car("CAR01"));
		cars.add(new Car("CAR02"));
		cars.add(new Car("CAR03"));

		// when
		race.playTurns(cars, turnCount);

		// then
		for (Car car : cars) {
			CarDriveHistory history = car.getCarDriveHistory();
			assertThat(history.getTotal()).isEqualTo(turnCount);
			isInDriveStatusTest(turnCount, history);
		}
	}

	@Test
	@DisplayName("차 이름이 주어지면, 자동차들을 생성하고, 반환합니다")
	void createCarsTest(){
		// given
		Set<String> carNameList = new HashSet<>();
		carNameList.add("CAR01");
		carNameList.add("CAR02");
		carNameList.add("CAR03");
		Race race = new Race(3);

		// when
		Set<Car> cars = race.createCars(carNameList);

		// then
		assertThat(cars.size()).isEqualTo(carNameList.size());
		for(String carName : carNameList){
			assertThat(cars.contains(new Car(carName))).isTrue();
		}
	}

}
