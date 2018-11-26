package generatorXml.orders;

import javax.xml.bind.annotation.*;

/*
 *@description:
 *
 *@author 10068921(LgyTT)
 *@date 2018/11/15 9:22
 */
@XmlType( propOrder={"id","targetRuntime","plugin","commentGenerator","jdbcConnection","javaTypeResolver","javaModelGenerator","SqlMapGenerator","javaClientGenerator","table"})
@XmlAccessorOrder(XmlAccessOrder.ALPHABETICAL)
@XmlAccessorType(XmlAccessType.NONE)
@XmlRootElement
public class Context {
    @XmlAttribute
    private String id;
    @XmlAttribute String targetRuntime;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTargetRuntime() {
        return targetRuntime;
    }

    public void setTargetRuntime(String targetRuntime) {
        this.targetRuntime = targetRuntime;
    }
}
