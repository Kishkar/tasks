package task278;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.Scanner;

/**
 *В современной биологии ученым часто приходится иметь дело с последовательностями ДНК.
 * Эти последовательности зачастую являются очень длинными, и их ручная обработка требует
 * большого количества времени и сил. Поэтому возникает идея автоматизировать этот процесс.
 *
 * Для этого можно применять компьютерные методы обработки данных, например, весьма полезными
 * оказываются алгоритмы на строках. В этой задаче последовательность ДНК будет представляться
 * в виде непустой строки, все символы которой входят в множество {A, G, С, T}.
 *
 * Пусть даны две последовательности ДНК: s = s1s2 … sn и t = t1t2 … tm. Будем говорить, что t может
 * получится в результате эволюции из s, если s является подпоследовательностью t, то есть существует
 * такая последовательность индексов 1 ≤ i1 < i2 < … < in ≤ m, что s1=ti1, s2=ti2, … sn=tin.
 * Необходимо выяснить, может ли последовательность t получится в результате эволюции из s.
 *
 * Входные данные
 * Первая строка входного файла INPUT.TXT содержит последовательность s, вторая — последовательность t.
 * Размер входного файла не превосходит 256 килобайт
 *
 * Выходные данные
 * В выходной файл OUTPUT.TXT выведите слово YES, если последовательность t могла получиться
 * в результате эволюции из s, и слово NO — иначе.
 */


public class task278{

    public static void main(String ... args){
        try(Scanner scanner = new Scanner(Paths.get("INPUT.TXT"));
            FileWriter out = new FileWriter("OUTPUT.TXT")) {
            String string = scanner.next(),string2 = scanner.next();
            int index1 = 0,index2 = -1;
            boolean flag = true;
            for(int i = 0 ; i < string.length() ; i++){
                index1 = string2.indexOf(string.charAt(i),index2 + 1); // ищем индекс i-того символа во второй строке
                if(index1 <= index2 ) {
                    flag = false;
                    break;
                }
                index2 = index1;
            }
            if (flag) {
                out.write("YES");
            } else {
                out.write("NO");
            }
            out.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}