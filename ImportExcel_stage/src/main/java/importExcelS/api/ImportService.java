package importExcelS.api;

import importExcelS.entity.Excel_Messages;

import java.util.List;

/*
 *@description:
 *
 *@author 10068921(LgyTT)
 *@date 2018/10/30 15:08
 */
public interface ImportService {
    void OpenFile(String path);
    List<Excel_Messages> getExcels();

}
