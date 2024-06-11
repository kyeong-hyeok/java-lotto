package lotto;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

class LottoGameTest {

    private List<LottoNumber> createLotto(int... numbers) {
        return Arrays.stream(numbers).mapToObj(LottoNumber::new).collect(Collectors.toList());
    }

//    @Test
//    void 일등() {
//        int actual = LottoGame.match(
//                List.of(1, 2, 3, 4, 5, 6),
//                List.of(1, 2, 3, 4, 5, 6), 7
//        );
//        assertThat(actual).isEqualTo(1);
//    }

//    @Test
//    void 일등() {
//        int actual = LottoGame.match(
//                createLotto(1, 2, 3, 4, 5, 6),
//                createLotto(1, 2, 3, 4, 5, 6), new LottoNumber(7)
//        );
//        // 두 객체가 같기 위해서 createLotto hashcode 재정의 필요
//        assertThat(actual).isEqualTo(1);
//    }

//    @Test
//    void 일등() {
//        int actual = LottoGame.match(
//                new Lotto(1, 2, 3, 4, 5, 6),
//                new Lotto(1, 2, 3, 4, 5, 6), new LottoNumber(7)
//        );
//        // 두 객체가 같기 위해서 createLotto hashcode 재정의 필요
//        assertThat(actual).isEqualTo(1);
//    }

//    @Test
//    void 일등() {
//        int actual = LottoGame.match(
//                new Lotto(1, 2, 3, 4, 5, 6),
//                new Lotto(1, 2, 3, 4, 5, 6), new LottoNumber(7)
//        );
//        // 두 객체가 같기 위해서 createLotto hashcode 재정의 필요
//        assertThat(actual).isEqualTo(1);
//    }

    @Test
    void 일등() {
        int actual = LottoGame.match(
                new Lotto(1, 2, 3, 4, 5, 6),
                new WinningLotto(new Lotto(1, 2, 3, 4, 5, 6), new LottoNumber(7))
        );
        // 두 객체가 같기 위해서 createLotto hashcode 재정의 필요
        assertThat(actual).isEqualTo(1);
    }
}