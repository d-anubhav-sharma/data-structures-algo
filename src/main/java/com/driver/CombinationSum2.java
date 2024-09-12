package com.driver;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

import com.logger.DLogger;

public class CombinationSum2 {

    public static void main(String[] args) {
        DLogger.info("{}\n{}\n{}\n{}\n{}", 
            new CombinationSum2().new Solution().combinationSum2(new int[] {2,3,6,7}, 7),
            new CombinationSum2().new Solution().combinationSum2(new int[] {2,3,5}, 8),
            new CombinationSum2().new Solution().combinationSum2(new int[] {2}, 1),
            new CombinationSum2().new Solution().combinationSum2(new int[] {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1}, 30),
            new CombinationSum2().new Solution().combinationSum2(new int[] {1,2}, 4)
        );
    }

    class Solution {

        class Data {
            List<Integer> result = new ArrayList<>();

            Data(List<Integer> list) {
                this.result = list;
            }

            @Override
            public int hashCode() {
                return Objects.hash(result);
            }

            @Override
            public boolean equals(Object target) {
                if (target instanceof Data other) {
                    return Objects.equals(this.result, other.result);
                }
                return false;
            }
        }

        public List<List<Integer>> combinationSum2(int[] candidates, int target) {
            Arrays.sort(candidates);
            Set<Data> result = new HashSet<>();
            Deque<Integer> stack = new ArrayDeque<>();
            traverse(stack, candidates, result, target, 0);
            return result.stream().map(e -> e.result).toList();
        }

        private void traverse(Deque<Integer> stack, int[] candidates, Set<Data> result, int rem, int start) {
            if (rem == 0) {
                result.add(new Data(new ArrayList<>(stack)));
                return;
            }
            int n = candidates.length;
            for (int i = start; i < n; i++) {
                if (i > start && candidates[i] == candidates[i - 1]) continue;
                
                int x = candidates[i];
                if (x <= rem) {
                    stack.push(x);
                    traverse(stack, candidates, result, rem - x, i + 1);
                    stack.pop();
                }
            }
        }
    }
}
