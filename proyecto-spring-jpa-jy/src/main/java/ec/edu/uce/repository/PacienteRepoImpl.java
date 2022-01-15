package ec.edu.uce.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import ec.edu.uce.modelo.Paciente;

@Repository
public class PacienteRepoImpl implements IPacienteRepo{

	//conexion mediante jdbc
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	
	@Override
	public void create(Paciente paciente) {
		// TODO Auto-generated method stub
		//insert into paciente (id,nombre,apellido, edad)values (1,'jessi','yanez',29)
		Object[] datosAInsertar=new Object[] {paciente.getId(),paciente.getNombre(),paciente.getApellido(), paciente.getEdad()};
		this.jdbcTemplate.update("insert into paciente (id,nombre,apellido, edad) values (?,?,?,?)",datosAInsertar);
	}

	@Override
	public Paciente read(Integer id) {
		Object[] datoABuscar=new Object[] {id};
		return this.jdbcTemplate.queryForObject("select * from paciente where id=?", datoABuscar, new BeanPropertyRowMapper<Paciente>(Paciente.class));
		 
	}

	@Override
	public void update(Paciente paciente) {
		//update paciente set id=1,nombre= 'Edison1', apellido='Cayambe1', edad=33  where id=1
				Object[] datosAAcutalizar= new Object[] {paciente.getId(), paciente.getNombre(), paciente.getApellido(),paciente.getEdad(), paciente.getId()};
				this.jdbcTemplate.update("update paciente set id=?,nombre= ?, apellido=?, edad=?  where id=?", datosAAcutalizar);
	}

	@Override
	public void delete(Integer id) {
		// TODO Auto-generated method stub
		Object[] datoABorrar=new Object[] {id};
		this.jdbcTemplate.update("delete from paciente where id=?",datoABorrar);
	}

}
