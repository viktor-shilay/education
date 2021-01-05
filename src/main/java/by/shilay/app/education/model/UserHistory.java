package by.shilay.app.education.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.util.Date;

@Data
@Entity
@Table(name = "users_history")
public class UserHistory {

    @Id
    @Column
    private Long id;

    @Column(name = "date")
    private Date date;

    @Column(name = "reason")
    private String reason;

    @OneToOne
    @MapsId
    @JoinColumn(name = "admin")
    private User admin;

    @OneToOne
    @JoinColumn (name = "target_user")
    private User targetUser;

}
