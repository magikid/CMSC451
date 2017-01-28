import java.util.ArrayList;

/**
 * Created by Chris on 1/28/2017.
 * Project project1
 */
public class SortMain {
  public static void main(String[] args) {
    ArrayList<Integer> al = new ArrayList<>(10);
    BenchmarkSorts bs = new BenchmarkSorts(al);
    bs.runSorts();
    bs.displayReport();
  }
}
