package com.devlog.soaproject.core.repository;

import com.devlog.soaproject.entity.Message;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MessageRepository extends JpaRepository<Message, Integer>{

    public Message findMessagesByIdMessage(Integer idMessage);
    public void deleteMessageByIdMessage(Integer idMessage);

}
