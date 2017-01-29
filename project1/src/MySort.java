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
  public List<Long> recursiveSort(List<Long> list) {
    this.startTime = System.nanoTime();
    List<Long> final_list = mergeSort(list);
    this.endTime = System.nanoTime();
    return final_list;
  }

  private List<Long> mergeSort(List<Long> list){
    count++;
    if(list.size() <= 1){
      return list;
    } else {
      int start = 0;
      int end = list.size() - 1;
      int half_way = (int) Math.floor((end - start) / 2);
      List<Long> left_side = mergeSort(list.subList(start, half_way));
      List<Long> right_size = mergeSort(list.subList(half_way + 1, end));
      return merge(left_side.iterator(), right_size.iterator());
    }
  }

  private List<Long> merge(Iterator<Long> leftList, Iterator<Long> rightList){
    List<Long> final_list = new ArrayList<>();
    while (leftList.hasNext() && rightList.hasNext()){
      long first_left = leftList.next();
      long first_right = rightList.next();
      if (first_left > first_right){
        final_list.add(first_right);
      } else {
        final_list.add(first_left);
      }
    }

    while(leftList.hasNext()){
      final_list.add(leftList.next());
    }

    while(rightList.hasNext()){
      final_list.add(rightList.next());
    }

    return final_list;
  }

  @Override
  public List<Long> iterativeSort(List<Long> list) {
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
