package task557;

import java.io.*;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;

/**
 * НЕ ПРОХОДИТ ЛИМИТ ПО ПАМЯТИ
 */


public class task557variant2 {
    public static void main(String ... args) throws IOException {
        try(Scanner scanner = new Scanner(Paths.get("INPUT.TXT"));
            FileWriter out = new FileWriter("OUTPUT.TXT");) {
            ArrayList<String> r = new ArrayList();
            while (scanner.hasNext()) {
                String s = scanner.nextLine();
                if (s.equals("")) s = scanner.nextLine();
                r.add(s);
            }
            scanner.close();
            String[] str = r.remove(0).split(" ");
            int chislo = Integer.parseInt(str[0]);
            int size = Integer.parseInt(str[1]);
            str = r.remove(0).split(" ");
            int stroka = Integer.parseInt(str[0]);
            int stolbec = Integer.parseInt(str[1]);
            int prostoechislo = Integer.parseInt(r.remove(0).split(" ")[0]);
            ArrayList<Integer> array = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                if (i == (stroka - 1)) {
                    array.addAll(Arrays.stream(r.remove(0)
                            .split(" "))
                            .map(Integer::parseInt)
                            .collect(Collectors.toList()));
                } else {
                    r.remove(0);
                }
            }
            ArrayList<Integer> array1;
            ArrayList<Integer> array2 = new ArrayList<>();
            while (chislo > 1) {
                array1 = new ArrayList<>(Collections.nCopies(size, 0));
                for (int i = 0; i < size; i++) {
                    array2.removeAll(array2);
                    array2.addAll(Arrays.stream(r.remove(0)
                            .split(" "))
                            .map(Integer::parseInt)
                            .collect(Collectors.toList()));
                    for (int j = 0; j < size; j++) {
                        array1.set(j, (array1.get(j) + array.get(i) * array2.get(j)) % prostoechislo);
                    }
                }
                for (int i = 0; i < size; i++) {
                    array.set(i, array1.get(i));
                }
                chislo--;
            }
            out.write(String.valueOf(array.get(stolbec - 1)));
            out.flush();
            out.close();
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }
}