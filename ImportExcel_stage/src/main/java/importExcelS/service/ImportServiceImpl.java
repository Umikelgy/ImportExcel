package importExcelS.service;

import importExcelS.api.ImportService;
import importExcelS.entity.Excel_Messages;

import java.io.File;
import java.util.List;

/*
 *@description:
 *
 *@author 10068921(LgyTT)
 *@date 2018/10/30 15:33
 */
public class ImportServiceImpl implements ImportService {
    @Override
    public void OpenFile(String path) {
        File file=new File(path);

    }

    @Override
    public List<Excel_Messages> getExcels() {
        return null;
    }
}
