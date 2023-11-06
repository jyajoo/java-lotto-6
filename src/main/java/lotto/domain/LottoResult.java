package lotto.domain;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;

public class LottoResult {
    private final Map<LottoRank, Integer> result;

    public LottoResult() {
        result = new EnumMap<>(LottoRank.class);
    }

    public void calculateResults(List<Integer> countResults, List<Boolean> bonusResults) {
        for (int i = 0; i < countResults.size(); i++) {
            LottoRank lottoRank = LottoRank.of(countResults.get(i), bonusResults.get(i));
            updateLottoResult(lottoRank);
        }
    }

    private void updateLottoResult(LottoRank lottoRank) {
        result.merge(lottoRank, 1, Integer::sum);
    }

    public int getCountByRank(LottoRank rank) {
        return result.getOrDefault(rank, 0);
    }
}
