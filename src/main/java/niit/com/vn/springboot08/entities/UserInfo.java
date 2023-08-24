package niit.com.vn.springboot08.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.Data;

@Data
@Entity(name = "user_infos")
public class UserInfo {
    @jakarta.persistence.Id
    private Long id;

    private String phone;
    private String address;

    @OneToOne()
    @JoinColumn(name = "user_id")
    public User user;
}
