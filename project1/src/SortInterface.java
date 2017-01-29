import java.util.List;

/**
 * Created by Chris on 1/28/2017.
 * Project project1
 */
interface SortInterface {
  List<Long> recursiveSort(List<Long> list);
  List<Long> iterativeSort(List<Long> list);
  int getCount();
  long getTime();
}
