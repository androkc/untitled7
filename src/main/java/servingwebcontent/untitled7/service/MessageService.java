package servingwebcontent.untitled7.service;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import servingwebcontent.untitled7.domain.Message;
import servingwebcontent.untitled7.domain.User;
import servingwebcontent.untitled7.domain.dto.MessageDto;
import servingwebcontent.untitled7.repository.MessageRepository;

import javax.persistence.EntityManager;

@Service
@RequiredArgsConstructor
public class MessageService {
    private final MessageRepository messageRepository;

    public Page<MessageDto> messageList(Pageable pageable, String filter, User user) {
        if (filter != null && !filter.isEmpty()) {
            return messageRepository.findByTag(filter, pageable,user);
        } else {
            return messageRepository.findAll(pageable,user);
        }
    }

    public Page<MessageDto> messageListForUser(Pageable pageable, User currentUser, User author) {
        return messageRepository.findByUser(pageable,author,currentUser);
    }
}
