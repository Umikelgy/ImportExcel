package generatorXml;

import generatorXml.orders.Context;

import javax.xml.bind.annotation.*;

/*
 *@description:
 *
 *@author 10068921(LgyTT)
 *@date 2018/11/15 9:06
 */
@XmlType(propOrder = {"properties","context"})
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@XmlAccessorOrder(XmlAccessOrder.ALPHABETICAL)
public class GeneratorConfig {
    @XmlElement
    private String properties;
    @XmlElement
    private Context context;
}
