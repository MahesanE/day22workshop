package sg.edu.nus.iss.day22_workshop.Model;

import java.sql.Date;

import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RSVP {

    @Id
    private Integer id;

    @Size(min = 2, max = 150, message = "Full name must be between 2 to 150 characters")
    @NotNull
    private String fullName;

    @Email(message = "Email must comply to email format")
    @Size(max = 150, message = "Email must be less than 150 characters")
    private String email;

    private String phone;

    private Date confirmationDate;

    private String comments;

}
