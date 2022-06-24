package com.example.lottery.data;

import com.example.lottery.model.Winner;
import org.springframework.data.repository.CrudRepository;

public interface WinnerRepository extends CrudRepository<Winner, Long> {
}
