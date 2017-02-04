import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by Chris on 1/28/2017.
 * Project project1
 */
class MySort implements SortInterface {
  private long startTime, endTime;
  private int count;

  @Override
  public Long[] recursiveSort(Long[] list) {
    this.startTime = System.nanoTime();
    count = 0;
    Long[] final_list = new Long[list.length];
    recursiveMergeSort(list, final_list, 0, list.length);
    this.endTime = System.nanoTime();
    return final_list;
  }

  private void recursiveMergeSort(Long[] list, Long[] final_list, int start, int end) {
    if (end - start <= 1) {
      return;
    }
    int half_way = start + (end - start) / 2;
    count++;
    recursiveMergeSort(list, final_list, start, half_way);
    count++;
    recursiveMergeSort(list, final_list, half_way, end);
    merge(list, final_list, start, half_way, end);
  }

  private void merge(Long[] list, Long[] final_list, int start, int half_way, int end){
    if (half_way >= list.length){
      return;
    }

    if (end > list.length){
      end = list.length;
    }

    int j = start, k = half_way;
    for (int i = start; i < end; i++) {
      if (j == half_way){
        final_list[i] = list[k++];
      }else if (k == end){
        final_list[i] = list[j++];
      }else if (list[k] < list[j]){
        final_list[i] = list[k++];
      }else{
        final_list[i] = list[j++];
      }
    }
    System.arraycopy(final_list, start, list, start, end - start);
  }

  @Override
  public Long[] iterativeSort(Long[] list) {
    this.startTime = System.nanoTime();
    count = 0;
    iterativeMergeSort(list);
    this.endTime = System.nanoTime();
    return list;
  }

  private Long[] iterativeMergeSort(Long[] list) {
    for (int array_size = 1; array_size < list.length; array_size += array_size * 2) {
      for (int left_index = 0; left_index < list.length - 1; left_index += array_size * 2) {
        int mid_index = left_index + array_size - 1;
        int right_index = Math.min(left_index + array_size * 2 - 1, list.length - 1);
        Long[] auxiliary = new Long[list.length];
        count++;
        merge(list, auxiliary, left_index, mid_index, right_index);
      }
    }
    
    return list;
  }

  @Override
  public int getCount() {
    return count;
  }

  @Override
  public long getTime() {
    return endTime - startTime;
  }
}
