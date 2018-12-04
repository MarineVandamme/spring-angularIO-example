package com.devlog.soaproject.core.service.impl;

import com.devlog.soaproject.core.dto.Authent;
import com.devlog.soaproject.core.repository.PersonRepository;
import com.devlog.soaproject.core.service.ContactService;
import com.devlog.soaproject.entity.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ContactServiceImpl implements ContactService{

    @Autowired
    private PersonRepository personRepository;


  @Override
  public Person getPersonByEmail(String email) {
    return personRepository.findPersonByEmail(email);
  }

  @Override
  public Boolean checkPassword(Authent authent) {
    Person person = personRepository.findPersonByEmail(authent.getEmail());
    System.out.println(person);
    if(person==null){
      return false;
    }
    else{
      if (person.getPassword().equals(authent.getPassword())){
        return true;
      }
      else{
        return false;
      }
    }
  }
}
