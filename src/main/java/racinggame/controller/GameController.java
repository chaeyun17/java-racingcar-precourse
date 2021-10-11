package racinggame.controller;

import java.util.List;

import racinggame.model.Car;
import racinggame.model.CarDriveHistory;
import racinggame.model.Judgement;
import racinggame.model.Race;
import racinggame.model.RaceCars;
import racinggame.util.GameUtils;
import racinggame.view.GameView;

public class GameController {

	private final GameView gameView;

	public GameController() {
		this.gameView = new GameView();
	}

	public void start() {
		// 자동차 이름 입력
		String carNamesStr = gameView.getCarNames();
		List<String> carNames = GameUtils.parseCarNameString(carNamesStr);

		String driveTurnCntStr = gameView.getDriveCount();
		int driveTurnCnt = GameUtils.parseDriveTurnCntString(driveTurnCntStr);

		Race race = new Race(driveTurnCnt);

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
