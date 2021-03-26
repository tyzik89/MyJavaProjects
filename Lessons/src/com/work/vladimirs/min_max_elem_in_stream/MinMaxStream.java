

import java.util.Comparator;
import java.util.function.BiConsumer;
import java.util.stream.Stream;

public class MinMaxStream {

    public static <T> void findMinMax(
            Stream<? extends T> stream,
            Comparator<? super T> order,
            BiConsumer<? super T, ? super T> minMaxConsumer) {

        T[] ts = (T[]) new Object[2];

        stream.forEach(t -> {
            if (ts[0] == null && ts[1] == null) {ts[0] = t; ts[1] = t;}
            if (order.compare(t, (T) ts[0]) < 0) ts[0] = t;
            if (order.compare(t, (T) ts[1]) > 0) ts[1] = t;
        });

        minMaxConsumer.accept(ts[0], ts[ts.length - 1]);
    }
}
