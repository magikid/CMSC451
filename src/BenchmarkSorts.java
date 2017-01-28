import java.util.ArrayList;

/**
 * Created by Chris on 1/28/2017.
 * Project project1
 */
class BenchmarkSorts {
  private ArrayList<Integer> list;
  private MySort sort;
  private Stats iterativeStats, recursiveStats;

  BenchmarkSorts(ArrayList<Integer> list) {
    this.list = list;
    this.sort = new MySort();
  }

  void runSorts(){
    sort.iterativeSort(list);
    iterativeStats = new Stats(sort.getTime(), sort.getCount());
    sort.recursiveSort(list);
    recursiveStats = new Stats(sort.getTime(), sort.getCount());
  }

  void displayReport(){

  }
}
