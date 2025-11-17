import java.util.*;

class MyMainClass{
    public static void main(String[] args) {
        System.out.println("Top K Frequent Elements : " + Arrays.toString(topKFrequent(new int[] {1,1,1,2,2,3},2)));
    }
    public static int[] topKFrequent(int[] nums, int k) {
        int[] res = new int[k];
        Map<Integer, Integer> map = new HashMap<>();
        for(int num : nums){
            map.put(num,map.getOrDefault(num,0)+ 1);
        }

        Map<Integer,Integer>orderedCount  = new LinkedHashMap();
        map.entrySet().stream().sorted(Map.Entry.comparingByValue(Comparator.reverseOrder())).forEachOrdered(x->orderedCount.put(x.getKey(),x.getValue()));

        for(int i : orderedCount.keySet()) {
            res[res.length-(k--)] = i;
            if(k == 0) break;
        }
        System.out.println(orderedCount);
        return res;
    }
    
   
}