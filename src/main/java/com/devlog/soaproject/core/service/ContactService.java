package com.devlog.soaproject.core.service;

import com.devlog.soaproject.core.dto.Authent;
import com.devlog.soaproject.entity.Person;

public interface ContactService {

  public Person getPersonByEmail(String email);
  public Boolean checkPassword(Authent authent);

}
