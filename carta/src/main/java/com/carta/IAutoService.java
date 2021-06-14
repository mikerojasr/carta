package com.carta;
import java.util.Optional;

public interface IAutoService {
     Auto crear(Auto auto);
     Optional<Auto> obtenerPorId(Long id);
     Auto actualizar(Long id, double nuevoPrecio);
     boolean eliminar(Long id);
}