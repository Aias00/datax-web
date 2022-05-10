package com.wugui.datax.admin.http.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class HbaseReaderDto implements Serializable {

  private String readerMaxVersion;

  private String readerMode;

  private Range readerRange;

}

