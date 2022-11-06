package Zad_69_Collections;

import java.util.*;

class Lotto {
    private List<Integer> list = new ArrayList<>();

    void generate() {
        Random random = new Random();
        for (int i = 0; i < 50; i++) {
            list.add(random.nextInt(49) + 1);
        }
        randomize();
    }

    void randomize() {
        Collections.shuffle(list);
    }

    int checkResult(List<Integer> numbers) {
        int num = 0;
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 6; j++) {
                if (Objects.equals(numbers.get(i), list.get(j))) num++;
            }
        }
        return num;
    }

    public List<Integer> getList() {
        List<Integer> nums = new ArrayList<>();
        for (int i = 0; i < 6; i++) {
            nums.add(list.get(i));
        }
        return nums;
    }
}
