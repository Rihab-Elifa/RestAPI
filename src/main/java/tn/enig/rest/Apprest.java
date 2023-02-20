package tn.enig.rest;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import tn.enig.dao.IDepartement;
import tn.enig.dao.IEmploye;
import tn.enig.model.Departement;
import tn.enig.model.Employe;

@RestController
public class Apprest {
	@Autowired
	IDepartement dao;
	@Autowired
	IEmploye daoE;
	
	public void setDao(IDepartement dao) {
		this.dao = dao;
	}
	
	public void setDaoE(IEmploye daoE) {
		this.daoE = daoE;
	}
	
	@GetMapping(path="/departements")
	public List<Departement> get1(){
		return dao.findAll();
	}
	@GetMapping(path="/employes")
	public List<Employe> get2(){
		return daoE.findAll();
	}
    
	@PostMapping(path="/addemploye")
	public void add(@RequestBody Employe em) {
		daoE.save(em);
		
	}
	@GetMapping(path="/employesDep/{id}")
	public List<Employe>  getEmployeeByDep(@PathVariable("id")int id){
		return daoE.ListMatByDepatement(id);
	}
	@PostMapping()
	
	@DeleteMapping(path="/deleteEmploye/{id}")
	public void del( @PathVariable ("id") int id) {
		daoE.deleteById(id);
	}
	
	

}
