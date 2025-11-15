class SmallestInfiniteSet {
    int curr;
    HashSet<Integer> hss;

    public SmallestInfiniteSet() {
        curr = 1;  
        hss = new HashSet<>();  
    }
    
    public int popSmallest() {
        if(!hss.isEmpty()){
            int min = Collections.min(hss);
            hss.remove(min);
            return min;
        }
        curr++;
        return curr - 1;
    }
    
    public void addBack(int num) {
        if(curr > num){
            hss.add(num);
        }
    }
}

/**
 * Your SmallestInfiniteSet object will be instantiated and called as such:
 * SmallestInfiniteSet obj = new SmallestInfiniteSet();
 * int param_1 = obj.popSmallest();
 * obj.addBack(num);
 */