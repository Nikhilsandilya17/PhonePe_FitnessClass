package model;

import enums.UserTier;

import java.util.ArrayList;
import java.util.List;

public class User {
    private String id;
    private String name;
    private String email;
    private UserTier userTier;
    private List<FitnessClass> bookedClasses;

    public User(String id, String name, String email, UserTier userTier) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.userTier = userTier;
        bookedClasses = new ArrayList<>();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public UserTier getUserTier() {
        return userTier;
    }

    public void setUserTier(UserTier userTier) {
        this.userTier = userTier;
    }

    public List<FitnessClass> getBookedClasses() {
        return bookedClasses;
    }

    public void setBookedClasses(List<FitnessClass> bookedClasses) {
        this.bookedClasses = bookedClasses;
    }
}
