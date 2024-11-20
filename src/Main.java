import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        List<Integer> list = new ArrayList<>();
        for (int i = 5; i > 0; i--) {
            list.add(i);
        }

        System.out.println("Lista inicial:" + list);
        Long initialTimeStamp = System.currentTimeMillis();
        bogoSort(list);
        Long finalTimeStamp = System.currentTimeMillis();
        System.out.println("Lista ordenada: " + list);
        System.out.println("Temo decorrido: " + (finalTimeStamp - initialTimeStamp) + "ms");
    }

    public static void bogoSort(List<Integer> list) throws InterruptedException {
        if (isSorted(list)) {
            return;
        }

        shuffle(list);
        Thread.sleep(100);
        System.out.println(list);
        bogoSort(list);
    }

    public static boolean isSorted(List<Integer> list) {
        for (int i = 0; i < list.size() - 1; i++) {
            if (list.get(i) > list.get(i + 1)) {
                return false;
            }
        }
        return true;
    }

    public static void shuffle(List<Integer> list) {
        Random random = new Random();
        for (int i = 0; i < list.size(); i++) {
            int randomIndex = random.nextInt(list.size());
            int temp = list.get(i);
            list.set(i, list.get(randomIndex));
            list.set(randomIndex, temp);
        }
    }
}