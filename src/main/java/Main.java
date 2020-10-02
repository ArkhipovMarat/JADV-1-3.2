import java.util.*;
import java.util.concurrent.*;
import java.util.concurrent.atomic.LongAdder;

public class Main {
        public static void main(String[] args) throws InterruptedException, ExecutionException {
            int count = 10;

            List<Integer> cashBox1 = new ArrayList<>();
            List<Integer> cashBox2 = new ArrayList<>();
            List<Integer> cashBox3 = new ArrayList<>();

            randomGenerator(cashBox1, count);
            randomGenerator(cashBox2, count);
            randomGenerator(cashBox3, count);

            LongAdder longAdder = new LongAdder();

            Thread thread1 = new Thread(new Summator(cashBox1, longAdder));
            Thread thread2 = new Thread(new Summator(cashBox2, longAdder));
            Thread thread3 = new Thread(new Summator(cashBox3, longAdder));

            thread1.start();
            thread2.start();
            thread3.start();

            thread1.join();
            thread2.join();
            thread3.join();

            System.out.println("> summ = " + longAdder.sum());
        }

        public static List<Integer> randomGenerator(List<Integer> arrayList, int count) {
            Random random = new Random();
            int randomCount = random.nextInt(count) + count / 2;
            for (int i = 0; i < randomCount; i++) {
                arrayList.add(random.nextInt(count));
            }
            System.out.println(arrayList);
            return arrayList;
        }
}

