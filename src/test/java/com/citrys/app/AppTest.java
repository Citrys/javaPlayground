package com.citrys.app;
import static org.junit.Assert.assertArrayEquals;
import com.citrys.app.SortingAlgos.BubbleSort;
import com.citrys.app.SortingAlgos.InsertionSort;
import com.citrys.app.SortingAlgos.SelectionSort;
import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class AppTest {
    @Test
    public void shouldBeSorted() {
        int[] arr = new int[]{-2, 5, 1, 3, 4, 7};
        BubbleSort buble = new BubbleSort();
        buble.bubbleSort(arr);
        int[] arrsorted = new int[]{-2, 1, 3, 4, 5, 7};
        assertArrayEquals(arr, arrsorted);
    }

    @Test
    public void selectionSortShouldBeSorted() throws Exception {
        int[] arr = new int[]{-2, 5, 1, 3, 4, 7};
        SelectionSort selection = new SelectionSort();
        selection.selectionSort(arr);
        int[] arrsorted = {-2, 1, 3, 4, 5, 7};

        assertArrayEquals(arr, arrsorted);
    }


    @Test
    public void insertionSortShouldBeSorted() throws Exception {
        int[] arr = new int[]{-2, 5, 1, 3, 4, 7};
        InsertionSort selection = new InsertionSort();
        selection.insertionSort(arr);
        int[] arrsorted = new int[]{-2, 1, 3, 4, 5, 7};
        assertArrayEquals(arr, arrsorted);
    }
}
