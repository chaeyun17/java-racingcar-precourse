package racinggame.model;

import nextstep.utils.Randoms;

public class Car {

	private String name;

	public Car(String name) {
		this.name = name;
	}

	public String getName() {
		return this.name;
	}

	public DriveStatus drive(int numberPicked) {
		if (numberPicked >= 4) {
			return DriveStatus.FORWARD;
		}
		return DriveStatus.STOP;
	}

	public DriveStatus drive() {
		int numberPicked = Randoms.pickNumberInRange(0, 9);
		return drive(numberPicked);
	}

}
