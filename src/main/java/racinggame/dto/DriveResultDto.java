package racinggame.dto;

public class DriveResultDto {

	private String carName;
	private int forwardCount;

	public DriveResultDto(String carName, int forwardCount) {
		this.carName = carName;
		this.forwardCount = forwardCount;
	}

	public String getCarName() {
		return carName;
	}

	public void setCarName(String carName) {
		this.carName = carName;
	}

	public int getForwardCount() {
		return forwardCount;
	}

	public void setForwardCount(int forwardCount) {
		this.forwardCount = forwardCount;
	}
}
