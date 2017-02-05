import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

/**
 * Created by Chris on 2/5/2017.
 * Project project1
 */
public class MySortTest {
  private Long[] unsorted_list;
  private Long[] sorted_list;
  private MySort sorter;

  @Before
  public void setUp() throws Exception {
    unsorted_list = null;
    sorted_list = null;
    sorter = new MySort();
  }

  @Test
  public void recursiveSort() throws Exception {
    unsorted_list = new Long[]{5L, 4L, 3L, 2L, 1L};
    sorted_list = sorter.recursiveSort(unsorted_list);
    assertArrayEquals(sorted_list, new Long[]{1L, 2L, 3L, 4L, 5L});
  }

  @Test
  public void iterativeSort() throws Exception {
    unsorted_list = new Long[]{5L, 4L, 3L, 2L, 1L};
    sorted_list = sorter.iterativeSort(unsorted_list);
    assertArrayEquals(new Long[]{1L, 2L, 3L, 4L, 5L}, sorted_list);
  }

  @Test
  public void getCount() throws Exception {
    unsorted_list = new Long[]{4L, 3L, 2L, 1L};
    sorter.recursiveSort(unsorted_list);
    assertEquals(sorter.getCount(), 3);
    sorter.iterativeSort(unsorted_list);
    assertEquals(sorter.getCount(), 3);
  }

}