package sg.iss.day13.model;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.NotEmpty;
import java.util.Random;
import java.io.Serializable;

public class Contact implements Serializable {
    @NotNull(message="Name cannot be empty")
    private String name;

    @NotEmpty(message="Email cannot be empty")
    private String email;

    private String id;

    public Contact() {
        this.id = generateId();
    }

    public Contact(String id, String name, String email){
        this.id = id;
        this.name = name;
        this.email = email;
    }

    private String generateId() {
        Random r = new Random();
        StringBuilder sb = new StringBuilder();
        while(sb.length() < 8) {
            sb.append(Integer.toHexString(r.nextInt()));
        }
        return sb.toString().substring(0, 8);
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

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Contact [name=" + name + ", email=" + email + ", id=" + id + "]";
    }
    
}
