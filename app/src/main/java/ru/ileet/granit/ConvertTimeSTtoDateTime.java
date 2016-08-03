package ru.ileet.granit;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

/**
 * Created by Ama on 23.07.2016.
 */
public class ConvertTimeSTtoDateTime {
    private long mTimeStamp;
    private String mFormat;
    private String mFormattedDate;

    public ConvertTimeSTtoDateTime(long timeStamp, String format) {
        mTimeStamp = timeStamp;
        mFormat = format;
        convert();
    }

    private void convert() {
        Date date = new Date(mTimeStamp*1000L);
        SimpleDateFormat dateFormat = new SimpleDateFormat(mFormat);
        dateFormat.setTimeZone(TimeZone.getTimeZone("GMT-3"));
        mFormattedDate = dateFormat.format(date);
    }

    public String getFormattedDate() {
        return mFormattedDate;
    }
}
