package generics;
interface MealPlan {
    String getPlanName();
    String getPrimaryDietaryFocus();
}

class VegetarianMeal implements MealPlan {
    @Override
    public String getPlanName() {
        return "Vegetarian Meal Plan";
    }
    @Override
    public String getPrimaryDietaryFocus() {
        return "Plant-based, excluding meat and fish.";
    }
}

class VeganMeal implements MealPlan {
    @Override
    public String getPlanName() {
        return "Vegan Meal Plan";
    }
    @Override
    public String getPrimaryDietaryFocus() {
        return "Strictly plant-based, excluding all animal products.";
    }
}

class KetoMeal implements MealPlan {
    @Override
    public String getPlanName() {
        return "Ketogenic Meal Plan";
    }
    @Override
    public String getPrimaryDietaryFocus() {
        return "High-fat, adequate-protein, low-carbohydrate.";
    }
}

public class MealPlanGenerator {

    public static <T extends MealPlan> void generatePersonalizedPlan(T mealPlan) {
        System.out.println("\n--- Generating Personalized Meal Plan ---");
        if (mealPlan == null || mealPlan.getPlanName() == null || mealPlan.getPlanName().isEmpty()) {
            System.out.println("Validation Failed: Invalid meal plan provided.");
            return;
        }
        
        System.out.println("Validation Successful!");
        System.out.println("Generating your '" + mealPlan.getPlanName() + "'...");
        System.out.println("Focus: " + mealPlan.getPrimaryDietaryFocus());
        System.out.println("Plan generated successfully!");
        System.out.println("-----------------------------------------");
    }

    public static void main(String[] args) {
        VegetarianMeal vegPlan = new VegetarianMeal();
        VeganMeal veganPlan = new VeganMeal();
        KetoMeal ketoPlan = new KetoMeal();

        generatePersonalizedPlan(vegPlan);
        generatePersonalizedPlan(veganPlan);
        generatePersonalizedPlan(ketoPlan);
    }
}