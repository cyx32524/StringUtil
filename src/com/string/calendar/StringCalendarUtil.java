package com.string.calendar;

import java.util.Calendar;

public class StringCalendarUtil {
    
    /**
     * 将毫秒转为时间 类似于20160310
     * @param timeMillis
     * @param type 
     * @return
     */
    public static String getNowDateStr(long timeMillis, String separate) {
        Calendar cal = Calendar.getInstance();
        StringBuffer sb = new StringBuffer();
        cal.setTimeInMillis(timeMillis);
        sb.append(cal.get(Calendar.YEAR));
        sb.append(separate);
        sb.append(fill(String.valueOf(cal.get(Calendar.MONTH)+1), 2, '0'));
        sb.append(separate);
        sb.append(fill(String.valueOf(cal.get(Calendar.DAY_OF_MONTH)), 2, '0'));
        
        return sb.toString();
    }
    
    /**
     * 填充字符串 place要大于needFile的长度
     * @param needFill 需要填充的字符串
     * @param place 需要填充到多少位
     * @param fillStuff 需要填充的字符
     * @return
     */
    public static String fill(String needFill, int place, char fillStuff) {
        if (needFill == null || place == 0) {
            return needFill;
        }
        if (needFill.length() < place) {
            char[] result = new char[place];
            for (int i = place-1, j = needFill.length()-1; i >= 0; i--, j--) {
                if (i >= place-needFill.length()) {
                    result[i] = needFill.charAt(j);
                } else {
                    result[i] = fillStuff;
                }
            }
            return String.valueOf(result);
        }
        return needFill;
    }
    
    /**
     * 通过一个dateline得到当天0点时的dateline<p>
     * daline是System.currentTimeMillis()/1000的格式
     * @param dateline
     * @return
     */
    public static long getDaysZeroTimeMillis (long dateline) {
        return ((dateline/86400*86400) + (dateline%86400 < 57600 ? 0 : 86400)) - 28800;
    }
    
    public static void main(String[] ar) {
        long time = System.currentTimeMillis();
//        Random rd = new Random();
        for (long i = 0L; i < 10000000L; i++) {
            getNowDateStr(System.currentTimeMillis(), "");
        }
        System.out.println(System.currentTimeMillis()-time);
    }
}
