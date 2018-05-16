package com.sunesoft.ecloud.caze.service.impl;

import com.google.gson.reflect.TypeToken;
import com.sunesoft.ecloud.caseclient.dto.AddPatentFeeDto;
import com.sunesoft.ecloud.caseclient.dto.DismissedNoticeDto;
import com.sunesoft.ecloud.caseclient.dto.notice.CheckInNoticeDto;
import com.sunesoft.ecloud.caseclient.dto.notice.FeeInfoAllDto;
import com.sunesoft.ecloud.caseclient.dto.notice.FeeInfoDetailDto;
import com.sunesoft.ecloud.caseclient.dto.notice.FeeReduceApprovalNoticeDto;
import com.sunesoft.ecloud.caseclient.enums.PatentFeeType;
import com.sunesoft.ecloud.caze.domain.NoticeInfo;
import com.sunesoft.ecloud.caze.repository.DismissedNoticeRepository;
import com.sunesoft.ecloud.caze.service.NoticeService;
import com.sunesoft.ecloud.caze.service.PatentService;
import com.sunesoft.ecloud.common.result.TResult;
import com.sunesoft.ecloud.common.result.resultFactory.ResultFactory;
import com.sunesoft.ecloud.common.utils.BeanUtil;
import com.sunesoft.ecloud.common.utils.JsonHelper;
import com.thoughtworks.xstream.XStream;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.UUID;
import java.util.function.BiConsumer;

/**
 * @Auther: niww
 * @Date: 2018/5/3/003
 */
@Service
public class NoticeServiceImpl implements NoticeService {

    @Autowired
    DismissedNoticeRepository noticeRepository;
    @Autowired
    PatentService patentService;

    @Override
    public TResult addNotice(DismissedNoticeDto dto) {
        UUID agId = dto.getAgId();
        if(null == dto.getAgId()){
            throw new IllegalArgumentException("参数agId不能为null");
        }
        NoticeInfo noticeInfo = new NoticeInfo();
        BeanUtil.copyPropertiesIgnoreNull(dto, noticeInfo);
        noticeRepository.saveAndFlush(noticeInfo);

        String noticeCode = dto.getNoticeCode();
        String content = noticeInfo.getContent();
        List<String> contentList  = (List<String>)JsonHelper.toObject(content, new TypeToken<List<String>>(){}.getType());
        content = contentList.get(0);
        switch (noticeCode){
            case "200101":
                //受理通知书:
                // 1.将申请号/专利号,申请日 与案件 关联，
                patentService.bindPatent(agId,dto.getCaseNo(),dto.getApplicationNo(),dto.getApplicationDate());
                break;
            case "200020": {
                //费用减缓审批通知书：保存费用明细及缴费截止日
                XStream xstream = new XStream();
                xstream.ignoreUnknownElements();
                xstream.processAnnotations(FeeReduceApprovalNoticeDto.class);
                FeeReduceApprovalNoticeDto feeNotice = (FeeReduceApprovalNoticeDto) xstream.fromXML(content);
                String applicationNo = feeNotice.getApplication_number();
                FeeInfoAllDto feeInfoAllDto = feeNotice.getFee_info_all();
                List<FeeInfoDetailDto> feeInfoList = feeInfoAllDto.getFee_info();
                LocalDate paymentPeriodDate = LocalDate.parse(feeNotice.getPay_deadline_date(),DateTimeFormatter.ofPattern("yyyyMMdd"));
                AddPatentFeeDto feeDto = new AddPatentFeeDto();
                feeDto.setApplicationNo(applicationNo);
                feeDto.setFeeType(PatentFeeType.APPLICATION);
                feeDto.setTotalPrice(feeInfoAllDto.getFee_total());
                feeDto.setPaymentPeriod(paymentPeriodDate);
                feeDto.setFeeDetailList(feeInfoList);
                patentService.addPatentFeeInfo(feeDto);
                break;
            }
            case "200701":
                //缴费通知书
                break;
            case "210304":
                //发明专利申请初步审查合格通知书
                break;
            case "210308":
                //发明专利申请公布及进入实质审查通知书
                break;
            case "210401":
                //第一次审查意见通知书
                break;
            case "210403":
                //第N次审查意见通知书
                break;
            case "200602":{
                //办理登记手续通知书
                XStream xstream = new XStream();
                xstream.ignoreUnknownElements();
                xstream.processAnnotations(CheckInNoticeDto.class);
                CheckInNoticeDto checkInNotice = (CheckInNoticeDto) xstream.fromXML(content);
                String applicationNo = checkInNotice.getApplication_number();
                FeeInfoAllDto feeInfoAllDto = checkInNotice.getFee_info_all();
                List<FeeInfoDetailDto> feeInfoList = feeInfoAllDto.getFee_info();
                setCheckInFeeTotal(feeInfoAllDto,feeInfoList,(info,amount)->{
                    info.setFee_total(info.getFee_total().add(amount));
                });
                LocalDate paymentPeriodDate = LocalDate.parse(checkInNotice.getPay_deadline_date(),DateTimeFormatter.ofPattern("yyyyMMdd"));
                AddPatentFeeDto feeDto = new AddPatentFeeDto();
                feeDto.setApplicationNo(applicationNo);
                feeDto.setFeeType(PatentFeeType.CHECKIN);
                feeDto.setTotalPrice(feeInfoAllDto.getFee_total());
                feeDto.setPaymentPeriod(paymentPeriodDate);
                feeDto.setFeeDetailList(feeInfoList);
                patentService.addPatentFeeInfo(feeDto);
                break;
            }
            case "210302":
                //补正通知书
                break;
            default:
                break;
        }
        return ResultFactory.success();
    }

    @Override
    public TResult handleNotice(UUID noticeId) {
        if(null == noticeId){
            throw new IllegalArgumentException("参数noticeId不能为null");
        }
        NoticeInfo noticeInfo = noticeRepository.findById(noticeId).get();
        noticeInfo.setHandleStatus(true);
        return ResultFactory.success();
    }


    @Override
    public TResult testContentToBean() {
        NoticeInfo noticeInfo = noticeRepository.findById(UUID.fromString("b498d76d-10e9-4f30-bbf8-5a095709ee05")).get();
        String content = noticeInfo.getContent();
        List<String> contentList  = (List<String>)JsonHelper.toObject(content, new TypeToken<List<String>>(){}.getType());
        content = contentList.get(0);
        //创建xStream对象
        XStream xstream = new XStream();
        xstream.ignoreUnknownElements();
        xstream.processAnnotations(FeeReduceApprovalNoticeDto.class);
        FeeReduceApprovalNoticeDto user2 = (FeeReduceApprovalNoticeDto) xstream.fromXML(content);

        return null;
    }

    private void setCheckInFeeTotal(FeeInfoAllDto info,List<FeeInfoDetailDto> detailList, BiConsumer<FeeInfoAllDto,BigDecimal> setTotal) {
        detailList.forEach(detail->{
            setTotal.accept(info,detail.getFee_amount());
        });
    }



}
