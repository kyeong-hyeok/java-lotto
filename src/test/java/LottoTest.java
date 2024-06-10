import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThat;

class LottoTest {

    @DisplayName("로또는 1~45까지의 숫자로 이루어져 있다.")
    @Test
    void lotto_definition() {
        List<Integer> lottos = intRangeProvider();
        Lotto lotto = new Lotto(lottos);
        assertThat(lotto.getLottoNums()).allMatch(num -> num >= 1 && num <= 45);
    }

    static List<Integer> intRangeProvider() {
        return IntStream.rangeClosed(1, 45).boxed().collect(Collectors.toList());
    }

}