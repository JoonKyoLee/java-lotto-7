package lotto.domain;

import lotto.exception.ErrorMessage;
import lotto.exception.InputException;
import lotto.util.ConvertInput;

public class BonusNumber {
    private static final int LOTTO_MINIMUM_BOUND = 1;
    private static final int LOTTO_MAXIMUM_BOUND = 45;
    private final int bonusNumber;

    private BonusNumber(int bonusNumber) {
        this.bonusNumber = bonusNumber;
    }

    public static BonusNumber from(String input) {
        int bonusNumber = ConvertInput.makeBonusNumberToInt(input);
        validate(bonusNumber);
        return new BonusNumber(bonusNumber);
    }

    private static void validate(int bonusNumber) {
        validateRangeOfNumbers(bonusNumber);
    }

    private static void validateRangeOfNumbers(int bonusNumber) {
        if (isNotInValidRange(bonusNumber)) {
            throw InputException.from(ErrorMessage.BONUS_NUMBER_HAS_OUT_OF_BOUND_NUMBER);
        }
    }

    private static boolean isNotInValidRange(int bonusNumber) {
        return bonusNumber < LOTTO_MINIMUM_BOUND || bonusNumber > LOTTO_MAXIMUM_BOUND;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }
}
