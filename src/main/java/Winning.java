import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Winning {

    List<Integer> matchCnt;
    final List<Lotto> lottoList;
    private static final int LOTTO_RANK_SIZE = 5;

    public Winning(List<Lotto> lottoList) {
        this.lottoList = lottoList;
    }


    public List<Integer> getMatchCnt() {

        List<Integer> matchCnt = new ArrayList<>(Collections.nCopies(LOTTO_RANK_SIZE + 1, 0));

        lottoList.forEach(lotto -> {
            int lottoRank = lotto.getLottoRank();
            matchCnt.set(lottoRank, matchCnt.get(lottoRank) + 1);
        });

        return matchCnt;
    }
}



//    public int receiveWinningMoney() {
//        return WinningPrice.THREE.getPrice() * threeWinningCnt
//                + WinningPrice.FOUR.getPrice() * fourWinningCnt
//                + WinningPrice.FIVE.getPrice() * fiveWinningCnt
//                + WinningPrice.FIVE_BONUS.getPrice() * fiveBonusWinningCnt
//                + WinningPrice.SIX.getPrice() * sixWinningCnt;
//    }
//
//
//
//    public double calculateTotalRate(int cnt) {
//        return Math.round((double)receiveWinningMoney() / (cnt * 1000) * 100.0) / 100.0;
//    }
//}
