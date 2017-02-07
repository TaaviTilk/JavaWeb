package model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Data
@Table(name = "CUSTOMER")
public class Vorm {

    @Id
    @SequenceGenerator(name = "my_seq", sequenceName = "seq1", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "my_seq")
    private Integer id;


    @Column(name = "first_name")
    private String firstName;


    @Column(name = "last_name")
    private String lastName;


    @Column(name = "email")
    private String eMail;


    @Column(name = "synniaeg")
    private String synniaeg;

    @Column(name = "aadress")
    private String aadress;




    public void setId(int id) {
        this.id = id;
    }
    public Integer getId() {
        return id;
    }

    public void setFirstName(String fn) {
        this.firstName = fn;
    }
    public String getFirstName() {
        return firstName;
    }

    public void setLastName(String ln) {
        this.lastName = ln;
    }
    public String getLastName() {
        return lastName;
    }

    public void seteMail(String eMail) {this.eMail = eMail; }
    public String geteMail() {return eMail;}

    public void setsynniaeg(String synniaeg) {this.synniaeg = synniaeg; }
    public String getsynniaeg() {return synniaeg;}

    public void setaadress(String aadress) {this.aadress = aadress; }
    public String getaadress() {return aadress;}


}
