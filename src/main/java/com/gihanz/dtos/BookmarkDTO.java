package com.gihanz.dtos;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.gihanz.entities.Bookmark;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.beans.BeanUtils;

import java.time.LocalDateTime;

@Data()
@NoArgsConstructor
@AllArgsConstructor
@ToString()
public class BookmarkDTO {

    private Long id;
    private Long bookmarkId;
    private String name;
    private String url;
    private String description;
    private String status;
    private String expiryDate;
    private Long userId;
    private Long featured;
    private String image;
    private String createdAt;

    @JsonIgnore()
    public Bookmark getEntity(){
        Bookmark bookmark = new Bookmark();
        BeanUtils.copyProperties(this,bookmark);
        return bookmark;
    }
}
