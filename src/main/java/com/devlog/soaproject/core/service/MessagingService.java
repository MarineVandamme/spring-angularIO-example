package com.devlog.soaproject.core.service;

import com.devlog.soaproject.entity.Message;

import java.util.List;

public interface MessagingService {

    public List<Message> getAll(String email);
    public Message getMessagebyId(Integer idMessage);
    public void deleteMessageById(Integer idMessage);
    public void addMessage(Message message);
}
