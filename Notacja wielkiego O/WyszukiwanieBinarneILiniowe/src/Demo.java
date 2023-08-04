public class Demo {
    public static void main(String[] args) {

        int[] nums = new int[100000];
        int target = 98;

        int result = linearSearch(nums, target);
        int result1 = binarySearch(nums, target);
//        int result2 = binarySearchRecursive(nums, target, 0, nums.length - 1);


        if (result != -1) {
            System.out.println("Element znaleziono pod indeksem: " + result);
        } else {
            System.out.println("Nie znaleziono");
        }
    }

    // wyszukiwanie liniowe
    private static int linearSearch(int[] nums, int target) {
        int steps = 0;
        for (int i = 0; i < nums.length; i++) {
            steps++;

            if (nums[i] == target){

                return i;
            }
        }
        System.out.println("Wyszukiwanie liniowe: kroki " + steps);
        return -1;
    }

    // wyszukiwanie binarne
    private static int binarySearch(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        int steps = 0;

        while (left <= right) {
            steps++;
            int mid = (left + right) / 2;

            if (nums[mid] == target) {

                return mid;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        System.out.println("Wyszukiwanie binarne: kroki " + steps);
        return -1;
    }


    // wyszukiwanie binarne rekurencja
    private static int binarySearchRecursive(int[] nums, int target, int left, int right) {
        int mid = (left + right) / 2;
        if (nums[mid] == target) {
            return mid;
        } else if (nums[mid] < target) {
            binarySearchRecursive(nums, target, mid + 1, right);
        } else {
            binarySearchRecursive(nums, target, left, mid - 1);
        }
        return -1;
    }


}
