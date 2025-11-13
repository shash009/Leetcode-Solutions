class Solution {
    List<String> res;
    public void helper(int i, String num, int target, StringBuilder str, long currVal, long prev){
        if(i == num.length()){
            if(currVal == target){
                res.add(str.toString());
            }
            return;
        }
        for(int j = i; j < num.length(); j++){
            if(j != i && num.charAt(i) == '0'){
                break;
            }
            long curr = Long.parseLong(num.substring(i, j+1));
            int len = str.length();
            if(i == 0){
                str.append(curr);
                helper(j + 1, num, target, str, curr, curr);
                str.setLength(len);
            }else{
                str.append("+");
                str.append(curr);
                helper(j + 1, num, target, str, curr + currVal, curr);
                str.setLength(len);
                
                str.append("-");
                str.append(curr);
                helper(j + 1, num, target, str, currVal - curr, -curr);
                str.setLength(len);
                
                str.append("*");
                str.append(curr);
                helper(j + 1, num, target, str, currVal - prev + prev * curr, prev * curr);
                str.setLength(len);
            }

        }
    }
    public List<String> addOperators(String num, int target) {
        res = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        helper(0, num, target, sb, 0, 0);
        return res;
    }
}