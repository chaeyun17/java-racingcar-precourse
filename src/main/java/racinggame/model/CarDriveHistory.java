package racinggame.model;

import java.util.ArrayList;
import java.util.List;

public class CarDriveHistory {

	private final List<DriveStatus> driveStatusList;

	public CarDriveHistory() {
		this.driveStatusList = new ArrayList<>();
	}

	public CarDriveHistory(List<DriveStatus> driveStatusList) {
		this.driveStatusList = new ArrayList<>();
		this.driveStatusList.addAll(driveStatusList);
	}

	public DriveStatus add(DriveStatus driveStatus) {
		this.driveStatusList.add(driveStatus);
		return driveStatus;
	}

	public DriveStatus get(int index) {
		return this.driveStatusList.get(index);
	}

	public int getTotal() {
		return this.driveStatusList.size();
	}
}
