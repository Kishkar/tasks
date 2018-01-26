package task579;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.Scanner;

/**
 * Дана последовательность целых чисел. Требуется найти подпоследовательность
 * заданной последовательности с максимальным модулем суммы входящих в нее чисел.
 * Напомним, что модуль целого числа x равняется x, если x ≥ 0 и -x, если x < 0.
 *
 * Входные данные
 * Первая строка входного файла INPUT.TXT содержит натуральное число n (1 ≤ n ≤ 10000) - длину последовательности.
 * Во второй строке записаны n целых чисел, по модулю не превосходящих 10000.
 *
 * Выходные данные
 * В первой строке выходного файла OUTPUT.TXT выведите длину k выбранной вами подпоследовательности. Во второй
 * строке должны быть записаны k различных чисел, разделенных пробелами - номера выбранных членов последовательности.
 *
 */

public class task579{

    public static void main(String ... args){
        try(Scanner scanner = new Scanner(Paths.get("INPUT.TXT"));
            FileWriter out = new FileWriter("OUTPUT.TXT")) {
            int number = 0, kol = 0, sum1 = 0 , sum2 = 0, length = scanner.nextInt();
            StringBuilder str1 = new StringBuilder("");
            StringBuilder str2 = new StringBuilder("");
            for(int i = 0 ; i < length ; i++){
                number = scanner.nextInt(); // считаем число и проверим его на знак
                if(number < 0 ) {
                    sum1 += number;
                    str1.append(i+1);
                    str1.append(' ');
                }else{
                    sum2 += number;
                    kol++;
                    str2.append(i+1);
                    str2.append(' ');
                }
            }
            if (sum2 > Math.abs(sum1)) {
                out.write(new String(kol + "\r\n" + str2));
            } else {
                out.write(new String((length - kol) + "\r\n" + str1));
            }
            out.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}