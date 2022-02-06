package com.jacobelali.codingchallenge.data;

import com.jacobelali.codingchallenge.helper.Indices;
import com.jacobelali.codingchallenge.util.DateUtils;
import org.apache.tomcat.jni.Local;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.*;
import org.springframework.util.StringUtils;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

@Document(indexName = Indices.ENTRY_INDEX)
@Setting(settingPath = "static/es-settings.json")
public class Entries implements Serializable {

    //initialise Entry variables
    @Id
    @Field(type= FieldType.Keyword)
    private String entryId;

    @Field(type= FieldType.Date, pattern = "MM-dd-yyyy")
    private String date;

    @Field(type= FieldType.Text)
    private String text;

    @Field(type= FieldType.Binary)
    private List<String> attachment;


    //getters and setters


    public String getEntryId() {
        return entryId;
    }

    public void setEntryId(String entryId) {
        this.entryId = entryId;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public List<String> getAttachment() {
        return attachment;
    }

    public void setAttachment(List<String> attachment) {
        this.attachment = attachment;
    }

    @Override
    public String toString() {
        return "Entries{" +
                "entryId='" + entryId + '\'' +
                ", date='" + date + '\'' +
                ", text='" + text + '\'' +
                ", attachment=" + attachment +
                '}';
    }
}
