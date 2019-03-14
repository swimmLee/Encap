package lab4;
/**
 */
public class MyCompany {
    private HRDept hr;
    
    public MyCompany(){
        hr = new HRDept();
    }
    
    public void hireEmployee(String firstName, String lastName, String ssn){
        hr.hireEmployee(firstName, lastName, ssn);
        hr.outputReport(ssn);
    }
    public HRDept getHr(){
        return hr;
    }
    
    public void setHr(HRDept hr){
        this.hr = hr;
    }
}
