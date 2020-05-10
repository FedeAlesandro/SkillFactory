import java.util.Objects;
import java.util.UUID;

public class ClubMember implements Comparable<ClubMember>{

    private String name;
    private UUID id;
    private String phone;
    private Integer age;

    public ClubMember(String name, String phone, Integer age){
        this.name = name;
        this.id = UUID.randomUUID();
        this.phone = phone;
        this.age = age;
    }

    public String getName() {
        return name;
    }
    public UUID getId() {
        return id;
    }
    public boolean equalsByName(ClubMember member){
        return name.equals(member.name);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ClubMember)) return false;
        ClubMember that = (ClubMember) o;
        return name.equals(that.name) &&
                phone.equals(that.phone) &&
                age.equals(that.age);
    }
    @Override
    public int hashCode() {
        return Objects.hash(name, phone, age);
    }
    @Override
    public String toString() {
        return "Club Member: " +
                "Name = " + name +
                ", id = " + id +
                ", phone = " + phone +
                ", age = " + age;
    }
    @Override
    public int compareTo(ClubMember o) {
        return this.getName().compareTo(o.getName());
    }
}
