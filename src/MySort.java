import java.util.ArrayList;

/**
 * Created by Chris on 1/28/2017.
 * Project project1
 */
class MySort implements SortInterface {
  private long startTime, endTime;
  private int count;

  @Override
  public ArrayList<Integer> recursiveSort(ArrayList<Integer> list) {
    return null;
  }

  @Override
  public ArrayList<Integer> iterativeSort(ArrayList<Integer> list) {
    return null;
  }

  @Override
  public int getCount() {
    return count;
  }

  @Override
  public long getTime() {
    return endTime - startTime;
  }

  public void resetTime(){
    startTime = 0;
    endTime = 0;
  }

  public void resetCount(){
    count = 0;
  }
}
