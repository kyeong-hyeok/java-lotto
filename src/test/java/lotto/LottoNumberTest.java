package lotto;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThat;

class LottoNumberTest {

    @ValueSource(ints = {-1, 0, 46, 50})
    @ParameterizedTest
    void create(final int number) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new LottoNumber(number));
    }

    @Test
    void equals() {
        final LottoNumber number1 = new LottoNumber(1);
        final LottoNumber number2 = new LottoNumber(1);
        assertThat(number1).isEqualTo(number2);
    }
}