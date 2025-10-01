public class Person {
    private String name;
    private String address;

    /**
     * Constructs a {@code Person} with the specified name and address.
     *
     * @param name    the person's name
     * @param address the person's address
     */
    public Person(String name, String address) {
        this.name = name;
        this.address = address;
    }

    /**
     * Returns the name of this person.
     *
     * @return the person's name
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name of this person.
     *
     * @param name the new name of the person
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Returns the address of this person.
     *
     * @return the person's address
     */
    public String getAddress() {
        return address;
    }

    /**
     * Sets the address of this person.
     *
     * @param address the new address of the person
     */
    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Person[name=" + name + ",address=" + address + "]";
    }
}
