package ass3;

import java.time.YearMonth;
import java.util.HashMap;

public class MonthlyIncome {
    private HashMap<YearMonth, Integer> income;

    public void earn(YearMonth ym, int money) {
        income.put(ym, income.getOrDefault(ym, 0) + money);
    }

    public int get(YearMonth m) {
        return income.get(m);
    }
}
