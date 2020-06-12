package com.cp.dd.common.util;

import lombok.extern.slf4j.Slf4j;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * Excel 工具类
 *
 * @author chengp
 * @date 2020/6/1
 */
@Slf4j
public class ExcelUtil {

    public static final String EXCEL_EXT_XLSX = ".xlsx";
    public static final String EXCEL_EXT_XLS = ".xls";

    /**
     * 导出 Excel
     *
     * @param fileName   文件名
     * @param titles     标题
     * @param fields     字段
     * @param objects    数据集合
     * @param response   http响应
     * @param converters 转换器 {@link Converter}
     * @author zouxq
     */
    public static <T> void exportExcel(String fileName, String[] titles, String[] fields, List<T> objects, HttpServletResponse response, Map<String, Converter> converters) {
        log.info("开始生成Excel文件【{}】", fileName);
        Workbook workbook = createWorkbook(fileName, titles, fields, objects, converters);

        try (ByteArrayOutputStream baOut = new ByteArrayOutputStream();
             OutputStream out = response.getOutputStream()) {

            log.info("开始导出Excel文件【{}】", fileName);

            workbook.write(baOut);
            response.setContentType("application/octet-stream; charset=utf-8");
            response.setHeader("Content-Disposition", "attachment; filename=" + URLEncoder.encode(fileName, "UTF-8"));
            response.setHeader("Content-Length", baOut.size() + "");

            out.write(baOut.toByteArray());
            out.flush();
        } catch (Exception e) {
            log.error("excel导出失败！", e);
        }
    }

    /**
     * 生成工作簿对象
     *
     * @param <T>        数据对象
     * @param fileName   文件名
     * @param titles     标题
     * @param fields     字段
     * @param objects    数据集合
     * @param converters 转换器
     * @return 工作簿对象 {@link Converter}
     * @author zouxq
     */
    public static <T> Workbook createWorkbook(String fileName, String[] titles, String[] fields, List<T> objects, Map<String, Converter> converters) {
        Workbook workbook;
        if (fileName.endsWith(EXCEL_EXT_XLSX)) {
            workbook = new XSSFWorkbook();
        } else {
            workbook = new HSSFWorkbook();
        }
        Sheet sheet = workbook.createSheet();
        // 设置行计数器
        int index = 0;

        // 创建标题样式和内容样式
        CellStyle titleStyle = getTitleStyle(workbook);
        CellStyle cellStyle = getContentStyle(workbook);

        // 设置表格标题行
        Row row = sheet.createRow(index++);
        setRowContent(row, new ArrayList<>(Arrays.asList(titles)), titleStyle);


        Class<?> clazz;
        for (T t : objects) {
            row = sheet.createRow(index++);
            List<Object> contents = new ArrayList<>();
            clazz = t.getClass();
            for (String field : fields) {
                try {
                    Method method = clazz.getMethod(getMethodName(field));
                    Object object = method.invoke(t);
                    //判断字段值是否需要类型转换
                    if (converters != null && converters.containsKey(field)) {
                        //noinspection unchecked
                        contents.add(converters.get(field).convert(object));
                    } else {
                        contents.add(object);
                    }
                } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
                    contents.add("");
                }
            }
            setRowContent(row, contents, cellStyle);
        }
        return workbook;
    }

    /**
     * 设置一行的内容
     *
     * @param row       行
     * @param contents  单元格内容
     * @param cellStyle 单元格样式
     */
    private static void setRowContent(Row row, List<Object> contents, CellStyle cellStyle) {
        for (int i = 0; i < contents.size(); i++) {
            Cell cell = row.createCell(i);
            cell.setCellStyle(cellStyle);
            if (contents.get(i) instanceof Number) {
                Number num = (Number) contents.get(i);
                cell.setCellValue(num.doubleValue());
            } else {
                if(contents.get(i)==null){
                    cell.setCellValue("");
                }else{
                    cell.setCellValue(contents.get(i).toString());
                }
            }
        }
    }

    /**
     * 设置标题样式
     *
     * @param workbook 工作簿
     * @return 标题样式
     */
    private static CellStyle getTitleStyle(Workbook workbook) {
        // 创建标题样式
        CellStyle titleStyle = workbook.createCellStyle();
        // 设置这些样式
        titleStyle.setFillForegroundColor(HSSFColor.HSSFColorPredefined.YELLOW.getIndex());
        titleStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
        titleStyle.setBorderBottom(BorderStyle.THIN);
        titleStyle.setBorderLeft(BorderStyle.THIN);
        titleStyle.setBorderRight(BorderStyle.THIN);
        titleStyle.setBorderTop(BorderStyle.THIN);
        titleStyle.setAlignment(HorizontalAlignment.CENTER);
        // 生成标题字体
        Font font = workbook.createFont();
        font.setFontName("宋体");
        font.setColor(HSSFColor.HSSFColorPredefined.BLACK.getIndex());
        font.setFontHeightInPoints((short) 14);
        titleStyle.setFont(font);

        return titleStyle;
    }

    /**
     * 设置内容样式
     *
     * @param workbook 工作簿
     * @return 内容样式
     */
    private static CellStyle getContentStyle(Workbook workbook) {
        // 创建单元格样式
        CellStyle cellStyle = workbook.createCellStyle();
        // 指定单元格居中对齐
        cellStyle.setAlignment(HorizontalAlignment.LEFT);
        // 指定单元格垂直居中对齐
        cellStyle.setVerticalAlignment(VerticalAlignment.CENTER);
        // 指定当单元格内容显示不下时自动换行
        cellStyle.setWrapText(true);
        // 设置单元格字体
        Font font = workbook.createFont();
        font.setFontName("宋体");
        font.setColor(HSSFColor.HSSFColorPredefined.BLACK.getIndex());
        font.setFontHeightInPoints((short) 12);
        cellStyle.setFont(font);

        return cellStyle;
    }

    /**
     * 获取方法名
     *
     * @param field 字段名
     * @return get方法名
     */
    private static String getMethodName(String field) {
        StringBuilder sb = new StringBuilder(field);
        sb.setCharAt(0, Character.toUpperCase(sb.charAt(0)));
        sb.insert(0, "get");
        return sb.toString();
    }

    /**
     * 转换器
     *
     * @author zouxq
     */
    public interface Converter<T> {
        /**
         * 把各类型的值转换为String
         *
         * @param t 转换对象
         * @return 字符串
         */
        String convert(T t);
    }

    /**
     * 从上传文件中获取工作簿
     *
     * @param file 上传文件
     * @return 工作簿
     */
    public static Workbook getWorkbookFromFile(MultipartFile file) {
        // 获取 Excel 工作簿
        Workbook workbook;
        String fileName = file.getOriginalFilename();
        try {
            if (fileName.endsWith(EXCEL_EXT_XLS)) {
                workbook = new HSSFWorkbook(file.getInputStream());
            } else if (fileName.endsWith(EXCEL_EXT_XLSX)) {
                workbook = new XSSFWorkbook(file.getInputStream());
            } else {
                throw new RuntimeException("文件格式错误");
            }
        } catch (IOException e) {
            throw new RuntimeException("文件读取失败");
        }
        return workbook;
    }
}
