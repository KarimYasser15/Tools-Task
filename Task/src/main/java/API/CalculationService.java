package API;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;


import ejbs.Calculation;

@Stateless
@Path("calculate")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class CalculationService {
	
	
	
	@PersistenceContext(unitName = "hello")
	private EntityManager entityManager;
	
	
	@POST
	@Path("operation")
	public int calculate(Calculation request)
	{
		entityManager.persist(request);
		return request.calculateNumber(request.getOperation());
	}
	
	@GET
	@Path("getAll")
	public List<Calculation> getAll()
	{
		return entityManager.createQuery("SELECT c FROM Calculation c", Calculation.class)
                .getResultList();
	}

}
