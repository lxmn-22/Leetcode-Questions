/*
Design a food rating system that can do the following:

Modify the rating of a food item listed in the system.
Return the highest-rated food item for a type of cuisine in the system.
Implement the FoodRatings class:

FoodRatings(String[] foods, String[] cuisines, int[] ratings) Initializes the system. 
The food items are described by foods, cuisines and ratings, all of which have a length of n.
foods[i] is the name of the ith food,
cuisines[i] is the type of cuisine of the ith food, and
ratings[i] is the initial rating of the ith food.
void changeRating(String food, int newRating) Changes the rating of the food item with the name food.
String highestRated(String cuisine) Returns the name of the food item that has the highest rating 
for the given type of cuisine. If there is a tie, return the item with the lexicographically smaller
 name.
Note that a string x is lexicographically smaller than string y if x comes before y in dictionary 
order, that is, either x is a prefix of y, or if i is the first position such that x[i] != y[i], 
then x[i] comes before y[i] in alphabetic order.

Example 1:
Input:
["FoodRatings", "highestRated", "highestRated", "changeRating", "highestRated", "changeRating", 
"highestRated"]
[[["kimchi", "miso", "sushi", "moussaka", "ramen", "bulgogi"], ["korean", "japanese", "japanese", 
"greek", "japanese", "korean"], [9, 12, 8, 15, 14, 7]], ["korean"], ["japanese"], ["sushi", 16], 
["japanese"], ["ramen", 16], ["japanese"]]
Output
[null, "kimchi", "ramen", null, "sushi", null, "ramen"]
 */
package Medium.DesignFoodRatingSystem;

/**
 * Your FoodRatings object will be instantiated and called as such:
 * FoodRatings obj = new FoodRatings(foods, cuisines, ratings);
 * obj.changeRating(food,newRating);
 * String param_2 = obj.highestRated(cuisine);
 */
class DesignFoodRatingSystem {
    public static FoodRatings(String[] foods, String[] cuisines, int[] ratings) {
        for (int i = 0; i < foods.length; ++i) {
            cuisineToRatingAndFoods.putIfAbsent(
                cuisines[i],
                new TreeSet<>((a, b)
                                    -> a.getKey().equals(b.getKey()) ? a.getValue().compareTo(b.getValue())
                                                                    : b.getKey() - a.getKey()));
            cuisineToRatingAndFoods.get(cuisines[i]).add(new Pair<>(ratings[i], foods[i]));
            foodToCuisine.put(foods[i], cuisines[i]);
            foodToRating.put(foods[i], ratings[i]);
        }
    }

    public static void changeRating(String food, int newRating) {
        final String cuisine = foodToCuisine.get(food);
        final int oldRating = foodToRating.get(food);
        TreeSet<Pair<Integer, String>> ratingAndFoods = cuisineToRatingAndFoods.get(cuisine);
        ratingAndFoods.remove(new Pair<>(oldRating, food));
        ratingAndFoods.add(new Pair<>(newRating, food));
        foodToRating.put(food, newRating);
    }

    public static String highestRated(String cuisine) {
        return cuisineToRatingAndFoods.get(cuisine).first().getValue();
    }

    // {cuisine: {(rating, food)}}
    Map<String, TreeSet<Pair<Integer, String>>> cuisineToRatingAndFoods = new HashMap<>();
    Map<String, String> foodToCuisine = new HashMap<>();
    Map<String, Integer> foodToRating = new HashMap<>();
}