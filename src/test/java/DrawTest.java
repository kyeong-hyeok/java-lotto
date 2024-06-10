import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThat;

class DrawTest {

    @DisplayName("3개 일치할 경우 장당 5000원을 받는다")
    @Test
    void three_numbers_same() {
        SameNumberCount sameNumberCount = new SameNumberCount(1, 0, 0, 0, 0);
        int money = sameNumberCount.receiveMoney();
        assertThat(money).isEqualTo(5000);
    }

    @DisplayName("4개 일치할 경우 장당 50000원을 받는다")
    @Test
    void four_numbers_same() {
        SameNumberCount sameNumberCount = new SameNumberCount(0, 1, 0, 0, 0);
        int money = sameNumberCount.receiveMoney();
        assertThat(money).isEqualTo(50000);
    }

    @DisplayName("5개 일치할 경우 장당 1500000원을 받는다.")
    @Test
    void five_numbers_same() {
        SameNumberCount sameNumberCount = new SameNumberCount(0, 0, 1, 0, 0);
        int money = sameNumberCount.receiveMoney();
        assertThat(money).isEqualTo(1500000);
    }

    @DisplayName("5개 일치할 경우(보너스 볼 일치) 장당 30000000원을 받는다")
    @Test
    void five_bonus_numbers_same() {
        SameNumberCount sameNumberCount = new SameNumberCount(0, 0, 0, 1, 0);
        int money = sameNumberCount.receiveMoney();
        assertThat(money).isEqualTo(30000000);
    }

    @DisplayName("6개 일치할 경우(보너스 볼 제외) 장당 2000000000원을 받는다")
    @Test
    void six_numbers_same() {
        SameNumberCount sameNumberCount = new SameNumberCount(0, 0, 0, 0, 1);
        int money = sameNumberCount.receiveMoney();
        assertThat(money).isEqualTo(2000000000);
    }
}