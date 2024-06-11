import java.util.List;
import java.util.stream.Collectors;

public class OutputView {

    public void printLottoNumbers(List<Integer> numbers) {
        String result = "[" + String.join(", ", numbers.stream().map(Object::toString).collect(Collectors.toList())) + "]";
        System.out.println(result);
    }

    public void printOutPut() {
        System.out.println();
        System.out.println("당첨 통계");
        System.out.println("----------");


    }
}
