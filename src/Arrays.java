import java.util.ArrayList;
import java.util.Optional;
import java.util.Random;
import java.util.Scanner;

public class Arrays {
    public static Integer[] prompt(String promptMessage, String endingValue, String startMessage) {
        String finalStartMessage = Optional.ofNullable(startMessage).orElse("Enter number values. If you want to end type '%s'");
        String finalPromptMessage = Optional.ofNullable(promptMessage).orElse(">> ");
        String finalEndingValue = Optional.ofNullable(endingValue).orElse("stop");

        Scanner sc = new Scanner(System.in);
        System.out.printf(finalStartMessage+"\n", finalEndingValue);
        ArrayList<Integer> list = new ArrayList<>();
        while (true) {
            System.out.printf("%s", finalPromptMessage);
            String input = sc.nextLine();

            if (input.equalsIgnoreCase(finalEndingValue)) {
                break;
            }

            try {
                int number = Integer.parseInt(input);
                list.add(number);
            } catch (NumberFormatException e) {
                System.out.printf("Not a number. Type '%s' or try again", finalEndingValue);
            }
        }
        Integer[] array = new Integer[list.size()];
        array = list.toArray(array);
        return array;
    }
    public static Integer[] prompt() {
        return prompt(null, null, null);
    }
    public static Integer[] prompt(String promptMessage) {
        return prompt(promptMessage, null, null);
    }
    public static Integer[] prompt(String promptMessage, String endingValue) {
        return prompt(promptMessage, endingValue, null);
    }

    public static Integer[] random(int size, int min, int max) {
        Integer[] array = new Integer[size];
        for (int i = 0; i < size; i++) {
            Random random = new Random();
            array[i] = random.nextInt(max - min + 1) + min;
        }
        return array;
    }
    public static Integer[] random() {
        return random(10, 0, 100);
    }
    public static Integer[] random(int size) {
        return random(size, 0, 100);
    }
    public static Integer[] random(int size, int max) {
        return random(size, 0, max);
    }

    public static void print(Integer[] array, int breakValue) {
        for (int i = 0; i < array.length; i++) {
            int length = (int) (Math.log10(array[i]) + 1);
            System.out.printf("%" + (length + 2) + "d", array[i]);
            if (breakValue > 1 && i % breakValue == 0 && i != 0 ) {
                System.out.println();
            }
        }
    }
    public static void print(Integer[] array) {
        print(array, 0);
    }
}
