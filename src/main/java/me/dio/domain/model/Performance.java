package me.dio.domain.model;

import jakarta.persistence.*;

@Entity(name = "tb_performance")
public class Performance {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Double averageGrade;
    private Integer attendancePercentage;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getAverageGrade() {
        return averageGrade;
    }

    public void setAverageGrade(Double averageGrade) {
        this.averageGrade = averageGrade;
    }

    public Integer getAttendancePercentage() {
        return attendancePercentage;
    }

    public void setAttendancePercentage(Integer attendancePercentage) {
        this.attendancePercentage = attendancePercentage;
    }
}
