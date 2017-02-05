import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;
import java.util.stream.IntStream;

/**
 * Created by Chris on 1/28/2017.
 * Project project1
 */
class SortMain {
  public static void main(String[] args) throws IOException {
    System.out.println("Beginning sorting comparison");
    PrintWriter f = new PrintWriter("output.csv");
    f.println("n,Recursive Count Avg,Recursive Count StdDev,Recursive Time Avg,Recursive Time "
        + "StdDev,Iterative Count Avg,Iterative Count StdDev,Iterative Time Avg,Iterative Time StdDev,");
    IntStream.rangeClosed(1, 5)
        .map(i -> (int) Math.pow(10,i))
        .forEach((i) -> {
          System.out.println("Starting batch of " + i);
          BenchmarkSorts bs = new BenchmarkSorts(generateList(i));
          bs.runSorts();
          bs.displayReport(f);
          f.flush();
        });
    f.close();
    System.out.println("Finished.  See output.csv for data.");
  }

  private static Long[] generateList(long numberElements){
    Random r = new Random();
    return r.longs(0,101)
        .limit(numberElements)
        .boxed()
        .toArray(Long[]::new);
  }
}
