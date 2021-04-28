package OldExams2016.Simulation;

import java.util.HashMap;
import java.util.Map;

public class ChkBloodType {
    public String[] chkBlood(String father, String mother) {
        Map<String, String[]> map = new HashMap<>();
        map.put("O,O", new String[]{"O"});
        map.put("A,O", new String[]{"A", "O"});
        map.put("A,A", new String[]{"A", "O"});
        map.put("A,B", new String[]{"A", "AB", "B", "O"});
        map.put("A,AB", new String[]{"A", "AB", "B"});
        map.put("B,O", new String[]{"B", "O"});
        map.put("B,B", new String[]{"B", "O"});
        map.put("B,AB", new String[]{"A", "AB", "B"});
        map.put("AB,O", new String[]{"A", "B"});
        map.put("AB,AB", new String[]{"A", "AB", "B"});
        String[] result = map.get(father + "," + mother);
        return result == null ? map.get(mother + "," + father) : result;
    }
}
