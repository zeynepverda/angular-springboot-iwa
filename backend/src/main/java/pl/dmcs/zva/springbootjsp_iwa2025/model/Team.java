package pl.dmcs.zva.springbootjsp_iwa2025.model;

import jakarta.persistence.*;
import org.hibernate.service.spi.InjectService;

import java.util.List;

@Entity
public class Team {
    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

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

    @Id
    @GeneratedValue
    private long id;
    private String teamName;

    @ManyToMany(cascade= CascadeType.PERSIST)
    private List<Student> studentList;

}
