package cn.codeforfun.test;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class Student {
  private Integer id;
  private String name;
  private Integer score;


}
