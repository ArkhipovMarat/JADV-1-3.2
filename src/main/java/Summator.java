import java.util.List;
import java.util.concurrent.atomic.LongAdder;

public class Summator implements Runnable {
    List<Integer> arrayList;
    LongAdder longAdder;

    public Summator(List<Integer> arrayList, LongAdder longAdder) {
        this.arrayList = arrayList;
        this.longAdder = longAdder;
    }

    @Override
    public void run() {
        arrayList.forEach(value -> longAdder.add(value));
    }
}
