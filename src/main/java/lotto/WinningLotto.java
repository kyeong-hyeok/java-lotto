package lotto;

public class WinningLotto {

    private final Lotto lotto;
    private final LottoNumber bonusNumber;

    public WinningLotto(Lotto lotto, LottoNumber bonusNumber) {
        if (lotto.getLottoNumbers().contains(bonusNumber)) {
            throw new IllegalArgumentException("당첨 번호와 보너스 번호는 중복되지 않아야 합니다.");
        }
        this.lotto = lotto;
        this.bonusNumber = bonusNumber;
    }

//    public Lotto getLotto() {
//        return lotto;
//    }
//
//    public LottoNumber getBonusNumber() {
//        return bonusNumber;
//    }

    public int rank(Lotto userLotto) {
        int matchCount = userLotto.match(lotto);
        boolean matchBonus = userLotto.contains(bonusNumber);
        return rank(matchCount, matchBonus);
    }

    private static int rank(int matchCount, boolean matchBonus) {
        if (matchCount == 6) {
            return 1;
        }
        if (matchCount == 5 && matchBonus) {
            return 2;
        }
        if (matchCount > 2) {
            return 6 - matchCount + 2;
        }
        return 0;
    }


}
