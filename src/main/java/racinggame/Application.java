package racinggame;

import racinggame.controller.GameController;

public class Application {
	public static void main(String[] args) {
		// TODO 자동차 경주 게임 구현
		GameController gameController = new GameController();
		gameController.start();
	}
}
