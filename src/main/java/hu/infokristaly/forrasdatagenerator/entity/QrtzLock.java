package hu.infokristaly.forrasdatagenerator.entity;

import java.io.Serializable;
import jakarta.persistence.*;


/**
 * The persistent class for the qrtz_locks database table.
 * 
 */
@Entity
@Table(name="qrtz_locks")
@NamedQuery(name="QrtzLock.findAll", query="SELECT q FROM QrtzLock q")
public class QrtzLock implements Serializable {
	private static final long serialVersionUID = 1L;
	private QrtzLockPK id;

	public QrtzLock() {
	}


	@EmbeddedId
	public QrtzLockPK getId() {
		return this.id;
	}

	public void setId(QrtzLockPK id) {
		this.id = id;
	}

}