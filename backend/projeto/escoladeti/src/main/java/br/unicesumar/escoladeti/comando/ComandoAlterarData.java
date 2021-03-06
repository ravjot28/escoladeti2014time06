package br.unicesumar.escoladeti.comando;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.format.annotation.DateTimeFormat;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Jhonatan on 16/09/2014.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class ComandoAlterarData {
    private Long id;
    private SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
    private String data;
    private Long usuario;

    public String getData() {
        return data;
    }

    public Date getDataAsDate() {
        try {
            return data == null ? null : simpleDateFormat.parse(data);
        } catch (ParseException e) {
            e.printStackTrace();
            throw new RuntimeException("Data inválida");
        }
    }

    public void setData(String data) {
        this.data = data;
    }

    public Long getUsuario() {
        return usuario;
    }

    public void setUsuario(Long usuario) {
        this.usuario = usuario;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
