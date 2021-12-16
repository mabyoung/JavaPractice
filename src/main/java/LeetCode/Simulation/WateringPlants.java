package LeetCode.Simulation;

public class WateringPlants {
    public int wateringPlants(int[] plants, int capacity) {
        int result = 0;
        int targetIndex = 0;
        int n = plants.length;
        int currentIndex = -1;
        int water = capacity;
        while (targetIndex < n) {
            if (water < plants[targetIndex]) {
                result += (currentIndex + 1) * 2;
                water = capacity;
            } else {
                currentIndex++;
                result++;
                water -= plants[currentIndex];
                targetIndex++;
            }
        }
        return result;
    }
}
