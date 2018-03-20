package com.sunesoft.ecloud.common.sqlBuilderTool.annotations;

import java.lang.annotation.*;

@Target({ElementType.FIELD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface AliasName {

    String value();
}
