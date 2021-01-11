package com.qbrainx.statistics.util;

public class DateUtil {
    private static final Long ONE_MINUTE = 60000L;

    /**
     * return true if time is not
     */
    public static boolean isTimestampInMinute(Long timestamp) {
        boolean response =false;
        long timeDiff = System.currentTimeMillis() - timestamp;
        response = (timeDiff < ONE_MINUTE && timeDiff >0);
        return response;
    }
}
