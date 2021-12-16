package LeetCode.Simulation;

import java.util.ArrayList;
import java.util.List;

public class FindMaximizedCapital {
    public class Project {
        int profit;
        int capital;
    }

    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        List<Project> projectList = new ArrayList<>();
        for (int i = 0; i < profits.length; i++) {
            Project project = new Project();
            project.profit = profits[i];
            project.capital = capital[i];
            projectList.add(project);
        }
        projectList.sort((o1, o2) -> {
            if (o1.profit == o2.profit) {
                return o1.capital - o2.capital;
            }
            return o2.profit - o1.profit;
        });
        int result = w;
        for (int i = 0; i < k; i++) {
            for (Project project : projectList) {
                
            }
        }
        return result;
    }
}
