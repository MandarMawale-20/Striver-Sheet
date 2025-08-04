
class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> triangle = new ArrayList<>();

        for (int row = 1; row <= numRows; row++) {
            triangle.add(helper(row));
        }

        return triangle;
    }

    private List<Integer> helper(int row) {
        long ans = 1;
        List<Integer> ansRow = new ArrayList<>();
        ansRow.add(1); // first element is always 1

        for (int col = 1; col < row; col++) {
            ans = ans * (row - col);
            ans = ans / col;
            ansRow.add((int) ans);
        }

        return ansRow;
    }
}

// Time Complexity: O(N^2)
// Space Complexity: O(N)
// Note: This code generates the first numRows of Pascal's Triangle using a helper method to calculate each row.