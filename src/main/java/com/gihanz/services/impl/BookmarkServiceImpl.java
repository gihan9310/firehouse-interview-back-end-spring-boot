package com.gihanz.services.impl;

import com.gihanz.dtos.BookmarkDTO;
import com.gihanz.entities.Bookmark;
import com.gihanz.repositories.BookmarkRepository;
import com.gihanz.services.BookmarkService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class BookmarkServiceImpl implements BookmarkService {

    private BookmarkRepository bookmarkRepository;

    public BookmarkServiceImpl(BookmarkRepository bookmarkRepository) {
        this.bookmarkRepository = bookmarkRepository;
    }

    @Transactional
    @Override
    public List<BookmarkDTO> createBookmarks(List<BookmarkDTO> list, Long userId) {

        try {
            List<Bookmark> bookmarks = new ArrayList<>();
            for (BookmarkDTO dto : list) {

                if (!this.bookmarkRepository.existsByBookmarkIdAndUserId(dto.getBookmarkId(), dto.getUserId())) {
                    bookmarks.add(dto.getEntity());
                } else {
                    // to reset data set
                    Long id = this.bookmarkRepository.deleteByBookmarkIdAndUserId(dto.getBookmarkId(), userId);
                    bookmarks.add(dto.getEntity());
                }
            }
            List<Bookmark> saveAllData = this.bookmarkRepository.saveAll(bookmarks);
            return saveAllData.stream().map(bookmark -> bookmark.getDto()).collect(Collectors.toList());
        } catch (Exception e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }

    @Override
    public List<BookmarkDTO> getAllBookmarks(Long userId) {
        try {
            List<Bookmark> list = this.bookmarkRepository.findAllByUserId(userId);
            return list.stream().map(bookmark -> bookmark.getDto()).collect(Collectors.toList());
        } catch (Exception e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }

    @Transactional
    @Override
    public Long deleteBookmark(Long userId, Long bookmarkId) {
        try {
            Long id = this.bookmarkRepository.deleteByBookmarkIdAndUserId(bookmarkId, userId);
            return id;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    @Transactional
    public BookmarkDTO updateBookmark(Long userId, BookmarkDTO dto) {
        try {
            Bookmark save = this.bookmarkRepository.save(dto.getEntity());
            return save.getDto();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
