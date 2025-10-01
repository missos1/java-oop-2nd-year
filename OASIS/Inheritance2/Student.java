public class Student extends Person {
    private String program;
    private int year;
    private double fee;

    /**
     * Constructs a {@code Student} with the specified personal details
     * and academic information.
     *
     * @param name    the student's name
     * @param address the student's address
     * @param program the study program
     * @param year    the year of study
     * @param fee     the tuition fee
     */
    public Student(String name, String address, String program,
                   int year, double fee) {
        super(name, address);
        this.program = program;
        this.fee = fee;
        this.year = year;
    }

    /**
     * Returns the study program of the student.
     *
     * @return the program
     */
    public String getProgram() {
        return program;
    }

    /**
     * Sets the study program of the student.
     *
     * @param program the new program
     */
    public void setProgram(String program) {
        this.program = program;
    }

    /**
     * Returns the year of study.
     *
     * @return the year
     */
    public int getYear() {
        return year;
    }

    /**
     * Sets the year of study.
     *
     * @param year the new year
     */
    public void setYear(int year) {
        this.year = year;
    }

    /**
     * Returns the tuition fee.
     *
     * @return the fee
     */
    public double getFee() {
        return fee;
    }

    /**
     * Sets the tuition fee.
     *
     * @param fee the new fee
     */
    public void setFee(double fee) {
        this.fee = fee;
    }

    @Override
    public String toString() {
        return "Student[" + super.toString()
                + ",program=" + program
                + ",year=" + year 
                + ",fee=" + fee + "]";
    }
}
