package racinggame.model;

public class GameValidator {

	private static GameValidator instance;

	public static GameValidator getInstance() {
		if (instance == null) {
			instance = new GameValidator();
		}
		return instance;
	}

	public boolean isInvalidCarNameInput(String carNamesStr) {
		String[] names = carNamesStr.split(",");

		if (names.length == 0) {
			return true;
		}

		int invalidCnt = 0;
		for (String name : names) {
			invalidCnt = increaseIfExceedLength(invalidCnt, name);
		}
		return invalidCnt > 0;
	}

	private int increaseIfExceedLength(int cnt, String target) {
		if (target.length() > 5) {
			return cnt + 1;
		}
		return cnt;
	}

}
