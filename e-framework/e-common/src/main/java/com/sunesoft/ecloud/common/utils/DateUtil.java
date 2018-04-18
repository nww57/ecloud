package com.sunesoft.ecloud.common.utils;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.time.DateUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Pattern;

/**
 * @Auther: niww
 * @Date: 2018/4/18/018
 */
public class DateUtil {

    public static Date parse(String str, String... parsePatterns) throws ParseException {
        return org.apache.commons.lang.time.DateUtils.parseDate(str, parsePatterns);
    }

    private static Pattern pattern1 = Pattern.compile("^\\d{4}\\d{1,2}\\d{1,2}$");
    private static Pattern pattern2 = Pattern.compile("^\\d{4}\\d{1,2}\\d{1,2} (0\\d{1}|1\\d{1}|2[0-3]):[0-5]\\d{1}:([0-5]\\d{1})$");
    private static Pattern pattern3 = Pattern.compile("^\\d{4}(\\-)\\d{1,2}\\1\\d{1,2}$");
    private static Pattern pattern4 = Pattern.compile("^\\d{4}(\\-)\\d{1,2}\\1\\d{1,2} (0\\d{1}|1\\d{1}|2[0-3]):[0-5]\\d{1}:([0-5]\\d{1})$");
    private static Pattern pattern5 = Pattern.compile("^\\d{4}(\\.)\\d{1,2}\\1\\d{1,2}$");
    private static Pattern pattern6 = Pattern.compile("^\\d{4}(\\.)\\d{1,2}\\1\\d{1,2} (0\\d{1}|1\\d{1}|2[0-3]):[0-5]\\d{1}:([0-5]\\d{1})$");
    private static Pattern pattern7 = Pattern.compile("^\\d{4}(\\/)\\d{1,2}\\1\\d{1,2}$");
    private static Pattern pattern8 = Pattern.compile("^\\d{4}(\\/)\\d{1,2}\\1\\d{1,2} (0\\d{1}|1\\d{1}|2[0-3]):[0-5]\\d{1}:([0-5]\\d{1})$");
    private static Pattern pattern9 = Pattern.compile("^\\d{4}(\\/)\\d{1,2}\\1\\d{1,2}$");
    private static Pattern pattern10 = Pattern.compile("^\\d{4}(\\/)\\d{1,2}\\1\\d{1,2} (0\\d{1}|1\\d{1}|2[0-3]):[0-5]\\d{1}:([0-5]\\d{1})$");
    private static SimpleDateFormat simpleDateFormat = new SimpleDateFormat();
    private static Logger logger = LoggerFactory.getLogger(DateUtils.class);

    public static Date parse(String dateStr)
    {
        if (StringUtils.isEmpty(dateStr)) {
            return null;
        }
        try
        {
            if (pattern1.matcher(dateStr).matches()) {
                return DateUtils.parseDate(dateStr, new String[] { "yyyyMMdd" });
            }
            if (pattern2.matcher(dateStr).matches()) {
                return DateUtils.parseDate(dateStr, new String[] { "yyyyMMdd HH:mm:ss" });
            }
            if (pattern3.matcher(dateStr).matches()) {
                return DateUtils.parseDate(dateStr, new String[] { "yyyy-MM-dd" });
            }
            if (pattern4.matcher(dateStr).matches()) {
                return DateUtils.parseDate(dateStr, new String[] { "yyyy-MM-dd HH:mm:ss" });
            }
            if (pattern5.matcher(dateStr).matches()) {
                return DateUtils.parseDate(dateStr, new String[] { "yyyy.MM.dd" });
            }
            if (pattern6.matcher(dateStr).matches()) {
                return DateUtils.parseDate(dateStr, new String[] { "yyyy.MM.dd HH:mm:ss" });
            }
            if (pattern7.matcher(dateStr).matches()) {
                return DateUtils.parseDate(dateStr, new String[] { "yyyy/MM/dd" });
            }
            if (pattern8.matcher(dateStr).matches()) {
                return DateUtils.parseDate(dateStr, new String[] { "yyyy/MM/dd HH:mm:ss" });
            }
            if (pattern9.matcher(dateStr).matches()) {
                return DateUtils.parseDate(dateStr, new String[] { "yyyy年MM月dd日" });
            }
            if (pattern10.matcher(dateStr).matches()) {
                return DateUtils.parseDate(dateStr, new String[] { "yyyy年MM月dd日 HH:mm:ss" });
            }
            return simpleDateFormat.parse(dateStr);
        }
        catch (ParseException ex)
        {
            logger.error(ex.getMessage(), ex);
        }
        return null;
    }

    public static Date parseStartDate(String dateStr)
    {
        if (StringUtils.isEmpty(dateStr)) {
            return null;
        }
        if ((pattern1.matcher(dateStr).matches()) || (pattern3.matcher(dateStr).matches()) || (pattern5.matcher(dateStr).matches()) || (pattern7.matcher(dateStr).matches()) || (pattern9.matcher(dateStr).matches())) {
            dateStr = dateStr + " 00:00:00";
        }
        return parse(dateStr);
    }

    public static Date parseEndDate(String dateStr)
    {
        if (StringUtils.isEmpty(dateStr)) {
            return null;
        }
        if ((pattern1.matcher(dateStr).matches()) || (pattern3.matcher(dateStr).matches()) || (pattern5.matcher(dateStr).matches()) || (pattern7.matcher(dateStr).matches()) || (pattern9.matcher(dateStr).matches())) {
            dateStr = dateStr + " 23:59:59";
        }
        return parse(dateStr);
    }
}
