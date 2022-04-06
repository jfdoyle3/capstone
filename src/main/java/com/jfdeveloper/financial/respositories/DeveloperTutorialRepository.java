package com.jfdeveloper.financial.respositories;

import com.jfdeveloper.financial.entities.DeveloperTutorial;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DeveloperTutorialRepository extends JpaRepository<DeveloperTutorial, Long> {
}
