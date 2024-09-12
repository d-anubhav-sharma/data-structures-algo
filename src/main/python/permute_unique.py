class Solution:
    def permuteUnique(self, nums):
        return self.permute(nums)

    def permute(self, nums):
        n = len(nums)
        if n==0: return []
        if n==1: return [[i for i in nums]]
        result = []
        prev = 101
        for i in range(n):
            removed_el = nums[i]
            remain_list = nums[:i]+nums[i+1:]
            if removed_el==prev: continue
            prev = removed_el
            remain_permute = self.permute(remain_list)
            for arr in remain_permute:
                for i in range(n-1):
                    narr = arr[:i]+[removed_el]+arr[i:]
                    if narr not in result: result.append(narr)
        return result
print(Solution().permuteUnique([1,2,3]))