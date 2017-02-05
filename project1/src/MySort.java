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
    recursiveMergeSort(list, final_list, start, half_way);
    recursiveMergeSort(list, final_list, half_way, end);
    merge(list, final_list, start, half_way, end);
  }

  private void merge(Long[] list, Long[] final_list, int start, int half_way, int end){
    count++;
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

  @SuppressWarnings("UnusedReturnValue")
  private Long[] iterativeMergeSort(Long[] list) {
    Long[] auxiliary = new Long[list.length];
    for (int array_size = 1; array_size <= list.length / 2 + 2; array_size *= 2) {
      for (int mid_index = array_size; mid_index < list.length; mid_index += array_size * 2) {
        merge(list, auxiliary, mid_index - array_size, mid_index, Math.min(mid_index +
            array_size, list.length));
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
