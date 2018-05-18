package com.sunesoft.ecloud.caze.query;


import com.sunesoft.ecloud.caseclient.dto.xml.ApprovalOpinion;
import com.sunesoft.ecloud.caseclient.dto.xml.SignatureInfo;
import com.sunesoft.ecloud.caseclient.dto.xml.XMLDate;
import com.sunesoft.ecloud.caseclient.dto.xml.qqs.fm.InventorPatentRequestDto;
import com.sunesoft.ecloud.caseclient.dto.xml.qqs.wg.AppearancePatentRequestDto;
import com.sunesoft.ecloud.caseclient.dto.xml.szscqqs.*;
import com.sunesoft.ecloud.caseclient.dto.xml.list.*;
import com.sunesoft.ecloud.caseclient.dto.xml.dlwts.*;
import com.sunesoft.ecloud.caseclient.dto.xml.qqs.*;
import com.sunesoft.ecloud.caseclient.dto.xml.wgsjtp.AppearanceDesignPictureDto;
import com.sunesoft.ecloud.caseclient.dto.xml.wgsjtp.AppearancePicture;
import com.thoughtworks.xstream.XStream;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.*;

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

        PrintWriter writer = new PrintWriter("E:/test100007.xml");
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
        dto.setContentInfo(new SubstantiveReviewRequestContentInfo(true));
        List<AttachmentInfo> infos = new ArrayList<>();
        infos.add(new AttachmentInfo("",1));
        dto.setAttachmentInfo(infos);
        dto.setRemarksInfo(new SubstantiveReviewRequestRemarksInfo());
        dto.setSignatureInfo(new SignatureInfo("上海点威知识产权代理有限公司",new XMLDate("2018","5","16")));
        dto.setOpinionInfo(new SubstantiveReviewRequestOpinionInfo("",new XMLDate()));
        PrintWriter writer = new PrintWriter("E:/test110401.xml");
        writer.write("<?xml version=\"1.0\" encoding=\"UTF-8\" ?>\n");
        XStream xs = new XStream();
        xs.processAnnotations(SubstantiveReviewRequestDto.class);
        xs.toXML(dto,writer);
        System.out.println(123);
    }

    /**
     * 测试生成发明专利请求书xml
     * @throws Exception
     */
    @Test
    public void test4() throws Exception{

        InventorPatentRequestDto dto =  new InventorPatentRequestDto();
        dto.setCaseNo("AJ201805170001");
        dto.setPatentName("一种通过文化云平台进行用户管理的方法及装置");
        List<InventorOther> inventorOthers = new ArrayList<>();
        inventorOthers.add(new InventorOther(1,"包嘉会",false));
        inventorOthers.add(new InventorOther(2,"李欣",false));
        Inventor inventor  = new Inventor(new InventorFirst("长红","CN",false,"34253119850816171X"),inventorOthers);
        dto.setInventor(inventor);


        ApplicantFirst applicantFirst = new ApplicantFirst();
        applicantFirst.setName("上海创图网络科技股份有限公司");
        applicantFirst.setApplicantType(3);
        applicantFirst.setUserCode("");
        applicantFirst.setIdCode("913101087653151511");
        applicantFirst.setEmail("");
        applicantFirst.setCountryCode("CN");
        applicantFirst.setLiveAddressCode("CN");
        applicantFirst.setProvinceCode("310000");
        applicantFirst.setCityCode("310000");
        applicantFirst.setAreaDetail("广中西路777弄12号二楼A－27室");
        applicantFirst.setZipCode("200072");
        applicantFirst.setFeeRecord(false);
        Applicant applicant = new Applicant(applicantFirst,Applicant.generateOriginalApplicantOther());
        dto.setApplicant(applicant);

        dto.setContactor(new Contactor());
        List<AgencyAgent> agentList = new ArrayList<>();
        agentList.add(new AgencyAgent(1,"胡志强","3132615981.5","3132615981.5"));
        agentList.add(new AgencyAgent(2,"","",""));
        dto.setAgency(new Agency("上海点威知识产权代理有限公司","31326",true,agentList));

        dto.setDivisionApplication(new DivisionApplication());
        dto.setSequenceTable(new SequenceTable(true));
        dto.setNoveltyStatement(new NoveltyStatement());

        dto.setSignatureInfo(new SignatureInfo("上海点威知识产权代理有限公司",new XMLDate("2018","12","15")));

        dto.setApprovalOpinion(new ApprovalOpinion("",new XMLDate()));
        PrintWriter writer = new PrintWriter("E:/test110101.xml");
        writer.write("<?xml version=\"1.0\" encoding=\"UTF-8\" ?>\n");
        XStream xs = new XStream();
        xs.processAnnotations(InventorPatentRequestDto.class);
        xs.toXML(dto,writer);
        System.out.println(123);

    }


    /**
     * 测试list.xml生成
     */
    @Test
    public void test5() throws FileNotFoundException{
        RequestInfo r = new RequestInfo();
        r.setId(UUID.randomUUID().toString());
        r.setApplyMode(1);
        r.setBusinessType(0);
        r.setFileType(0);
        r.setSubmiterCode("23CDSF1");
        r.setPatentName("一种通过文化云平台进行用户管理的方法及装置");
        r.setCaseNo("AJ201805170001");

        PackageHeader header = new PackageHeader(" ",7);
        List<PackageFileInfo> fileInfoList = new ArrayList<>();
        fileInfoList.add(new PackageFileInfo("110101.xml",".XML","110101","110101\\110101.xml","1.0",4,0,0,"发明专利请求书",""));
        fileInfoList.add(new PackageFileInfo("110101.xml",".XML","110101","110101\\110101.xml","1.0",4,0,0,"发明专利请求书",""));
        fileInfoList.add(new PackageFileInfo("110101.xml",".XML","110101","110101\\110101.xml","1.0",4,0,0,"发明专利请求书",""));
        fileInfoList.add(new PackageFileInfo("110101.xml",".XML","110101","110101\\110101.xml","1.0",4,0,0,"发明专利请求书",""));
        fileInfoList.add(new PackageFileInfo("110101.xml",".XML","110101","110101\\110101.xml","1.0",4,0,0,"发明专利请求书",""));
        fileInfoList.add(new PackageFileInfo("110101.xml",".XML","110101","110101\\110101.xml","1.0",4,0,0,"发明专利请求书",""));
        fileInfoList.add(new PackageFileInfo("110101.xml",".XML","110101","110101\\110101.xml","1.0",4,0,0,"发明专利请求书",""));
        PackageOriginalInfo info =  new PackageOriginalInfo(header,fileInfoList);
        ColligateInfoDto dto = new ColligateInfoDto(r,info);
        PrintWriter writer = new PrintWriter("E:/list.xml");
        writer.write("<?xml version=\"1.0\" encoding=\"UTF-8\" ?>\n");
        XStream xs = new XStream();
        xs.processAnnotations(ColligateInfoDto.class);
        xs.toXML(dto,writer);
        System.out.println(123);
    }


    @Test
    public void testGetImageWidthAndHeight(){
        Map<String, Object> imageInfoMap = new HashMap<>();
        InputStream is = null;
        try {
            File file = new File("C:\\Users\\Administrator\\Desktop\\51c97b3d-e4ea-492e-90f0-be22b7ebe1c3\\130001\\1709201417451.jpg");
            is = new FileInputStream(file);
            BufferedImage image = ImageIO.read(is);
            imageInfoMap.put("size", file.length());
            imageInfoMap.put("width", image.getWidth());
            imageInfoMap.put("height", image.getHeight());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (is != null) {
                try {
                    is.close(); // 关闭流
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        System.out.println(23);
    }


    /**
     * 测试生成外观设计图片或照片xml文件
     */
    @Test
    public void test6() throws Exception{
        List<AppearancePicture> list = new ArrayList<>();
        list.add(new AppearancePicture(1,"139.9646","178.5938","主视图","jpg","1709201417451.jpg"));
        list.add(new AppearancePicture(2,"139.9646","178.5938","主视图","jpg","1709201417451.jpg"));
        list.add(new AppearancePicture(3,"139.9646","178.5938","主视图","jpg","1709201417451.jpg"));
        list.add(new AppearancePicture(4,"139.9646","178.5938","主视图","jpg","1709201417451.jpg"));
        list.add(new AppearancePicture(5,"139.9646","178.5938","主视图","jpg","1709201417451.jpg"));
        list.add(new AppearancePicture(6,"139.9646","178.5938","主视图","jpg","1709201417451.jpg"));
        list.add(new AppearancePicture(7,"139.9646","178.5938","主视图","jpg","1709201417451.jpg"));
        AppearanceDesignPictureDto dto = new AppearanceDesignPictureDto(list);
        PrintWriter writer = new PrintWriter("E:/test130001.xml");
        writer.write("<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n");
        XStream xs = new XStream();
        xs.processAnnotations(AppearanceDesignPictureDto.class);
        xs.toXML(dto,writer);
        System.out.println(123);
    }


    /**
     * 测试外观专利请求书xml
     * @throws Exception
     */
    @Test
    public void test7() throws Exception{
        AppearancePatentRequestDto dto =  new AppearancePatentRequestDto();
        dto.setCaseNo("AJ201805170001");
        dto.setPatentName("一种通过文化云平台进行用户管理的方法及装置");
        List<InventorOther> inventorOthers = new ArrayList<>();
        inventorOthers.add(new InventorOther(1,"祁辰黎",false));
        inventorOthers.add(new InventorOther(2,"倩",false));
        Designer inventor  = new Designer(new InventorFirst("宋海瑛","CN",false,"34253119850816171X"),inventorOthers);
        dto.setDesigner(inventor);


        ApplicantFirst applicantFirst = new ApplicantFirst();
        applicantFirst.setName("上海创图网络科技股份有限公司");
        applicantFirst.setApplicantType(3);
        applicantFirst.setUserCode("");
        applicantFirst.setIdCode("913101087653151511");
        applicantFirst.setEmail("");
        applicantFirst.setCountryCode("CN");
        applicantFirst.setLiveAddressCode("CN");
        applicantFirst.setProvinceCode("310000");
        applicantFirst.setCityCode("310000");
        applicantFirst.setAreaDetail("广中西路777弄12号二楼A－27室");
        applicantFirst.setZipCode("200072");
        applicantFirst.setFeeRecord(false);
        Applicant applicant = new Applicant(applicantFirst,Applicant.generateOriginalApplicantOther());
        dto.setApplicant(applicant);

        dto.setContactor(new Contactor());
        List<AgencyAgent> agentList = new ArrayList<>();
        agentList.add(new AgencyAgent(1,"胡志强","3132615981.5","18212587452"));
        agentList.add(new AgencyAgent(2,"","",""));
        dto.setAgency(new Agency("上海点威知识产权代理有限公司","31326",true,agentList));
        dto.setDivisionApplication(new DivisionApplication());
        dto.setNoveltyStatement(new NoveltyStatement());
        dto.setSimilarDesign(new SimilarDesign(false,null));
        dto.setCompleteProduct(new CompleteProduct(false,null));
        dto.setSignatureInfo(new SignatureInfo("上海点威知识产权代理有限公司",new XMLDate("2018","12","15")));
        dto.setApprovalOpinion(new ApprovalOpinion("",new XMLDate()));
        PrintWriter writer = new PrintWriter("E:/test130101.xml");
        writer.write("<?xml version=\"1.0\" encoding=\"UTF-8\" ?>\n");
        XStream xs = new XStream();
        xs.processAnnotations(AppearancePatentRequestDto.class);
        xs.omitField(Agency.class,"statementInfoIdentical");
        xs.toXML(dto,writer);
        System.out.println(123);
    }

}
