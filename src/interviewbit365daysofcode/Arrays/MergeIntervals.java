package interviewbit365daysofcode.Arrays;
import java.util.*;


 class Interval {
      int start;
      int end;
      Interval() { start = 0; end = 0; }
      Interval(int s, int e) { start = s; end = e; }
  }

public class MergeIntervals {

    public ArrayList<Interval> insert(ArrayList<Interval> intervals, Interval newInterval) {
        ArrayList<Interval> mergedIntervals = new ArrayList<>();
        int i = 0;
        int n = intervals.size();

        // Add all intervals that come before the newInterval (non-overlapping intervals)
        while (i < n && intervals.get(i).end < newInterval.start) {
            mergedIntervals.add(intervals.get(i));
            i++;
        }

        // Merge overlapping intervals
        while (i < n && intervals.get(i).start <= newInterval.end) {
            newInterval.start = Math.min(newInterval.start, intervals.get(i).start);
            newInterval.end = Math.max(newInterval.end, intervals.get(i).end);
            i++;
        }

        // Add the merged interval
        mergedIntervals.add(newInterval);

        // Add remaining non-overlapping intervals (if any)
        while (i < n) {
            mergedIntervals.add(intervals.get(i));
            i++;
        }

        return mergedIntervals;

    }

    public static void main(String[] args) {
        MergeIntervals mergeIntervals = new MergeIntervals();

        // Create some sample intervals
        ArrayList<Interval> intervals = new ArrayList<>();
        intervals.add(new Interval(1, 3));
        intervals.add(new Interval(6, 9));

        // New interval to insert
        Interval newInterval = new Interval(2, 5);

        // Insert and merge intervals
        ArrayList<Interval> mergedIntervals = mergeIntervals.insert(intervals, newInterval);

        // Print the merged intervals
        System.out.println("Merged Intervals:");
        for (Interval interval : mergedIntervals) {
            System.out.println("[" + interval.start + ", " + interval.end + "]");
        }
    }
}
