package mypackage.repositories.interfaces;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import mypackage.entities.Empleado;

public interface I_EmpleadoRepository {

    void save(Empleado empleado);

    void remove(Empleado empleado);

    void update(Empleado empleado);

    List<Empleado> getAll();

    default Stream<Empleado> getStream() {
        return getAll().stream();
    }

    default Empleado getById(int id) {
    
        return getStream()
                .filter(objeto -> objeto.getId() == id)
                .findAny()
                .orElse(new Empleado());
    }


    default List<Empleado> getLikeNombre(String nombre) {
        if (nombre == null) {
            return new ArrayList<Empleado>();
        }
        return getStream()
                .filter(objeto -> objeto.getNombre().toLowerCase()
                .startsWith(nombre.toLowerCase()))
                .collect(Collectors.toList());
    }

    default List<Empleado> getLikeApellido(String apellido) {
        if (apellido == null) {
            return new ArrayList<Empleado>();
        }
        return getStream()
                .filter(objeto -> objeto.getApellido().toLowerCase()
                .startsWith(apellido.toLowerCase()))
                .collect(Collectors.toList());
    }

    default List<Empleado> getByEdad(int edad) {

        return getStream()
                .filter(objeto -> objeto.getEdad() == edad)
                .collect(Collectors.toList());
    }


        default List<Empleado> getByEdadMayorIgualQue(int edad) {

        return getStream()
                .filter(objeto -> objeto.getEdad() >= edad)
                .collect(Collectors.toList());
    }

    default List<Empleado> getByEdadMenorIgualQue(int edad) {

        return getStream()
                .filter(objeto -> objeto.getEdad() <= edad)
                .collect(Collectors.toList());
    }

    default List<Empleado> getLikeGenero(String genero) {
        if (genero == null) {
            return new ArrayList<Empleado>();
        }
        return getStream()
                .filter(objeto -> objeto.getGenero().toLowerCase()
                .startsWith(genero.toLowerCase()))
                .collect(Collectors.toList());
    }

        default List<Empleado> getLikeTipoDocumento(String tipo_documento) {
        if (tipo_documento == null) {
            return new ArrayList<Empleado>();
        }
        return getStream()
                .filter(objeto -> objeto.getTipoDocumento().toLowerCase()
                .contains(tipo_documento.toLowerCase()))
                .collect(Collectors.toList());
    }
        
        
    default List<Empleado> getLikeNumeroDocumento(String numero_documento) {
        if (numero_documento == null) {
            return new ArrayList<Empleado>();
        }
         return getStream()
                .filter(objeto -> objeto.getNumeroDocumento().toLowerCase()
                .startsWith(numero_documento.toLowerCase()))
                .collect(Collectors.toList());
    }
    
        
    default List<Empleado> getLikeCorreoElectronico(String correo_electronico) {
        if (correo_electronico == null) {
            return new ArrayList<Empleado>();
        }
         return getStream()
                .filter(objeto -> objeto.getCorreoElectronico().toLowerCase()
                .contains(correo_electronico.toLowerCase()))
                .collect(Collectors.toList());
    }
    
       
    default List<Empleado> getLikeNumeroTelefono(String numero_telefono) {
        if (numero_telefono == null) {
            return new ArrayList<Empleado>();
        }
           return getStream()
                .filter(objeto -> objeto.getNumeroTelefono().toLowerCase()
                .startsWith(numero_telefono.toLowerCase()))
                .collect(Collectors.toList());
    }
    

    default List<Empleado> getLikeFechaInicio(Date fecha_inicio) {
        if (fecha_inicio == null) {
            return new ArrayList<Empleado>();
        }
        return getStream()
                .filter(objeto -> objeto.getFechaInicio() == fecha_inicio)
                .collect(Collectors.toList());
    }
    
     
    
    default List<Empleado> getByCantidadHsSemanales(int cantidad_hs_semanales) {

        return getStream()
                .filter(objeto -> objeto.getCantidadHsSemanales() == cantidad_hs_semanales)
                .collect(Collectors.toList());
    }

 
    default List<Empleado> getBySueldo(float sueldo) {

        return getStream()
                .filter(objeto -> objeto.getSueldo() == sueldo)
                .collect(Collectors.toList());
    }
  

    
    
}
