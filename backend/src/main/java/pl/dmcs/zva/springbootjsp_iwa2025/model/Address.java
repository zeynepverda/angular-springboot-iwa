package pl.dmcs.zva.springbootjsp_iwa2025.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import org.springframework.boot.autoconfigure.web.WebProperties;

import javax.annotation.processing.Generated;
import java.util.List;

@Entity
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    long id;

    @JsonManagedReference
    @OneToMany(mappedBy = "address", fetch = FetchType.EAGER)
    //@JoinTable(name="student_address", joinColumns=@JoinColumn(name="student_id"), inverseJoinColumns= @JoinColumn(name="address_id"))
    private List<Student> studentList;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public List<Student> getStudentList() {
        return studentList;
    }

    public void setStudentList(List<Student> studentList) {
        this.studentList = studentList;
    }
}
