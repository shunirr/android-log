package jp.s5r.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Log {
  public static final boolean ENABLE_LOG = true;

  public static final String TAG_NAME     = "AndroidLog";
  public static final String PACKAGE_NAME = "jp.s5r.";

  protected Log() {}

  public static void d(String message) {
    if (!ENABLE_LOG) {
      return;
    }
    if (android.util.Log.isLoggable(TAG_NAME, android.util.Log.DEBUG)) {
      dTime(TAG_NAME, "<" + getCallMethodName() + "> " + message);
    }
  }

  public static void d(String variableName, boolean value) {
    if (!ENABLE_LOG) {
      return;
    }
    if (android.util.Log.isLoggable(TAG_NAME, android.util.Log.DEBUG)) {
      dTime(TAG_NAME, "<" + getCallMethodName() + "> " +
          variableName + ":" + ((value) ? "true" : "false"));
    }
  }

  public static void v(String message) {
    if (!ENABLE_LOG) {
      return;
    }
    if (android.util.Log.isLoggable(TAG_NAME, android.util.Log.VERBOSE)) {
      vTime(TAG_NAME, "<" + getCallMethodName() + "> " + message);
    }
  }

  public static void e(String message) {
    if (!ENABLE_LOG) {
      return;
    }
    if (android.util.Log.isLoggable(TAG_NAME, android.util.Log.ERROR)) {
      eTime(TAG_NAME, "<" + getCallMethodName() + "> " + message);
    }
  }

  public static void e(Throwable t) {
    if (!ENABLE_LOG) {
      return;
    }
    if (android.util.Log.isLoggable(TAG_NAME, android.util.Log.ERROR)) {
      eTime(TAG_NAME, "<" + getCallMethodName() + "> ", t);
    }
  }

  public static void i(String message) {
    if (!ENABLE_LOG) {
      return;
    }
    if (android.util.Log.isLoggable(TAG_NAME, android.util.Log.INFO)) {
      iTime(TAG_NAME, "<" + getCallMethodName() + "> " + message);
    }
  }

  public static void w(String message) {
    if (!ENABLE_LOG) {
      return;
    }
    if (android.util.Log.isLoggable(TAG_NAME, android.util.Log.WARN)) {
      wTime(TAG_NAME, "<" + getCallMethodName() + "> " + message);
    }
  }

  public static void trace() {
    if (!ENABLE_LOG) {
      return;
    }
    if (android.util.Log.isLoggable(TAG_NAME, android.util.Log.INFO)) {
      iTime(TAG_NAME, "<" + getCallMethodName() + ">");
    }
  }

  private static final SimpleDateFormat SDF = new SimpleDateFormat("HH:mm:ss");

  private static void dTime(String tag, String message) {
    Date d = new Date();
    android.util.Log.d(tag, "[" + SDF.format(d) + "] " + message);
  }

  private static void vTime(String tag, String message) {
    Date d = new Date();
    android.util.Log.v(tag, "[" + SDF.format(d) + "] " + message);
  }

  private static void eTime(String tag, String message) {
    Date d = new Date();
    android.util.Log.e(tag, "[" + SDF.format(d) + "] " + message);
  }

  private static void eTime(String tag, String message, Throwable t) {
    Date d = new Date();
    android.util.Log.e(tag, "[" + SDF.format(d) + "] " + message, t);
  }

  private static void iTime(String tag, String message) {
    Date d = new Date();
    android.util.Log.i(tag, "[" + SDF.format(d) + "] " + message);
  }

  private static void wTime(String tag, String message) {
    Date d = new Date();
    android.util.Log.v(tag, "[" + SDF.format(d) + "] " + message);
  }

  private static String getCallMethodName() {
    Throwable t = new Throwable();
    StackTraceElement element = t.getStackTrace()[2];
    String className  = element.getClassName().replace(PACKAGE_NAME, "");
    String methodName = element.getMethodName();

    return className + "/" + methodName;
  }
}
