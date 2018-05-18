package com.sunesoft.ecloud.caseclient.dto.xml.converter;

import com.thoughtworks.xstream.converters.Converter;
import com.thoughtworks.xstream.converters.MarshallingContext;
import com.thoughtworks.xstream.converters.UnmarshallingContext;
import com.thoughtworks.xstream.io.HierarchicalStreamReader;
import com.thoughtworks.xstream.io.HierarchicalStreamWriter;

import java.lang.annotation.Annotation;

/**
 * @auther: niww
 * @date: 2018/5/16/016
 * 转化成XML时添加“附加”节点
 */
public class AdditionalConverter implements Converter {


    @Override
    public boolean canConvert(Class aClass) {
        return aClass.equals(Boolean.TYPE)|| aClass.equals(Boolean.class);
    }


    @Override
    public void marshal(Object object, HierarchicalStreamWriter writer, MarshallingContext context) {
        Boolean b = (Boolean) object;
        Annotation[] a = object.getClass().getAnnotations();
        writer.startNode("附加");
        String value = "";
        if(b){
            value = "1";
        }else{
            value = "0";
        }
        writer.setValue(value);
        writer.endNode();
    }

    @Override
    public Object unmarshal(HierarchicalStreamReader hierarchicalStreamReader, UnmarshallingContext unmarshallingContext) {
        return null;
    }
}
