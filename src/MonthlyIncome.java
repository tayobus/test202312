import java.time.YearMonth;
import java.util.HashMap;

public class MonthlyIncome {
    private HashMap<YearMonth, Integer> rIncome = new HashMap<>();
    private HashMap<YearMonth, Integer> nrIncome = new HashMap<>();

    public void rEarn(YearMonth ym, int money) {
        try {
            rIncome.put(ym, rIncome.get(ym) + money);
        } catch (NullPointerException e) {
            rIncome.put(ym, money);
        }
    }
    public void nrEarn(YearMonth ym, int money) {
        try {
            nrIncome.put(ym, nrIncome.get(ym) + money);
        } catch (NullPointerException e) {
            nrIncome.put(ym, money);
        }
    }

    public int getrIncome(YearMonth m) {
        try {
            return rIncome.get(m);
        } catch (NullPointerException e) {
            return 0;
        }
    }
    public int getnrIncome(YearMonth m) {
        try {
            return nrIncome.get(m);
        } catch (Exception e) {
            return 0;
        }
    }
}
