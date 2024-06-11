package lotto;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class LottoTest {

    @Test
    void create() {
        Assertions.assertThatIllegalArgumentException()
                .isThrownBy(() -> new Lotto(1,2,3,4,5,6,7));
    }
}

