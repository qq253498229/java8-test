package cn.codeforfun.test;

import lombok.extern.log4j.Log4j;
import org.junit.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;

@Log4j
public class DateTest {

  @Test
  public void test1() {
    LocalDateTime currentTime = LocalDateTime.now();
    log.info("当前时间: " + currentTime);

    LocalDate localDate = currentTime.toLocalDate();
    log.info(localDate);
    Month month = currentTime.getMonth();
    int day = currentTime.getDayOfMonth();
    int seconds = currentTime.getSecond();

    log.info("月: " + month + ", 日: " + day + ", 秒: " + seconds);

    LocalDateTime date2 = currentTime.withDayOfMonth(10).withYear(2012);
    log.info("date2: " + date2);

    // 12 december 2014
    LocalDate date3 = LocalDate.of(2014, Month.DECEMBER, 12);
    log.info("date3: " + date3);

    // 22 小时 15 分钟
    LocalTime date4 = LocalTime.of(22, 15);
    log.info("date4: " + date4);

    // 解析字符串
    LocalTime date5 = LocalTime.parse("20:15:30");
    log.info("date5: " + date5);

    LocalDateTime parse = LocalDateTime.parse("2018-05-02T16:51:41");
    log.info("parse:" + parse);
  }
}
