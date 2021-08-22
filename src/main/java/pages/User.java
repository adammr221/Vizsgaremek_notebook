package pages;

//This class is used in HomePage class in a function called "SaveJsonFileContentInArray".
//The function mentioned above is run by a test called "testSuccessfulSubscribtionForNewsLetter" (input_data_from_source package).
public class User {

    private String firstName;
    private String lastName;
    private String email;


    public User(String firstname, String lastname, String email) {
        this.setFirstName(firstname);
        this.setLastName(lastname);
        this.setEmail(email);
    }

    //Setters
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    //Getters
    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

}
