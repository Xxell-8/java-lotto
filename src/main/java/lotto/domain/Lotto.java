package lotto.domain;

import java.util.*;
import java.util.stream.Collectors;

public class Lotto {
    private static final int LOTTO_SIZE = 6;
    private static final String WRONG_NUMBER_EXCEPTION = "[ERROR] 로또 번호는 중복되지 않는 6자리여야 합니다.";

    private final List<LottoNumber> numbers;

    private Lotto(List<LottoNumber> numbers) {
        validateLotto(numbers);
        this.numbers = numbers;
    }

    public static Lotto from(List<LottoNumber> numbers) {
        return new Lotto(numbers);
    }


    public static Lotto from(String[] numbers) {
        List<LottoNumber> lottoNumbers = Arrays.stream(numbers)
                .map(String::trim)
                .map(LottoNumber::from)
                .collect(Collectors.toList());
        return Lotto.from(lottoNumbers);
    }

    private void validateLotto(List<LottoNumber> numbers) {
        Set<LottoNumber> lottoNumbers = new HashSet<>(numbers);

        if (lottoNumbers.size() != LOTTO_SIZE) {
            throw new IllegalArgumentException(WRONG_NUMBER_EXCEPTION);
        }
    }

    public List<LottoNumber> getLottoNumbers() {
        return new ArrayList<>(this.numbers);
    }

    @Override
    public String toString() {
        List<Integer> result = numbers.stream()
                .map(LottoNumber::get)
                .sorted()
                .collect(Collectors.toList());
        return result.toString();
    }
}
