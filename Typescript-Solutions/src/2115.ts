/*
PROBLEM: 2115: Find all possible recipes from given supplies

You have information about n different recipes. You are given a string array recipes and a 2D string array ingredients. The ith recipe has the name recipes[i], and you can create it if you have all the needed ingredients from ingredients[i]. A recipe can also be an ingredient for other recipes, i.e., ingredients[i] may contain a string that is in recipes.

You are also given a string array supplies containing all the ingredients that you initially have, and you have an infinite supply of all of them.

Return a list of all the recipes that you can create. You may return the answer in any order.

Note that two recipes may contain each other in their ingredients.

Example 1:
Input: recipes = ["bread"], ingredients = [["yeast","flour"]], supplies = ["yeast","flour","corn"]
Output: ["bread"]
Explanation:
We can create "bread" since we have the ingredients "yeast" and "flour".

Example 2:
Input: recipes = ["bread","sandwich"], ingredients = [["yeast","flour"],["bread","meat"]], supplies = ["yeast","flour","meat"]
Output: ["bread","sandwich"]
Explanation:
We can create "bread" since we have the ingredients "yeast" and "flour".
We can create "sandwich" since we have the ingredient "meat" and can create the ingredient "bread".

Example 3:
Input: recipes = ["bread","sandwich","burger"], ingredients = [["yeast","flour"],["bread","meat"],["sandwich","meat","bread"]], supplies = ["yeast","flour","meat"]
Output: ["bread","sandwich","burger"]
Explanation:
We can create "bread" since we have the ingredients "yeast" and "flour".
We can create "sandwich" since we have the ingredient "meat" and can create the ingredient "bread".
We can create "burger" since we have the ingredient "meat" and can create the ingredients "bread" and "sandwich".
*/
function findAllRecipes(
	recipes: string[],
	ingredients: string[][],
	supplies: string[]
): string[] {
	let recSet = new Set(recipes),
		dp = new Map<string, boolean>(supplies.map((x) => [x, true]));

	const canCreate = (rec: string, visited: Set<string>): boolean => {
		if (dp.has(rec)) return dp.get(rec)!;
		if (!recSet.has(rec)) return false;
		if (visited.has(rec)) return false; // Cycle!

		visited.add(rec);

		for (let ing of ingredients[recipes.indexOf(rec)]) {
			if (!canCreate(ing, visited)) {
				dp.set(rec, false);
				return false;
			}
		}

		visited.delete(rec);

		dp.set(rec, true);
		return true;
	};

	return recipes.filter((rec) => canCreate(rec, new Set<string>()));
}
