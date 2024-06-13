class Solution {
    public int minMovesToSeat(int[] seats, int[] students) {
        Arrays.sort(seats);
        Arrays.sort(students);
        int numMoves = 0;
        for(int i = 0; i < students.length; i++) {
            numMoves += Math.abs(seats[i] - students[i]);
        }
        return numMoves;
    }
}