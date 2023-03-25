import java.util.Calendar;

public class Bill {

    public String check(int time) {
        return getString(time);
    }

    public String check(int startYear, int startMouth, int startDay, int startHour, int startMinute,
                        int endYear, int endMouth, int endDay, int endHour, int endMinute, boolean isConvert) {
        endMouth--;
        startMouth--;
        Calendar start = Calendar.getInstance();
        start.set(startYear, startMouth, startDay, startHour, startMinute);
        Calendar end = Calendar.getInstance();
        end.set(endYear, endMouth, endDay, endHour, endMinute);
        long timeDiff = (end.getTimeInMillis() - start.getTimeInMillis()) / 1000;
        if (isConvert) {
            if (start.get(Calendar.MONTH) == Calendar.NOVEMBER &&
                    start.get(Calendar.DAY_OF_WEEK_IN_MONTH) == 1 &&
                    start.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY) {
                timeDiff += 3600;
            }
            if (start.get(Calendar.MONTH) == Calendar.MARCH &&
                    start.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY) {
                timeDiff -= 3600;
            }
        }
        timeDiff = timeDiff / 60;
        int time = (int) timeDiff;
        return getString(time);
    }

    private String getString(int time) {
        int cost;
        if (time < 0 || time > 1800) {
            return "通话时间错误";
        } else if (time <= 20 && time > 0) {
            cost = time * 5;
        } else {
            time -= 20;
            cost = 100 + time * 10;

        }
        return "花费" + String.format("%d.%02d", cost / 100, cost % 100) + "美元";
    }
}
