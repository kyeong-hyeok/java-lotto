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
}