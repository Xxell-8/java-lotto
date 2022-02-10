package lotto.domain;

import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

public class Lotto {
    private static final int LOTTO_SIZE = 6;
    private static final String WRONG_NUMBER_EXCEPTION = "[ERROR] 로또 번호는 중복되지 않는 6자리여야 합니다.";

    private final List<LottoNumber> numbers;

    private Lotto(List<LottoNumber> numbers) {
        validateLotto(numbers);
        this.numbers = numbers;
    }

    public static Lotto of(List<LottoNumber> numbers) {
        return new Lotto(numbers);
    }

    private void validateLotto(List<LottoNumber> numbers) {
        Set<LottoNumber> lottoNumbers = new HashSet<>(numbers);

        if (lottoNumbers.size() != LOTTO_SIZE) {
            throw new IllegalArgumentException(WRONG_NUMBER_EXCEPTION);
        }
    }

    public List<LottoNumber> getLottoNumbers() {
        return this.numbers;
    }

    public List<Integer> getNumbers() {
        return this.numbers.stream()
            .map(LottoNumber::get)
            .collect(Collectors.toList());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Lotto lotto = (Lotto) o;
        return Objects.equals(numbers, lotto.numbers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(numbers);
    }
}
