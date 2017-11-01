public class Solution {
    public String convert(String s, int numRows) {
        if (s == null || s.length() < 2 || numRows < 2)
            return s;

        ArrayList<StringBuilder> list = new ArrayList<StringBuilder>();
        for (int i = 0; i < numRows; i++) {
            list.add(new StringBuilder());
        }

        int cycle = 2 * numRows - 2;
        int length = s.length();
        for (int j = 0; j < length; j++) {
            int index = numRows - 1 - Math.abs(numRows - 1 - (j % cycle));
            list.get(index).append(s.charAt(j));
        }

        StringBuilder sb = new StringBuilder();
        for (int k = 0; k < numRows; k++) {
            sb.append(list.get(k));
        }

        return sb.toString();
    }
}
