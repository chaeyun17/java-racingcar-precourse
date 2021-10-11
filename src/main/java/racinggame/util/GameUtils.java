package racinggame.util;

import java.util.Arrays;
import java.util.List;

public class GameUtils {

	private static final String SPLIT_CHAR_CAR_NAMES = ",";

	public static List<String> parseCarNameString(String carNamesStr) {
		return Arrays.asList(carNamesStr.split(SPLIT_CHAR_CAR_NAMES));
	}

	public static int parseDriveTurnCntString(String driveTurnCntStr) {
		return Integer.parseInt(driveTurnCntStr);
	}
}
