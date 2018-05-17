package com.sunesoft.ecloud.caseclient.dto.xml.examine.converter;

import com.sunesoft.ecloud.caseclient.dto.xml.examine.SubstantiveReviewRequestContentInfo;
import com.sunesoft.ecloud.caseclient.dto.xml.examine.SubstantiveReviewRequestRemarksInfo;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.converters.Converter;
import com.thoughtworks.xstream.converters.MarshallingContext;
import com.thoughtworks.xstream.converters.UnmarshallingContext;
import com.thoughtworks.xstream.io.HierarchicalStreamReader;
import com.thoughtworks.xstream.io.HierarchicalStreamWriter;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;

/**
 * @auther: niww
 * @date: 2018/5/16/016
 * 转化成XML时添加“附加”节点
 */
public class AdditionalConverter implements Converter {
    @Override
    public void marshal(Object o, HierarchicalStreamWriter hierarchicalStreamWriter, MarshallingContext marshallingContext) {
        try {
            Field[] fields = o.getClass().getDeclaredFields();
            for (Field field : fields) {
                field.setAccessible(true);
                String fieldName = field.getName();
                Annotation annotation = field.getAnnotation(XStreamAlias.class);
                if (null != annotation) {
                    String value = ((XStreamAlias) annotation).value();
                    hierarchicalStreamWriter.startNode(value);
                } else {
                    hierarchicalStreamWriter.startNode(fieldName);
                }
                hierarchicalStreamWriter.startNode("附加");
                hierarchicalStreamWriter.setValue(field.get(o).toString());
                hierarchicalStreamWriter.endNode();
                hierarchicalStreamWriter.endNode();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public Object unmarshal(HierarchicalStreamReader hierarchicalStreamReader, UnmarshallingContext unmarshallingContext) {
        return null;
    }

    @Override
    public boolean canConvert(Class aClass) {
        return aClass.equals(SubstantiveReviewRequestRemarksInfo.class) || aClass.equals(SubstantiveReviewRequestContentInfo.class) ;
    }
}
