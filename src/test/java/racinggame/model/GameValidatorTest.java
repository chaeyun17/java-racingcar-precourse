package racinggame.model;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class GameValidatorTest {

	@Test
	@DisplayName("주어진 입력값이 길이가 5 초과일 경우, true 를 반환한다")
	void isInvalidCarNameInput() {
		isInvalidCarNameInput("javajigi", true);
		isInvalidCarNameInput("fobi", false);
		isInvalidCarNameInput("fobi,crong", false);
	}

	private void isInvalidCarNameInput(String input, boolean expected) {
		GameValidator gameValidator = GameValidator.getInstance();
		boolean isInvalid = gameValidator.isInvalidCarNameInput(input);
		assertThat(isInvalid).isEqualTo(expected);
	}

}
