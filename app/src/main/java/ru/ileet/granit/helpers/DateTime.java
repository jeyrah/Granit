package ru.ileet.granit.helpers;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

import org.apache.commons.lang.time.DateUtils;

/**
 * Класс для работы с датой и временем
 */
public class DateTime {
    private long mCurrentDate;
    private String mFormat;
    private String mFormattedDate;
    private Date mDate;

    public DateTime(){
        mCurrentDate = System.currentTimeMillis() / 1000;
        mDate = new Date(mCurrentDate * 1000L);

    }

    public DateTime(long timeStamp, String format) {
        mCurrentDate = timeStamp;
        mFormat = format;
        mDate = new Date(mCurrentDate * 1000L);
        convert();
    }

    private void convert() {
        SimpleDateFormat dateFormat = new SimpleDateFormat(mFormat);
        dateFormat.setTimeZone(TimeZone.getTimeZone("GMT-3"));
        mFormattedDate = dateFormat.format(mDate);
    }

    public String getFormattedDate() {
        return mFormattedDate;
    }

    public boolean isSameDay(long serverTS){
        if(DateUtils.isSameDay(new Date(serverTS * 1000L), new Date(mCurrentDate * 1000L))){
            return true;
        } else
            return false;
    }

    public boolean isNextDay (long serverTS){
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy.MM.dd");

        Date currentDate = new Date(mCurrentDate * 1000L);
        String stringCurrentDate = dateFormat.format(currentDate);
        Calendar calendar = Calendar.getInstance();
        try {
            calendar.setTime(dateFormat.parse(stringCurrentDate));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        calendar.add(Calendar.DATE, 1);
        stringCurrentDate = dateFormat.format(calendar.getTime());

        Date nextDate = new Date(serverTS * 1000L);
        String stringNextDate = dateFormat.format(nextDate);

        if (stringNextDate.equals(stringCurrentDate)){
            return true;
        } else return false;
    }
}
