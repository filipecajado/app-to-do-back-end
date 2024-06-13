package br.com.apptodo.repository;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.apptodo.entity.TaskEntity;

@Repository
public interface TaskRepository extends CrudRepository<TaskEntity, Long>{	

    @Modifying
    @Transactional
    @Query("UPDATE TaskEntity t SET t.checked = :checked WHERE t.id = :id")
    void changeChecked(@Param("checked") Boolean checked, @Param("id") Long id);
}
