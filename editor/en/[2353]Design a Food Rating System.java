
//leetcode submit region begin(Prohibit modification and deletion)
class FoodRatings {
    class Food {
        String name;
        String cuisine;
        int rating;

        public Food(String name, String cuisine, int rating) {
            this.name = name;
            this.cuisine = cuisine;
            this.rating = rating;
        }
    }

    Map<String, PriorityQueue<Food>> pqMap;
    Map<String, Food> map;

    public FoodRatings(String[] foods, String[] cuisines, int[] ratings) {
        pqMap = new HashMap<>();
        map = new HashMap<>();

        for (int i = 0; i < foods.length; i++) {
            String name = foods[i];
            String cuisine = cuisines[i];
            int rating = ratings[i];

            if (!pqMap.containsKey(cuisine)) {
                pqMap.put(cuisine, createFoodPriorityQueue());
            }

            Food food = new Food(name, cuisine, rating);
            pqMap.get(cuisine).offer(food);
            map.put(name, food);
        }
    }


    public void changeRating(String food, int newRating) {
        Food curr = map.get(food);
        Food updated = new Food(food, curr.cuisine, newRating);
        pqMap.get(curr.cuisine).remove(curr);
        map.put(food, updated);
        pqMap.get(updated.cuisine).offer(updated);
    }

    public String highestRated(String cuisine) {
        PriorityQueue<Food> pq = pqMap.get(cuisine);
        return pq.isEmpty() ? "" : pq.peek().name;
    }

    private PriorityQueue<Food> createFoodPriorityQueue() {
        return new PriorityQueue<>((a, b) -> a.rating == b.rating ? a.name.compareTo(b.name) : b.rating - a.rating);
    }
}

/**
 * Your FoodRatings object will be instantiated and called as such:
 * FoodRatings obj = new FoodRatings(foods, cuisines, ratings);
 * obj.changeRating(food,newRating);
 * String param_2 = obj.highestRated(cuisine);
 */
//leetcode submit region end(Prohibit modification and deletion)
