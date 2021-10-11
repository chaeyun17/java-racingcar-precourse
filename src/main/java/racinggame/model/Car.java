package racinggame.model;

import java.util.Objects;

public class Car {

	private final String name;
	private final CarDriveHistory carDriveHistory;

	public Car(String name) {
		this.name = name;
		this.carDriveHistory = new CarDriveHistory();
	}

	public String getName() {
		return this.name;
	}

	public DriveStatus drive(int numberPicked) {
		if (numberPicked >= 4) {
			DriveStatus forward = DriveStatus.FORWARD;
			carDriveHistory.add(forward);
			return forward;
		}
		DriveStatus stop = DriveStatus.STOP;
		carDriveHistory.add(stop);
		return stop;
	}

	public CarDriveHistory getCarDriveHistory() {
		return this.carDriveHistory;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		Car car = (Car)o;
		return name.equals(car.name);
	}

	@Override
	public int hashCode() {
		return Objects.hash(name);
	}

}
