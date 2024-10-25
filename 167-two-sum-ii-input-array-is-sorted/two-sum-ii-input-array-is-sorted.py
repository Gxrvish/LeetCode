class Solution:
    def twoSum(self, numbers: List[int], target: int) -> List[int]:
        r = len(numbers) - 1
        l = 0

        while r > l:
            if(numbers[r] + numbers[l] == target):
                return [l+1, r+1]
            elif(numbers[r] + numbers[l] > target):
                r -= 1
            else:
                l += 1
            