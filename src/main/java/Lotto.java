import java.util.List;

public class Lotto {

    private final List<Integer> lottoNums;
    private final int price;
    private LottoRank rank;

    public Lotto(List<Integer> lottoNums) {
        this.lottoNums = lottoNums;
        this.price = 1000;
    }

    public Lotto(List<Integer> lottoNums, LottoRank rank) {
        this(lottoNums);
        this.rank = rank;
    }

    public List<Integer> getLottoNums() {
        return lottoNums;
    }

    public int getPrice() {
        return price;
    }

    public void setRank(WinningNumbers winningNumbers) {
        int count = getMatchCount(winningNumbers);

        if(count == 6) { this.rank = LottoRank.FIRST; }
        if(count == 5) { this.rank = matchBonus(winningNumbers.getBonusNumber()); }
        if(count == 4) { this.rank = LottoRank.FOURTH; }
        if(count == 3) { this.rank = LottoRank.FIFTH; }
    }

    public int getLottoRank() {
        return this.rank.getRank();
    }

    private LottoRank matchBonus(Integer bonusNumber) {
        if (lottoNums.contains(bonusNumber)) {
            return LottoRank.SECOND;
        }
        return LottoRank.THIRD;
    }

    public int getMatchCount(WinningNumbers winningNumbers) {
        return (int) lottoNums.stream()
                .filter(winningNumbers.getNumbers()::contains)
                .count();
    }
}
