package com.dharbor.messagingstompwebsocket.repository;

import com.dharbor.messagingstompwebsocket.model.History;
import org.springframework.data.jpa.repository.JpaRepository;

    public interface HistoryRepository extends JpaRepository<History, Long> { }


