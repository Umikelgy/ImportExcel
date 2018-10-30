package importExcelS.entity;

import lombok.Data;

/*
 *@description:
 *
 *@author 10068921(LgyTT)
 *@date 2018/10/30 15:14
 */
@Data
public class Excel_Messages {
    private long id;//序号
    private String stageName;//厂站名
    private String branch_lineName;//分支线路名
    private String workDetails;//工作内容
    private String taskSource;//任务来源
    private String planProperty;//计划性质
}
