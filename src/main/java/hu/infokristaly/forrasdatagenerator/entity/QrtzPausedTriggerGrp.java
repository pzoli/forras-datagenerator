package hu.infokristaly.forrasdatagenerator.entity;

import java.io.Serializable;
import jakarta.persistence.*;


/**
 * The persistent class for the qrtz_paused_trigger_grps database table.
 * 
 */
@Entity
@Table(name="qrtz_paused_trigger_grps")
@NamedQuery(name="QrtzPausedTriggerGrp.findAll", query="SELECT q FROM QrtzPausedTriggerGrp q")
public class QrtzPausedTriggerGrp implements Serializable {
	private static final long serialVersionUID = 1L;
	private QrtzPausedTriggerGrpPK id;

	public QrtzPausedTriggerGrp() {
	}


	@EmbeddedId
	public QrtzPausedTriggerGrpPK getId() {
		return this.id;
	}

	public void setId(QrtzPausedTriggerGrpPK id) {
		this.id = id;
	}

}