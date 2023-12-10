package ass3;

import java.time.YearMonth;
import java.util.HashMap;

public class MonthlyIncome {
    private HashMap<YearMonth, Integer> rIncome;
    private HashMap<YearMonth, Integer> nrIncome;

    public void rEarn(YearMonth ym, int money) {
        rIncome.put(ym, rIncome.getOrDefault(ym, 0) + money);
    }
    public void nrEarn(YearMonth ym, int money) {
        nrIncome.put(ym, nrIncome.getOrDefault(ym, 0) + money);
    }

    public int getrIncome(YearMonth m) {
        return rIncome.get(m);
    }
    public int getnrIncome(YearMonth m) {
        return nrIncome.get(m);
    }
}
