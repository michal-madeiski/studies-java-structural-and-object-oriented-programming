package z2;

import java.util.Arrays;

public class AlgorytmSortowaniaTablicy_3 implements SortowanieTablicy {
    @Override
    public void AlgorytmSortowaniaTablicy(int[] t) {
        Arrays.sort(t);
    }

    @Override
    public void wyswietlInfo() {
        System.out.println("(AlgorytmSortowaniaTablicy_3)");
    }
}
