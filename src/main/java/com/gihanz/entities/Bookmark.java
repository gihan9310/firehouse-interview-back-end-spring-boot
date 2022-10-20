package com.gihanz.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.gihanz.dtos.BookmarkDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.beans.BeanUtils;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data()
@NoArgsConstructor
@AllArgsConstructor
@Entity
@ToString()
@Table(name = "Bookmarks")
public class Bookmark {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long bookmarkId;
    private String name;
    private String url;
    @Column(length = 2500)
    private String description;
    private String status;
    private String expiryDate;
    private Long featured;
    private Long userId;
    private String image;
    private String createdAt;

    @JsonIgnore()
    public BookmarkDTO getDto(){
        BookmarkDTO bookmark = new BookmarkDTO();
        BeanUtils.copyProperties(this,bookmark);
        return bookmark;
    }
}
