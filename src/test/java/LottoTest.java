import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;

class LottoTest {

    @DisplayName("로또는 1~45 사이의 숫자로 이루어져 있다.")
    @Test
    void lotto_definition() {
        List<Integer> lottos = getSixNumbers();
        Lotto lotto = new Lotto(lottos);
        assertThat(lotto.getLottoNums()).allMatch(num -> num >= 1 && num <= 45);
    }

    @DisplayName("로또 1장의 가격은 1000원이다.")
    @Test
    void lotto_price() {
        List<Integer> lottos = getSixNumbers();
        Lotto lotto = new Lotto(lottos);
        assertThat(lotto.getPrice()).isEqualTo(1000);
    }

    @DisplayName("로또 번호의 개수는 6개이다. (1~45)")
    @Test
    void lotto_num_size() {
        List<Integer> lottos = getSixNumbers();
        Lotto lotto = new Lotto(lottos);
        assertThat(lotto.getLottoNums()).hasSize(6);
    }

    @DisplayName("당첨 번호는 1~45 사이의 숫자로 이루어져 있다")
    @Test
    void winning_numbers_definition() {
        List<Integer> winningNums = getSixNumbers();
        WinningNumbers winningNumbers = new WinningNumbers(winningNums, 1);
        assertThat(winningNumbers.getNumbers()).allMatch(num -> num >= 1 && num <= 45);
    }

    @DisplayName("당첨 번호의 개수는 6개이다. (1~45)")
    @Test
    void winning_numbers_size() {
        List<Integer> winningNums = getSixNumbers();
        WinningNumbers winningNumbers = new WinningNumbers(winningNums, 1);
        assertThat(winningNumbers.getNumbers()).hasSize(6);
    }

    @DisplayName("보너스 볼은 1~45 사이의 숫자로 이루어져 있다.")
    @Test
    void bonus_ball_is_one() {
        Integer bonusNumber = getOneNumber();
        WinningNumbers winningNumbers = new WinningNumbers(getSixNumbers(), bonusNumber);
        assertThat(winningNumbers.getBonusNumber()).isBetween(1, 45);
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