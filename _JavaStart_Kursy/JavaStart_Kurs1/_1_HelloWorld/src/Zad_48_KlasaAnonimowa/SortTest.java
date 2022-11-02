package Zad_48_KlasaAnonimowa;

import java.util.Arrays;

class SortTest {
    public static void main(String[] args) {
        double[] n = new double[]{-4, 5, 0, 134, -543, 0.324, 7.5, 134.01, 56};
        System.out.println("Tablica przed sortowaniem: " + Arrays.toString(n));

        Sortable srt = new Sortable() {
            @Override
            public void sort(double[] nums) {
                for (int i = 0; i < nums.length; i++) {
                    for (int j = 1; j < nums.length; j++) {
                        if (nums[j - 1] > nums[j]) {
                            double temp = nums[j-1];
                            nums[j - 1] = nums[j];
                            nums[j] = temp;
                        }
                    }
                }
            }

        };

        srt.sort(n);
        System.out.println("Tablica po sortowaniu: " + Arrays.toString(n));
    }

}
