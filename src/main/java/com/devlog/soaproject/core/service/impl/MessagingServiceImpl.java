package com.devlog.soaproject.core.service.impl;

import com.devlog.soaproject.core.repository.MessageRepository;
import com.devlog.soaproject.core.service.MessagingService;
import com.devlog.soaproject.entity.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MessagingServiceImpl implements MessagingService{

    @Autowired
    private MessageRepository messageRepository;


    @Override
    public List<Message> getAll() {
        return messageRepository.findAll();
    }

    @Override
    public Message getMessagebyId(Integer idMessage) {
        return messageRepository.findMessagesByIdMessage(idMessage);
    }

    @Override
    public void deleteMessageById(Integer idMessage) {
        messageRepository.deleteMessageByIdMessage(idMessage);
    }

    @Override
    public void addMessage(Message message) {
        messageRepository.save(message);
    }
}
