package racinggame.model;

public class Judgement {

	private static Judgement instance;

	private Judgement() {
	}

	public static Judgement getInstance() {
		if (instance == null) {
			instance = new Judgement();
		}
		return instance;
	}

	public RaceCars getWinners(RaceCars candidates) {
		RaceCars winners = new RaceCars();
		int mostDistance = getMostDistance(candidates);
		for (Car car : candidates.getCars()) {
			addIfMostDistance(winners, car, mostDistance);
		}
		return winners;
	}

	private void addIfMostDistance(RaceCars winners, Car car, int mostDistance) {
		if (car.getCarDriveHistory().getForwardTotal() < mostDistance) {
			return;
		}
		winners.add(car);
	}

	private int getMostDistance(RaceCars candidates) {
		int most = 0;
		for (Car car : candidates.getCars()) {
			most = Math.max(most, car.getCarDriveHistory().getForwardTotal());
		}
		return most;
	}

}
