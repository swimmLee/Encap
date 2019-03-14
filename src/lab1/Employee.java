package lab1;

import java.util.Date;

/**
 * Fix the code in this class to do PROPERTY encapsulation correctly. Also
 * consider if any of the properties should be mandatory and use a constructor
 * to enforce that. Review the tips in the document "EncapCheckList.pdf" if
 * needed.
 */

public class Employee {

    private String firstName;
    private String lastName;
    private String ssn;
    private boolean metWithHr;
    private boolean metDeptStaff;
    private boolean reviewedDeptPolicies;
    private boolean movedIn;
    protected String cubeId;
    private Date orientationDate;
    
    public Employee(String first, String last, String ssn){
        this.firstName = setFirstName(first);
        this.lastName = setLastName(last);
        this.ssn = setSSN(ssn);
    }
    
    private String setFirstName(String first){
        String str;
        if( !first.equals("") ){
            str = first;
        }
        else{
            String message = "First Name is required";
            str = "";
        }
        return str;
    }
    
    private String setLastName(String last){
        String str;
        if( !last.equals("") ){
            str = last;
        }
        else{
            String message = "Last Name is required";
            str = "";
        }
        return str;
    }
    
    private String setSSN(String ssn){
        //check SSN format
        String str = "";
        if(ssn.length() >= 9 && ssn.length() <= 11){
            str = ssn;
        }
        else{
            String message = "Not a legal Social Security Number Format.";
            this.ssn = "";
        }
        return str;
    }
}
