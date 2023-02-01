public class People {

    int age;

    String lastName;
    String gender;
    String occupation;
    public People (String lastName, int age, String gender, String occupation){
        this.age = age;
        this.lastName = lastName;
        this.gender = gender;
        this.occupation = occupation;
    }

    public int getAge() {
        return age;
    }

    public String getLastName() {
        return lastName;
    }

    public String getGender() {
        return gender;
    }

    public String getOccupation() {
        return occupation;
    }

}
