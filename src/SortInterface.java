import java.util.ArrayList;

/**
 * Created by Chris on 1/28/2017.
 * Project project1
 */
interface SortInterface {
  ArrayList<Integer> recursiveSort(ArrayList<Integer> list);
  ArrayList<Integer> iterativeSort(ArrayList<Integer> list);
  int getCount();
  long getTime();
}
