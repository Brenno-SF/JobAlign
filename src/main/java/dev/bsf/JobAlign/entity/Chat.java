package dev.bsf.JobAlign.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Entity
@Table(name="chat_tb")
public class Chat {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "chat_id")
    private String chatId;
    @ManyToOne
    @JoinColumn(name = "user_id_fk", nullable = false)
    @JsonIgnore
    private User user;
    private String content;
    @Column(name = "created_at")
    @CreationTimestamp
    private LocalDateTime createdAT;
}
