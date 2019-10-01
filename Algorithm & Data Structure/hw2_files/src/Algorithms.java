import java.util.Queue;

/**
 * Write your solution to this assignment in this class
 */
public class Algorithms {

    /**
     * Write your implementation of the sortQueue algorithm here
     *
     * @param queue the queue to sort
     */
    public static <T extends Comparable<T>> void sortQueue(Queue<T> queue) {
        int originalSize = queue.size();

        for (int i = 0; i < originalSize; i++) {

            T firstValue = queue.peek();
            queue.poll();
            int size = queue.size();
            T secondValue = queue.peek();


            for (int j = 0; j < size; j++) {

                // Compare two values and always put the larger one at the end of the queue.
                if (firstValue.compareTo(secondValue) >= 0) {
                    queue.offer(secondValue);
                    queue.poll();
                    secondValue = queue.peek();
                } else {
                    queue.offer(firstValue);
                    firstValue = secondValue;
                    queue.poll();
                    secondValue = queue.peek();
                }
            }
            queue.offer(firstValue);
        }
    }



    /**
     * Write your implementation of the findMissingNumber algorithm here
     *
     * @param numbers the arithmetic sequence
     * @return the missing number in the sequence
     */
    public static int findMissingNumber(int[] numbers) {
        return findMissingNumberHelper(numbers, 0,  numbers.length - 1);
    }

    private static int findMissingNumberHelper(int[] numbers, int startIndex,
                                               int endIndex) {
        int commonDifference = (numbers[numbers.length - 1] - numbers[0]) / (numbers.length + 1 - 1);
        int midIndex = (startIndex + endIndex) / 2;

        // Consider the common difference is zero, which means all elements are the same.
        if (numbers[startIndex] == numbers[endIndex]){
            return numbers[startIndex];
        }
        if(midIndex - startIndex <= 1 || endIndex - midIndex <= 1) {
            // Consider there are only two elements in the sequence.
            if (numbers.length == 2) {
                return (numbers[startIndex] + commonDifference);
            }
            // Consider the missing number is between number[midIndex] and number[midIndex + 1].
            else if (numbers[midIndex + 1] - numbers[midIndex] != commonDifference) {
                return (numbers[midIndex] + commonDifference);
            }
            // Consider the missing number is between number[midIndex - 1] and number[midIndex].
            else if (numbers[midIndex] - numbers[midIndex - 1] != commonDifference) {
                return (numbers[midIndex] - commonDifference);
            }
        }
        // Calculate the common difference from the first element to the middle element.
        // If the calculation result is equal to the common difference, this means the missing
        // element is on the other side. So, the start position updates to midIndex plus 1.
        if ((numbers[midIndex] - numbers[0]) / midIndex == commonDifference) {
            return findMissingNumberHelper(numbers, midIndex + 1, endIndex);
        }
        // Same as above. However, this time the missing element is on the left side.
        // So, change the end position to midIndex minus 1.
        return findMissingNumberHelper(numbers, startIndex, midIndex - 1);

    }
}
