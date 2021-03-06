

// Сортировка пузырьком: после каждой итерации вложенного цикла
// "в этом случае" наибольший элемент перемещается в конец
// массива, размер которого в предалах первого цикла уменьшается

public class BubbleSort {
    public static <T extends Comparable<? super T>>void sort_ins(T[] mas) {
        int res = 0;
        for(int i = 0; i<mas.length-1; ++i) {
            T one = (T) mas[i];
            T two = (T) mas[i+1];
            res = one.compareTo(two);
            if (res > 0 ) {
                boolean b = true;
                int res2 = 0;
                T val;
                for(int j = i+1; b==true && j > 0; --j) {
                    T one1 = (T) mas[j-1];
                    T two2 = (T) mas[j];
                    res2 = one1.compareTo(two2);
                    if (res2 > 0) {
                        mas[j] = one1;
                        mas[j-1] = two2;
                        b=true;
                    }
                    else
                        b=false;
                }
            }
        }
    }



}
