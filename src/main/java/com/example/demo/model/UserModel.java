
import java.lang.annotation.Inherited;

import javax.annotation.processing.Generated;

import sun.jvm.hotspot.gc.shared.Generation;
import sun.reflect.generics.reflectiveObjects.GenericArrayTypeImpl;


@Entity
public class UserModel {
    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    public Long edv;

    @Column
    public String name;

    @Column
    public String email;

    @Column
    public String password;

    public Long getEdv() {
        return edv;
    }

    public void setEdv(Long edv) {
        this.edv = edv;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Long getId() {
        return id;
    }

    
}
