package com.sunesoft.ecloud.admin.query.impl;

import com.sunesoft.ecloud.admin.domain.agency.AgencyOrganization;
import com.sunesoft.ecloud.admin.domain.agency.User;
import com.sunesoft.ecloud.admin.query.AgencyOrganizationQueryService;
import com.sunesoft.ecloud.adminclient.cretirias.AgencyOrganizationCriteria;
import com.sunesoft.ecloud.adminclient.dtos.AgencyOrganizationDto;
import com.sunesoft.ecloud.adminclient.dtos.BasicDto;
import com.sunesoft.ecloud.common.result.ListResult;
import com.sunesoft.ecloud.common.result.TResult;
import com.sunesoft.ecloud.common.sqlBuilderTool.SqlBuilder;
import com.sunesoft.ecloud.hibernate.sqlBuilder.HSqlBuilder;
import com.sunesoft.ecloud.hibernate.sqlExcute.GenericQuery;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

/**
 * @Auther: niww
 * @Date: 2018/3/28/028
 */
@Service
@SuppressWarnings("All")
public class AgencyOrganizationQueryServiceImpl extends GenericQuery implements AgencyOrganizationQueryService {



    @Override
    public ListResult<AgencyOrganizationDto> findAgencyOrganization(AgencyOrganizationCriteria criteria) {
        UUID agId = criteria.getAgId();
        SqlBuilder<AgencyOrganizationDto> builder = HSqlBuilder.hFrom(AgencyOrganization.class, "org")
                .leftJoin(User.class,"user")
                .on("org.leaderId = user.id")
                .where("org.agId",agId)
                .select(AgencyOrganizationDto.class)
                .setFieldValue("pid","org.parentId")
                .setFieldValue("leaderName","user.realName")
                .setFieldValue("leaderId","user.id");
        List<AgencyOrganizationDto> allOrg = this.queryList(builder);
        return new ListResult<>(buildTree(allOrg));
    }

    @Override
    public TResult<AgencyOrganizationDto> findAgencyOrganizationBasicById(UUID id) {
        SqlBuilder<AgencyOrganizationDto> builder = HSqlBuilder.hFrom(AgencyOrganization.class,"org")
                .leftJoin(User.class,"user")
                .on("org.leaderId = user.id")
                .leftJoin(AgencyOrganization.class,"parent")
                .on("org.parentId = parent.id")
                .where("org.id",id)
                .select(AgencyOrganizationDto.class)
                .setFieldValue("name","org.name")
                .setFieldValue("code","org.code")
                .setFieldValue("description","org.description")
                .setFieldValue("leaderId","user.Id")
                .setFieldValue("leaderName","user.realName")
                .setFieldValue("parentId","parent.id")
                .setFieldValue("parentName","parent.name");
        return new TResult<>(this.queryForObject(builder));
    }

    @Override
    public ListResult<BasicDto> getOrganizationIdName() {

        SqlBuilder<BasicDto> userBuilder = HSqlBuilder.hFrom(AgencyOrganization.class,"org")
                .select(BasicDto.class);
        List<BasicDto> orgList = queryList(userBuilder);
        return new ListResult<>(orgList);

    }


    /**
     * 将集合数据转化成树形结构
     * @param dtoList 集合数据
     * @return 返回树形结构数据
     */
    private static List<AgencyOrganizationDto> buildTree(List<AgencyOrganizationDto> dtoList){
        List<AgencyOrganizationDto> treeList = new ArrayList<>();
        dtoList.forEach(parent->{
            if(null == parent.getPid()){
                treeList.add(parent);
            }
            dtoList.forEach(child->{
                if(Objects.equals(child.getPid(),parent.getId())){
                    if(null == parent.getChildren()){
                        parent.setChildren(new ArrayList<>());
                    }
                    parent.getChildren().add(child);
                }
            });
        });
        return treeList;
    }
}
