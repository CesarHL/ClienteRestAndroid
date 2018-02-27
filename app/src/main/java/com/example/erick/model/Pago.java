package com.example.erick.model;

import java.io.Serializable;

/**
 * Created by Erick on 25/02/2018.
 */

public class Pago implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    private Integer id;

    private Double cantidad;

    private String folio;

    private String receptor;

    private String emisor;

    public Pago() {
        super();
    }

    public Pago(Integer id, Double cantidad, String folio, String receptor, String emisor) {
        super();
        this.id = id;
        this.cantidad = cantidad;
        this.folio = folio;
        this.receptor = receptor;
        this.emisor = emisor;
    }

    /**
     * @return the id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id
     *            the id to set
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * @return the cantidad
     */
    public Double getCantidad() {
        return cantidad;
    }

    /**
     * @param cantidad
     *            the cantidad to set
     */
    public void setCantidad(Double cantidad) {
        this.cantidad = cantidad;
    }

    /**
     * @return the folio
     */
    public String getFolio() {
        return folio;
    }

    /**
     * @param folio
     *            the folio to set
     */
    public void setFolio(String folio) {
        this.folio = folio;
    }

    /**
     * @return the receptor
     */
    public String getReceptor() {
        return receptor;
    }

    /**
     * @param receptor
     *            the receptor to set
     */
    public void setReceptor(String receptor) {
        this.receptor = receptor;
    }

    /**
     * @return the emisor
     */
    public String getEmisor() {
        return emisor;
    }

    /**
     * @param emisor
     *            the emisor to set
     */
    public void setEmisor(String emisor) {
        this.emisor = emisor;
    }

    /*
     * (non-Javadoc)
     *
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "Pago [id=" + id + ", cantidad=" + cantidad + ", folio=" + folio + ", receptor=" + receptor + ", emisor="
                + emisor + "]";
    }

}
