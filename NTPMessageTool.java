
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class NTPMessageTool {
    private static final long SECS = 60 * 60 * 24 * 25567L;
    public static double getTimestamp(short[] data, int index) {
        double timestamp = 0.0;
        for (int i = 0; i < 8; i++) {
            timestamp += (data[index + i] * Math.pow(2, (3 - i) * 8));
        }
        return timestamp;
    }
    public static String getTime(double timestamp) {
        return (new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS")).format(new Date((long) (1000.0 * (timestamp - SECS))));
    }
    public static void main(String[] args) throws ParseException {
        short[] data = {225, 72, 40, 99, 105, 153, 22, 188, 225, 72, 40, 106, 185, 120, 53, 155, 225, 72, 40, 106, 185, 120, 97, 58};
        double t1 = getTimestamp(data, 0);
        double t2 = getTimestamp(data, 8);
        double t3 = getTimestamp(data, 16);
        long t_1 = (long) (1000 * (t1 - SECS));
        long t_2 = (long) (1000 * (t2 - SECS));
        long t_3 = (long) (1000 * (t3 - SECS));
        System.out.println(getTime(t1));
        System.out.println(getTime(t2));
        System.out.println(getTime(t3));
        long t_4 = (new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS")).parse("2019-10-09 16:35:47.783").getTime();
        double t4 = t_4 / 1000.0 + SECS;
        double tnew = ((t2 - t1) + (t3 - t4)) / 2.0 + t4;
        System.out.println(getTime(tnew));
        long t_new = (long) (1000 * (tnew - SECS));
        System.out.println(((tnew - t4) * 1000));
    }
}
