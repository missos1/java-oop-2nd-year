// package Exception2; 

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Week8Task2 {
    public void nullPointerEx() throws NullPointerException {
        throw new NullPointerException("Lỗi Null Pointer");  
    }

    /**
     * Test method for NullPointerException.
     * 
     * @return String message of the exception or 
     * "Không có lỗi" if no exception occurs
     */
    public String nullPointerExTest() {
        try {
            nullPointerEx();  
        } catch (NullPointerException e) {
            return e.getMessage();
        }
        return "Không có lỗi";
    }

    
    public void arrayIndexOutOfBoundsEx() throws ArrayIndexOutOfBoundsException {
        throw new ArrayIndexOutOfBoundsException(
            "Lỗi Array Index Out of Bounds"); 
    }

    /**
     * Test method for ArrayIndexOutOfBoundsException.
     * 
     * @return String message of the exception or 
     * "Không có lỗi" if no exception occurs
     */
    public String arrayIndexOutOfBoundsExTest() {
        try {
            this.arrayIndexOutOfBoundsEx();
         } catch (ArrayIndexOutOfBoundsException e) {
            return e.getMessage();
        }
        return "Không có lỗi";
    }

    public void arithmeticEx() throws ArithmeticException {
        throw new ArithmeticException("Lỗi Arithmetic");
    }

    /**
     * Test method for ArithmeticException.
     * 
     * @return String message of the exception 
     * or "Không có lỗi" if no exception occurs
     */
    public String arithmeticExTest() {
        try {
            this.arithmeticEx();
        } catch (ArithmeticException e) {
            return e.getMessage();
        }
        return "Không có lỗi";
    }
 
    public void fileNotFoundEx() throws FileNotFoundException {
        throw new FileNotFoundException("Lỗi File Not Found");
    }

    /**
     * Test method for FileNotFoundException.
     * 
     * @return String message of the exception 
     * or "Không có lỗi" if no exception occurs
     */
    public String fileNotFoundExTest() {
        try {
            this.fileNotFoundEx();
        } catch (FileNotFoundException e) {
            return e.getMessage();
        }
        return "Không có lỗi";
    }
 
    public void ioEx() throws IOException {
        throw new IOException("Lỗi IO");
    }

    /**
     * Test method for IOException.
     * 
     * @return String message of the exception 
     * or "Không có lỗi" if no exception occurs
     */
    public String ioExTest() {
        try {
            this.ioEx();
        } catch (IOException e) {
            return e.getMessage();
        }
        return "Không có lỗi";
    }
}