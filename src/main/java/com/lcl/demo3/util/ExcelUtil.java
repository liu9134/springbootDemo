package com.lcl.demo3.util;

import com.lcl.demo3.model.ExcelData;
import jdk.nashorn.tools.Shell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.util.CellUtil;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import javax.swing.filechooser.FileSystemView;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author liuchonglong
 * @version V1.0
 * @Description: TODO
 * @date 2018/10/18 16:00
 */
public class ExcelUtil {

    /**
     * 导出excel文件
     * @param data
     * @throws IOException
     */
    public static void exportExcel(ExcelData data) throws IOException {
        XSSFWorkbook workbook = new XSSFWorkbook();
        // 获取第一个表单
        XSSFSheet first = workbook.createSheet();
        Integer rowSize = data.getRows().size() + 1;//总excel行数等于数据长度加标题长度
        for (int i = 0; i < rowSize; i++) {
            Row row = first.createRow(i);
            for (int j = 0; j < data.getTitles().size(); j++) {
                if (i == 0) {
                    // 首行
                    row.createCell(j).setCellValue(data.getTitles().get(j));
                } else {
                    // 数据
                    CellUtil.createCell(row, j, data.getRows().get(i-1).get(j));
                }
            }
        }
        // 写入文件
        FileOutputStream out = new FileOutputStream(data.getName());
        workbook.write(out);
        out.close();
    }

    /**
     *  导入excel文件
     * @param filePath  文件路径
     * @return
     * @throws IOException
     */
    public static ExcelData importExcel(String filePath) throws IOException{
        ExcelData data = new ExcelData();
        List<String> title = new ArrayList<>();
        List<List<String>> rows =  new ArrayList<>();
        File file = new File(filePath);
        FileInputStream fileInputStream = new FileInputStream(file);
        XSSFWorkbook workbook = new XSSFWorkbook(fileInputStream);
        XSSFSheet shell = workbook.getSheetAt(0);
        for (int i=0;i<=shell.getLastRowNum();i++){
            Row row = shell.getRow(i);
            List<String> item = new ArrayList<>();
            for (int j=0;j<row.getLastCellNum();j++) {
                if(i==0){
                    title.add(row.getCell(j).toString());
                }else{
                    item.add(row.getCell(j).toString());
                }
            }
            if(i!=0){
                rows.add(item);
            }
        }
        data.setName(file.getName());
        data.setRows(rows);
        data.setTitles(title);
        return data;
    }

    /**
     * 创建桌面文件目录
     * @return
     */
    public static String getFilePath(){
        File desktopDir = FileSystemView.getFileSystemView().getHomeDirectory();
        String desktopPath = desktopDir.getAbsolutePath();
        long filename = new Date().getTime();
        desktopPath = desktopPath + File.separator + filename + ".xlsx";
        return desktopPath;
    }

    public static void main(String[] args) {
        try {
            String pathName = getFilePath();
            ExcelData data = new ExcelData();
            List<String> title = new ArrayList<>();
            title.add("姓名");
            title.add("性别");
            title.add("年龄");

            List<List<String>> rows = new ArrayList<>();
            List<String> row1 = new ArrayList<>();
            row1.add("张三");
            row1.add("男");
            row1.add("18");

            List<String> row2 = new ArrayList<>();
            row2.add("李四");
            row2.add("男");
            row2.add("17");

            List<String> row3 = new ArrayList<>();
            row3.add("王五");
            row3.add("男");
            row3.add("16");

            rows.add(row1);
            rows.add(row2);
            rows.add(row3);
            data.setTitles(title);
            data.setRows(rows);
            data.setName(pathName);
            ExcelUtil.exportExcel(data);

            ExcelData readData = ExcelUtil.importExcel(pathName);
            System.out.println(readData.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
