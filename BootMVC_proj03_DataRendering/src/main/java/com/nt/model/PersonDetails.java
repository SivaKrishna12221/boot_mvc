package com.nt.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class PersonDetails 
{
  private Integer pid;
  private String name;
  private String address;
  private Long phNumber;
  
}
