package com.upc.trabajoparcialcinemahub.security.repositories;
import com.upc.trabajoparcialcinemahub.security.entities.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {
}
