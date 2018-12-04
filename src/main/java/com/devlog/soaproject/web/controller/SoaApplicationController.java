package com.devlog.soaproject.web.controller;

import com.devlog.soaproject.core.dto.Authent;
import com.devlog.soaproject.core.service.ContactService;
import com.devlog.soaproject.core.service.MessagingService;
import com.devlog.soaproject.entity.Message;
import com.devlog.soaproject.entity.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "")
public class SoaApplicationController {

    @Autowired
    MessagingService messagingService;

    @Autowired
    ContactService contactService;

    @RequestMapping(value = "", method = RequestMethod.POST)
    public List<Message> getMessages(@RequestBody String email){
      System.out.println("email : "+email);
        return messagingService.getAll(email);
    }

    @RequestMapping(value = "/message/{id}", method = RequestMethod.GET)
    public Message getMessageById(@PathVariable Integer id){
        return messagingService.getMessagebyId(id);
    }

    @RequestMapping(value = "/delete/{idMessage}", method = RequestMethod.DELETE)
    public void deleteMessageById(@PathVariable Integer idMessage){
      messagingService.deleteMessageById(idMessage);
    }

    @RequestMapping(value = "/send", method = RequestMethod.POST)
    public void sendMessage(@RequestBody Message message){
        messagingService.addMessage(message);
    }

    @RequestMapping(value = "/check", method = RequestMethod.POST)
    public Boolean checkPassword(@RequestBody Authent authent){
      System.out.println(authent.getEmail()+','+authent.getPassword());
      return contactService.checkPassword(authent);
    }

    @RequestMapping(value = "/find/{email}", method = RequestMethod.GET)
    public Person getPersonByEmail(@PathVariable String email){
      System.out.println(contactService.getPersonByEmail(email).getName());
      return contactService.getPersonByEmail(email);
    }
}
