class Solution {
    public int reversePairs(int[] nums) {
        return mergeSort(nums, 0, nums.length - 1);
    }

    static int mergeSort(int[] arr, int l, int r) {
        if (l >= r) return 0;

        int mid = l + (r - l) / 2;

        int left = mergeSort(arr, l, mid);
        int right = mergeSort(arr, mid + 1, r);
        int merged = merge(arr, l, mid, r);

        return left + right + merged;
    }

    static int merge(int[] arr, int l, int mid, int r) {
        int[] temp = new int[r - l + 1];

        int i = l;          // left pointer
        int j = mid + 1;    // right pointer
        int k = 0;          // temp pointer
        int count = 0;

        // COUNTING LOOP happens first
        while (i <= mid && j <= r) {
            if (arr[i] > 2L * arr[j]) {
                count += (mid - i + 1);
                j++;
            } else {
                i++;
            }
        }
        i = l;
        j = mid+1;

        while (i <= mid && j <= r) {
            if (arr[i] <= arr[j]) {
                temp[k++] = arr[i++];
            } else {
                temp[k++] = arr[j++];
            }
        }

        // left leftover
        while (i <= mid) temp[k++] = arr[i++];

        // right leftover
        while (j <= r) temp[k++] = arr[j++];

        // copy back
        for (int x = 0; x < temp.length; x++) {
            arr[l + x] = temp[x];
        }

        return count;
    }
}
