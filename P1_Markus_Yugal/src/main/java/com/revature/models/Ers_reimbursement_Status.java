package com.revature.models;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name="Ers_reimbursement_Status")
public class Ers_reimbursement_Status {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="reimb_statusid")
	private int reimb_status_id;
	
	@Column(name="reimb_status", unique = true, nullable = true)
	private String reimb_status;

	public Ers_reimbursement_Status() {
		super();
	}

	public Ers_reimbursement_Status(String reimb_status) {
		super();
		this.reimb_status = reimb_status;
	}

	public Ers_reimbursement_Status(int reimb_status_id, String reimb_status) {
		super();
		this.reimb_status_id = reimb_status_id;
		this.reimb_status = reimb_status;
	}

	public int getReimb_status_id() {
		return reimb_status_id;
	}

	public void setReimb_status_id(int reimb_status_id) {
		this.reimb_status_id = reimb_status_id;
	}

	public String getReimb_status() {
		return reimb_status;
	}

	public void setReimb_status(String reimb_status) {
		this.reimb_status = reimb_status;
	}

	@Override
	public int hashCode() {
		return Objects.hash(reimb_status, reimb_status_id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Ers_reimbursement_Status other = (Ers_reimbursement_Status) obj;
		return Objects.equals(reimb_status, other.reimb_status) && reimb_status_id == other.reimb_status_id;
	}

	@Override
	public String toString() {
		return "Ers_reimbursement_Status [reimb_status_id=" + reimb_status_id + ", reimb_status=" + reimb_status + "]";
	}
	
	

}
