import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThat;

class DrawControllerTest {

    @DisplayName("로또 번호와 당첨 번호가 3개가 일치한다")
    @Test
    void three_numbers_same() {
        Lotto lotto = new Lotto(List.of(1,2,3,4,5,6));
        WinningNumbers winningNumbers = new WinningNumbers(List.of(1,2,3,7,8,9), 10);
        assertEquals(lotto.getLottoNums().stream().filter(winningNumbers.getNumbers()::contains).count(), 3);
    }

    @DisplayName("로또 번호와 당첨 번호가 4개가 일치한다")
    @Test
    void four_numbers_same() {
        Lotto lotto = new Lotto(List.of(1,2,3,4,5,6));
        WinningNumbers winningNumbers = new WinningNumbers(List.of(1,2,3,4,8,9), 10);
        assertEquals(lotto.getLottoNums().stream().filter(winningNumbers.getNumbers()::contains).count(), 4);
    }

    @DisplayName("로또 번호와 당첨 번호가 5개가 일치한다")
    @Test
    void five_numbers_same() {
        Lotto lotto = new Lotto(List.of(1,2,3,4,5,6));
        WinningNumbers winningNumbers = new WinningNumbers(List.of(1,2,3,4,5,9), 10);
        assertEquals(lotto.getLottoNums().stream().filter(winningNumbers.getNumbers()::contains).count(), 5);
    }

    @DisplayName("로또 번호와 당첨 번호가 5개가 일치하고 보너스볼이 일치한다")
    @Test
    void five_bonus_numbers_same() {
        Lotto lotto = new Lotto(List.of(1,2,3,4,5,6));
        WinningNumbers winningNumbers = new WinningNumbers(List.of(1,2,3,4,5,9), 6);
        assertEquals(lotto.getLottoNums().stream().filter(winningNumbers.getNumbers()::contains).count(), 5);
        assertEquals(lotto.getLottoNums().stream().filter(number -> number.equals(winningNumbers.getBonusNumber())).count(), 1);
    }

    @DisplayName("로또 번호와 당첨 번호가 6개가 일치한다")
    @Test
    void six_numbers_same() {
        Lotto lotto = new Lotto(List.of(1,2,3,4,5,6));
        WinningNumbers winningNumbers = new WinningNumbers(List.of(1,2,3,4,5,6), 7);
        assertEquals(lotto.getLottoNums().stream().filter(winningNumbers.getNumbers()::contains).count(), 6);
    }

    @DisplayName("3개 일치할 경우 장당 5000원을 받는다")
    @Test
    void three_numbers_same_get_money() {
        Winning winning = new Winning(1, 0, 0, 0, 0);
        int money = winning.receiveWinningMoney();
        assertThat(money).isEqualTo(5000);
    }

    @DisplayName("4개 일치할 경우 장당 50000원을 받는다")
    @Test
    void four_numbers_same_get_money() {
        Winning winning = new Winning(0, 1, 0, 0, 0);
        int money = winning.receiveWinningMoney();
        assertThat(money).isEqualTo(50000);
    }

    @DisplayName("5개 일치할 경우 장당 1500000원을 받는다.")
    @Test
    void five_numbers_same_get_money() {
        Winning winning = new Winning(0, 0, 1, 0, 0);
        int money = winning.receiveWinningMoney();
        assertThat(money).isEqualTo(1500000);
    }

    @DisplayName("5개 일치할 경우(보너스 볼 일치) 장당 30000000원을 받는다")
    @Test
    void five_bonus_numbers_same_get_money() {
        Winning winning = new Winning(0, 0, 0, 1, 0);
        int money = winning.receiveWinningMoney();
        assertThat(money).isEqualTo(30000000);
    }

    @DisplayName("6개 일치할 경우(보너스 볼 제외) 장당 2000000000원을 받는다")
    @Test
    void six_numbers_same_get_money() {
        Winning winning = new Winning(0, 0, 0, 0, 1);
        int money = winning.receiveWinningMoney();
        assertThat(money).isEqualTo(2000000000);
    }

    @DisplayName("수익률은 당첨 금액 / 구매한 금액을 소수점 두자리까지 구한다")
    @ValueSource(ints = 3)
    @ParameterizedTest
    void total_return_rate(final int cnt) {
        Winning winning = new Winning(1, 0, 0, 0, 0);
        double totalReturn = winning.calculateTotalRate(cnt);
        assertThat(totalReturn).isEqualTo(1.67);
    }
}