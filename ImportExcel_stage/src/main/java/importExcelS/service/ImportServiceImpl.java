package importExcelS.service;

import importExcelS.api.ImportService;
import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.jupiter.api.Test;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.*;

/*
 *@description:
 *
 *@author 10068921(LgyTT)
 *@date 2018/10/30 15:33
 */
@Service
public class ImportServiceImpl implements ImportService {
    @Override
    public void OpenFile(String path) {
        File file=new File(path);

    }

    @Override
    public Map<Integer,List<Object>> getExcels(File file) throws IOException {
        String fileName=file.getName();
        //获取文件后缀
        String extension=fileName.lastIndexOf(".")==-1?"":fileName.substring(fileName.lastIndexOf(".")+1);
        if(extension.equals("xlsx"))
            return ListExcel(file);
        else throw new IOException("不支持文件类型");

    }

    @Override
    public void CreateTable(List<Object> objects) {

    }

    private Map<Integer,List<Object>> ListExcel(File file)throws IOException {
        Map<Integer ,List<Object>> map= new HashMap<>();

        //构造XSSFWorkbook对象，
        XSSFWorkbook xwb=new XSSFWorkbook(new FileInputStream(file));
        //读取第一张表格内容
        XSSFSheet sheet=xwb.getSheetAt(0);
//        Excel_Messages messages=new Excel_Messages();

        Iterator<Row> iterator=sheet.iterator();
        int i=0;
        while(iterator.hasNext()){
            Row row=iterator.next();
            List<Object> list=new ArrayList<>();
            Iterator<Cell>  cellIterator=row.iterator();
            while (cellIterator.hasNext()){
                Cell cell=cellIterator.next();
              list.add(getData(cell));
            }
            map.put(i,list);
            i++;
        }
        return map;

    }
    private Object getData(Cell cell){
        DecimalFormat df=new DecimalFormat("0");//格式化数字
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-mm-dd HH:mm:ss");//格式化时间字符串
       // DecimalFormat nf=new DecimalFormat("0");//格式化数字
        Object object=null;
        try {
       String t=cell.getStringCellValue();
       return t;
        }catch (Exception e){
            try {
            object=cell.getBooleanCellValue();
            }catch (Exception e1){
                if("@".equals(cell.getCellStyle().getDataFormatString())){
                    object = df.format(cell.getNumericCellValue());
                } else if("General".equals(cell.getCellStyle().getDataFormatString())){
                  //  object = df.format(cell.getNumericCellValue());
                }else
                    object = sdf.format(HSSFDateUtil.getJavaDate(cell.getNumericCellValue()));
            }
        }
        return object;
    }
    private Object lists(){
        List<String> list=new ArrayList<>();
        list.add("djkls");
        return list;
    }
    @Test
    public void TestCloum(){
        File file=new File("E:\\testFile\\testExcel.xlsx");
        List<List<Object>> list=null;
        try {
               // list= new ImportServiceImpl().getExcels(file);

        } catch (Exception e) {
            e.printStackTrace();
        }

        for(List<Object> object:list){
            for(Object link:object){
                System.out.println(link);
            }
        }
    }
}
