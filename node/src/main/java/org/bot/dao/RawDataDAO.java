package org.bot.dao;

import org.bot.entity.RawData;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Artur Tomeyan
 * @date 27/10/2022
 */
public interface RawDataDAO extends JpaRepository<RawData, Long> {

}