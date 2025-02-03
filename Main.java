
public class Main {

    public static void main(String[] args) {
        try {
            System.out.println(Q1(new int[]{7, 1, 5, 3, 6, 4}));
            System.out.println(Q1(new int[]{7, 6, 4, 3, 1}));
            System.out.println(Q2("1.01", "1.001"));
            System.out.println(Q2("1.0", "1.0.0"));
            System.out.println(Q2("0.1", "1.1"));
            System.out.println(Q3(2));
            System.out.println(Q3(3));

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    public static int Q1(int[] prices) throws Exception {
        int maxProfit = 0;
        if (prices.length < 1 || prices.length > 100000) {
            throw new Exception("Prices length must be between 1 and 100000.");
        }

        int minPrice = Integer.MAX_VALUE;

        for (int price : prices) {
            if (price < 0 || price > 100000) {
                throw new Exception("Price must be between 0 and 100000.");
            }

            if (price < minPrice) {
                minPrice = price;
            } else {
                maxProfit = Math.max(maxProfit, price - minPrice);
            }
        }
        return maxProfit;
    }

    public static int Q2(String version1, String version2) throws Exception {
        if (version1.length() < 1 || version1.length() > 500 || version2.length() < 1 || version2.length() > 500) {
            throw new Exception("Version lengths must be between 1 and 500 characters.");
        }

        if (!version1.matches("\\d+(\\.\\d+)*") || !version2.matches("\\d+(\\.\\d+)*")) {
            throw new Exception("Versions must contain only digits and dots.");
        }

        String[] v1 = version1.split("\\.");
        String[] v2 = version2.split("\\.");

        int maxLength = Math.max(v1.length, v2.length);
        for (int i = 0; i < maxLength; i++) {
            int num1 = 0;
            int num2 = 0;

            if (i < v1.length) {
                num1 = Integer.parseInt(v1[i]);
            }
            if (i < v2.length) {
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

    public static int Q3(int n) throws Exception {
        if (n < 1 || n > 45) {
            throw new Exception("n must be between 1 and 45.");
        }
        if(n == 1) {
            return 1;
        }

        int firstStep = 1;
        int secondStep = 2;

        for (int i = 3; i <= n; i++) {
            int thirdStep = firstStep + secondStep;
            firstStep = secondStep;
            secondStep = thirdStep;
        }

        return secondStep;
    }
}

