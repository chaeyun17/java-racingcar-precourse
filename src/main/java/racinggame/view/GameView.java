package racinggame.view;

import java.util.Collection;
import java.util.NoSuchElementException;

import nextstep.utils.Console;
import racinggame.dto.DriveResultDto;

public class GameView {

	public String getCarNames() {
		System.out.println("경주할 자동차 이름을 입력하세요.(이름은쉼표(,)기준으로구분)");
		return Console.readLine();
	}

	public String getDriveCount() throws NoSuchElementException {
		System.out.println("시도할 회수는 몇회인가요?");
		return Console.readLine();
	}

	public void showDriveResult(Collection<DriveResultDto> dtoList) {
		System.out.println("실행 결과");
		for (DriveResultDto dto : dtoList) {
			System.out.print(dto.getCarName() + " : ");
			System.out.println(getForwardString(dto.getForwardCount()));
		}
	}

	private String getForwardString(int forwardCnt) {
		StringBuilder forwardString = new StringBuilder();
		for (int i = 0; i < forwardCnt; i++) {
			forwardString.append("-");
		}
		return forwardString.toString();
	}

	public void showWinnerResult(Collection<String> winnerNames) {
		System.out.println(getWinnerString(winnerNames));
	}

	private String getWinnerString(Collection<String> names) {
		System.out.println();
		String msg = "최종 우승자는 ";
		String winnerNames = String.join(",", names);
		msg += winnerNames;
		msg += " 입니다.";
		return msg;
	}

	public void showError(NoSuchElementException e) {
		System.out.println("[ERROR] 입력 중 에러가 발생했습니다.");
	}

	public void showInvalidCarNameInput(String carNamesStr) {
		System.out.println("[ERROR] 자동차 이름이 잘못되었습니다. 다시 입력해주세요. ");
	}
}
