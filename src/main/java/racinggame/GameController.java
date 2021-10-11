package racinggame;

import java.util.ArrayList;
import java.util.List;

import racinggame.model.Car;
import racinggame.model.CarDriveHistory;
import racinggame.model.Judgement;
import racinggame.model.Race;
import racinggame.model.RaceCars;

public class GameController {

	public void start() {
		int turnCount = 3;
		Race race = new Race(3);
		List<String> carNames = new ArrayList<>();
		carNames.add("CAR001");
		carNames.add("CAR002");
		carNames.add("CAR003");
		RaceCars cars = race.start(carNames);
		RaceCars winners = Judgement.getInstance().getWinners(cars);
		System.out.println("실행 결과");
		for (Car car : cars.getCars()) {
			System.out.print(car.getName() + ": ");
			CarDriveHistory history = car.getCarDriveHistory();
			System.out.println(getForwardString(history));
		}
		System.out.println();
		System.out.println(getWinnerString(winners));
	}

	private String getForwardString(CarDriveHistory carDriveHistory) {
		StringBuilder forwardString = new StringBuilder();
		int forwardCnt = carDriveHistory.getForwardTotal();
		for (int i = -0; i < forwardCnt; i++) {
			forwardString.append("-");
		}
		return forwardString.toString();
	}

	private String getWinnerString(RaceCars raceCars) {
		String msg = "최종 우승자는 ";
		String winnerNames = String.join(",", raceCars.getNames());
		msg += winnerNames;
		msg += " 입니다.";
		return msg;
	}
}
