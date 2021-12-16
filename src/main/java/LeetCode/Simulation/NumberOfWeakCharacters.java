package LeetCode.Simulation;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class NumberOfWeakCharacters {
    class Character {
        int attack;
        int defense;
    }

    public int numberOfWeakCharacters(int[][] properties) {
        int result = 0;
        List<Character> list = new ArrayList<>();
        for (int[] property : properties) {
            Character character = new Character();
            character.attack = property[0];
            character.defense = property[1];
            list.add(character);
        }
        list.sort((o1, o2) -> {
            if (o1.attack == o2.attack) {
                return o2.defense - o1.defense;
            } else {
                return o1.attack - o2.attack;
            }
        });
        Stack<Integer> stack = new Stack<>();
        stack.push(list.get(0).defense);
        for (int i = 1; i < list.size(); i++) {
            while (!stack.isEmpty() && list.get(i).defense > stack.peek()) {
                stack.pop();
                result++;
            }
            stack.push(list.get(i).defense);
        }
        return result;
    }

    public static void main(String[] args) {
        NumberOfWeakCharacters numberOfWeakCharacters = new NumberOfWeakCharacters();
        int result = numberOfWeakCharacters.numberOfWeakCharacters(new int[][]{{1, 1}, {2, 1}, {2, 2}, {1, 2}});
        System.out.println(result);
    }
}
