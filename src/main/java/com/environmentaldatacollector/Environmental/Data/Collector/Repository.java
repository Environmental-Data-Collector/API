package com.environmentaldatacollector.Environmental.Data.Collector;

import org.springframework.data.jpa.repository.JpaRepository;

@org.springframework.stereotype.Repository
public interface Repository extends JpaRepository<Model, String> {
}
