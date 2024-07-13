class Solution {
    public int largestAltitude(int[] gain) {
        int maxh=0, h=0;
        for(int i = 0; i < gain.length; i++) {
            h += gain[i];
            maxh = Math.max(h, maxh);
        }
        return maxh;
    }
}