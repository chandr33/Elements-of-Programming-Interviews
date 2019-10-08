package epi;
import epi.test_framework.EpiTest;
import epi.test_framework.GenericTest;

import java.util.ArrayList;
import java.util.List;
public class IntAsArrayIncrement {
  @EpiTest(testDataFile = "int_as_array_increment.tsv")
  public static List<Integer> plusOne(List<Integer> A) {
    List<Integer> result = new ArrayList<>();
    int sum, carry;
    sum = A.get(A.size()-1)+1;
    carry = sum / 10;
    result.add(0,sum % 10);
    for (int i = A.size()-2; i >= 0; i--) {
      sum = carry + A.get(i);
      carry = sum / 10;
      result.add(0, sum % 10);
    }
    if (carry > 0)
      result.add(0, carry);
    return result;
  }

  public static void main(String[] args) {
    System.exit(
        GenericTest
            .runFromAnnotations(args, "IntAsArrayIncrement.java",
                                new Object() {}.getClass().getEnclosingClass())
            .ordinal());
  }
}
