package com.wegneto.blog.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wegneto.blog.entity.Avatar;

public interface AvatarRepository extends JpaRepository<Avatar, Long> {

}
