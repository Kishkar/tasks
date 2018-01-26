package task670;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.Scanner;

/**
 * Антон записал ряд натуральных чисел в порядке возрастания: 1, 2, 3, 4, 5, 6, 7,
 * 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23 и т.д. Затем вычеркнул из него
 * все числа, в которых имеется хотя бы две одинаковых цифры, и получил последовательность:
 * 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 23 и т.д.
 *
 * Вам необходимо по заданному N найти N-ое по счету число в получившейся последовательности.
 *
 * Входные данные
 * В единственной строке входного файла INPUT.TXT записано натуральное число N (1 ≤ N ≤ 10000).
 *
 * Выходные данные
 * В единственную строку выходного файла OUTPUT.TXT нужно вывести N-ое по счету число без одинаковых цифр.
 */

public class task670 {
    public static void main(String ... args){
        try(Scanner scanner = new Scanner(Paths.get("INPUT.TXT"));
            FileWriter out = new FileWriter("OUTPUT.TXT")) {
            int index = scanner.nextInt(),number = 11;
            String result = "";
            if(index > 10) {
                for (int i = 11; i <= index; ) {
                    number++;
                    boolean flag = true;
                    String str = String.valueOf(number);
                    for (int j = 0; j < str.length(); j++) {
                        if (str.indexOf(str.charAt(j), str.indexOf(str.charAt(j)) + 1) != -1) {
                            flag = false;
                            break;
                        }
                    }
                    if (flag) {
                        i++;
                    }
                }
                index = number;
            }
            out.write(String.valueOf(index));
            out.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
