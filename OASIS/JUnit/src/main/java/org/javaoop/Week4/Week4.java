package org.javaoop.Week4;

public class Week4 {
    /**
     * Return the larger of a pair of integers.
     * @param a 1st integer
     * @param b 2nd integer
     * @return a if a is bigger, b if b is bigger
     */
    public static int max2Int(int a, int b) {
        return a > b ? a : b;
    }

    /**
     * Return the minimum of an array of integers.
     * @param array an array of integers
     * @return the minimum of the array
     */
    public static int minArray(int[] array) {
        int min = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i] < min) {
                min = array[i];
            }
        }

        return min;
    }

    /**
     * Return classifications given the weight and height via BMI categories.
     * @param weight given weight
     * @param height given height
     * @return the category of BMI a person with given weight and height  
     */
    public static String calculateBMI(double weight, double height){
        double bmi = Math.round((weight / (height * height)) * 10.0) / 10.0;

        System.out.println(bmi + "");

        if (bmi < 18.5) {
            return "Thiếu cân";
        }

        if (bmi < 23) {
            return "Bình thường";
        }

        if (bmi < 25) {
            return "Thừa cân";
        }

        return "Béo phì";
    }

    // public static void main(String[] args) {
    //     System.out.println(Week4.calculateBMI(80, 20));
    //     System.out.println(Week4.calculateBMI(60, 1.7));
    //     System.out.println(Week4.calculateBMI(70, 1.7));
    //     System.out.println(Week4.calculateBMI(90, 1.7));
    //     System.out.println(Week4.calculateBMI(50, 1.65));
    // }
}
 