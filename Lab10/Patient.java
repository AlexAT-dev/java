package com.example.lab10;

import java.util.Date;

public class Patient {
    public int id;
    public String surname;
    public String name;
    public Date birthday;
    public String phone;
    public int visited;

    public int getId()
    {
        return id;
    }

    public String getSurname()
    {
        return surname;
    }

    public String getName()
    {
        return name;
    }

    public Date getBirthday()
    {
        return birthday;
    }


    public String getPhone()
    {
        return phone;
    }

    public int getVisited()
    {
        return visited;
    }

    public Patient(int id, String surname, String name, Date birthday, String phone, int visited)
    {
        this.id = id;
        this.surname = surname;
        this.name = name;
        this.birthday = birthday;
        this.phone = phone;
        this.visited = visited;
    }
}
