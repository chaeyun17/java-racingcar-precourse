package racinggame.controller;

import java.util.ArrayList;
import java.util.List;

import racinggame.dto.DriveResultDto;
import racinggame.model.Car;
import racinggame.model.GameValidator;
import racinggame.model.Judgement;
import racinggame.model.Race;
import racinggame.model.RaceCars;
import racinggame.util.GameUtils;
import racinggame.view.GameView;

public class GameController {

	private final GameView gameView;
	private final GameValidator gameValidator;

	public GameController() {
		this.gameView = new GameView();
		this.gameValidator = new GameValidator();
	}

	public void start() {
		boolean isInvalid;
		String carNamesStr;
		do {
			carNamesStr = gameView.getCarNames();
			isInvalid = gameValidator.isInvalidCarNameInput(carNamesStr);
			showErrorIfInvalidInput(isInvalid, carNamesStr);
		} while (isInvalid);

		List<String> carNames = GameUtils.parseCarNameString(carNamesStr);
		String driveTurnCntStr = gameView.getDriveCount();
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
			DriveResultDto dto = new DriveResultDto(car.getName(),
				car.getCarDriveHistory().getForwardTotal());
			dtoList.add(dto);
		}
		return dtoList;
	}

	private void showErrorIfInvalidInput(boolean isInvalid, String carNamesStr) {
		if (isInvalid) {
			gameView.showInvalidCarNameInput(carNamesStr);
		}
	}

}
