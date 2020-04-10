```java
    static public int maxSubArray(int[] nums, int min, int max) {
        if (max == min) return nums[min];

        int mid = (min + max)/2;

        return Math.max(Math.max(
                maxSubArray(nums, min, mid),
                maxSubArray(nums, mid + 1, max)),
                maxCrossingSubArray(nums, min, mid, max)
        );
    }
```