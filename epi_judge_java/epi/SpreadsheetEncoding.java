package epi;
import epi.test_framework.EpiTest;
import epi.test_framework.GenericTest;
import java.lang.Math;
public class SpreadsheetEncoding {
  @EpiTest(testDataFile = "spreadsheet_encoding.tsv")

  private static int calcOffset(int n) {
    if (n == 1)
      return 0;
    int sum = 0;
    for (int i = 2; i <= n; i++)
      sum += Math.pow(26, i-1);
    return sum;
  }
  public static int ssDecodeColID(final String col) {
    if (col == null)
      return 0;
    char[] str = col.toCharArray();
    int sum = 1, n = str.length;
    for (int i = 0; i < n; i++) {
      int coeff = str[i] - 'A';
      int multiplier = n - i - 1;
      sum += coeff * Math.pow(26, multiplier);
    }
    return calcOffset(n) + sum;
  }

  public static void main(String[] args) {
    System.exit(
        GenericTest
            .runFromAnnotations(args, "SpreadsheetEncoding.java",
                                new Object() {}.getClass().getEnclosingClass())
            .ordinal());
  }
}
