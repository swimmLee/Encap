package lab2;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * In this lab focus on METHOD encapsulation and fix/add code as necessary.
 * Pay special attention to the following issues:
 *    1. Not all methods need to be public
 *    2. When methods need to be called in a certain order you can do this
 *       by creating a parent method that calls the other, helper methods.
 *    3. There is some duplicate code used that violates the D.R.Y. principle.
 *       Eliminate that by encapsulating the duplicate code in a new method
 *       and then call that method in place of the duplicate code
 *    4. All method parameters should be validated.
 * 
 * Review the tips in the document "EncapCheckList.pdf" if needed.
 */
public class Employee {
    private String firstName;
    private String lastName;
    private String ssn;
    private boolean metWithHr;
    private boolean metDeptStaff;
    private boolean reviewedDeptPolicies;
    private boolean movedIn;
    private String cubeId;
    private Date orientationDate;

    public Employee(String firstName, String lastName, String ssn) {
        this.firstName = this.setFirstName(firstName);
        this.lastName = lastName;
        this.ssn = ssn;
    }
    
    public void meetAndOrientation(String cubeId){
        meetWithHrForBenefitAndSalaryInfo();
        meetDepartmentStaff();
        reviewDeptPolicies();
        moveIntoCubicle(cubeId);
        
    }

    // Assume this must be performed first, and assume that an employee
    // would only do this once, upon being hired.
    private void meetWithHrForBenefitAndSalaryInfo() {
        metWithHr = true;
        String message = setName() + " met with Hr on ";
        makeMessage(message);
    }

    // Assume this must be performed second, and assume that an employee
    // would only do this once, upon being hired.
    private void meetDepartmentStaff() {
        metDeptStaff = true;
        String message = setName() + " met with Dept. Staff on ";
        makeMessage(message);
    }

    // Assume this must be performed third. And assume that because department
    // policies may change that this method may need to be called 
    // independently from other classes.
    public void reviewDeptPolicies() {
        reviewedDeptPolicies = true;
        String message = setName() + " reviewed Dept policies on ";
        makeMessage(message);
    }

    // Assume this must be performed 4th. And assume that because employees
    // sometimes change office locations that this method may need to be called 
    // independently from other classes.
    public void moveIntoCubicle(String cubeId) {
        this.cubeId = cubeId;
        this.movedIn = true;
        String message = setName() + " moved into cubicle "
                + cubeId + " on ";
        makeMessage(message);
        makeMessage(setName() + " moved into cubicle "
                + cubeId + " on ");
    }
    
    private String setName(){
        String str = firstName + " " + lastName;
        return str;
    }
    
    private void makeMessage(String message){
        SimpleDateFormat sdf = new SimpleDateFormat("M/d/yyyy");
        String fmtDate = sdf.format(orientationDate);        
        System.out.println(message + fmtDate);
    }
    
    public String getFirstName() {
        return firstName;
    }

    // setter methods give the developer the power to control what data is
    // allowed through validation.
    
    private String setFirstName(String firstName) {
        if( !firstName.equalsIgnoreCase("")){
            return firstName;
        }
        String message = "First Name is Required, cannot be blank.";
        setMessage(message);
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    private String setLastName(String lastName) {
       if( !lastName.equalsIgnoreCase("")){
            return lastName;
        }
        String message = "Last Name is Required, cannot be blank.";
        setMessage(message);
        return lastName;
    }

    public String getSsn() {
        return ssn;
    }

    private String setSsn(String ssn) {
        if( ssn.length() >= 9 && ssn.length() <= 11){
            return ssn;
        }
        String message = "Not a Legal Social Security Number.";
        setMessage(message);
        return ssn = "";
    }
    
    private void setMessage(String message){
        System.out.println(message);
    }

    public boolean isMetWithHr() {
        return metWithHr;
    }

    // boolean parameters need no validation
    private void setMetWithHr(boolean metWithHr) {
        this.metWithHr = metWithHr;
    }

    public boolean isMetDeptStaff() {
        return metDeptStaff;
    }

    private void setMetDeptStaff(boolean metDeptStaff) {
        this.metDeptStaff = metDeptStaff;
    }

    public boolean isReviewedDeptPolicies() {
        return reviewedDeptPolicies;
    }

    private void setReviewedDeptPolicies(boolean reviewedDeptPolicies) {
        this.reviewedDeptPolicies = reviewedDeptPolicies;
    }

    public boolean isMovedIn() {
        return movedIn;
    }

    private void setMovedIn(boolean movedIn) {
        this.movedIn = movedIn;
    }

    public String getCubeId() {
        return cubeId;
    }

    private void setCubeId(String cubeId) {
        this.cubeId = cubeId;
    }

    public Date getOrientationDate() {
        return orientationDate;
    }

    private void setOrientationDate(Date orientationDate) {
        this.orientationDate = orientationDate;
    }
}
