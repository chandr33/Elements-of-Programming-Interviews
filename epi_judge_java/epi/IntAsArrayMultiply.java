package epi;
import epi.test_framework.EpiTest;
import epi.test_framework.GenericTest;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
public class IntAsArrayMultiply {
  @EpiTest(testDataFile = "int_as_array_multiply.tsv")
  public static List<Integer> multiply(List<Integer> num1, List<Integer> num2) {
    List<Integer> result = new ArrayList<>(Collections.nCopies(num1.size()+num2.size(), 0));
    int sign = (num1.get(0) ^ num2.get(0)) >= 0 ? 1 : -1;
    int i = num1.size()-1, j = num2.size()-1;
    num1.set(0, Math.abs(num1.get(0)));
    num2.set(0, Math.abs(num2.get(0)));
    int sum, carry = 0;
    while (j >= 0) {
      while (i >= 0) {
        int prod_sum = (num1.get(i) * num2.get(j)) + carry + result.get(i + j + 1);
        sum = prod_sum % 10;
        carry = prod_sum / 10;
        result.set(i + j + 1, sum);
        i--;
      }
      if (carry > 0)
        result.set(i+j+1,carry);
      carry = 0;
      i = num1.size()-1;
      j--;
    }
    int zero_index = 0;
    while (result.get(zero_index) == 0 && zero_index < result.size()-1)
      zero_index++;
    result = result.subList(zero_index,result.size());
    result.set(0, result.get(0)*sign);
    return result;
  }

  public static void main(String[] args) {
    System.exit(
        GenericTest
            .runFromAnnotations(args, "IntAsArrayMultiply.java",
                                new Object() {}.getClass().getEnclosingClass())
            .ordinal());
  }
}
