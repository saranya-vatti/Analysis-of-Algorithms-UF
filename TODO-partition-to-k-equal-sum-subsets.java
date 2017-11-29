class Solution {
    
    private void allValidSubsets(ArrayList<ArrayList<Integer>> lists, int[] nums, int sum) {
        int n = nums.length;
        for (int i = 0; i < (1<<n); i++) {
            ArrayList<Integer> alist = new ArrayList<>();
            int sumAlist = 0;
            for (int j = 0; j < n; j++) {
 
                // (1<<j) is a number with jth bit 1
                // so when we 'and' them with the
                // subset number we get which numbers
                // are present in the subset and which
                // are not
                if ((i & (1 << j)) > 0) {
                    alist.add(nums[j]);
                    sumAlist += nums[j];
                }
            }
            if(sumAlist == sum) {
                System.out.println(Arrays.toString(alist.toArray()));
                lists.add(alist);
            }
        }
    }
    public boolean canPartitionKSubsets(int[] nums, int k) {
        ArrayList<ArrayList<Integer>> lists = new ArrayList<>();
        int sum = 0;
        for(int i=0;i<nums.length;i++) {
            sum += nums[i];
        }
        allValidSubsets(lists, nums, sum/k);
        return true;
    }
}