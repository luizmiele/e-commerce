package org.br.serratec.ecommerce.entities;

import jakarta.persistence.*;
import org.br.serratec.ecommerce.dtos.ItemPedidoDTO;

import java.util.List;

@Entity
@Table(name="ItemPedido")
public class ItemPedido {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="item_pedido_id")
    private Integer itemPedidoID;

    @Column(name="quatidade")
    private Double quantidade;

    @Column(name="preco_venda")
    private Double precoVenda;

    @Column(name="percentual_desconto")
    private Double percentualDesconto;

    @Column(name="valor_bruto")
    private Double valorBruto;

    @Column(name="valor_liquido")
    private Double valorLiquido;

    @ManyToMany
    @JoinTable(
            name="pedido",
            joinColumns = @JoinColumn(name = "pedido_id"),
            inverseJoinColumns = @JoinColumn(name = "item_pedido_id")
    )
    private List<Pedido> pedidos;

    @OneToMany(mappedBy = "ItemPedido")
    private List<Produto> produtos;


    public ItemPedido(ItemPedidoDTO itemPedidoDTO) {
        this.itemPedidoID = itemPedidoDTO.id();
        this.produtos = itemPedidoDTO.produtos();
        this.pedidos = itemPedidoDTO.pedidos();
        this.valorLiquido = itemPedidoDTO.valorLiquido();
        this.valorBruto = itemPedidoDTO.valorBruto();
        this.percentualDesconto = itemPedidoDTO.percentualDesconto();
        this.precoVenda = itemPedidoDTO.precoVenda();
        this.quantidade = itemPedidoDTO.quantidade();
    }


    public Integer getItemPedidoID() {
        return itemPedidoID;
    }

    public void setItemPedidoID(Integer itemPedidoID) {
        this.itemPedidoID = itemPedidoID;
    }

    public double getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(double quantidade) {
        this.quantidade = quantidade;
    }

    public double getPrecoVenda() {
        return precoVenda;
    }

    public void setPrecoVenda(double precoVenda) {
        this.precoVenda = precoVenda;
    }

    public double getPercentualDesconto() {
        return percentualDesconto;
    }

    public void setPercentualDesconto(double percentualDesconto) {
        this.percentualDesconto = percentualDesconto;
    }

    public double getValorBruto() {
        return valorBruto;
    }

    public void setValorBruto(double valorBruto) {
        this.valorBruto = valorBruto;
    }

    public double getValorLiquido() {
        return valorLiquido;
    }

    public void setValorLiquido(double valorLiquido) {
        this.valorLiquido = valorLiquido;
    }

    public List<Pedido> getPedidos() {
        return pedidos;
    }

    public void setPedidos(List<Pedido> pedidos) {
        this.pedidos = pedidos;
    }

    public List<Produto> getProdutos() {
        return produtos;
    }

    public void setProdutos(List<Produto> produtos) {
        this.produtos = produtos;
    }
}
