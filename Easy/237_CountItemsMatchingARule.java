class Solution {
    public int countMatches(List<List<String>> items, String ruleKey, String ruleValue) {
        int totalRows = items.size();
        int count = 0;
        if (totalRows != 0) {
            int totalColumns = items.get(0).size();
            if (totalColumns != 0) {
                int rowIndex = -1;
                if (ruleKey.equals("type")) {
                    rowIndex = 0;
                } else if (ruleKey.equals("color")) {
                    rowIndex = 1;
                } else if (ruleKey.equals("name")) {
                    rowIndex = 2;
                }
                // System.out.println(rowIndex);
                if (rowIndex > -1) {
                    for (int currRow = 0; currRow < totalRows; currRow++) {
                        if (rowIndex < items.get(currRow).size()) {
                            if (items.get(currRow).get(rowIndex).equals(ruleValue)) {
                                count++;
                            }
                        }
                    }
                }
            }
        }
        return count;
    }
}