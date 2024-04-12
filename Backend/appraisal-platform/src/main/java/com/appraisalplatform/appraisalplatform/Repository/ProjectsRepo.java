package com.appraisalplatform.appraisalplatform.Repository;

import com.appraisalplatform.appraisalplatform.Model.Projects;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjectsRepo extends JpaRepository<Projects,Long> {
}
