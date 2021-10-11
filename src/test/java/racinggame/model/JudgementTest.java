package racinggame.model;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class JudgementTest {

	@Test
	@DisplayName("자동차들이 주어지면, 우승한 차들을 판별하여, 우승한 차들만 반환한다")
	void getWinners() {
		Judgement judgement = Judgement.getInstance();
		RaceCars raceCars = new RaceCars();
		Car car1 = getDriveCar("CAR01", 1, 4);
		Car car2 = getDriveCar("CAR02", 2, 3);
		Car car3 = getDriveCar("CAR03", 3, 2);
		Car car4 = getDriveCar("CAR04", 3, 2);
		raceCars.add(car1);
		raceCars.add(car2);
		raceCars.add(car3);
		raceCars.add(car4);

		RaceCars winners = judgement.getWinners(raceCars);

		assertThat(winners.getTotal()).isEqualTo(2);
		assertThat(winners.isContains(car3.getName())).isTrue();
		assertThat(winners.isContains(car4.getName())).isTrue();
	}

	private Car getDriveCar(String name, int forwardCnt, int stopCnt) {
		Car car = new Car(name);
		for (int i = 0; i < forwardCnt; i++) {
			car.getCarDriveHistory().add(DriveStatus.FORWARD);
		}
		for (int i = 0; i < stopCnt; i++) {
			car.getCarDriveHistory().add(DriveStatus.STOP);
		}
		return car;
	}
}
