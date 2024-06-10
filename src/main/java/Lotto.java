import java.util.List;

public class Lotto {

    private final List<Integer> lottoNums;

    public Lotto(List<Integer> lottoNums) {
        this.lottoNums = lottoNums;
    }

    public List<Integer> getLottoNums() {
        return lottoNums;
    }
}
