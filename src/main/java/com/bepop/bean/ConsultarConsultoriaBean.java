package com.bepop.bean;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;



import com.bepop.dao.ConsultoriaDAO;
import com.bepop.model.Consultoria;

@ManagedBean
@ViewScoped
public class ConsultarConsultoriaBean {
	private String cnpjBusca;
    private List<Consultoria> consultoriasEncontradas;
    private ConsultoriaDAO consultoriaDAO;
    private Consultoria consultoriaSelecionada;
    private Date dataMinima;
    
    
    
    @PostConstruct
    public void init() {
        consultoriaDAO = new ConsultoriaDAO();
        consultoriasEncontradas = new ArrayList<>();
        long oneDay = 24 * 60 * 60 * 1000;
        Date hoje = new Date();
		dataMinima = new Date(hoje.getTime()+((1+(14/24)) * oneDay));
    }
    
    public void prepararEdicao(Consultoria consultoria) {
    	this.consultoriaSelecionada = consultoria;
    }

    public void buscar() {
        if (cnpjBusca == null || cnpjBusca.trim().isEmpty()) {
            FacesContext.getCurrentInstance().addMessage(null, 
                new FacesMessage(FacesMessage.SEVERITY_WARN, "Atenção!", "Digite um CNPJ para buscar."));
            return;
        }
        consultoriasEncontradas = consultoriaDAO.buscarPorCnpj(cnpjBusca);
        System.out.println("--- BUSCA FINALIZADA. ENCONTRADOS " + consultoriasEncontradas.size() + " REGISTROS. ---");
        for (Consultoria consultoria : consultoriasEncontradas) {
        	System.out.println(consultoria.getNomeEmpresa() +" "+ consultoria.getCnpj());
        }
    }

    public void excluir(Consultoria consultoria) {
        consultoriaDAO.excluir(consultoria);
        consultoriasEncontradas.remove(consultoria); 
        FacesContext.getCurrentInstance().addMessage(null, 
            new FacesMessage(FacesMessage.SEVERITY_INFO, "Sucesso!", "Consultoria removida."));
    }

    public void atualizar() {
		try {
            consultoriaDAO.atualizar(consultoriaSelecionada);
            
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Sucesso!", "Consultoria atualizada."));
            
            consultoriaSelecionada = new Consultoria();

        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro!", "Não foi possível atualizar a consultoria."));
        }
	}
	
    
    
    

    public String getCnpjBusca() { 
    	return cnpjBusca;
    }
    
    
    public void setCnpjBusca(String cnpjBusca) { 
    	this.cnpjBusca = cnpjBusca; 
    }
    
    
    public List<Consultoria> getConsultoriasEncontradas() { 
    	return consultoriasEncontradas;
    }

	public ConsultoriaDAO getConsultoriaDAO() {
		return consultoriaDAO;
	}

	public void setConsultoriaDAO(ConsultoriaDAO consultoriaDAO) {
		this.consultoriaDAO = consultoriaDAO;
	}

	public Consultoria getConsultoriaSelecionada() {
		return consultoriaSelecionada;
	}

	public void setConsultoriaSelecionada(Consultoria consultoriaSelecionada) {
		this.consultoriaSelecionada = consultoriaSelecionada;
	}

	public void setConsultoriasEncontradas(List<Consultoria> consultoriasEncontradas) {
		this.consultoriasEncontradas = consultoriasEncontradas;
	}

	public Date getDataMinima() {
		return dataMinima;
	}

	public void setDataMinima(Date dataMinima) {
		this.dataMinima = dataMinima;
	}
}
