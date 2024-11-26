import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        List<Integer> list = new ArrayList<>();
        for (int i = 5; i > 0; i--) {
            list.add(i);
        }

        System.out.println("Lista inicial: " + list);
        Long initialTimeStamp = System.currentTimeMillis();
        AtomicInteger trys = new AtomicInteger(0);
        bogoSort(list, trys);
        Long finalTimeStamp = System.currentTimeMillis();
        System.out.println("Lista ordenada: " + list);
        System.out.println("Tempo decorrido: " + (finalTimeStamp - initialTimeStamp) + "ms. " + trys.get() + " tentativas");
    }

    public static void bogoSort(List<Integer> list, AtomicInteger trys) throws InterruptedException {
        if (isSorted(list)) {
            return;
        }
        trys.incrementAndGet();
        shuffle(list);
        System.out.println(list);
        bogoSort(list, trys);
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
