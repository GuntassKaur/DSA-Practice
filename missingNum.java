class Solution {
    int missingNum(int arr[]) {
        int n = arr.length + 1;

        long expected_sum = (long) n * (n + 1) / 2;
        long actual_sum = 0;

        for (int i = 0; i < arr.length; i++) {
            actual_sum += arr[i];
        }

        return (int)(expected_sum - actual_sum);
    }
}
