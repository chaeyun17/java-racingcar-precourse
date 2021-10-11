package racinggame.model;

import java.util.ArrayList;
import java.util.Collection;
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

	public Collection<DriveStatus> getHistory() {
		return this.driveStatusList;
	}

	public int getForwardTotal() {
		int cnt = 0;
		for (DriveStatus driveStatus : driveStatusList) {
			cnt = increaseForwardCnt(cnt, driveStatus);
		}
		return cnt;
	}

	public int increaseForwardCnt(int count, DriveStatus driveStatus) {
		if (driveStatus.equals(DriveStatus.FORWARD)) {
			return count + 1;
		}
		return count;
	}

}
