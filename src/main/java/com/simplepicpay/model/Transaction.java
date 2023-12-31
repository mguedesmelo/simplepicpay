package com.simplepicpay.model;

import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "tb_transaction")
public class Transaction extends BaseEntity {
	/**
	 * 
	 */
	private static final long serialVersionUID = 2675852495449493477L;

	@ManyToOne
	@JoinColumn(name = "payer_id", nullable = false)
	private User payer;

	@ManyToOne
	@JoinColumn(name = "payee_id", nullable = false)
	private User payee;

	@Column(name = "ammount")
	private BigDecimal ammount;

	@Override
	public String toString() {
		return "Transaction [payer=" + payer + ", payee=" + payee + ", ammount=" + ammount + "]";
	}
}
