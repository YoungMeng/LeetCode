/**
 * Given a binary tree, return the postorder traversal of its nodes' values.
 * <p>
 * For example:
 * Given binary tree {1,#,2,3},
 * 1
 * \
 * 2
 * /
 * 3
 * return [3,2,1].
 * <p>
 * Note: Recursive solution is trivial, could you do it iteratively?
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
 
 /*
  *1.---递归---
  */
public class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<Integer>();
        if (root == null)
            return list;

        postorder(root, list);

        return list;
    }

    public void postorder(TreeNode root, List<Integer> list) {
        if (root == null)
            return;

        if (root.left != null)
            postorder(root.left, list);

        if (root.right != null)
            postorder(root.right, list);

        list.add(root.val);
    }
}

/*
 *2.---迭代---
 */
public class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<Integer>();
        if (root == null)
            return list;

        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.push(root);
        list.add(root.val);
        TreeNode cur = root.right;

        while (!stack.empty()) {
            while (cur != null) {
                stack.push(cur);
                list.add(cur.val);
                cur = cur.right;
            }

            TreeNode node = stack.pop();
            cur = node.left;
            if (cur != null) {
                stack.push(cur);
                list.add(cur.val);
                cur = cur.right;
            }
        }

        int i = 0;
        int j = list.size() - 1;
        while (i < j) {
            int temp = list.get(i);
            list.set(i, list.get(j));
            list.set(j, temp);
            i++;
            j--;
        }

        return list;
    }
}
