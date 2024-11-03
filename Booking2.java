public class Booking2 {
  private String name;
  private String dob;
  private int age;
  private String gender;
  private long adh;
  private long pp;
  private String seat;

  public Booking2(String name, String dob, int age, String gender, long adh, long pp, String seat) {
    this.name = name;
    this.dob = dob;
    this.age = age;
    this.gender = gender;
    this.adh = adh;
    this.pp = pp;
    this.seat = seat;
  }

  // Getters and setters for the fields
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getDob() {
    return dob;
  }

  public void setDob(String dob) {
    this.dob = dob;
  }

  public int getAge() {
    return age;
  }

  public void setAge(int age) {
    this.age = age;
  }

  public String getGender() {
    return gender;
  }

  public void setGender(String gender) {
    this.gender = gender;
  }

  public long getAdh() {
    return adh;
  }

  public void setAdh(int adh) {
    this.adh = adh;
  }

  public long getPp() {
    return pp;
  }

  public void setPp(int pp) {
    this.pp = pp;
  }

  public String getSeat() {
    return seat;
  }

  public void setSeat(String seat) {
    this.seat = seat;
  }
}
