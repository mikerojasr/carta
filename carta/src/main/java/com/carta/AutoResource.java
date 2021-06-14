package com.carta;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class AutoResource {
    @Autowired
    private IAutoService autoService;
    @PostMapping("autos")
    public Auto crearAuto(@RequestBody Auto auto1) {
    	return this.autoService.crear(auto1); 
    }
    @GetMapping("/autos/{id}")
    public ResponseEntity<Auto> obtenerAuto(@PathVariable("id") Long id) {
        Optional<Auto> optionalAuto = this.autoService.obtenerPorId(id);
        if (optionalAuto.isPresent())
            return new ResponseEntity<Auto>(optionalAuto.get(), HttpStatus.OK);
        return ResponseEntity.notFound().build();
    }
    @PutMapping("/autos/{id}/nuevoprecio/{precio}")
    public ResponseEntity<Auto> actualizarAuto(@PathVariable("id") Long id, @PathVariable("precio") double precio) {
        Auto autoActualizado = this.autoService.actualizar(id, precio);
        if (autoActualizado != null) {
            return new ResponseEntity<Auto>(autoActualizado, HttpStatus.OK);
        }
        return ResponseEntity.notFound().build();
    }
    @DeleteMapping("/autos/{id}")
    public ResponseEntity<Void> eliminarAuto(@PathVariable("id") Long id) {
        this.autoService.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}