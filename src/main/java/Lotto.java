import java.util.List;

public class Lotto {

    private final List<Integer> lottoNums;
    private final int price;

    public Lotto(List<Integer> lottoNums) {
        this.lottoNums = lottoNums;
        this.price = 1000;
    }

    public List<Integer> getLottoNums() {
        return lottoNums;
    }

    public int getPrice() {
        return price;
    }
}
