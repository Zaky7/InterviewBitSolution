package String;

public class CompareVersions {

    /***
     * 
     * @param A String 1
     * @param B String 2
     * @return 1 if version A > version B -1 if version A < version B 0 if both
     *         version are same
     */
    public int compareVersion(String A, String B) {
        String[] versionArr1 = A.split("\\.");
        String[] versionArr2 = B.split("\\.");

        int len = versionArr1.length > versionArr2.length ? versionArr2.length : versionArr1.length;

        try {
            for (int i = 0; i < len; i++) {
                System.out.println(versionArr1[i] + " " + versionArr2[i]);
                Integer versionCode1 = Integer.parseInt(versionArr1[i]);
                Integer versionCode2 = Integer.parseInt(versionArr2[i]);
                if (versionCode1 < versionCode2) {
                    return -1;
                } else if (versionCode1 > versionCode2) {
                    return 1;
                }
            }
        } catch (Exception e) {
            // TODO: handle exception
            System.out.println(e);
            throw new ClassCastException();
        }

        if (versionArr1.length != versionArr2.length) {
            if (versionArr1.length > versionArr2.length) {
                return 1;
            } else {
                return -1;
            }
        }

        // Both the string are equal return 0
        return 0;
    }

    public static void main(String[] args) {
        String A = "13.0";
        String B = "13.0.8";
        CompareVersions cv = new CompareVersions();
        int result = cv.compareVersion(A, B);
        System.out.println(result);
    }

}