package epi;
import epi.test_framework.EpiTest;
import epi.test_framework.GenericTest;
import java.util.List;
public class AdvanceByOffsets {
  @EpiTest(testDataFile = "advance_by_offsets.tsv")
  public static boolean canReachEnd(List<Integer> maxAdvanceSteps) {
    int maxIndexReached = 0, endIndex = maxAdvanceSteps.size()-1;
    for (int i = 0; i <= maxIndexReached && maxIndexReached < endIndex; i++) {
        maxIndexReached = Math.max(maxIndexReached,i+maxAdvanceSteps.get(i));
    }
    return maxIndexReached >= endIndex;
  }

  public static void main(String[] args) {
    System.exit(
        GenericTest
            .runFromAnnotations(args, "AdvanceByOffsets.java",
                                new Object() {}.getClass().getEnclosingClass())
            .ordinal());
  }
}
