package com.senac.projetoUc16.repositorys;

import com.senac.projetoUc16.models.Coordenadas;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface CoordenadasRepository extends JpaRepository<Coordenadas, Long>{
    Coordenadas findCoordenadasById(Long id);
    List<Coordenadas> findCoordenadasByLatitude(String latitude);
}
