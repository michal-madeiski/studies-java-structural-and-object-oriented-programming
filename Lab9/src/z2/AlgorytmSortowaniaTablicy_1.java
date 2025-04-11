package z2;

public class AlgorytmSortowaniaTablicy_1 implements SortowanieTablicy {
    @Override
    public void AlgorytmSortowaniaTablicy(int[] t) {
        for (int i = 0; i < t.length; i++) {
            for (int j = 1; j < t.length; j++) {
                if (t[j] < t[j - 1]) {
                    int temp = t[j];
                    t[j] = t[j - 1];
                    t[j - 1] = temp;
                }
            }
        }
    }

    @Override
    public void wyswietlInfo() {
        System.out.println("(AlgorytmSortowaniaTablicy_1)");
    }
}
