package cn.codeforfun.test;

import lombok.extern.log4j.Log4j;
import org.junit.Test;

import java.util.Optional;

@Log4j
public class OptionalTest {
  private Integer a = null;
  private Integer b = 10;

  @Test(expected = NullPointerException.class)
  public void test1() {
    //a为null会报NullPointerException异常
    log.info(a + b);
  }

  @Test
  public void test2() {
    //指定如果a是null时转化为0
    Integer integer = Optional.ofNullable(this.a).orElse(0);
    log.info(integer + b);
  }
}
