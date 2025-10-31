public class Main {
    public static void main(String[] args) {
        try {
            String fileContent = java.nio.file.Files.readString(
                java.nio.file.Paths.get("RandomNumberUtils.txt")
            );
            java.util.List<String> methods = Week10.getAllFunctions(fileContent);
            System.out.println("Found methods:");
            for (String m : methods) {
                System.out.println(m);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }



        String test = """
        package com.test;
        import com.nordstrom.common.jdbc.utils.QueryAPI;
        import com.nordstrom.common.jdbc.Param;
        
        public class Test {
            public static void update(QueryAPI api, Object... args) {}
            public static void executeStoredProcedure(Class<?> c, String s1, String s2, Param... params) {}
        }
        """;
        
        java.util.List<String> methods = Week10.getAllFunctions(test);
        System.out.println("\n=== FINAL RESULTS ===");
        for (String m : methods) {
            System.out.println(m);
        }
    }
}
