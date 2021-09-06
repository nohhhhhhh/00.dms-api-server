package com.dms.core.poi;

import com.dms.api.dto.tag.TagDataHistoryDto;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.CreationHelper;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.streaming.SXSSFCell;
import org.apache.poi.xssf.streaming.SXSSFRow;
import org.apache.poi.xssf.streaming.SXSSFSheet;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class DmsPoiUtils {

  public static String TYPE = "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet";
  // TODO: DYNAMIC
  static String[] COLUMNS = {"SOURCE_TB_SEQ", "TAG_ID", "EVENT_DT", "VAL", "PRODUCT_ID"};
  static String SHEET = "Weight";

  public static ByteArrayInputStream bigDataExport(List<TagDataHistoryDto> tagData)
      throws IOException {
    FileOutputStream fos = null;
    SXSSFWorkbook workbook = null;
    SXSSFRow row = null;
    SXSSFCell cell = null;
    int HeaderCount = 0;
    Long RowCount = 0L;

    ByteArrayOutputStream out = new ByteArrayOutputStream();
    workbook = new SXSSFWorkbook();
    workbook.setCompressTempFiles(true);
    SXSSFSheet sheet = (SXSSFSheet) workbook.createSheet("시트이름");
    sheet.setRandomAccessWindowSize(1000); // 메모리 행 100개로 제한, 초과 시 Disk로 flush

    //셀 칼럼 크기 설정
    sheet.setColumnWidth(2, 300);
    // 행 생성
    row = sheet.createRow(0);
    // 셀 스타일 생성
    CreationHelper ch = workbook.getCreationHelper();
    // 헤더 적용
    for (String head : COLUMNS) {
      cell = row.createCell(HeaderCount++);
      cell.setCellValue(head);
    }

    for (TagDataHistoryDto tagDataDto : tagData) {
      int Rowcount = sheet.getLastRowNum() - sheet.getFirstRowNum() + 1;
      System.out.println(Rowcount);

      if (Rowcount > 1048573) {
        break;
      }
      row = sheet.createRow(Rowcount);

      row.createCell(0).setCellValue(tagDataDto.getSourceTbSeq());
      row.createCell(1).setCellValue(tagDataDto.getTagId());
      row.createCell(2).setCellValue(tagDataDto.getEventDt());
      row.createCell(3).setCellValue(tagDataDto.getVal());
      row.createCell(4).setCellValue(tagDataDto.getProductId());
    }

    workbook.write(out);

    return new ByteArrayInputStream(out.toByteArray());

  }


  public static ByteArrayInputStream customersToExcel(
      List<TagDataHistoryDto> tagData) throws IOException {

    try (Workbook workbook = new XSSFWorkbook(); ByteArrayOutputStream out = new ByteArrayOutputStream();) {
      CreationHelper createHelper = workbook.getCreationHelper();

      Sheet sheet = workbook.createSheet(SHEET);

      Font headerFont = workbook.createFont();
      headerFont.setBold(true);
      headerFont.setColor(IndexedColors.BLUE.getIndex());

      CellStyle headerCellStyle = workbook.createCellStyle();
      headerCellStyle.setFont(headerFont);

      // Row for Header
      Row headerRow = sheet.createRow(0);

      // Header
      for (int col = 0; col < COLUMNS.length; col++) {
        Cell cell = headerRow.createCell(col);
        cell.setCellValue(COLUMNS[col]);
        cell.setCellStyle(headerCellStyle);
      }

      int rowIdx = 1;
      for (TagDataHistoryDto tagDataDto : tagData) {
        Row row = sheet.createRow(rowIdx++);

        row.createCell(0).setCellValue(tagDataDto.getSourceTbSeq());
        row.createCell(1).setCellValue(tagDataDto.getTagId());
        row.createCell(2).setCellValue(tagDataDto.getEventDt());
        row.createCell(3).setCellValue(tagDataDto.getVal());
        row.createCell(4).setCellValue(tagDataDto.getProductId());
      }

      workbook.write(out);
      return new ByteArrayInputStream(out.toByteArray());
    }
  }


}
