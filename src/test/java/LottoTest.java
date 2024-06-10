import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Collections;
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

    @DisplayName("로또 1장의 가격은 1000원이다.")
    @Test
    void lotto_price() {
        List<Integer> lottos = intRangeProvider();
        Lotto lotto = new Lotto(lottos);
        assertThat(lotto.getPrice()).isEqualTo(1000);
    }

    @DisplayName("당첨 번호는 6개이다. (1~45)")
    @Test
    void lotto_num_size() {
        List<Integer> lottos = intRangeProvider();
        Lotto lotto = new Lotto(lottos);
        assertThat(lotto.getLottoNums()).hasSize(6);
    }

    static List<Integer> intRangeProvider() {
        List<Integer> numList = IntStream.rangeClosed(1, 45).boxed().collect(Collectors.toList());
        Collections.shuffle(numList);
        return numList.subList(0, 6);
    }

}