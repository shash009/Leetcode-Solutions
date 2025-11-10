class Solution {
    public boolean closeStrings(String word1, String word2) {
        if(word1.length() != word2.length()){
            return false;
        }
        HashMap<Character, Integer> mpp1 = new HashMap<>();
        HashMap<Character, Integer> mpp2 = new HashMap<>();
        for(char c : word1.toCharArray()){
            mpp1.put(c, mpp1.getOrDefault(c, 0) + 1);
        }
        for(char c : word2.toCharArray()){
            mpp2.put(c, mpp2.getOrDefault(c, 0) + 1);
        }     
        if (!mpp1.keySet().equals(mpp2.keySet())) {
            return false;
        }
        List<Integer> freq1 = new ArrayList<>(mpp1.values());
        List<Integer> freq2 = new ArrayList<>(mpp2.values());
        Collections.sort(freq1);
        Collections.sort(freq2);
        return freq1.equals(freq2);
    }
}