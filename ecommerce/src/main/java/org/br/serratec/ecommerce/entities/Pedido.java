package org.br.serratec.ecommerce.entities;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import org.br.serratec.ecommerce.dtos.PedidoDTO;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "pedido")
//@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "pedidoId", scope = Pedido.class)
public class Pedido {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "pedido_id")
	private Integer pedidoId;

	@Column(name = "data_pedido")
	private LocalDateTime dataPedido;

	@Column(name = "data_entrega")
	private LocalDate dataEntrega;

	@Column(name = "data_envio")
	private LocalDate dataEnvio;

	@Column(name = "status")
	private Boolean status;

	@Column(name = "valor_total")
	private Double valorTotal;

	@ManyToOne
	@JoinColumn(name = "cliente_id")
	private Cliente cliente;

	@OneToMany
	private List<ItemPedido> itensPedido;

	public Pedido() {
	}

	public Pedido(PedidoDTO pedidoDTO) {
		this.dataPedido = LocalDateTime.now();
		this.dataEntrega = pedidoDTO.getDataEntrega();
		this.dataEnvio = pedidoDTO.getDataEnvio();
		this.status = pedidoDTO.getStatus();
		this.valorTotal = pedidoDTO.getValorTotal();
		this.cliente = pedidoDTO.getCliente();
	}

	public Integer getPedidoId() {
		return pedidoId;
	}

	public Pedido(Integer pedidoId, LocalDateTime dataPedido, LocalDate dataEntrega, LocalDate dataEnvio, Boolean status,
			Double valorTotal, Cliente cliente, List<ItemPedido> itensPedido) {
		super();
		this.pedidoId = pedidoId;
		this.dataPedido = dataPedido;
		this.dataEntrega = dataEntrega;
		this.dataEnvio = dataEnvio;
		this.status = status;
		this.valorTotal = valorTotal;
		this.cliente = cliente;
		this.itensPedido = itensPedido;
	}

	public void setPedidoId(Integer pedidoId) {
		this.pedidoId = pedidoId;
	}

	public LocalDateTime getDataPedido() {
		return dataPedido;
	}

	public void setDataPedido(LocalDateTime dataPedido) {
		this.dataPedido = dataPedido;
	}

	public LocalDate getDataEntrega() {
		return dataEntrega;
	}

	public void setDataEntrega(LocalDate dataEntrega) {
		this.dataEntrega = dataEntrega;
	}

	public LocalDate getDataEnvio() {
		return dataEnvio;
	}

	public void setDataEnvio(LocalDate dataEnvio) {
		this.dataEnvio = dataEnvio;
	}

	public Boolean getStatus() {
		return status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}

	public Double getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(Double valorTotal) {
		this.valorTotal = valorTotal;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
}