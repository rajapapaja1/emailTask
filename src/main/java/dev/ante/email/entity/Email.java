package dev.ante.email.entity;

import dev.ante.email.common.ImportanceEnum;

import org.hibernate.annotations.CreationTimestamp;
import lombok.*;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@Getter
@Setter
@Entity
@Table(name = "email_table")
@EntityListeners({AuditingEntityListener.class})
public class Email {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "from_address")
    private String from;

    @Column(name = "to_address")
    private String to;

    @Column(name = "cc_addresses")
    private String cc;

    @Column(name = "subject")
    private String subject;

    @Enumerated(EnumType.STRING)
    @Column(name = "importance")
    private ImportanceEnum importance;

    @Column(name = "emailContent")
    private String emailContent;

    @CreationTimestamp
    @Column(name = "createdTimestamp")
    private LocalDateTime createdTimestamp;
}
