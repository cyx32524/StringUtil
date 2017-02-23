package com.string.calendar;

import java.util.Calendar;

public class StringCalendarUtil {
    
    /**
     * ������תΪʱ�� ������20160310
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
     * ����ַ��� placeҪ����needFile�ĳ���
     * @param needFill ��Ҫ�����ַ���
     * @param place ��Ҫ��䵽����λ
     * @param fillStuff ��Ҫ�����ַ�
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
     * ͨ��һ��dateline�õ�����0��ʱ��dateline<p>
     * daline��System.currentTimeMillis()/1000�ĸ�ʽ
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
