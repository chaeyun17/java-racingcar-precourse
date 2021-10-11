package racinggame.model;

import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Objects;
import java.util.Set;

public class RaceCars {

	private final LinkedHashMap<String, Car> cars;

	public RaceCars() {
		this.cars = new LinkedHashMap<>();
	}

	public RaceCars(List<Car> carList) {
		this.cars = new LinkedHashMap<>();
		for (Car car : carList) {
			cars.put(car.getName(), car);
		}
	}

	public Car get(String carName) {
		return cars.get(carName);
	}

	public void add(Car car) {
		if (Objects.isNull(car)) {
			return;
		}
		cars.put(car.getName(), car);
	}

	public Set<String> getNames() {
		return cars.keySet();
	}

	public Collection<Car> getCars() {
		return cars.values();
	}

	public int getTotal() {
		return cars.size();
	}

	public boolean isContains(String name) {
		return this.cars.containsKey(name);
	}

}
