package com.devlog.soaproject.entity;

import javax.persistence.*;
import java.io.File;
import java.time.LocalDateTime;

@Entity
@Table(name = "message")
public class Message {

  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE)
  @Column(name = "id_message")
  private Integer idMessage;
  @Column(name = "subject")
  private String subject;
  @Column(name = "text")
  private String text;
  @Column(name = "dateTime")
  private LocalDateTime dateTime;
  @Column(name = "frompers")
  private String frompers;
  @Column(name = "topers")
  private String topers;
    /*/!!!!!
    @ManyToOne
    @JoinColumn(name = "topers")
    //@Column(name = "topers")
    private Person topers;
    //!!!!!
    @ManyToOne
    @JoinColumn(name = "id_person")
    private Person from;*/

  public Message() {
  }

  public Message(String subject, String text, String frompers, String topers) {
    this.subject = subject;
    this.text = text;
    this.frompers = frompers;
    this.topers = topers;
    this.dateTime = LocalDateTime.now();
  }

  public LocalDateTime getDateTime() {
    return dateTime;
  }

  public void setDateTime(LocalDateTime dateTime) {
    this.dateTime = dateTime;
  }

  public Integer getIdMessage() {
    return idMessage;
  }

  public void setIdMessage(Integer idMessage) {
    this.idMessage = idMessage;
  }

  public String getSubject() {
    return subject;
  }

  public void setSubject(String subject) {
    this.subject = subject;
  }

  public String getText() {
    return text;
  }

  public void setText(String text) {
    this.text = text;
  }

  public String getFrompers() {
    return frompers;
  }

  public void setFrompers(String frompers) {
    this.frompers = frompers;
  }

  public String getTopers() {
    return topers;
  }

  public void setTopers(String topers) {
    this.topers = topers;
  }
}
