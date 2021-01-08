package cn.sliew.milky.common.exception;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;

public final class ThrowableUtil {

    /**
     * Gets the stack trace from a Throwable as a String.
     *
     * @param cause the {@link Throwable} to be examined
     * @return the stack trace as generated by {@link Throwable#printStackTrace(java.io.PrintWriter)} method.
     */
    public static String stackTraceToString(Throwable cause) {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        PrintStream pout = new PrintStream(out);
        cause.printStackTrace(pout);
        pout.flush();
        try {
            return new String(out.toByteArray());
        } finally {
            try {
                out.close();
            } catch (IOException ignore) {
                // ignore as should never happen
            }
        }
    }

    private ThrowableUtil() {
        throw new IllegalStateException("cant do this");
    }
}