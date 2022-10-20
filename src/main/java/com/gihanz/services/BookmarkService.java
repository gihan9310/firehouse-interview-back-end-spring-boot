package com.gihanz.services;

import com.gihanz.dtos.BookmarkDTO;
import com.gihanz.entities.Bookmark;

import java.util.List;

public interface BookmarkService {

    List<BookmarkDTO> createBookmarks(List<BookmarkDTO>list,Long userId);
    List<BookmarkDTO> getAllBookmarks(Long userId);
    Long deleteBookmark(Long userId,Long bookmarkId);
    BookmarkDTO updateBookmark(Long userId,BookmarkDTO dto);
}
