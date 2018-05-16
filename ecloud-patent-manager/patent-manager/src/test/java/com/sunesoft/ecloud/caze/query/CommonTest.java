package com.sunesoft.ecloud.caze.query;


import com.sunesoft.ecloud.caseclient.dto.xml.XMLDate;
import com.sunesoft.ecloud.caseclient.dto.xml.examine.*;
import com.sunesoft.ecloud.caseclient.dto.xml.proxy.*;
import com.thoughtworks.xstream.XStream;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

/**
 * @Auther: niww
 * @Date: 2018/5/4/004
 */
@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
public class CommonTest {
    @Test
    public void test1(){
        System.out.println(23);
    }

    /**
     * 测试代理委托书xml生成
     * @throws FileNotFoundException
     */
    @Test
    public void test2() throws FileNotFoundException {
        List<ProxyAgent> agentList = new ArrayList<>();
        agentList.add(new ProxyAgent("胡志强",1));
        agentList.add(new ProxyAgent("",2));

        List<Entrustor> entrustorList = new ArrayList<>();
        entrustorList.add(new Entrustor("来看看的",1));
        entrustorList.add(new Entrustor("签章",2));

        List<Picture> pictureList = new ArrayList<>();
        pictureList.add(new Picture("委托书","171229144558.jpg",1));

        PatentProxyXMLDto dto = new PatentProxyXMLDto();
        dto.setAgencyName("上海点威知识产权代理有限公司");
        dto.setAgencyCode("31326");
        dto.setPatentName("一种汽车装置");
        dto.setAgentList(agentList);
        dto.setEntrustorSignatureList(entrustorList);
        dto.setAgentSignature("上海点威知识产权代理有限公司");
        dto.setXMLDate(new XMLDate("2018","5","16"));

        dto.setPictureList(pictureList);
        dto.setInformationConsistencyStatement(new InformationConsistencyStatement());

        PrintWriter writer = new PrintWriter("E:/100008.xml");
        writer.write("<?xml version=\"1.0\" encoding=\"UTF-8\" ?>\n");
        XStream xs = new XStream();
        //xs.alias("cat", Cat.class); //等同于 @XStreamAlias("cat")
        xs.processAnnotations(PatentProxyXMLDto.class);//将Cat.class类上的注解将会使用
        xs.toXML(dto,writer);
        System.out.println(123);
    }

    /**
     * 测试实质审查请求书xml生成
     */
    @Test
    public void test3() throws FileNotFoundException {
        SubstantiveReviewRequestDto dto = new SubstantiveReviewRequestDto();
        dto.setPatentInfo(new SubstantiveReviewRequestPatentInfo("二种通过文化云平台进行用户管理的方法及装置aab","上海创图网络科技股份有限公司aab"));
        dto.setContentInfo(new SubstantiveReviewRequestContentInfo(1));
        List<AttachmentInfo> infos = new ArrayList<>();
        infos.add(new AttachmentInfo("",1));
        dto.setAttachmentInfo(infos);
        dto.setRemarksInfo(new SubstantiveReviewRequestRemarksInfo());
        dto.setSignatureInfo(new SubstantiveReviewRequestSignatureInfo("上海点威知识产权代理有限公司",new XMLDate("2018","5","16")));
        dto.setOpinionInfo(new SubstantiveReviewRequestOpinionInfo("",new XMLDate()));
        PrintWriter writer = new PrintWriter("E:/110401.xml");
        writer.write("<?xml version=\"1.0\" encoding=\"UTF-8\" ?>\n");
        XStream xs = new XStream();
        xs.processAnnotations(SubstantiveReviewRequestDto.class);
        xs.toXML(dto,writer);
        System.out.println(123);
    }
}
