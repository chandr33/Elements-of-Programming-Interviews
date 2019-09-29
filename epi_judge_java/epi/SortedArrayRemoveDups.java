package epi;
import epi.test_framework.EpiTest;
import epi.test_framework.GenericTest;
import epi.test_framework.TimedExecutor;
import java.util.List;
public class SortedArrayRemoveDups {
  // Returns the number of valid entries after deletion.
  public static int deleteDuplicates(List<Integer> A) {
    int lastDuplicateIndex = 0;
    int curr_index = 1;
    while (curr_index < A.size()) {
      if (!A.get(curr_index).equals(A.get(lastDuplicateIndex))) {
        A.set(lastDuplicateIndex+1,A.get(curr_index));
        lastDuplicateIndex++;
      }
      curr_index++;
    }
    return Math.min(lastDuplicateIndex + 1, A.size());
  }
  @EpiTest(testDataFile = "sorted_array_remove_dups.tsv")
  public static List<Integer> deleteDuplicatesWrapper(TimedExecutor executor,
                                                      List<Integer> A)
      throws Exception {
    int end = executor.run(() -> deleteDuplicates(A));
    return A.subList(0, end);
  }

  public static void main(String[] args) {
    System.exit(
        GenericTest
            .runFromAnnotations(args, "SortedArrayRemoveDups.java",
                                new Object() {}.getClass().getEnclosingClass())
            .ordinal());
  }
}
