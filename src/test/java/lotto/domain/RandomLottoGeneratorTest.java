package lotto.domain;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class RandomLottoGeneratorTest {

    @Test
    public void 로또생성기는_6자리의_수를_반환한다() {
        //given
        RandomLottoGenerator randomLottoGenerator = new RandomLottoGenerator();

        //when
        List<Integer> lottoNumbers = randomLottoGenerator.get();

        //then
        assertThat(lottoNumbers.size()).isEqualTo(6);
    }
}