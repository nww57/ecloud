package com.sunesoft.ecloud.admin.demon;

import com.sunesoft.ecloud.admin.demon.EUser;
import com.sunesoft.ecloud.admin.demon.eUserTemp;
import com.sunesoft.ecloud.common.sqlBuilderTool.SqlBuilder;
import com.sunesoft.ecloud.hibernate.sqlBuilder.HSqlBuilder;
import com.sunesoft.ecloud.hibernate.sqlExcute.GenericQuery;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;

/**
 * @author: Zhouzh
 * @Date: 2018/3/22
 */
@Repository
@SuppressWarnings("ALL")
public class DemoQuery extends GenericQuery {

    public void m() {
        List<eUserTemp> query = this.queryList("select * from e_user ", new HashMap<>(), eUserTemp.class);
//       List<Map<String,Object>>  map =jdbcTemplate.queryForList()
        System.out.println(query.size());
    }

    public void m2() {

        SqlBuilder builder = new HSqlBuilder();
        builder.from(EUser.class,"u").select(eUserTemp.class);


        List<eUserTemp> query = this.queryList(builder);
//       List<Map<String,Object>>  map =jdbcTemplate.queryForList()
        System.out.println(query.size());
    }



    public void page() {
        Pageable pageable = new PageRequest(1,10);
//        Page<eUserTemp> query = this.queryPaged(pageable,"select * from e_user", new HashMap<>(), eUserTemp.class);
//       List<Map<String,Object>>  map =jdbcTemplate.queryForList()
        System.out.println("");
    }


}
