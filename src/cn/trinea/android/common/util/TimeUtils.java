package cn.trinea.android.common.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * TimeUtils
 * 
 * @author <a href="http://www.trinea.cn" target="_blank">Trinea</a> 2013-8-24
 */
public class TimeUtils {

    public static final SimpleDateFormat DEFAULT_DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    public static final SimpleDateFormat DATE_FORMAT_DATE    = new SimpleDateFormat("yyyy-MM-dd");

    private TimeUtils() {
        throw new AssertionError();
    }

    /**
     * long time to string
     * 
     * @param timeInMillis
     * @param dateFormat
     * @return
     */
    public static String getTime(long timeInMillis, SimpleDateFormat dateFormat) {
        return dateFormat.format(new Date(timeInMillis));
    }

    /**
     * long time to string, format is {@link #DEFAULT_DATE_FORMAT}
     * 
     * @param timeInMillis
     * @return
     */
    public static String getTime(long timeInMillis) {
        return getTime(timeInMillis, DEFAULT_DATE_FORMAT);
    }

    /**
     * get current time in milliseconds
     * 
     * @return
     */
    public static long getCurrentTimeInLong() {
        return System.currentTimeMillis();
    }

    /**
     * get current time in milliseconds, format is {@link #DEFAULT_DATE_FORMAT}
     * 
     * @return
     */
    public static String getCurrentTimeInString() {
        return getTime(getCurrentTimeInLong());
    }

    /**
     * get current time in milliseconds
     * 
     * @return
     */
    public static String getCurrentTimeInString(SimpleDateFormat dateFormat) {
        return getTime(getCurrentTimeInLong(), dateFormat);
    }
    
 
	/**
	 * 将UMT时间转换为本地时间
	 * @param str
	 * @return
	 * @throws ParseException 
	 */
	public static Date ParseUTCDate(String str){
		//格式化2012-03-04T23:42:00+08:00
		SimpleDateFormat formatter=new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssZ",Locale.CHINA);
		try {
			Date date = formatter.parse(str);
			
			return date;
		} catch (ParseException e) {
			//格式化Sat, 17 Mar 2012 11:37:13 +0000
			//Sat, 17 Mar 2012 22:13:41 +0800
			try{
				SimpleDateFormat formatter2=new SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss Z",Locale.CHINA);
				Date date2 = formatter2.parse(str);
				
				return date2;
			}catch(ParseException ex){
				return null;
			}
		}		
	}
}
