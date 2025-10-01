public class Staff extends Person {
    private String school;
    private double pay;

    /**
     * Constructs a {@code Staff} object with the specified personal details
     * and work information.
     *
     * @param name    the staff member's name
     * @param address the staff member's address
     * @param school  the school where the staff member works
     * @param pay     the staff member's pay
     */
    public Staff(String name, String address, String school, double pay) {
        super(name, address);
        this.school = school;
        this.pay = pay;
    }

    /**
     * Returns the school where the staff member works.
     *
     * @return the school
     */
    public String getSchool() {
        return school;
    }

    /**
     * Sets the school where the staff member works.
     *
     * @param school the new school
     */
    public void setSchool(String school) {
        this.school = school;
    }

    /**
     * Returns the pay of the staff member.
     *
     * @return the pay
     */
    public double getPay() {
        return pay;
    }

    /**
     * Sets the pay of the staff member.
     *
     * @param pay the new pay
     */
    public void setPay(double pay) {
        this.pay = pay;
    }

    @Override
    public String toString() {
        return "Staff[" + super.toString() 
                + ",school=" + school 
                + ",pay=" + pay + "]";
    }
}