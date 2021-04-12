package paysys;
/**
 * @author Rory Young
 */
public class Name {
        private String firstName;
        private String middleName;
        private String lastName;

    /**
     * @param fName First name of employee.
     * @param mName Middle name of employee.
     * @param lName Last name of employee.
     */
    public Name(String fName, String mName, String lName) {
            this.firstName = fName;
            this.middleName = mName;
            this.lastName = lName;
        }

        /**
         * @param fName First name of employee.
         */
        public void setFirstName(String fName) {
            this.firstName = fName;
        }

        /**
         * @param mName Middle name of employee.
         */
        public void setMiddleName(String mName) {
            this.middleName = mName;
        }

        /**
         * @param lName Last name of employee.
         */
        public void setLastName(String lName) {
            this.lastName = lName;
        }

        /**
         * @return the first name of employee.
         */
        public String getFirstName() {
            return this.firstName;
        }

    /**
     * @return the middle name of employee.
     */
    public String getMiddleName() {
        return this.middleName;
    }

    /**
         * @return the last name of employee.
         */
        public String getLastName() {
            return this.lastName;
        }


        /**
         * @return the first, middle and last name of employee.
         */
        public String toString() {
            return this.firstName + " " + this.middleName + " " + this.lastName;
        }
}
