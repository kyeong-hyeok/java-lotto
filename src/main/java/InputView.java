import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputView {

    private Scanner scanner;

    public InputView(Scanner scanner) {
        this.scanner = scanner;
    }

    public int inputCount() {
        return scanner.nextInt() / 1000;
    }

    public List<Integer> inputWinningNumbers() {
        return Arrays.stream(scanner.nextLine().split(", "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    public Integer inputBonusNumber() {
        return scanner.nextInt();
    }
}
