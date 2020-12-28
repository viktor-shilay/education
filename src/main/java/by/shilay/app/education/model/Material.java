package by.shilay.app.education.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.Date;
import java.util.List;

@Data
@Entity
@Table(name = "materials")
public class Material {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "material_id")
    private Long id;

    @Column(name = "material_name")
    private String materialName;

    @Column(name = "creation_date")
    private Date creationDate;

    @Column(name = "type")
    private String type;

    @Column(name = "description")
    private String description;

    @OneToMany(mappedBy = "review")
    private List<Review> reviews;

    @ManyToOne
    @JoinColumn(name = "discipline_id")
    private Discipline discipline;

    /*@OneToMany(mappedBy = "material")
    private List<User> users;*/

}
