package racinggame.model;

import static org.assertj.core.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class RaceTest {

	@Test
	@DisplayName("주행횟수와 자동차들이 주어지면, 경주를 하고, 차별 주행기록을 반환해야한다")
	void startTest() {

		// given
		int turnCount = 3;
		Race race = new Race(turnCount);
		List<Car> carList = new ArrayList<>();
		carList.add(new Car("CAR01"));
		carList.add(new Car("CAR02"));
		carList.add(new Car("CAR03"));

		// when
		carList = race.start(carList);

		// then
		for (Car car : carList) {
			CarDriveHistory history = car.getCarDriveHistory();
			assertThat(history.getTotal()).isEqualTo(turnCount);
			isInDriveStatus(turnCount, history);
		}
	}

	void isInDriveStatus(int turnCount, CarDriveHistory history){
		for (int i = 0; i < turnCount; i++) {
			DriveStatus driveStatus = history.get(i);
			assertThat(driveStatus).isIn(DriveStatus.STOP, DriveStatus.FORWARD);
		}
	}


}
