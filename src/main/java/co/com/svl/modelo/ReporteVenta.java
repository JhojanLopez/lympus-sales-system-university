/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.com.svl.modelo;

import java.io.Serializable;
import java.math.BigInteger;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author JHOJAN L
 */
@Entity
@Table(name = "reporte_venta")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ReporteVenta.findAll", query = "SELECT r FROM ReporteVenta r"),
    @NamedQuery(name = "ReporteVenta.findByCodigoReporte", query = "SELECT r FROM ReporteVenta r WHERE r.reporteVentaPK.codigoReporte = :codigoReporte"),
    @NamedQuery(name = "ReporteVenta.findByCodigoVenta", query = "SELECT r FROM ReporteVenta r WHERE r.reporteVentaPK.codigoVenta = :codigoVenta"),
    })
public class ReporteVenta implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ReporteVentaPK reporteVentaPK;
    @JoinColumn(name = "codigo_reporte", referencedColumnName = "codigo", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Reporte reporte;
    @JoinColumn(name = "codigo_venta", referencedColumnName = "codigo", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Venta venta;

    public ReporteVenta() {
    }

    public ReporteVenta(ReporteVentaPK reporteVentaPK) {
        this.reporteVentaPK = reporteVentaPK;
    }

    public ReporteVenta(long codigoReporte, long codigoVenta) {
        this.reporteVentaPK = new ReporteVentaPK(codigoReporte, codigoVenta);
    }

    public ReporteVentaPK getReporteVentaPK() {
        return reporteVentaPK;
    }

    public void setReporteVentaPK(ReporteVentaPK reporteVentaPK) {
        this.reporteVentaPK = reporteVentaPK;
    }

    public Reporte getReporte() {
        return reporte;
    }

    public void setReporte(Reporte reporte) {
        this.reporte = reporte;
    }

    public Venta getVenta() {
        return venta;
    }

    public void setVenta(Venta venta) {
        this.venta = venta;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (reporteVentaPK != null ? reporteVentaPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ReporteVenta)) {
            return false;
        }
        ReporteVenta other = (ReporteVenta) object;
        if ((this.reporteVentaPK == null && other.reporteVentaPK != null) || (this.reporteVentaPK != null && !this.reporteVentaPK.equals(other.reporteVentaPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ReporteVenta{" + "reporteVentaPK=" + reporteVentaPK + '}';
    }

  
   
}
