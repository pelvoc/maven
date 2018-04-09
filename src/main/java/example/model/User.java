package example.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import lombok.Data;

@Entity
@Table(name = "auser")
@Data
public class User implements Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String userName;
        
        @Column(name = "password", length = 128, nullable = false)
	private String password;
        
        @Temporal(javax.persistence.TemporalType.TIMESTAMP)
	private Date createdAt;
	
	public User() {
	}	
	
	public User(String userName, String password) {
		this.userName = userName;
		this.password = password;
                this.createdAt = new Date();
	}
}
