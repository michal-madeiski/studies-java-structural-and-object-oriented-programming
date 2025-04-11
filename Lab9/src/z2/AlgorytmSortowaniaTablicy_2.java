package z2;

public class AlgorytmSortowaniaTablicy_2 implements SortowanieTablicy {
    @Override
    public void AlgorytmSortowaniaTablicy(int[] t) {
        for (int i = 0; i < t.length - 1; i++) {
            for (int j = i; j < t.length; j++) {
                if (t[i] > t[j]) {
                    int temp = t[i];
                    t[i] = t[j];
                    t[j] = temp;
                }
            }
        }
    }

    @Override
    public void wyswietlInfo() {
        System.out.println("(AlgorytmSortowaniaTablicy_2)");
    }
}
