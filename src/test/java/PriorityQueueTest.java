import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.NoSuchElementException;
import java.util.PriorityQueue;
import java.util.stream.Stream;

public class PriorityQueueTest {
    public static Stream<Arguments> stringIntAndListProvider() {
        return Stream.of(
          Arguments.arguments(new Integer[] {1, 3, 2, 4}, new Integer[] {1, 2, 3, 4}),
          Arguments.arguments(new Integer[] {5, 3, 6, 8}, new Integer[] {3, 5, 6, 8}),
          Arguments.arguments(new Integer[] {7, 9, 2, 3, 8, 0}, new Integer[] {0, 2, 3, 7, 8, 9}),
          Arguments.arguments(new Integer[] {4, 6, 3}, new Integer[] {3, 4, 6}),
          Arguments.arguments(new Integer[] {2, 3, 4, 5, 6}, new Integer[] {2, 3, 4, 5, 6})
        );
    }

    @ParameterizedTest(name = "#{index} - Test with {0}, {1}.")
    @MethodSource("stringIntAndListProvider")
    public void PriorityQueueTest_RunTest(Integer[] test_data, Integer[] correct_data) {
        PriorityQueue<Integer> test = new PriorityQueue<Integer>();
        for (int test_datum : test_data) {
            test.offer(test_datum);
        }

        for(int i = 0; i < test_data.length; i++) {
            Assertions.assertEquals(test.poll(), correct_data[i]);
        }
    }

    @Test
    public void throw_NullPointer() {
        Exception exception = Assertions.assertThrows(NullPointerException.class, () -> {
            new PriorityQueue<Integer>().offer(null);
        });
    }

    @Test
    public void throw_NoElement_remove() {
        Exception exception = Assertions.assertThrows(NoSuchElementException.class, () -> {
            new PriorityQueue<Integer>().remove();
        });
    }

    @Test
    public void throw_NoElement_element() {
        Exception exception = Assertions.assertThrows(NoSuchElementException.class, () -> {
            new PriorityQueue<Integer>().element();
        });
    }
}
























