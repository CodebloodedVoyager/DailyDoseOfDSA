class Solution {
    public long minCost(int[] basket1, int[] basket2) {

        // You're what you regularly do. 

        Map<Integer, Integer> freq = new HashMap<>();
        int minVal = Integer.MAX_VALUE;

        for (int i = 0; i < basket1.length; i++) {
            freq.put(basket1[i], freq.getOrDefault(basket1[i], 0) + 1);
            freq.put(basket2[i], freq.getOrDefault(basket2[i], 0) - 1);
            minVal = Math.min(minVal, Math.min(basket1[i], basket2[i]));
        }

        List<Integer> excess = new ArrayList<>();

        for (Map.Entry<Integer, Integer> e : freq.entrySet()) {
            int val = e.getKey(), count = e.getValue();

            if (count % 2 != 0) return -1; // Impossible to make baskets equal

            for (int i = 0; i < Math.abs(count) / 2; i++) {
                excess.add(val);
            }
        }

        Collections.sort(excess);
        long cost = 0;

        for (int i = 0; i < excess.size() / 2; i++) {
            cost += Math.min(excess.get(i), 2L * minVal);
        }

        return cost;
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        // TreeMap<Integer, Integer> freq = new TreeMap<>();

        // // Count net frequency difference
        // for (int fruit : basket1) {
        //     freq.put(fruit, freq.getOrDefault(fruit, 0) + 1);
        // }
        // for (int fruit : basket2) {
        //     freq.put(fruit, freq.getOrDefault(fruit, 0) - 1);
        // }

        // List<Integer> extra = new ArrayList<>();
        // int minVal = Integer.MAX_VALUE;

        // for (Map.Entry<Integer, Integer> e : freq.entrySet()) {
        //     int fruit = e.getKey();
        //     int count = e.getValue();
        //     if (count % 2 != 0) return -1; // Impossible to balance

        //     minVal = Math.min(minVal, fruit);

        //     for (int i = 0; i < Math.abs(count) / 2; i++) {
        //         extra.add(fruit);
        //     }
        // }

        // Collections.sort(extra);
        // long cost = 0;
        // for (int i = 0; i < extra.size() / 2; i++) {
        //     cost += Math.min(extra.get(i), 2 * minVal);
        // }

        // return cost;
    }
}