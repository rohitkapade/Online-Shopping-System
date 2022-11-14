package com.Shopping.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Shopping.Model.CurrentUserSession;

public interface CurrentUserSessionRepo extends JpaRepository<CurrentUserSession, Integer>{

	public CurrentUserSession findByUuid(String uuid);
}
