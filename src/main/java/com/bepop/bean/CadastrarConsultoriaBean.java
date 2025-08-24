package com.bepop.bean;

import java.util.Date;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import com.bepop.dao.ConsultoriaDAO;
import com.bepop.model.Consultoria;


@ManagedBean
@ViewScoped
public class CadastrarConsultoriaBean {
	
	private Consultoria consultoria;
	private ConsultoriaDAO consultoriaDAO;
	private Date dataMinima;
	
	
	@PostConstruct
	public void inti() {
		consultoria = new Consultoria();
		consultoriaDAO = new ConsultoriaDAO();
		long oneDay = 24 * 60 * 60 * 1000;
		Date hoje = new Date();
		dataMinima = new Date(hoje.getTime()+ ((1+(14/24)) * oneDay));
	}
	
	
	
	
	public void salvar() {
		try {
            consultoriaDAO.salvar(consultoria);
            
            FacesContext.getCurrentInstance().addMessage(null, 
                    new FacesMessage(FacesMessage.SEVERITY_INFO, "Sucesso!", "Consultoria adicionada."));
            
            consultoria = new Consultoria();

        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro!", "Não foi possível agendar a consultoria."));
        }
	}
	
	
	
	
	public Consultoria getConsultoria() {
		return consultoria;
	}
	public void setConsultoria(Consultoria consultoria) {
		this.consultoria = consultoria;
	}
	public ConsultoriaDAO getConsultoriaDAO() {
		return consultoriaDAO;
	}
	public void setConsultoriaDAO(ConsultoriaDAO consultoriaDAO) {
		this.consultoriaDAO = consultoriaDAO;
	}




	public Date getDataMinima() {
		return dataMinima;
	}




	public void setDataMinima(Date dataMinima) {
		this.dataMinima = dataMinima;
	}
	
	
	
	
}
