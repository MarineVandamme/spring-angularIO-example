package com.devlog.soaproject.web.controller;

import com.devlog.soaproject.core.service.MessagingService;
import com.devlog.soaproject.entity.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "")
public class SoaApplicationController {

    @Autowired
    MessagingService messagingService;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public List<Message> getMessages(){
        return messagingService.getAll();
    }

    @RequestMapping(value = "/message/{id}", method = RequestMethod.GET)
    public Message getMessageById(@PathVariable Integer id){
        return messagingService.getMessagebyId(id);
    }

    @RequestMapping(value = "/delete/{id]", method = RequestMethod.DELETE)
    public void deleteMessageById(@PathVariable Integer id){
        deleteMessageById(id);
    }

    @RequestMapping(value = "/send", method = RequestMethod.POST)
    public void sendMessage(@RequestBody Message message){
        messagingService.addMessage(message);
    }

}
