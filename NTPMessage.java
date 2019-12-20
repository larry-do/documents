package TCP;

import java.sql.Date;
import java.text.SimpleDateFormat;

public class NTPMessage {

    private static final long DAYS = 25567;
    private static final long SECS = 60 * 60 * 24 * DAYS;

    public static short unsignedByteToShort(byte b) {
        if ((b & 0x80) == 0x80) {
            return (short) (128 + (b & 0x7f));
        } else {
            return (short) b;
        }
    }

    public static double decodeTimestamp(byte[] array, int pointer) {
        double r = 0.0;

        for (int i = 0; i < 8; i++) {
            r += unsignedByteToShort(array[pointer + i]) * Math.pow(2, (3 - i) * 8);
        }

        return r;
    }


    public static String timestampToString(final double timestamp) {
        if (timestamp == 0) {
            return "0";
        }
        return millisToDate((long) (1000.0 * (timestamp - SECS)));
    }

    public static String millisToDate(final long ms) {
        Date date = new Date(ms);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
        return sdf.format(date);
    }

    public static void main(String[] args) {
        int[] data = {225,72,41,51,107,253,19,188};
        byte[] ntpData = new byte[24];
        for (int i = 0; i < 24; i++) {
            ntpData[i] = (byte) data[i];
        }
        System.out.println(timestampToString(decodeTimestamp(ntpData,0)));
    }
}
