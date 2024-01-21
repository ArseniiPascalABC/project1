package ru.alishev.springcourse.models;

import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import org.springframework.format.annotation.DateTimeFormat;

public class Person {
    private int id;

    @Pattern(regexp = "[А-Я][а-я]+ [А-Я][а-я]+ [А-Я][а-я]+", message = "Формат ФИО: \"Иванов Иван Иванович\"")
    @Size(max = 70, message = "Длина должна быть менее 70-ти символов")
    private String fio;

    @DateTimeFormat
    private String dob;

    public Person() {

    }
    public Person(int id, String fio, String dob) {
        this.id = id;
        this.fio = fio;
        this.dob = dob;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFio() {
        return fio;
    }

    public void setFio(String fio) {
        this.fio = fio;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }
}
