package com.init.learningPlatform.model;

import lombok.Data;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;

@Entity
@Table(name = "user_role_init_1")
@Data
public class UserRole {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "role", nullable = false, length = 50)
    private String role;

    @ManyToOne
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    public UserRole() {
    }

    public UserRole(User user, String role) {
        this.user = user;
        this.role = role;
    }
}
