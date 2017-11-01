/**
 * Given a binary tree, return the zigzag level order traversal of its nodes' values. (ie, from left to right, then right to left for the next level and alternate between).
 * <p>
 * For example:
 * Given binary tree {3,9,20,#,#,15,7},
 *    3
 *   / \
 *  9  20
 *  /  \
 * 15   7
 * return its zigzag level order traversal as:
 * [
 * [3],
 * [20,9],
 * [15,7]
 * ]
 * <p>
 * 思路：和层序遍历不同的是，层序遍历暂存每层节点时用的是队列（Queue）；而本题用的是栈（Stack）
 */

/**
 * 思路：和层序遍历不同的是，层序遍历暂存每层节点时用的是队列（Queue）；而本题用的是栈（Stack）
 */

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> lists = new ArrayList<List<Integer>>();
        if (root == null) return lists;

        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.add(root);
        int level = 1;

        while (!stack.isEmpty()) {
            Stack<TreeNode> stackHelper = new Stack<TreeNode>();
            List<Integer> list = new ArrayList<Integer>();
            while (!stack.isEmpty()) {
                TreeNode node = stack.pop();
                list.add(node.val);

                if (level % 2 != 0) {
                    if (node.left != null)
                        stackHelper.add(node.left);
                    if (node.right != null)
                        stackHelper.add(node.right);
                } else {
                    if (node.right != null)
                        stackHelper.add(node.right);
                    if (node.left != null)
                        stackHelper.add(node.left);
                }
            }
            level++;
            lists.add(list);
            stack = stackHelper;
        }

        return lists;
    }
}
