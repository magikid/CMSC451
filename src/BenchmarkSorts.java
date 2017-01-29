import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Created by Chris on 1/28/2017.
 * Project project1
 */
class BenchmarkSorts {
  private final ArrayList<Long> list;
  private final MySort sort;
  private final ArrayList<Stats> iterativeStats;
  private final ArrayList<Stats> recursiveStats;

  BenchmarkSorts(ArrayList<Long> list) {
    this.list = list;
    sort = new MySort();
    iterativeStats = new ArrayList<>();
    recursiveStats= new ArrayList<>();
  }

  void runSorts(){
    IntStream.rangeClosed(1,10).forEach((i) -> {
      sort.iterativeSort(list);
      iterativeStats.add(new Stats(sort.getTime(), sort.getCount()));
      sort.recursiveSort(list);
      recursiveStats.add(new Stats(sort.getTime(), sort.getCount()));
    });
  }

  void displayReport(PrintWriter f){
    double iterativeCountAvg = iterativeStats.stream()
        .collect(Collectors.summarizingInt(Stats::getCount)).getAverage();
    double iterativeCountStdDev = stdDeviationCounts(iterativeStats, iterativeCountAvg);
    double iterativeTimeAvg = iterativeStats.stream()
        .collect(Collectors.summarizingLong(Stats::getTime)).getAverage();
    double iterativeTimeStdDev = stdDeviationTimes(iterativeStats, iterativeTimeAvg);
    double recursiveCountAvg = recursiveStats.stream()
        .collect(Collectors.summarizingInt(Stats::getCount)).getAverage();
    double recursiveCountStdDev = stdDeviationCounts(recursiveStats, recursiveCountAvg);
    double recursiveTimeAvg = recursiveStats.stream()
        .collect(Collectors.summarizingLong(Stats::getTime)).getAverage();
    double recursiveTimeStdDev = stdDeviationTimes(recursiveStats, recursiveTimeAvg);

    f.printf("%d,%.1f,%.1f,%.1f,%.1f,%.1f,%.1f,%.1f,%.1f%n", list.size(), recursiveCountAvg,
        recursiveCountStdDev,
        recursiveTimeAvg, recursiveTimeStdDev, iterativeCountAvg, iterativeCountStdDev,
        iterativeTimeAvg, iterativeTimeStdDev);
  }

  private double stdDeviationCounts(ArrayList<Stats> list, double average){
    double sum_of_numerator = list.stream()
        .map(Stats::getCount)
        .map((i) -> Math.pow((i - average), 2))
        .reduce(0.0, Double::sum);
    return Math.sqrt(sum_of_numerator / list.size());
  }

  private double stdDeviationTimes(ArrayList<Stats> list, double average){
    double sum_of_numerator = list.stream()
        .map(Stats::getTime)
        .map((i) -> Math.pow((i - average), 2))
        .reduce(0.0, Double::sum);
    return Math.sqrt(sum_of_numerator / list.size());
  }
}
