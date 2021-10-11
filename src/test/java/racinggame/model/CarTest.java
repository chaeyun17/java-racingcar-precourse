package racinggame.model;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CarTest {

	@Test
	@DisplayName("주어진 이름으로 차를 생성하면, 이름을 확인할 수 있어야 한다")
	void initTest() {
		String name = "CAR001";

		Car car = new Car(name);

		assertThat(car).isNotNull();
		assertThat(car.getName()).isEqualTo(name);
	}

	@Test
	@DisplayName("자동차 주행 시, 전진 또는 멈춤 상태를 반환한다")
	void driveTest() {
		driveTest(0, DriveStatus.STOP);
		driveTest(3, DriveStatus.STOP);
		driveTest(2, DriveStatus.STOP);
		driveTest(4, DriveStatus.FORWARD);
		driveTest(9, DriveStatus.FORWARD);
	}

	private void driveTest(int numberPicked, DriveStatus expected) {
		String name = "CAR001";
		Car car = new Car(name);
		DriveStatus driveStatus = car.drive(numberPicked);
		assertThat(driveStatus).isEqualTo(expected);
	}

}
