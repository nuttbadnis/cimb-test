
public class Main {

    public static void main(String[] args) {
        System.out.println(Q2("1.0", "1.0.0"));
    }

    public static void Q1() {

    }

    public static int Q2(String version1, String version2) {

        if (version1.length() < 1 || version1.length() > 500 || version2.length() < 1 || version2.length() > 500) {
            throw new IllegalArgumentException("Version lengths must be between 1 and 500 characters.");
        }

        if (!version1.matches("\\d+(\\.\\d+)*") || !version2.matches("\\d+(\\.\\d+)*")) {
            throw new IllegalArgumentException("Versions must contain only digits and dots.");
        }

        String[] v1 = version1.split("\\.");
        String[] v2 = version2.split("\\.");

        int maxLength = Math.max(v1.length, v2.length);
        for (int i = 0; i < maxLength; i++) {
            int num1 = 0;
            int num2 = 0;

            if(i < v1.length){
                num1 = Integer.parseInt(v1[i]);
            }
            if(i < v2.length){
                num2 = Integer.parseInt(v2[i]);
            }

            if (num1 < num2) {
                return -1;
            } else if (num1 > num2) {
                return 1;
            }
        }

        return 0;
    }

    public static int Q3(String version1, String version2){

    }
}
