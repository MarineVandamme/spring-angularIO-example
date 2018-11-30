package com.devlog.soaproject.entity;

import javax.persistence.*;
import java.io.File;

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
    //!!!!!
    @Column(name = "topers")
    private String topers;
    //!!!!!
    @ManyToOne
    @JoinColumn(name = "id_person")
    private Person from;

    public Message() {
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

    public String getTo() {
        return topers;
    }

    public void setTo(String to) {
        this.topers = to;
    }

    public Person getFrom() {
        return from;
    }

    public void setFrom(Person from) {
        this.from = from;
    }
}
