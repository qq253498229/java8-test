package cn.codeforfun.test;

import lombok.extern.log4j.Log4j;
import org.junit.Test;

import java.io.UnsupportedEncodingException;
import java.util.Base64;
import java.util.UUID;

@Log4j
public class Base64Test {
  @Test
  public void test1() {
    try {

      // 使用基本编码
      String base64encodedString = Base64.getEncoder().encodeToString("测试基本".getBytes("utf-8"));
      log.info("Base64 编码字符串 (基本) :" + base64encodedString);
      // 解码
      byte[] base64decodedBytes = Base64.getDecoder().decode(base64encodedString);
      log.info("原始字符串: " + new String(base64decodedBytes, "utf-8"));


      base64encodedString = Base64.getUrlEncoder().encodeToString("测试URL".getBytes("utf-8"));
      log.info("Base64 编码字符串 (URL) :" + base64encodedString);

      byte[] decode = Base64.getUrlDecoder().decode(base64encodedString);
      log.info("原始字符串: " + new String(decode, "utf-8"));


      StringBuilder stringBuilder = new StringBuilder();
      for (int i = 0; i < 10; ++i) {
        stringBuilder.append(UUID.randomUUID().toString());
      }
      log.info("原始字符串: " + stringBuilder.toString());
      byte[] mimeBytes = stringBuilder.toString().getBytes("utf-8");
      String mimeEncodedString = Base64.getMimeEncoder().encodeToString(mimeBytes);
      log.info("Base64 编码字符串 (MIME) :" + mimeEncodedString);

      byte[] decode1 = Base64.getMimeDecoder().decode(mimeEncodedString);
      log.info("原始字符串: " + new String(decode1, "utf-8"));

    } catch (UnsupportedEncodingException e) {
      log.error("Error :" + e.getMessage());
    }
  }
}
