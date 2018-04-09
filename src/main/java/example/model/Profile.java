package example.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import lombok.Data;

/**
 *
 * @author davis
 */
@Entity
@Table(name = "profile")
@Data
public class Profile implements Serializable {
        
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;
        
        @OneToOne
        @JoinColumn(name = "user_id", referencedColumnName = "id", nullable = false)
        private User user;
        
        @Column(name = "birthdate", nullable = false)
        @Temporal(javax.persistence.TemporalType.TIMESTAMP)
        private Date birthdate;
        
        @Column(name = "phone_number", nullable = false)
        private String phoneNumber;
        
        
}
