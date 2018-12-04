package com.devlog.soaproject.core.service.impl;

import com.devlog.soaproject.core.repository.MessageRepository;
import com.devlog.soaproject.core.service.MessagingService;
import com.devlog.soaproject.entity.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class MessagingServiceImpl implements MessagingService{

    @Autowired
    private MessageRepository messageRepository;


    @Override
    public List<Message> getAll(String topers) {
      System.out.println("topers : "+topers);
      System.out.println("MSGS : "+messageRepository.findMessagesByTopers(topers));
        return messageRepository.findMessagesByTopers(topers);
    }

    @Override
    public Message getMessagebyId(Integer idMessage) {
        return messageRepository.findMessagesByIdMessage(idMessage);
    }

    @Override
    public void deleteMessageById(Integer idMessage) {
        Message message = messageRepository.findMessagesByIdMessage(idMessage);
        messageRepository.delete(message);
    }

    @Override
    public void addMessage(Message message) {
      message.setDateTime(LocalDateTime.now());
        messageRepository.save(message);
    }
}
