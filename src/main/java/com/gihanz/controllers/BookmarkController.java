package com.gihanz.controllers;

import com.gihanz.dtos.BookmarkDTO;
import com.gihanz.dtos.UserDTO;
import com.gihanz.entities.Bookmark;
import com.gihanz.services.BookmarkService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "bookmarks")
@CrossOrigin()
public class BookmarkController {

    private BookmarkService bookmarkService;

    public BookmarkController(BookmarkService bookmarkService) {
        this.bookmarkService = bookmarkService;
    }

    @PostMapping(value = "save-all/{userId}")
    public ResponseEntity<List<BookmarkDTO>> saveAll(@RequestBody List<BookmarkDTO> list,@PathVariable("userId") Long userId){
        List<BookmarkDTO> bookmarks = this.bookmarkService.createBookmarks(list, userId);
        System.out.println("Calling...");
        return new ResponseEntity<>(bookmarks, HttpStatus.OK);
    }

    @GetMapping(value = "find-all/{userId}")
    public ResponseEntity<List<BookmarkDTO>> findAllForUser(@PathVariable("userId") Long userId){
        List<BookmarkDTO> bookmarks = this.bookmarkService.getAllBookmarks(userId);
        return new ResponseEntity<>(bookmarks, HttpStatus.OK);
    }

    @PutMapping(value = "update-bookmark/{userId}")
    public ResponseEntity<BookmarkDTO> updateBookmark(@RequestBody BookmarkDTO dto, @PathVariable("userId") Long userId){
        BookmarkDTO bookmark = this.bookmarkService.updateBookmark(userId, dto);
        return new ResponseEntity<>(bookmark, HttpStatus.OK);
    }
    @DeleteMapping(value = "delete-bookmark/{userId}/{bookmarkId}")
    public ResponseEntity<Long> deleteBookmark(@PathVariable("userId") Long userId,@PathVariable("bookmarkId") Long bookmarkId){
        Long bookmark = this.bookmarkService.deleteBookmark(userId, bookmarkId);
        return new ResponseEntity<>(bookmark, HttpStatus.OK);
    }
}
