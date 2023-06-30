package dev.ante.email.controller;

import dev.ante.email.dto.EmailDTO;
import dev.ante.email.service.EmailService;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class MailController {

    private final EmailService emailService;

    public MailController(EmailService emailService) {
        this.emailService = emailService;
    }

    @GetMapping("/emails")
    public ResponseEntity<List<EmailDTO>> getEmails(@PageableDefault Pageable pageable) {
        return ResponseEntity.ok(emailService.getEmails(pageable));
    }

    @PostMapping("/send")
    public ResponseEntity<Void> send(@Valid @RequestBody EmailDTO email) {
        emailService.handleSendRequest(email);
        return ResponseEntity.ok().build();
    }
}
