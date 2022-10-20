package com.gihanz.repositories;

import com.gihanz.entities.Bookmark;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookmarkRepository extends JpaRepository<Bookmark,Long> {

    boolean existsByBookmarkIdAndUserId(Long bookmarkId,Long userId);
    List<Bookmark> findAllByUserId(Long userId);
    Long deleteByBookmarkIdAndUserId(Long bookmarkId,Long userId);
}
