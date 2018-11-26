package importExcelS.controller;

import importExcelS.api.ImportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;


/*
 *@description:
 *
 *@author 10068921(LgyTT)
 *@date 2018/10/31 11:24
 */
@Controller
public class ImportController {
    @Autowired
    private ImportService service;
    @ResponseBody
    @RequestMapping(value = "/tests")
    public List<String> Test() throws IOException {
        File file=new File("E:\\testFile\\testExcel.xlsx");
        //String msg=null;
        List<String> list=new ArrayList<>();
        Map<Integer ,List<Object>> maps=service.getExcels(file);
        for(int i=0;i<maps.size();i++){
            if(i==0){
                for(Object o:maps.get(i))
                list.add(o.toString());
            }
          for(Object object:maps.get(i))
              System.out.print(object+"  ");
        }
        System.out.println("list="+list);
        return list;
    }
    @RequestMapping(value = "/tet")
    public String tet(){
        ModelAndView mv=new ModelAndView();
        mv.addObject("time",new Date());
        mv.addObject("message");
        return "pathTest";
    }
}
