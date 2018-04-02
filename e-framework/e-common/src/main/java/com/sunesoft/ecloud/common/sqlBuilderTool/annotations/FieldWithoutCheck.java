package com.sunesoft.ecloud.common.sqlBuilderTool.annotations;

import java.lang.annotation.*;

/**
 * @author: jiangzhenjing
 * @date: 2018/3/29 下午5:56
 * -
 */

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface FieldWithoutCheck {
}
