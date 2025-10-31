import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Week10 {
    private static final Pattern PACKAGE = Pattern.compile(
        "package\\s+([^;]+)\\s*;",
        Pattern.MULTILINE
    );

    private static final Pattern IMPORTS = Pattern.compile(
        "import\\s+(?:static\\s+)?([\\w.]+);",
        Pattern.MULTILINE
    );

    private static final Pattern CLASSES = Pattern.compile(
        "^\\s*" // indentation if exists
         + "(?:(?:abstract|public|private|protected|static|final)\\s+)*"
         + "(class|interface|enum)\\s+"
         + "([^<\\s]+)" // class name, captures until <, example get Foo from Foo<T>
         + "([^{]+)?" // everthing until {
         + "\\s*\\{",
        Pattern.MULTILINE
    );

    private static final Pattern STATIC_METHODS = Pattern.compile(
        "(?:public|private|protected)?" // captures level of access modifiers
         + "\\s+static\\s+" // " " + static " " (at least 1 space each)
         + "(?:[\\w<>\\[\\],\\s]+?)" // group 1: return type
         + "\\s+" // at least 1 whitespace
         + "(\\w+)" // group 2: captures method's name like (at least 1 char) 
         + "\\s*\\(([^)]*)\\)", // group 3: any char except 
         Pattern.MULTILINE
    ); 

    private static final Map<String, String> dataMap = new HashMap<>();

    private static Matcher matcher;
    
    /**
     * Get all static methods in the file.
     * 
     * @param fileContent file directory
     * @return list of static methods with their parameters
     */
    public static List<String> getAllFunctions(String fileContent) {
        dataMap.clear();
        List<String> methods = new ArrayList<>();

        fileContent = removeComments(fileContent);

        String packageName = handlePackages(fileContent);
        handleClasses(fileContent, packageName);
        handleImports(fileContent);
        
        matcher = STATIC_METHODS.matcher(fileContent);

        while (matcher.find()) {
            String methodName = matcher.group(1);
            String params = matcher.group(2);
            params = formattingParams(params);
            methods.add(methodName + "(" + params + ")");
        }

        return methods;
    }

    /**
     * Get the package name of the file.
     * 
     * @param fileContent file directory
     * @return package name
     */
    private static String handlePackages(String fileContent) {
        matcher = PACKAGE.matcher(fileContent);
        if (matcher.find()) {
            return matcher.group(1).trim();
        }

        return "";
    }

    /**
     * Get all imports in the file and put them into dataMap.
     * 
     * @param fileContent file directory
     */
    private static void handleImports(String fileContent) {
        matcher = IMPORTS.matcher(fileContent);
        while (matcher.find()) {
            String fullImp = matcher.group(1);
            int lastDot = fullImp.lastIndexOf('.');
            String nameImp = fullImp.substring(lastDot + 1);
            
            dataMap.put(nameImp, fullImp);
        }
    }

    /**
     * Get all classes in the file and put them into dataMap.
     * 
     * @param fileContent file directory
     * @param pack package name
     */
    private static void handleClasses(String fileContent, String pack) {
        matcher = CLASSES.matcher(fileContent);
        while (matcher.find()) {
            String className = matcher.group(2);
            if (!pack.isEmpty()) {
                dataMap.put(className, pack + "." + className);
            } else {
                dataMap.put(className, className);  // no package case
            }
        }
    }

    /**
     * Get the correct type with full package name.
     * 
     * @param type original type
     * @return correct type with full package name
     */
    private static String getCorrectType(String type) {
        if (type.endsWith("[]")) {
            String baseType = type.substring(0, type.length() - 2);

            return (baseType.length() == 1)
             ? baseType + "[]"
             : getCorrectType(baseType) + "[]";
        }
        if (type.endsWith("...")) {
            String baseType = type.substring(0, type.length() - 3);

            return getCorrectType(baseType);
        }
        if (dataMap.containsKey(type)) {
            return dataMap.get(type);
        }    
        if (type.matches("[A-Z]\\w*")) {
            return type.length() == 1 ? type : "java.lang." + type;
        } 
        if (type.contains("<")) {
            String[] parts = type.split("<");
            parts[0] = getCorrectType(parts[0]);
            parts[1] = getCorrectType(parts[1].replace(">", ""));

            return String.format(
                "%s<%s>",
                parts[0],
                parts[1]
            );
        }

        return type;
    }

    /**
     * Removes all comments from the input file.
     * 
     * @param fileContent file directory
     * @return file with comments removed
     */
    private static String removeComments(String fileContent) {
        // removes single line comments
        fileContent = fileContent.replaceAll("//.*", "");
        // removes multi line comments
        fileContent = fileContent.replaceAll("(?s)/\\*.*?\\*/", "");
        return fileContent;
    }

    /**
     * Format the param so that only types remained.
     * 
     * @param params orginal parameters of the method
     * @return the types only of the parameters 
     */
    private static String formattingParams(String params) {
        if (params.isEmpty()) {
            return "";
        }

        String[] paramArray = params.split(",");
        List<String> types = new ArrayList<>();

        for (String p : paramArray) {
            p = p.trim();

            int lastSpace = p.lastIndexOf(' ');
            if (lastSpace > 0) {
                String type = p.substring(0, lastSpace);
                types.add(getCorrectType(type));
            }
        }

        return String.join(",", types);
    }
}
