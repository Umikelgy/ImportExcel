package importExcelS.api;

import importExcelS.entity.Excel_Messages;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;

/*
 *@description:
 *
 *@author 10068921(LgyTT)
 *@date 2018/10/30 15:08
 */
public interface ImportService {
    void OpenFile(String path);
    Map<Integer,List<Object>> getExcels(File file)throws IOException;
    void CreateTable(List<Object> objects);

}
