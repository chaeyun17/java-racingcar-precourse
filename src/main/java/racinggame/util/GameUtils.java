package racinggame.util;

import java.util.Arrays;
import java.util.List;

public class GameUtils {

	public static List<String> parseCarNameString(String carNamesStr) {
		return Arrays.asList(carNamesStr.split(","));
	}

	public static int parseDriveTurnCntString(String driveTurnCntStr) {
		return Integer.parseInt(driveTurnCntStr);
	}
}
