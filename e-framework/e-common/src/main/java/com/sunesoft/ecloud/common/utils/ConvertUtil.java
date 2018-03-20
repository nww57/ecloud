package com.sunesoft.ecloud.common.utils;

import com.sunesoft.ecloud.common.result.PagedResult;

import java.util.ArrayList;
import java.util.List;

public class ConvertUtil {
    /**
     * convert from dto
     *
     * @param source
     * @param
     * @return
     */
    public static <S, T> T convert(S source, Class<T> target) {

        T t = null;
        try {
            t = target.newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        BeanUtil.copyPropertiesIgnoreNull(source, t);
        return t;
    }

    public static <S, T> List<T> convert(List<S> source, Class<T> target) {
        List<T> list = new ArrayList<>();
        if (null != source)
            source.stream().forEach(s -> list.add(convert(s, target)));
        return list;
    }

    public static <S, T> PagedResult<T> convert(PagedResult<S> source, Class<T> target) {
        List<T> list = new ArrayList<>();
        if (source.getTotalCount() > 0)
            list = convert(source.getResult(), target);
        return new PagedResult<>(
                list, source.getPageIndex(), source.getPageSize(), source.getTotalCount());
    }
}