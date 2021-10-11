package racinggame.view;

import nextstep.utils.Console;

public class GameView {

	public String getCarNames() {
		System.out.println("경주할 자동차 이름을 입력하세요.(이름은쉼표(,)기준으로구분)");
		return Console.readLine();
	}

	public String getDriveCount() {
		System.out.println("시도할 회수는 몇회인가요?");
		return Console.readLine();
	}
}
