package com.devlog.soaproject.core.service.impl;

import com.devlog.soaproject.core.repository.PersonRepository;
import com.devlog.soaproject.core.service.ContactService;
import com.devlog.soaproject.entity.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ContactServiceImpl implements ContactService{

    @Autowired
    private PersonRepository personRepository;


}
