package ru.ileet.granit;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

/**
 * Класс для работы с датой
 */
public class DateTime {
    private long mTimeStamp;
    private String mFormat;
    private String mFormattedDate;
    private Date mDate;

    public DateTime(long timeStamp, String format) {
        mTimeStamp = timeStamp;
        mFormat = format;
        convert();
    }

    private void convert() {
        mDate = new Date(mTimeStamp*1000L);
        SimpleDateFormat dateFormat = new SimpleDateFormat(mFormat);
        dateFormat.setTimeZone(TimeZone.getTimeZone("GMT-3"));
        mFormattedDate = dateFormat.format(mDate);
    }

    public String getFormattedDate() {
        return mFormattedDate;
    }


}
