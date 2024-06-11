package lotto;

public class LottoGame {
    /**
     * Integer 1 .. 45 -> Integer을 LottoNumber로 변경
     * userLotto.toSet().size() == 6 -> Lotto 클래스 생성
     * winningLotto.toSet().size == 6
     * bonusNumber !in winningLotto
     */
    // first code
//    public static int match(List<Integer> userLotto, List<Integer> winningLotto, int bonusNumber) {
//        int matchCount = match(userLotto, winningLotto);
//        boolean matchBonus = userLotto.contains(bonusNumber);
//        return rank(matchCount, matchBonus);
//    }

    // refactoring 1 code
//    public static int match(List<LottoNumber> userLotto, List<LottoNumber> winningLotto, LottoNumber bonusNumber) {
//        int matchCount = match(userLotto, winningLotto);
//        boolean matchBonus = userLotto.contains(bonusNumber);
//        return rank(matchCount, matchBonus);
//    }

    // refactoring 2 code - private 메서드 match의 변수 줄이기
//    public static int match(Lotto userLotto, Lotto winningLotto, LottoNumber bonusNumber) {
//        int matchCount = match(userLotto, winningLotto);
//        boolean matchBonus = userLotto.contains(bonusNumber);
//        return rank(matchCount, matchBonus);
//    }

    public static int match(Lotto userLotto, Lotto winningLotto, LottoNumber bonusNumber) {
        int matchCount = userLotto.match(winningLotto);
        boolean matchBonus = userLotto.contains(bonusNumber);
        return rank(matchCount, matchBonus);
    }

    // first code
//    private static int match(List<Integer> userLotto, List<Integer> winningLotto) {
//        return (int) userLotto.stream().filter(winningLotto::contains).count();
//    }

    // refactoring 1 code
//    private static int match(List<LottoNumber> userLotto, List<LottoNumber> winningLotto) {
//        return (int) userLotto.stream().filter(winningLotto::contains).count();
//    }

    // refactoring 2 code - private 메서드 match의 변수 줄이기
//    private static int match(Lotto userLotto, Lotto winningLotto) {
//        return (int) userLotto.getLottoNumbers().stream().filter(winningLotto::contains).count();
//    }

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
