package dev.ante.email.service;

import dev.ante.email.dto.EmailDTO;
import dev.ante.email.entity.Email;
import dev.ante.email.mapper.EmailMapper;
import dev.ante.email.repository.EmailRepository;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmailService {

    private static final int PAGE_SIZE = 20;
    private final EmailMapper emailMapper;
    private final EmailRepository emailRepository;

    public EmailService(EmailMapper emailMapper, EmailRepository emailRepository) {
        this.emailMapper = emailMapper;
        this.emailRepository = emailRepository;
    }

    @Transactional
    public void handleSendRequest(EmailDTO dto) {
        Email email = emailMapper.dtoToEntity(dto);

        emailRepository.save(email);
    }

    public List<EmailDTO> getEmails(Pageable pageable) {
        return emailRepository
                .findAll(getCustomPageable(pageable))
                .stream()
                .map(emailMapper::entityToDto)
                .collect(Collectors.toList());
    }

    private Pageable getCustomPageable(Pageable pageable) {
        return PageRequest.of(
                pageable.getPageNumber(),
                PAGE_SIZE,
                Sort.by("id").descending()
        );
    }
}
