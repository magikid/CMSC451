/**
 * Created by Chris on 1/28/2017.
 * Project project1
 */
class Stats {
  private long time;
  private int count;

  Stats(long time, int count) {
    this.time = time;
    this.count = count;
  }

  public long getTime() {
    return time;
  }

  public int getCount() {
    return count;
  }
}
