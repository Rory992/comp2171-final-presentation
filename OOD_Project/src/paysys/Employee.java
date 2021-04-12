package paysys;

/**
 * @author Rory Young
 */

public class Employee {
    private Name empName;
    private Address empAdd;
    private final int trn;
    private final char gender;
    private final String dob;
    private short empID;
    private Position pos;
    private float hours = 0;

    /**
     * @param trn
     * @param gender
     * @param fName
     * @param mName
     * @param lName
     **/
    public Employee(int trn, String dob, char gender, short id, String fName, String mName,
                    String lName, String country, String parish, String town, String street, byte pos, float hrs) {
        empName = new Name(fName, mName, lName);
        empAdd = new Address(country, parish, town, street);
        this.trn = trn;
        this.gender = gender;
        this.dob = dob;
        empID = id;
        setPosition(pos);
        hours = hrs;
    }

    public Employee(int trn, String dob, char gender, short id, String fName, String mName, String lName, byte pos) {
        empName = new Name(fName, mName, lName);
        this.trn = trn;
        this.gender = gender;
        this.dob = dob;
        this.empID = id;
        setPosition(pos);
    }

    public void setAddress(Address addr) {
        empAdd = addr;
    }

    /**
     * @return address
     */
    public Address getAddress() {
        return empAdd;
    }

    /**
     * @return name
     */
    public Name getName() {
        return empName;
    }

    /**
     * @param val
     */
    public void setHours(float val) {
        hours += val;
    }

    /**
     * @return hours
     */
    public float getHours() {
        return hours;
    }

    public void resetHours() {
        hours = 0;
    }

    /**
     * @param val
     */
    public void takeHours(float val) {
        hours -= val;
    }

    /**
     * @param val
     */
    public void setEmployeeID(short val) {
        empID = val;
    }

    /**
     * @return employeeID
     */
    public short getEmployeeID() {
        return empID;
    }

    public void setPosition(byte val) {
        if (val == 1) {
            pos = Position.JUNIORSTAFF;
        } else if (val == 0) {
            pos = Position.SENIORSTAFF;
        }
    }

    public Position getPosition() {
        return pos;
    }

    public String toString() {
        return empName.toString() + "\nId #: " + getEmployeeID() + "\nAddress: " + empAdd.toString() + "\nPosition: " + pos + "\nHours on file: " + getHours();
    }

    public char getGender() {
        return gender;
    }

    public int getTRN() {
        return trn;
    }

    public String getDOB() {
        return dob;
    }
}