package com.datastax.workshop.todo;

import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

import java.util.UUID;

@Table(value =  "todos")
public class Todo {
    
    @PrimaryKey
    UUID uid;
    
    String title;

    boolean completed = false;

    private int offset = 0;
    
    public Todo(String title, int offset) {
        this.uid = UUID.randomUUID();
        this.title = title;
        this.offset= offset;
    }

    // Getters and Setters

    /**
     * Gets uid
     *
     * @return value of uid
     */
    public UUID getUid() {
        return uid;
    }

    /**
     * Set value for uid
     *
     * @param uid new value for uid
     */
    public void setUid(UUID uid) {
        this.uid = uid;
    }

    /**
     * Gets title
     *
     * @return value of title
     */
    public String getTitle() {
        return title;
    }

    /**
     * Set value for title
     *
     * @param title new value for title
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * Gets completed
     *
     * @return value of completed
     */
    public boolean isCompleted() {
        return completed;
    }

    /**
     * Set value for completed
     *
     * @param completed new value for completed
     */
    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    /**
     * Gets offset
     *
     * @return value of offset
     */
    public int getOffset() {
        return offset;
    }

    /**
     * Set value for offset
     *
     * @param offset new value for offset
     */
    public void setOffset(int offset) {
        this.offset = offset;
    }
}
