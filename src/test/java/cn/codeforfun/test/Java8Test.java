package cn.codeforfun.test;

import lombok.extern.log4j.Log4j;
import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

@Log4j
public class Java8Test {
  private List<Student> students = Arrays.asList(
          new Student(1, "张三", 97),
          new Student(2, "李四", 78),
          new Student(3, "王五", 87),
          new Student(4, "赵六", 78),
          new Student(5, "田七", 92)
  );

  @Test
  public void testSort() {
    //分数从大到小排序
    students.sort((a, b) -> -a.getScore().compareTo(b.getScore()));
    students.forEach(log::info);

    log.info("----------------");
    //分数从小到大排序
    students.sort(Comparator.comparing(Student::getScore));
    students.forEach(log::info);


    log.info("----------------");
    //先按分数从小到大排序，再按id从小到大排序
    students.stream()
            .sorted(Comparator
                    .comparing(Student::getScore)
                    .thenComparing(Student::getId)
            )
            .forEach(log::info);

  }

  @Test
  public void testStream() {
    students.stream()
            //过滤分数为78的数据
            .filter(a -> a.getScore() == 78)
            //按id排序
            .sorted(Comparator.comparing(Student::getId))
            //输出结果
            .forEach(log::info);
  }
}
