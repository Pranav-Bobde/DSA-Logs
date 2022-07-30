//Link: https://leetcode.com/contest/weekly-contest-303/problems/design-a-food-rating-system/

//Time & Space Complexity: O(NLogN) O(N)

//Giving TLE.. why dunno!?!
class Node implements Comparator<Node>{
    String food;
    int rating;
    Node(){}
    Node(String f, int r){
        food = f;
        rating = r;
    }
    @Override
    public String toString(){
        return "food: " + food + " rating: " + rating;
    }
    @Override
    public int compare(Node n1, Node n2){
        if(n1.rating > n2.rating){
            return -1;
        }else if(n1.rating < n2.rating){
            return 1;
        }else{
            if(n1.food.compareTo(n2.food) < 0) return -1;
            else return 1;
        }
    }
}

class FoodRatings {
    String[] foodArr, cuisineArr;
    int[] ratingArr;
    Map<String, PriorityQueue<Node>> map;
    Map<String, String> foodCuisineMap;
    public FoodRatings(String[] foods, String[] cuisines, int[] ratings) {
        foodArr = foods;
        cuisineArr = cuisines;
        ratingArr = ratings;
        map = new HashMap<>();
        foodCuisineMap = new HashMap<>();
        for(int i=0; i<foodArr.length; i++){
            String food = foodArr[i];
            String cuisine = cuisineArr[i];
            int rating = ratingArr[i];
            foodCuisineMap.put(food, cuisine);
            if(map.get(cuisine)==null){
                PriorityQueue<Node> pq = new PriorityQueue<>(new Node());
                pq.add(new Node(food, rating));
                map.put(cuisine, pq);
            }else{
                map.get(cuisine).add(new Node(food, rating));
            }
        }
    }
    
    public void changeRating(String food, int newRating) {
        String cuisine = foodCuisineMap.get(food);
        PriorityQueue<Node> pq = map.get(cuisine);
        Node node = null;
        for(Node n : pq){
            if(n.food.equals(food)){
                node = n;
                break;
            }
        }
        pq.remove(node);
        pq.add(new Node(food, newRating));
    }
    
    public String highestRated(String cuisine) {
        PriorityQueue<Node> pq = map.get(cuisine);
        return pq.peek().food;
    }
}
