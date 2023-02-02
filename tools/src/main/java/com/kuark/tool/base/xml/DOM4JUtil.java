package com.kuark.tool.base.xml;

import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
/**
 * Created by cc on 2016/5/9.
 * TODO 使用dom4j包处理xml文件
 * 创建document、添加节点、属性及注释
 */
public class DOM4JUtil {
    /**
     * 创建document
     * @return
     */
    public static Document createDomFJ(){
        Document doc =DocumentHelper.createDocument();
        return doc;
    }

    /**
     * 给文档添加根节点
     * @param elName 子节点名称
     * @param doc   文档
     * @return
     */
    public static Element appendChile(String elName,Document doc){
        Element root=doc.addElement(elName);
        return root;
    }
    /**
     * 给父节点添加子节点
     * @param elName 子节点的名称
     * @param el  父节点
     * @return
     */
    public static Element appendChile(String elName,Element el){
        Element sub=el.addElement(elName);
        return sub;
    }
    /**
     * 添加子节点及其对应的值
     * @param elName 子节点的名称
     * @param value   子节点的值
     * @param el     父节点
     */
    public static void appendChile(String elName,String value,Element el){
        Element sub=el.addElement(elName);
        sub.setText(value);
    }
    /**
     * 根目录添加注释
     * @param explain  说明文字
     * @param doc
     */
    public static void addCommend(String explain,Document doc){
        doc.addComment(explain);
    }
    /**
     * 为子节点添加说明
     * @param explain
     * @param element
     */
    public static void addCommend(String explain,Element element){
        element.addComment(explain);
    }
    /**
     * 为节点添加属性
     * @param attName 属性名
     * @param attValue 属性值
     * @param element
     */
    public static void addAttribute(String attName,String attValue,Element element){
        element.addAttribute(attName, attValue);
    }
}
