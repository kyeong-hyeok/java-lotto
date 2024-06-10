import java.util.List;

public class WinningNumbers {

    final List<Integer> numbers;
    final Integer bonusNumber;

    public WinningNumbers(List<Integer> numbers, Integer bonusNumber) {
        this.numbers = numbers;
        this.bonusNumber = bonusNumber;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    public Integer getBonusNumber() {
        return bonusNumber;
    }
}
