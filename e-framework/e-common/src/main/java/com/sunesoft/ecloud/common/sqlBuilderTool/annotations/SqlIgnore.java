package com.sunesoft.ecloud.common.sqlBuilderTool.annotations;

import java.lang.annotation.*;

@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface SqlIgnore {
}
