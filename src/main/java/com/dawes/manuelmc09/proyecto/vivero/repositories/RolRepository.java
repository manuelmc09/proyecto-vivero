package com.dawes.manuelmc09.proyecto.vivero.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dawes.manuelmc09.proyecto.vivero.entities.Rol;

@Repository
public interface RolRepository extends JpaRepository<Rol, Integer> {

}
