package pl.coderslab.demo.entities;

import lombok.*;

import java.util.List;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Student {

    private String firstName;
    private String lastName;
    private String gender;
    private String country;
    private String notes;
    private boolean mailingList;
    private List<String> programmingSkills;
    private List<String> hobbies;

}
