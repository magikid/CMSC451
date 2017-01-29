import java.util.concurrent.TimeUnit;

/**
 * Created by Chris on 1/28/2017.
 * Project project1
 */
class Stats {
  private final long time;
  private final int count;

  Stats(long time, int count) {
    this.time = TimeUnit.MILLISECONDS.convert(time, TimeUnit.NANOSECONDS);
    this.count = count;
  }

  long getTime() {
    return time;
  }

  int getCount() {
    return count;
  }

  @Override
  public String toString() {
    return "time " + time + " " +
           "count " + count + "\n";
  }
}
