package xmr;

/**
 * Created by xmr on 2018/8/28.
 */
public class PathUtil {
    public static String getProjectPath() {

        java.net.URL url = PathUtil.class .getProtectionDomain().getCodeSource().getLocation();
        String filePath = null ;
        try {
            filePath = java.net.URLDecoder.decode (url.getPath(), "utf-8");
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (filePath.endsWith(".jar"))
            filePath = filePath.substring(0, filePath.lastIndexOf("/") + 1);
        java.io.File file = new java.io.File(filePath);
        filePath = file.getAbsolutePath();
        return filePath;
    }

    public static void main(String[] args) {
        String ss=getProjectPath();
        System.out.println(ss);
    }
}
