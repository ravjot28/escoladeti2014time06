package br.unicesumar.escoladeti.entity;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public class Entidade implements Serializable {
    
    private static final long serialVersionUID = -8559579530998613052L;
    
    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE)
    protected Long id;

    public Entidade() {	
    }

    public Long getId() {
        return id;
    }
    
    public void setId(Long id) {
		this.id = id;
	}

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 83 * hash + Objects.hashCode(this.id);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Entidade other = (Entidade) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }
    
    
}
