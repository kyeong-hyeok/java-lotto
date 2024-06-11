package lotto;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

public class Lotto {

    private final Set<LottoNumber> lottoNumbers;

    public Lotto(int ... numbers) {
        if (numbers.length != 6) {
            throw new IllegalArgumentException("로또는 1부터 45까지의 숫자만 가능합니다.");
        }
        this.lottoNumbers = Arrays.stream(numbers).mapToObj(LottoNumber::new).collect(Collectors.toSet());
    }

    public Set<LottoNumber> getLottoNumbers() {
        return lottoNumbers;
    }

    public boolean contains(LottoNumber lottoNumber) {
        return lottoNumbers.contains(lottoNumber);
    }
}
