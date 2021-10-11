package racinggame.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import racinggame.dto.DriveResultDto;
import racinggame.model.Car;
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
		String carNamesStr = gameView.getCarNames();
		List<String> carNames = GameUtils.parseCarNameString(carNamesStr);
		String driveTurnCntStr = "";
		try {
			driveTurnCntStr = gameView.getDriveCount();
		} catch (NoSuchElementException e) {
			gameView.showError(e);
		}
		int driveTurnCnt = GameUtils.parseDriveTurnCntString(driveTurnCntStr);

		Race race = new Race(driveTurnCnt);

		RaceCars cars = race.start(carNames);
		RaceCars winners = Judgement.getInstance().getWinners(cars);
		gameView.showDriveResult(mapTo(cars));
		gameView.showWinnerResult(winners.getNames());
	}

	private List<DriveResultDto> mapTo(RaceCars raceCars) {
		List<DriveResultDto> dtoList = new ArrayList<>();
		for (Car car : raceCars.getCars()) {
			dtoList.add(new DriveResultDto(car.getName(),
				car.getCarDriveHistory().getForwardTotal()));
		}
		return dtoList;
	}

}
