package racinggame.model;

import static org.assertj.core.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CarDriveHistoryTest {

	@Test
	@DisplayName("주어진 주행상태를 추가를 하면, 추가된 운전상태를 반환해야 한다")
	void addTest() {
		CarDriveHistory carDriveHistory = new CarDriveHistory();

		DriveStatus status1 = carDriveHistory.add(DriveStatus.FORWARD);
		DriveStatus status2 = carDriveHistory.add(DriveStatus.STOP);

		assertThat(status1).isEqualTo(DriveStatus.FORWARD);
		assertThat(status2).isEqualTo(DriveStatus.STOP);
	}

	@Test
	@DisplayName("주어진 주행 기록을 특정 index 로 확인가능해야 한다")
	void getTest() {
		List<DriveStatus> driveStatusList = new ArrayList<>();
		driveStatusList.add(DriveStatus.FORWARD);
		driveStatusList.add(DriveStatus.FORWARD);
		driveStatusList.add(DriveStatus.STOP);
		CarDriveHistory carDriveHistory = new CarDriveHistory(driveStatusList);

		for (int i = 0; i < driveStatusList.size(); i++) {
			DriveStatus expected = driveStatusList.get(i);
			assertThat(carDriveHistory.get(i)).isEqualTo(expected);
		}
	}

	@Test
	@DisplayName("주어진 주행 기록의 총 갯수를 반환해야 한다")
	void getTotalTest() {
		List<DriveStatus> driveStatusList = new ArrayList<>();
		driveStatusList.add(DriveStatus.FORWARD);
		driveStatusList.add(DriveStatus.FORWARD);
		driveStatusList.add(DriveStatus.STOP);
		CarDriveHistory carDriveHistory = new CarDriveHistory(driveStatusList);

		assertThat(carDriveHistory.getTotal()).isEqualTo(driveStatusList.size());
	}
}
