import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class DrawController {

    private InputView inputView;
    private OutputView outputView;



    public void run() {
        int lottoCount = inputView.inputCount();
        List<Lotto> lottoList = buyLotto(lottoCount);
        List<Integer> winningNumbers = inputView.inputWinningNumbers();
        Integer bonusNumber = inputView.inputBonusNumber();
    }

    private List<Lotto> buyLotto(int lottoCount) {
        List<Lotto> lottoList = new ArrayList<>();
        for (int i = 0; i < lottoCount; i++) {
            Lotto lotto = new Lotto(getSixNumbers());
            lottoList.add(lotto);
            outputView.printLottoNumbers(lotto.getLottoNums());
        }
        return lottoList;
    }

    static Integer getOneNumber() {
        List<Integer> numList = IntStream.rangeClosed(1, 45).boxed().collect(Collectors.toList());
        Collections.shuffle(numList);
        Integer bonusNumber = numList.get(0);
        return bonusNumber;
    }

    static List<Integer> getSixNumbers() {
        List<Integer> numList = IntStream.rangeClosed(1, 45).boxed().collect(Collectors.toList());
        Collections.shuffle(numList);
        List<Integer> subList = numList.subList(0, 6);
        Collections.sort(subList);
        return subList;
    }


}
