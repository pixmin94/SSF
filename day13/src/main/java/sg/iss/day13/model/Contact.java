package sg.iss.day13.model;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.NotEmpty;

public class Contact {
    @NotNull(message="Name cannot be empty")
    private String name;

    @NotEmpty(message="Email cannot be empty")
    private String email;

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
    
}
