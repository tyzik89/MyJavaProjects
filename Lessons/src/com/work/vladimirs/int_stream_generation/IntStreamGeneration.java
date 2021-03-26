

import java.util.stream.IntStream;

public class IntStreamGeneration {

    protected IntStream pseudoRandomStream(int seed) {
        return IntStream.iterate(seed, x -> x * x / 10 % 1000);
    }

    protected IntStream pseudoRandomStream(int seed, int limit) {
        return pseudoRandomStream(seed).limit(limit);
    }
}
