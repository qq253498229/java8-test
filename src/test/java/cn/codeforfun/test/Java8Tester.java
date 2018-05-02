package cn.codeforfun.test;

import lombok.extern.log4j.Log4j;
import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @apiNote http://www.runoob.com/java/java8-streams.html
 */
@Log4j
public class Java8Tester {
  @Test
  public void test() {
    log.info("使用 Java 7: ");

    // 计算空字符串
    List<String> strings = Arrays.asList("abc", "", "bc", "efg", "abcd", "", "jkl");
    log.info("列表: " + strings);
    long count = getCountEmptyStringUsingJava7(strings);

    log.info("空字符数量为: " + count);
    count = getCountLength3UsingJava7(strings);

    log.info("字符串长度为 3 的数量为: " + count);

    // 删除空字符串
    List<String> filtered = deleteEmptyStringsUsingJava7(strings);
    log.info("筛选后的列表: " + filtered);

    // 删除空字符串，并使用逗号把它们合并起来
    String mergedString = getMergedStringUsingJava7(strings, ", ");
    log.info("合并字符串: " + mergedString);
    List<Integer> numbers = Arrays.asList(3, 2, 2, 3, 7, 3, 5);

    // 获取列表元素平方数
    List<Integer> squaresList = getSquares(numbers);
    log.info("平方数列表: " + squaresList);
    List<Integer> integers = Arrays.asList(1, 2, 13, 4, 15, 6, 17, 8, 19);

    log.info("列表: " + integers);
    log.info("列表中最大的数 : " + getMax(integers));
    log.info("列表中最小的数 : " + getMin(integers));
    log.info("所有数之和 : " + getSum(integers));
    log.info("平均数 : " + getAverage(integers));
    log.info("随机数: ");

    // 输出10个随机数
    Random random = new Random();

    for (int i = 0; i < 10; i++) {
      log.info(random.nextInt());
    }

    log.info("使用 Java 8: ");
    log.info("列表: " + strings);

    count = strings.stream().filter(String::isEmpty).count();
    log.info("空字符串数量为: " + count);

    count = strings.stream().filter(string -> string.length() == 3).count();
    log.info("字符串长度为 3 的数量为: " + count);

    filtered = strings.stream().filter(string -> !string.isEmpty()).collect(Collectors.toList());
    log.info("筛选后的列表: " + filtered);

    mergedString = strings.stream().filter(string -> !string.isEmpty()).collect(Collectors.joining(", "));
    log.info("合并字符串: " + mergedString);

    squaresList = numbers.stream().map(i -> i * i).distinct().collect(Collectors.toList());
    log.info("Squares List: " + squaresList);
    log.info("列表: " + integers);

    IntSummaryStatistics stats = integers.stream().mapToInt((x) -> x).summaryStatistics();

    log.info("列表中最大的数 : " + stats.getMax());
    log.info("列表中最小的数 : " + stats.getMin());
    log.info("所有数之和 : " + stats.getSum());
    log.info("平均数 : " + stats.getAverage());
    log.info("随机数: ");

    random.ints().limit(10).sorted().forEach(System.out::println);

    // 并行处理
    count = strings.parallelStream().filter(String::isEmpty).count();
    log.info("空字符串的数量为: " + count);
  }

  private static int getCountEmptyStringUsingJava7(List<String> strings) {
    int count = 0;

    for (String string : strings) {

      if (string.isEmpty()) {
        count++;
      }
    }
    return count;
  }

  private static int getCountLength3UsingJava7(List<String> strings) {
    int count = 0;

    for (String string : strings) {

      if (string.length() == 3) {
        count++;
      }
    }
    return count;
  }

  private static List<String> deleteEmptyStringsUsingJava7(List<String> strings) {
    List<String> filteredList = new ArrayList<>();

    for (String string : strings) {

      if (!string.isEmpty()) {
        filteredList.add(string);
      }
    }
    return filteredList;
  }

  private static String getMergedStringUsingJava7(List<String> strings, String separator) {
    StringBuilder stringBuilder = new StringBuilder();

    for (String string : strings) {

      if (!string.isEmpty()) {
        stringBuilder.append(string);
        stringBuilder.append(separator);
      }
    }
    String mergedString = stringBuilder.toString();
    return mergedString.substring(0, mergedString.length() - 2);
  }

  private static List<Integer> getSquares(List<Integer> numbers) {
    List<Integer> squaresList = new ArrayList<>();

    for (Integer number : numbers) {
      Integer square = number * number;

      if (!squaresList.contains(square)) {
        squaresList.add(square);
      }
    }
    return squaresList;
  }

  private static int getMax(List<Integer> numbers) {
    int max = numbers.get(0);

    for (int i = 1; i < numbers.size(); i++) {

      Integer number = numbers.get(i);

      if (number > max) {
        max = number;
      }
    }
    return max;
  }

  private static int getMin(List<Integer> numbers) {
    int min = numbers.get(0);

    for (int i = 1; i < numbers.size(); i++) {
      Integer number = numbers.get(i);

      if (number < min) {
        min = number;
      }
    }
    return min;
  }

  private static int getSum(List numbers) {
    int sum = (int) (numbers.get(0));

    for (int i = 1; i < numbers.size(); i++) {
      sum += (int) numbers.get(i);
    }
    return sum;
  }

  private static int getAverage(List<Integer> numbers) {
    return getSum(numbers) / numbers.size();
  }
}
