package task557;

import java.io.*;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;

/**
 * Аня недавно узнала, что такое квадратная матрица размерности n. Это таблица n×n с целыми
 * числами в ячейках. Число, стоящее на пересечении i-ой строки и j-ого столбца матрицы A,
 * кратко обозначается A[i, j]. Матрицы можно умножать, и Аня быстро освоила, как запрограммировать
 * эту операцию с помощью циклов. Результатом умножения двух матриц A и B будет матрица C, элементы
 * которой определяются следующим образом:
 *
 * Матрицы ей понадобились для конкретной задачи, в которой надо узнать определенный элемент произведения
 * нескольких матриц. Это уже достаточно сложная задача для Ани, но она усложняется тем, что все вычисления
 * ведутся по модулю некоторого простого числа p, то есть если при арифметических операциях получается число,
 * большее, либо равное p, оно заменяется на остаток при делении на p.
 *
 * Помогите Ане вычислить нужный ей элемент.
 *
 * Входные данные
 * В первой строчке входного файла INPUT.TXT стоят два числа: m - количество матриц, n - размер каждой из матриц
 * (1 ≤ m ≤ 130, 1 ≤ n ≤ 130). В следующей строчке содержатся номер строки и столбца, интересующего Аню элемента
 * 1 ≤ a ≤ n, 1 ≤ b ≤ n. В третьей строке содержится простое число p ≤ 1000. Далее следует описание m матриц.
 * Описание каждой матрицы состоит из n строк. В каждой из строк содержится n неотрицательных целых чисел, меньших p.
 * Соседние числа в строке разделены пробелом, а перед каждой матрицей пропущена строка.
 *
 * Выходные данные
 * В выходной файл OUTPUT.TXT выведите нужный Ане элемент произведения матриц.
 *
 * НЕ ПРОШЛА ТЕСТ НА ВРЕМЯ
 * ДОЛГО ЧИТАЕТ ИЗ ФАЙЛА
 */

public class task557 {
    public static void main(String ... args) throws IOException {
        try(Scanner scanner = new Scanner(Paths.get("INPUT.TXT"));
            FileWriter out = new FileWriter("OUTPUT.TXT")){
            ArrayList<Integer> countAndSize = new ArrayList<>(Arrays.stream(scanner.nextLine()
                    .split(" "))
                    .map(Integer::parseInt)
                    .collect(Collectors.toList()));
            int count = countAndSize.get(0);
            int size = countAndSize.get(1);
            ArrayList<Integer> lineAndColumn = new ArrayList<>(Arrays.stream(scanner.nextLine()
                    .split(" "))
                    .map(Integer::parseInt)
                    .collect(Collectors.toList()));
            int primeNumber = Arrays.stream(scanner.nextLine()
                    .split(" "))
                    .map(Integer::parseInt)
                    .collect(Collectors.toList()).get(0);
            ArrayList<Integer> array = new ArrayList<>();
            scanner.nextLine();
            for(int i = 0 ; i < size ; i++){
                if(i == (lineAndColumn.get(0)-1)) {
                    array.addAll(Arrays.stream(scanner.nextLine()
                            .split(" "))
                            .map(Integer::parseInt)
                            .collect(Collectors.toList()));
                }else{
                    scanner.nextLine();
                }
            }
            while(count > 1) {
                scanner.nextLine();
                ArrayList<Integer> array1 = new ArrayList<>(Collections.nCopies(countAndSize.get(1),0));
                for(int i = 0 ; i < size; i++){
                    ArrayList<Integer> array2 = new ArrayList<>(Arrays.stream(scanner.nextLine()
                            .split(" "))
                            .map(Integer::parseInt)
                            .collect(Collectors.toList()));
                    for (int j = 0; j < size; j++) {
                        array1.set(j, (array1.get(j) + array.get(i) * array2.get(j)) % primeNumber);
                    }
                }
                Collections.copy(array,array1);
                count--;
            }
            out.write(String.valueOf(array.get(lineAndColumn.get(1)-1)));
            out.flush();
        }
        catch(IOException e){

            e.printStackTrace();
        }
    }
}